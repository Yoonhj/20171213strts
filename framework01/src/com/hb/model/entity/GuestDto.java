package com.hb.model.entity;

import java.sql.Date;

public class GuestDto {
	
	private int sabun;
	private String name;
	private Date nalzza;
	private int pay;
	
	public GuestDto() {
		toString();
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNalzza() {
		return nalzza;
	}

	public void setNalzza(Date nalzza) {
		this.nalzza = nalzza;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "GuestDto [sabun=" + sabun + ", name=" + name + ", nalzza="
				+ nalzza + ", pay=" + pay + "]";
	}
	
	
	
}
