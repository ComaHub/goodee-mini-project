package com.goodee.proj.animal;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.common.file.FileDTO;

@Mapper
public interface AnimalDAO {
	int insertAnimal(AnimalDTO animalDTO) throws Exception;
	int insertAnimalAttach(FileDTO fileDTO) throws Exception;

}
