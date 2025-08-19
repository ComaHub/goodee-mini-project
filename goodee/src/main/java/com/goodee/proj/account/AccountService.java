package com.goodee.proj.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
