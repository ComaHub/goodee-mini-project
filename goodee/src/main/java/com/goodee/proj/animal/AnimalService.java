package com.goodee.proj.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.proj.common.file.FileService;

@Service
public class AnimalService {
	@Autowired
	private AnimalDAO animalDAO;
	@Autowired
	private FileService fileService;
	
	public AnimalDTO getAnimal(Long animalNumber) throws Exception {
		return animalDAO.selectAnimal(animalNumber);
	}
	
	public List<AnimalDTO> getAnimalList() throws Exception {
		return animalDAO.selectAnimalList();
	}
	
	public AnimalProfileDTO getAnimalProfile(Long animalNumber) throws Exception {
		return animalDAO.selectAnimalProfile(animalNumber);
	}
	
	public int addAnimal(AnimalDTO animalDTO, MultipartFile animalAttach) throws Exception {
		animalDTO.setStatus("보호중");
		int result = animalDAO.insertAnimal(animalDTO);
		
		if (animalAttach != null && !animalAttach.isEmpty()) {
			String fileName = fileService.saveFile(FileService.ANIMAL, animalAttach);
			
			AnimalProfileDTO animalProfileDTO = new AnimalProfileDTO();
			animalProfileDTO.setType(FileService.ANIMAL);
			animalProfileDTO.setKeyData(animalDTO.getAnimalNumber());
			animalProfileDTO.setOrigin(animalAttach.getOriginalFilename());
			animalProfileDTO.setSaved(fileName);
			
			animalDAO.insertAnimalAttach(animalProfileDTO);
		}
		
		return result;
	}

	public int updateAnimal(AnimalDTO animalDTO, MultipartFile animalAttach) throws Exception {
		int result = animalDAO.updateAnimal(animalDTO);
		
		if (animalAttach != null && !animalAttach.isEmpty()) {
			AnimalProfileDTO animalProfileDTO = animalDAO.selectAnimalProfile(animalDTO.getAnimalNumber());
			fileService.deleteFile(animalProfileDTO);
			
			String fileName = fileService.saveFile(FileService.ANIMAL, animalAttach);
			animalProfileDTO.setOrigin(animalAttach.getOriginalFilename());
			animalProfileDTO.setSaved(fileName);
			
			animalDAO.updateAnimalAttach(animalProfileDTO);
		}
		
		return result;
	}

	

	

}
