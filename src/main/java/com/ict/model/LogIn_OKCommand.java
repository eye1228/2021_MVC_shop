package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.MVO;

public class LogIn_OKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MVO m_vo = new MVO();
		m_vo.setId(request.getParameter("id"));
		m_vo.setPw(request.getParameter("pw"));
		
		System.out.println(m_vo.getId() + "??");
		
		MVO mvo = DAO.getLogIn(m_vo);
		
		if(mvo == null) {
			return "MyController?cmd=login";
		}else {
			request.getSession().setAttribute("mvo", mvo);
			request.getSession().setAttribute("login","ok");
			
			if(mvo.getId().equals("admin")) {
				request.getSession().setAttribute("admin", "ok");
				return "MyController?cmd=admin";
			}
			
			return "MyController?cmd=list";
		}
	}
}
