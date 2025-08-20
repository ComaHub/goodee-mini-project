package com.goodee.proj.account;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.proj.common.file.FileDTO;

import jakarta.validation.Valid;

@Mapper
public interface AccountDAO {

	int insert(AccountDTO accountDTO) throws Exception;
	List<AccountDTO> list() throws Exception;
	int updateAdmin(AccountDTO accountDTO) throws Exception;
	@Valid
	AccountDTO login(AccountDTO accountDTO) throws Exception;
	AccountDTO detail(AccountDTO accountDTO) throws Exception;
	int update(AccountDTO accountDTO) throws Exception;
	int dropOut(AccountDTO accountDTO) throws Exception;
	int insertAttach(FileDTO fileDTO) throws Exception;
	FileDTO detailAttach(Long keyData) throws Exception;
	int deleteAttach(FileDTO oldFile) throws Exception;
}
