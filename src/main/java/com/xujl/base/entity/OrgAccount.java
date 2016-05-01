package com.xujl.base.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrgAccount implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  @Id
	@GeneratedValue
	Integer id;
	
	String regId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	

}