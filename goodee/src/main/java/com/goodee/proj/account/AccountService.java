package com.goodee.proj.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public int insert(AccountDTO accountDTO) throws Exception {
		return accountDAO.insert(accountDTO);
	}

	public List<AccountDTO> list() throws Exception {
		return accountDAO.list();
	}

	public int updateAdmin(AccountDTO accountDTO) throws Exception {
		return accountDAO.updateAdmin(accountDTO);
	}

	public AccountDTO login(AccountDTO accountDTO) throws Exception {
		return accountDAO.login(accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return accountDAO.detail(accountDTO);
	}

	public int update(AccountDTO accountDTO) throws Exception {
		return accountDAO.update(accountDTO);
	}
}
