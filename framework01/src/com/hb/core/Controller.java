package com.hb.core;

import javax.servlet.http.HttpServletRequest;

public interface Controller {

	String execute(HttpServletRequest req); //String을 리턴하는 추상메소드... req를 인자로 전달받자.
}
