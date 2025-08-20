package com.goodee.proj.animal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	private String dateToString;
	
	public void setDate(LocalDateTime date) {
		this.date = date;
		this.dateToString = date.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
	}
}
