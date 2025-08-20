package com.goodee.proj.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public void getProductList(Model model) throws Exception {
		List<ProductDTO> productList = productService.getProductList();
		model.addAttribute("productList", productList);
	}
	
	@GetMapping("add")
	public String getProductAdd(ProductDTO productDTO) {
		return "product/product_form";
	}
	
	@PostMapping("add")
	public String postProductAdd(@Valid ProductDTO productDTO, BindingResult bindingResult, MultipartFile productImage, Model model) throws Exception {
		
		if (bindingResult.hasErrors()) {
			return "product/product_form";
		}
		
		int result = productService.addProduct(productDTO, productImage);
		
		String resultMsg = "상품 등록 중 오류가 발생했습니다.";
		String resultIcon = "warning";
		
		if (result > 0) {
			resultMsg = "상품이 등록되었습니다.";
			resultIcon = "success";
			
			String url = "list";
			model.addAttribute("url", url);
		}
		
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("resultIcon", resultIcon);
		return "common/result";
	}
	
	@GetMapping("detail")
	public void getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.getProduct(productDTO);
		model.addAttribute("productDTO", productDTO);
	}
	
	@GetMapping("update")
	public String getProductUpdate(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.getProduct(productDTO);
		model.addAttribute("productDTO", productDTO);
		
		return "product/product_form";
	}

	@PostMapping("update")
	public String postProductUpdate(@Valid ProductDTO productDTO, BindingResult bindingResult, MultipartFile productImage, Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			return "product/product_form";
		}
		
		int result = productService.updateProduct(productDTO, productImage);
		
		String resultMsg = "상품 정보 수정 중 오류가 발생했습니다.";
		String resultIcon = "warning";
		
		if (result > 0) {
			resultMsg = "상품 정보가 수정되었습니다.";
			resultIcon = "success";
			
			String url = "detail?productNumber=" + productDTO.getProductNumber();
			model.addAttribute("url", url);
		}
		
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("resultIcon", resultIcon);
		return "common/result";
	}
	
	@GetMapping("delete")
	public String getProductDelete(Long productNumber, Model model) throws Exception {
		int result = productService.deleteProduct(productNumber);
		
		String resultMsg = "상품 삭제 중 오류가 발생했습니다.";
		String resultIcon = "warning";
		
		if (result > 0) {
			resultMsg = "상품이 삭제되었습니다.";
			resultIcon = "success";
			
			String url = "list";
			model.addAttribute("url", url);
		}
		
		model.addAttribute("resultMsg", resultMsg);
		model.addAttribute("resultIcon", resultIcon);
		return "common/result";
	}
	
	
}
