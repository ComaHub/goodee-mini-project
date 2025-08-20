package com.goodee.proj.like;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.product.ProductDTO;

@Mapper
public interface LikeDAO {

	List<ProductDTO> selectLikeList(Map<String, Object> map) throws Exception;
	Long totalCount(Map<String, Object> map) throws Exception;
	int insertLike(LikeDTO likeDTO) throws Exception;
	int deleteLike(LikeDTO likeDTO) throws Exception;

}
