package com.xujl.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xujl.base.entity.Person;
import com.xujl.base.entity.User;
import com.xujl.base.repository.UserRepository;
import com.xujl.base.service.UserService;

@Controller
@RequestMapping("/u")
public class UserAction implements BaseAction {
	static int i=0;
	@Autowired
	UserService userServiceImpl;

	@RequestMapping(value = "/form")
	public @ModelAttribute User create(Model model) {
		User user = new User();
		user.setUserName("name-"+i);
		user.setPassword("pw-"+i);
		user.setAddress("addr-"+i);
		user.setMail(i+"@mail.com");
		userServiceImpl.saveAndFlush(user);
		i++;
		return new User();
	}

	@RequestMapping(value = "/list")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			Model model) {
		int pageNum = page != null ? page : DEFAULT_PAGE_NUM;
		Pageable pageable = new PageRequest(pageNum, DEFAULT_PAGE_SIZE);
		Object paging = userServiceImpl.findAll(pageable);
		model.addAttribute("page", paging);
		return "/sysuser/list";
	}
}
