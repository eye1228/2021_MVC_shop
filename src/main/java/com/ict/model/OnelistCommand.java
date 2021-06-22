package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class OnelistCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		
		VO vo = DAO.getOneList(idx);
		request.setAttribute("vo", vo);
		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		
		return "view/product_content.jsp";
	}

}
