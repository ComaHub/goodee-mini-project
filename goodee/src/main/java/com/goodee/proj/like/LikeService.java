package com.goodee.proj.like;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.proj.account.AccountDTO;
import com.goodee.proj.common.Paging;
import com.goodee.proj.product.ProductDTO;

@Service
public class LikeService {
	@Autowired
	private LikeDAO likeDAO;
	
	public List<ProductDTO> getLikeList(AccountDTO accountDTO, Paging paging) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("accountNumber", accountDTO.getAccountNumber());
		map.put("paging", paging);
		return likeDAO.selectLikeList(map);
	}

	public Long totalCount(AccountDTO accountDTO, Paging paging) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("accountNumber", accountDTO.getAccountNumber());
		map.put("paging", paging);
		return likeDAO.totalCount(map);
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
