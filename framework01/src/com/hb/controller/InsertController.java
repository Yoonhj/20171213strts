package com.hb.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hb.core.Controller;
import com.hb.model.GuestDao;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		
		Map<String, String> param = new HashMap<String, String>();
		Enumeration<String> paramNames = req.getParameterNames(); //�ڷᱸ���� ������ ���� �ٽ� ����... ���� ������ ��� �̸����� �̾���

		while(paramNames.hasMoreElements()){
			
			String pname = paramNames.nextElement(); 
			param.put(pname, req.getParameter(pname));
			
		}
		
		int sabun = Integer.parseInt(param.get("sabun"));
		String name = param.get("name");
		String nalzza = param.get("nalzza");
		int pay = Integer.parseInt(param.get("pay"));
		
		
		System.out.println(sabun);
		System.out.println(name);
		System.out.println(nalzza);
		System.out.println(pay);
		
		
		GuestDao dao = new GuestDao();
		dao.insertOne(sabun, name, nalzza, pay);
		
		return "redirect:list.do";
	}

}
