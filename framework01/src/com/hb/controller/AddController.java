package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.Controller;

public class AddController implements Controller{
	//Plain Old Java Object 
	//add.do로 들어왔을때
	
	public String execute(HttpServletRequest req){
		System.out.println("Add Controller run...");
		return "add";
	}
	
}
