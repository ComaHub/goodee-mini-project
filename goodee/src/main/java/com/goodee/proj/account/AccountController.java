package com.goodee.proj.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.proj.account.groups.Join;
import com.goodee.proj.account.groups.Login;
import com.goodee.proj.account.groups.Update;
import com.goodee.proj.common.file.FileDTO;
import com.goodee.proj.common.file.FileService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private FileService fileService;
	
	@GetMapping("/join")
	public void join(AccountDTO accountDTO) {
	}
	
	@PostMapping("/join")
	public String join(Model model, @Validated(Join.class) AccountDTO accountDTO, 
			BindingResult bindingResult, MultipartFile attach) throws Exception {
		
		if (bindingResult.hasErrors()) {
			return "/account/join";
		}
		System.out.println(attach);
		int result = accountService.insert(accountDTO, attach);
		
		if (result > 0) {
			return "redirect:/";
		}
		
		return "/account/join";
	}
	
	@GetMapping("/login")
	public void login(AccountDTO accountDTO) {
	}
	
	@PostMapping("/login")
	public String login(@Validated(Login.class) AccountDTO accountDTO, BindingResult bindingResult, 
			HttpSession session) throws Exception {
		if (bindingResult.hasErrors()) {
			return "/account/login";
		}
		
		AccountDTO result = accountService.login(accountDTO);
		
		if (result == null) {
			return "/account/login";
		}
		
		session.setAttribute("logined", result);

		return "redirect:/account/detail";
	}
	
	@GetMapping("/detail")
	public void detail(Model model, HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		accountDTO = accountService.detail(accountDTO);
		
		FileDTO fileDTO = accountService.detailProfile(accountDTO.getAccountNumber());
		
		model.addAttribute("accountDTO", accountDTO);
		model.addAttribute("fileDTO", fileDTO);
	}
	
	@GetMapping("/update")
	public void update(Model model, HttpSession session) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("accountDTO", accountDTO);
	}
	
	@PostMapping("/update")
	public String update(HttpSession session, @Validated(Update.class) AccountDTO accountDTO, 
			BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			return "/account/update";
		}
		
		AccountDTO dto = (AccountDTO) session.getAttribute("logined");
		accountDTO.setAccountNumber(dto.getAccountNumber());
		
		int result = accountService.update(accountDTO);
		
		return "redirect:/account/detail";
	}
	
	@PostMapping("/dropOut")
	public String dropOut(HttpSession session, String password) throws Exception {
		AccountDTO accountDTO = (AccountDTO) session.getAttribute("logined");
		accountDTO.setPassword(password);
		
		int result = accountService.dropOut(accountDTO);
		
		if (result > 0) {
			return "redirect:/account/logout";
		}
		
		return "redirect:/account/detail";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("logined");
		session.setMaxInactiveInterval(0);
		return "redirect:/";
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
