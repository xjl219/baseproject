package com.xujl.base.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.xujl.base.entity.Role;
import com.xujl.base.repository.RoleRepository;
import com.xujl.base.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService {
	@Inject
	RoleRepository roleRepository;
	
	@Override
	public List<Role> allRoles() {
		return roleRepository.findAll();
	}

}
