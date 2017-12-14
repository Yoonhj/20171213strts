package com.hb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.Controller;
import com.hb.model.GuestDao;
import com.hb.model.entity.GuestDto;

public class ListController implements Controller {
	//Plain Old Java Object 
	//list.do로 들어왔을때
	
	public String execute(HttpServletRequest req){
		System.out.println("List Controller run...");
		
		GuestDao dao = new GuestDao();
		List<GuestDto> list = dao.selectAll();
		
//		for(GuestDto bean : list){
//			System.out.println(bean);
//		}
		
		req.setAttribute("alist", list);
		
		return "list";
	}
	
}
