package com.xujl.base.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.xujl.base.entity.Permission;
import com.xujl.base.repository.BaseRepository;
import com.xujl.base.repository.PermissionRepository;
import com.xujl.base.service.PermissionService;
@Service
public class PermissionServiceImpl extends BaseService<Permission, Integer> implements PermissionService {
	@Autowired
	PermissionRepository permissionRepository;

	@Override
	BaseRepository<Permission, Integer> getJpaRepository() {
		return permissionRepository;
	}

}
