package com.goodee.proj.like;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.product.ProductDTO;

@Service
public class LikeService {
	@Autowired
	private LikeDAO likeDAO;
	
	public List<ProductDTO> getLikeList(AccountDTO accountDTO) throws Exception {
		return likeDAO.selectLikeList(accountDTO.getAccountNumber());
	}

	public int addLike(Long accountNumber, Long productNumber) throws Exception {
		LikeDTO likeDTO = new LikeDTO();
		likeDTO.setAccountNumber(accountNumber);
		likeDTO.setProductNumber(productNumber);
		
		return likeDAO.insertLike(likeDTO);
	}

	public int removeLike(Long accountNumber, Long productNumber) throws Exception {
		LikeDTO likeDTO = new LikeDTO();
		likeDTO.setAccountNumber(accountNumber);
		likeDTO.setProductNumber(productNumber);
		
		return likeDAO.deleteLike(likeDTO);
	}

}
