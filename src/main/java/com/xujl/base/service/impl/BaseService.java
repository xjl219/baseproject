package com.xujl.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.xujl.base.repository.BaseRepository;

public abstract  class BaseService<T, ID extends Serializable>  implements BaseRepository<T, ID> {
	
	public Page<T> findAll(Pageable pageable) {
		return getJpaRepository().findAll(pageable);
	}
	public <S extends T> S save(S entity) {
		
		return getJpaRepository().save(entity);
	}
	public T findOne(ID id) {
		
		return getJpaRepository().findOne(id);
	}
	public boolean exists(ID id) {
		
		return getJpaRepository().exists(id);
	}
	public Iterable<T> findAll(Iterable<ID> ids) {
		
		return getJpaRepository().findAll(ids);
	}
	public long count() {
		
		return getJpaRepository().count();
	}
	public void delete(ID id) {
		getJpaRepository().delete(id);
		
	}
	public void delete(T entity) {

		getJpaRepository().delete(entity);
	}
	public void delete(Iterable<? extends T> entities) {
		getJpaRepository().delete(entities);		
	}
	public void deleteAll() {
		getJpaRepository().deleteAll();
		
	}
	public List<T> findAll() {
		
		return getJpaRepository().findAll();
	}
	public List<T> findAll(Sort sort) {
		
		return getJpaRepository().findAll(sort);
	}
	public <S extends T> List<S> save(Iterable<S> entities) {
		
		return getJpaRepository().save(entities);
	}
	public void flush() {
		
		getJpaRepository().flush();
		
	}
	public T saveAndFlush(T entity) {
		
		return getJpaRepository().saveAndFlush(entity);
	}
	public void deleteInBatch(Iterable<T> entities) {
		getJpaRepository().deleteInBatch(entities);
		
	}
	public void deleteAllInBatch() {

		getJpaRepository().deleteAllInBatch();
	}
	
	public T findOne(Specification<T> spec) {
		return getJpaRepository().findOne(spec);
	}

	
	public List<T> findAll(Specification<T> spec) {
		return getJpaRepository().findAll(spec);
	}

	
	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		return getJpaRepository().findAll(spec, pageable);
	}

	
	public List<T> findAll(Specification<T> spec, Sort sort) {
		return getJpaRepository().findAll(spec, sort);
	}

	
	public long count(Specification<T> spec) {
		return getJpaRepository().count(spec);
	}

	
	public T findOne(Predicate predicate) {
		return getJpaRepository().findOne(predicate);
	}

	
	public Iterable<T> findAll(Predicate predicate) {
		return getJpaRepository().findAll(predicate);
	}

	
	public Iterable<T> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
		return getJpaRepository().findAll(predicate, orders);
	}

	
	public Page<T> findAll(Predicate predicate, Pageable pageable) {
		return getJpaRepository().findAll(predicate, pageable);
	}

	
	public long count(Predicate predicate) {
		return getJpaRepository().count(predicate);
	}
	
	abstract BaseRepository<T,ID> getJpaRepository();
}
