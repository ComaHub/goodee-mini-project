package com.goodee.proj.animal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnimalServiceTest {
	@Autowired
	private AnimalService animalService;
	
	@Test
	void insertAnimalTest() throws Exception {
		AnimalDTO animalDTO = new AnimalDTO();
		animalDTO.setName("테스터");
		animalDTO.setSpecies("개");
		animalDTO.setBreed("시고르자브종");
		animalDTO.setGender("남");
		animalDTO.setWeight(9.32);
		animalDTO.setNeutered(true);
		animalDTO.setStatus("보호중");
		
		int result = animalService.insertAnimal(animalDTO);
		
		assertEquals(1, result);
	}

}
