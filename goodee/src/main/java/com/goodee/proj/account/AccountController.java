package com.goodee.proj.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/join")
	public void join(AccountDTO accountDTO) {
	}
	
	@PostMapping("/join")
	public String join(Model model, @Valid AccountDTO accountDTO, BindingResult bindingResult) throws Exception {
		
		if (bindingResult.hasErrors()) {
			return "/account/join";
		}
		int result = accountService.insert(accountDTO);
		
		return "/";
	}
	
	@GetMapping("/list")
	public void list(Model model, AccountDTO accountDTO) throws Exception {
		List<AccountDTO> list = accountService.list();
		model.addAttribute("list", list);
	}
	
	@PostMapping("/list")
	@ResponseBody
	public void list(AccountDTO accountDTO) throws Exception {
		int result = accountService.updateAdmin(accountDTO);
	}
	
	
}
