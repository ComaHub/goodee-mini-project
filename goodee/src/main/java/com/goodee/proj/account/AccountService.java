package com.goodee.proj.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.proj.common.file.FileDTO;
import com.goodee.proj.common.file.FileService;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private FileService fileService;
	
	@Transactional(rollbackFor = Exception.class)
	public int insert(AccountDTO accountDTO, MultipartFile attach) throws Exception {
		int result = accountDAO.insert(accountDTO);
//		
		if (result != 1) throw new Exception();
		
		if (attach != null && !attach.isEmpty()) {
			String fileName = fileService.saveFile(FileService.ACCOUNT, attach);
			
			FileDTO fileDTO = new FileDTO();
			fileDTO.setType(FileService.ACCOUNT);
			fileDTO.setKeyData(accountDTO.getAccountNumber());
			fileDTO.setOrigin(attach.getOriginalFilename());
			fileDTO.setSaved(fileName);
			
			result = accountDAO.insertAttach(fileDTO);
			
			if (result != 1) {
				fileService.deleteFile(fileDTO);
				throw new Exception();
			}
		}
		
		return result;
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

	@Transactional(rollbackFor = Exception.class)
	public int update(AccountDTO accountDTO, MultipartFile attach) throws Exception {
		int result = accountDAO.update(accountDTO);

		if (result != 1) throw new Exception();
		
		if (attach != null && !attach.isEmpty()) {
			accountDAO.detailProfile(accountDTO.getAccountNumber());
			
			
			
			String fileName = fileService.saveFile(FileService.ACCOUNT, attach);
			
			FileDTO fileDTO = new FileDTO();
			fileDTO.setType(FileService.ACCOUNT);
			fileDTO.setKeyData(accountDTO.getAccountNumber());
			fileDTO.setOrigin(attach.getOriginalFilename());
			fileDTO.setSaved(fileName);
			
			result = accountDAO.insertAttach(fileDTO);
			
			if (result != 1) {
				fileService.deleteFile(fileDTO);
				throw new Exception();
			}
		}
		
		return result;
	}

	public int dropOut(AccountDTO accountDTO) throws Exception {
		return accountDAO.dropOut(accountDTO);
	}

	public FileDTO detailProfile(Long keyData) throws Exception {
		return accountDAO.detailProfile(keyData);
	}
}
