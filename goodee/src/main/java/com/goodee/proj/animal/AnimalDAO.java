package com.goodee.proj.animal;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimalDAO {
	int insertAnimal(AnimalDTO animalDTO) throws Exception;

}
