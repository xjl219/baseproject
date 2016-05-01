package com.xujl.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xujl.base.entity.Role;
import com.xujl.base.entity.User;
import com.xujl.base.repository.BaseRepository;
import com.xujl.base.repository.RoleRepository;
import com.xujl.base.service.RoleService;
import com.xujl.base.service.UserService;
@Service
public class RoleServiceImpl extends BaseService<Role,Integer> implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	BaseRepository<Role, Integer> getJpaRepository() {
		return roleRepository;
	}


}
