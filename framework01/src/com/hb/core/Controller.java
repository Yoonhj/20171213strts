package com.hb.core;

import javax.servlet.http.HttpServletRequest;

public interface Controller {

	String execute(HttpServletRequest req); //String�� �����ϴ� �߻�޼ҵ�... req�� ���ڷ� ���޹���.
}
