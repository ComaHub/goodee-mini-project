package com.goodee.proj.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/add")
	public void add(ProductDTO productDTO) {
	}
	
	@PostMapping("/add")
	public String add(@Valid ProductDTO productDTO, BindingResult bindingResult) throws Exception {
		
		if (bindingResult.hasErrors()) {
			return "/product/add";
		}
		
		int reulst = productService.insert(productDTO);
		return "/product/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		List<ProductDTO> list = productService.list();
		model.addAttribute("list", list);
	}
}
