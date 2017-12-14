package com.hb.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.AddController;
import com.hb.controller.DetailController;
import com.hb.controller.InsertController;
import com.hb.controller.ListController;
import com.hb.controller.UpdateController;

public class FrontController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//doget이 테스트하는게 잘보이니까 일단 이걸로 만들어두고
		//dopost는 doget에서 호출
		
		System.out.println("FrontController runs....");
		
		
		String uri = req.getRequestURI();//앞에 컨텍스트명 포함됨..framework01/~~
		String cpath =req.getContextPath();
		String url = uri.substring(cpath.length()); //url은 uri를 cpath의 길이뺀만큼 
		System.out.println(url);//파라미터가 있어도 상관없이 파라미터 쿼리문 ?aaa=bbb&ccc=ddd 빠지고 url만 나옴 
				
		
		Controller control=null;
			//execute를 가진 추상클래스/인터페이스가 있으면 다형성 이용가능
		
		if("/list.do".equals(url)){
			control = new ListController();

		}else if("/add.do".equals(url)){
			control = new AddController();
		}else if("/insert.do".equals(url)){
			control = new InsertController();
		}else if("/detail.do".equals(url)){
			control = new DetailController();
		}else if("/update.do".equals(url)){
			control = new UpdateController();
		}
		
		String viewName = control.execute(req);
		
		if(viewName.startsWith("redirect:")){
			
			resp.sendRedirect(viewName.replace("redirect:", ""));
					
			return; //redirect:로 시작하면 더이상 진행못하게 리턴 
			
		}
		viewName+=".jsp";
		
		req.getRequestDispatcher(viewName).forward(req, resp);
		
	}
	
	
}
