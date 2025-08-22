package com.goodee.proj.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.proj.common.Paging;
import com.goodee.proj.common.file.FileService;

@Service
@Transactional(rollbackFor = Exception.class)
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
	

	public Long totalCount(Paging paging) throws Exception {
		return productDAO.totalCount(paging);
	}
	
	public List<ProductDTO> getProductList(Paging paging) throws Exception {
		return productDAO.selectProductList(paging);
	}

	public ProductDTO getProduct(ProductDTO productDTO) throws Exception {
		return productDAO.selectProduct(productDTO);
	}

	public int updateProduct(ProductDTO productDTO, MultipartFile productImage) throws Exception {
		int result = productDAO.updateProduct(productDTO);
		
		if (productImage != null && !productImage.isEmpty()) {
			ProductImageDTO productImageDTO = productDAO.selectProductImage(productDTO.getProductNumber());
			fileService.deleteFile(productImageDTO);
			
			String fileName = fileService.saveFile(FileService.PRODUCT, productImage);
			productImageDTO.setOrigin(productImage.getOriginalFilename());
			productImageDTO.setSaved(fileName);
			
			productDAO.updateProductImage(productImageDTO);
		}
		
		return result;
	}
	
	public int updateProductAmount(List<Long> productNumbers) throws Exception {
		return productDAO.updateProductAmount(productNumbers);
	}

	public int deleteProduct(Long productNumber) throws Exception {
		ProductImageDTO productImageDTO = productDAO.selectProductImage(productNumber);
		
		if (productImageDTO != null) {
			productDAO.deleteProductImage(productImageDTO.getAttachNumber());
		}
		
		int result = productDAO.deleteProduct(productNumber);
		
		if (result > 0) {
			fileService.deleteFile(productImageDTO);
		}
		
		return result;
	}


	

}
