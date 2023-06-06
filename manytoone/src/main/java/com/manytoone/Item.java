package com.manytoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double cost;
	
	@ManyToOne
	private AmazonOrder a0;

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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public AmazonOrder getA0() {
		return a0;
	}

	public void setA0(AmazonOrder a0) {
		this.a0 = a0;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", cost=" + cost + ", a0=" + a0 + "]";
	}

}
