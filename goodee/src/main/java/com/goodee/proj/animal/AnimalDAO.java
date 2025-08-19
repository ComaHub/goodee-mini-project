package com.goodee.proj.animal;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.common.file.FileDTO;

@Mapper
public interface AnimalDAO {
	List<AnimalDTO> selectAnimalList() throws Exception;
	int insertAnimal(AnimalDTO animalDTO) throws Exception;
	int insertAnimalAttach(FileDTO fileDTO) throws Exception;

}
