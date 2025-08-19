package com.goodee.proj.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.proj.common.file.FileDTO;
import com.goodee.proj.common.file.FileService;

@Service
public class AnimalService {
	@Autowired
	private AnimalDAO animalDAO;
	@Autowired
	private FileService fileService;
	
	public int addAnimal(AnimalDTO animalDTO, MultipartFile animalAttach) throws Exception {
		animalDTO.setStatus("보호중");
		int result = animalDAO.insertAnimal(animalDTO);
		
		if (animalAttach != null && !animalAttach.isEmpty()) {
			String fileName = fileService.saveFile(fileService.animal, animalAttach);
			
			FileDTO fileDTO = new FileDTO();
			fileDTO.setType(fileService.animal);
			fileDTO.setKeyData(animalDTO.getNumber());
			fileDTO.setOrigin(animalAttach.getOriginalFilename());
			fileDTO.setSaved(fileName);
			
			animalDAO.insertAnimalAttach(fileDTO);
		}
		
		return result;
	}
}
