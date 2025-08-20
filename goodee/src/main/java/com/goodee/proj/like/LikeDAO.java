package com.goodee.proj.like;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.product.ProductDTO;

@Mapper
public interface LikeDAO {

	List<ProductDTO> selectLikeList(Long accountNumber) throws Exception;
	int insertLike(LikeDTO likeDTO) throws Exception;
	int deleteLike(LikeDTO likeDTO) throws Exception;

}
