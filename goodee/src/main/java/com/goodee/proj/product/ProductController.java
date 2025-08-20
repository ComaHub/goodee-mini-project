package com.goodee.proj.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodee.proj.common.Paging;

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
	public void list(Model model, Paging paging) throws Exception {
		Long totalCount = productService.totalCount(paging);
		
		paging.setTotalData(totalCount);
		
		List<ProductDTO> list = productService.list(paging);
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/detail")
	public void detail(Model model, ProductDTO productDTO) throws Exception {
		productDTO = productService.detail(productDTO);
		model.addAttribute("productDTO", productDTO);
	}
	
	@GetMapping("/update")
	public void update(Model model, ProductDTO productDTO) throws Exception {
		productDTO = productService.detail(productDTO);
		model.addAttribute("productDTO", productDTO);
	}

	@PostMapping("/update")
	public String update(@Valid ProductDTO productDTO, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return "redirect:/product/update?productNumber=" + productDTO.getProductNumber();
		}
		
		int result = productService.update(productDTO);
		
		if (result > 0 ) {
			return "redirect:/product/detail?productNumber=" + productDTO.getProductNumber();
		}
		
		return "redirect:/product/update?productNumber=" + productDTO.getProductNumber();
	}
	
	
}
