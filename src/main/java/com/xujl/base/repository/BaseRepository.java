package com.xujl.base.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;


public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T, ID > ,JpaSpecificationExecutor<T>,QueryDslPredicateExecutor<T>{

}
