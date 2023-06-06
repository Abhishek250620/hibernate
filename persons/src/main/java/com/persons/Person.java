package com.persons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name="personTable")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String loc;
	
	@OneToOne
	private PanCard pancard;
	@Column(nullable = false, unique = true)
	private long phno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public PanCard getPancard() {
		return pancard;
	}
	public void setPancard(PanCard pancard) {
		this.pancard = pancard;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", loc=" + loc + ", pancard=" + pancard + ", phno=" + phno + "]";
	}
	
	
	
}
