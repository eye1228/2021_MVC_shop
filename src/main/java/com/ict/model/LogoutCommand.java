package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//���� �ʱ�ȭ
		request.getSession().invalidate();
		
		
		Cart.cartList.clear();
		Cart.total = 0;
		
		return "MyController?cmd=list";
	}

}
