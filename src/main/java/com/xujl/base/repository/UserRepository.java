package com.xujl.base.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.xujl.base.entity.Person;
import com.xujl.base.entity.User;

public interface UserRepository extends BaseRepository<User,Integer>{
	public  Page<User> findByUserNameLike(String userName, Pageable pageable);
    public User getByUserName(String userName);
}
