package com.onetomanybidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Entity
public class Sim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String telecomName;
	private String simType;
	
	@JoinColumn
	@ManyToOne
	private Mobile mobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelecomName() {
		return telecomName;
	}

	public void setTelecomName(String telecomName) {
		this.telecomName = telecomName;
	}

	public String getSimType() {
		return simType;
	}

	public void setSimType(String simType) {
		this.simType = simType;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Sim [id=" + id + ", telecomName=" + telecomName + ", simType=" + simType + ", mobile=" + mobile + "]";
	}
	
}
