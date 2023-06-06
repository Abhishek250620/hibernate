package com.onetomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AmazonOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String address;
	private String status;
	private long phNo;
	
	@OneToMany
	private List<Item> item;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "AmazonOrder [orderId=" + orderId + ", address=" + address + ", status=" + status + ", phNo=" + phNo
				+ ", item=" + item + "]";
	}

}
