package com.goodee.proj.animal;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnimalDTO {
	private Long animalNumber;
	private LocalDateTime date;
	private String name;
	private String species;
	private String breed;
	private String gender;
	private Double weight;
	private Boolean neutered;
	private String status;
	
	private AnimalProfileDTO animalProfileDTO;
}
