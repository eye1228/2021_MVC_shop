package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.MVO;
import com.ict.db.VO;

public class LoginOKCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		MVO m_vo = new MVO();

		m_vo.setId(request.getParameter("id"));
		m_vo.setPw(request.getParameter("pw"));

		System.out.println(request.getParameter("id") + "   ����");
		
		
		MVO mvo = DAO.getLogIn(m_vo);

		if (mvo == null) {
			return "MyController?cmd=login";
		}else {
			request.getSession().setAttribute("mvo", mvo);
			request.getSession().setAttribute("login", "ok");
			
			//���������� �Ϲ� �������� �˻�
			//�����ڴ� ��ǰ �߰� ������ �������� �̵�, �Ϲ� ������ product_list.jsp�� �̵�
			if(mvo.getId().equals("admin")) {
				request.getSession().setAttribute("admin", "admin_ok");
				return "MyController?cmd=admin";
			}
			return "MyController?cmd=list";
		}
	}
}
