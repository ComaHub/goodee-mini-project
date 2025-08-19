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
	
	public List<AnimalDTO> getAnimalList() throws Exception {
		return animalDAO.selectAnimalList();
	}
	
	public int addAnimal(AnimalDTO animalDTO, MultipartFile animalAttach) throws Exception {
		animalDTO.setStatus("보호중");
		int result = animalDAO.insertAnimal(animalDTO);
		
		if (animalAttach != null && !animalAttach.isEmpty()) {
			String fileName = fileService.saveFile(FileService.ANIMAL, animalAttach);
			
			AnimalProfileDTO animalProfileDTO = new AnimalProfileDTO();
			animalProfileDTO.setType(FileService.ANIMAL);
			animalProfileDTO.setKeyData(animalDTO.getNumber());
			animalProfileDTO.setOrigin(animalAttach.getOriginalFilename());
			animalProfileDTO.setSaved(fileName);
			
			animalDAO.insertAnimalAttach(animalProfileDTO);
		}
		
		return result;
	}

}
