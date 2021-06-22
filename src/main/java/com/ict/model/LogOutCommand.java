package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		
		Cart.cartList.clear();
		Cart.total= 0 ;
		
		return "MyController?cmd=list";
	}
}
