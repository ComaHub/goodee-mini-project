package com.goodee.proj.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.proj.common.file.FileService;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private FileService fileService;
	
	public int addProduct(ProductDTO productDTO, MultipartFile productImage) throws Exception {
		int result = productDAO.insertProduct(productDTO);
		
		if (productImage != null && !productImage.isEmpty()) {
			String fileName = fileService.saveFile(FileService.PRODUCT, productImage);
			
			ProductImageDTO productImageDTO = new ProductImageDTO();
			productImageDTO.setType(FileService.PRODUCT);
			productImageDTO.setKeyData(productDTO.getProductNumber());
			productImageDTO.setOrigin(productImage.getOriginalFilename());
			productImageDTO.setSaved(fileName);
			
			productDAO.insertProductImage(productImageDTO);
		}
		
		return result;
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		return productDAO.selectProductList();
	}

	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		return productDAO.detail(productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

}
