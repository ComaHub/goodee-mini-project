package com.goodee.proj.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AnimalController {
	@Autowired
	private AnimalService animalService;
}
