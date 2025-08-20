package com.goodee.proj.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.proj.common.file.FileService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/animal/*")
public class AnimalController {
	@Autowired
	private AnimalService animalService;
	@Autowired
	private FileService fileService;
	
	@GetMapping("list")
	public void getAnimalList(Model model) throws Exception {
		List<AnimalDTO> animalList = animalService.getAnimalList();
		
		model.addAttribute("animalList", animalList);
	}
	
	@GetMapping("add")
	public String getAnimalAdd(AnimalDTO animalDTO) throws Exception {
		return "animal/animal_form";
	}
	
	@PostMapping("add")
	public String postAnimalAdd(AnimalDTO animalDTO, MultipartFile animalAttach, Model model) throws Exception {
		int result = animalService.addAnimal(animalDTO, animalAttach);
		
		String resultMsg = "보호 동물 등록 중 오류가 발생했습니다.";
		String resultIcon = "warning";
		
		if (result > 0) {
			resultMsg = "보호 동물이 등록되었습니다.";
			resultIcon = "success";
			
			String url = "list";
			model.addAttribute("url", url);
		}
		
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("resultIcon", resultIcon);
		return "common/result";
	}

	@GetMapping("detail")
	public void getAnimalDetail(Long num, Model model) throws Exception {
		AnimalDTO animalDTO = animalService.getAnimal(num);
		model.addAttribute("animalDTO", animalDTO);
	}
	
	@GetMapping("update")
	public String getAnimalUpdate(Long num, Model model) throws Exception {
		AnimalDTO animalDTO = animalService.getAnimal(num);
		model.addAttribute("animalDTO", animalDTO);
		
		return "animal/animal_form";
	}
	
	@PostMapping("update")
	public String postAnimalUpdate(AnimalDTO animalDTO, MultipartFile animalAttach, Model model) throws Exception {
		int result = animalService.updateAnimal(animalDTO, animalAttach);
		
		String resultMsg = "보호 동물 정보 수정 중 오류가 발생했습니다.";
		String resultIcon = "warning";
		
		if (result > 0) {
			resultMsg = "보호 동물 정보가 수정되었습니다.";
			resultIcon = "success";
			
			String url = "detail?num=" + animalDTO.getAnimalNumber();
			model.addAttribute("url", url);
		}
		
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("resultIcon", resultIcon);
		return "common/result";
	}
	
	@GetMapping("fileDownload")
	public void getAnimalFileDownload(Long animalNumber, HttpServletResponse response) throws Exception {
		AnimalProfileDTO animalProfileDTO = animalService.getAnimalProfile(animalNumber);
		fileService.downloadFile(animalProfileDTO, response);
	}
}
