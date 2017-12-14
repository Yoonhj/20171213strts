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
		//doget�� �׽�Ʈ�ϴ°� �ߺ��̴ϱ� �ϴ� �̰ɷ� �����ΰ�
		//dopost�� doget���� ȣ��
		
		System.out.println("FrontController runs....");
		
		
		String uri = req.getRequestURI();//�տ� ���ؽ�Ʈ�� ���Ե�..framework01/~~
		String cpath =req.getContextPath();
		String url = uri.substring(cpath.length()); //url�� uri�� cpath�� ���̻���ŭ 
		System.out.println(url);//�Ķ���Ͱ� �־ ������� �Ķ���� ������ ?aaa=bbb&ccc=ddd ������ url�� ���� 
				
		
		Controller control=null;
			//execute�� ���� �߻�Ŭ����/�������̽��� ������ ������ �̿밡��
		
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
					
			return; //redirect:�� �����ϸ� ���̻� ������ϰ� ���� 
			
		}
		viewName+=".jsp";
		
		req.getRequestDispatcher(viewName).forward(req, resp);
		
	}
	
	
}
