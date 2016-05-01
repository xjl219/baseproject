package com.xujl.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xujl.base.entity.Role;
import com.xujl.base.service.RoleService;

@Controller
@RequestMapping(value="/r")
public class RoleAction implements BaseAction {
	@Autowired
	RoleService roleServiceImpl;
	static int i=0;
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(){
		Role r= new Role();
		r.setRoleName("name:"+i);
		r.setRoleCode("ROLE_"+i);
		r.setStatus(true);
		roleServiceImpl.saveAndFlush(r);
		i++;
		return "ok";
	}
}
