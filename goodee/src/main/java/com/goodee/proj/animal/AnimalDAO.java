package com.goodee.proj.animal;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.common.file.FileDTO;

@Mapper
public interface AnimalDAO {
	AnimalDTO selectAnimal(Long animalNumber) throws Exception;
	List<AnimalDTO> selectAnimalList() throws Exception;
	AnimalProfileDTO selectAnimalProfile(Long animalNumber) throws Exception;
	int insertAnimal(AnimalDTO animalDTO) throws Exception;
	int insertAnimalAttach(FileDTO fileDTO) throws Exception;
	int updateAnimal(AnimalDTO animalDTO) throws Exception;
	int updateAnimalAttach(AnimalProfileDTO animalProfileDTO) throws Exception;
	int deleteAnimal(Long animalNumber) throws Exception;
	int deleteAnimalAttach(Long attachNumber) throws Exception;

}
