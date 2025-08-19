package com.goodee.proj.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
	@Autowired
	private AnimalDAO animalDAO;
	
	public int addAnimal(AnimalDTO animalDTO) throws Exception {
		animalDTO.setStatus("보호중");
		
		return animalDAO.insertAnimal(animalDTO);
	}
}
