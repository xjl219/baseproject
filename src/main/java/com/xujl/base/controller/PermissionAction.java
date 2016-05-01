package com.xujl.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xujl.base.entity.Permission;
import com.xujl.base.service.PermissionService;
@Controller
@RequestMapping(value="p")
public class PermissionAction implements BaseAction {
	@Autowired
	PermissionService permissionServiceImpl;
	static int i=0;
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(){
		Permission p= new Permission();
		p.setPermission_uri("/p/save"+i);
		
		p.setPermissioncode("p:"+i);
		
		permissionServiceImpl.saveAndFlush(p);
		++i;
		return "ok";
	}
}
