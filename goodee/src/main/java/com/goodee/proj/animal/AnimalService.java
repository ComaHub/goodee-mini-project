package com.goodee.proj.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
	@Autowired
	private AnimalDAO animalDAO;
	
	public int insertAnimal(AnimalDTO animalDTO) throws Exception {
		return animalDAO.insertAnimal(animalDTO);
	}
}
