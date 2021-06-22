package com.ict.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class ListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String category = request.getParameter("category");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		if(category==null || category=="") {
			category="ele002";
		}
		List<VO> list = DAO.getList(category);
		request.setAttribute("list", list);
		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		
		
		return "view/product_list.jsp";
	}
}
