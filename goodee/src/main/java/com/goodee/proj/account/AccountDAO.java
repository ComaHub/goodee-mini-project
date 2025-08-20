package com.goodee.proj.account;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDAO {

	int insert(AccountDTO accountDTO) throws Exception;
	List<AccountDTO> list() throws Exception;
	int updateAdmin(AccountDTO accountDTO) throws Exception;
}
