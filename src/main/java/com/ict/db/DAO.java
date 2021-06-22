package com.ict.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	
	//전체 리스트 보기
	public static List<VO> getList(String category){
		List<VO> list = null;
		list = getSession().selectList("list", category);
		
		return list;
	}

	//상세보기
	public static VO getOneList(String idx) {
		VO vo = null;
		
		vo = getSession().selectOne("onelist", idx);
		
		return vo;
	}

	//로그인
	public static MVO getLogIn(MVO m_vo) {
		MVO mvo = null;
		System.out.println(m_vo.getId());
		System.out.println(m_vo.getPw());
		
		mvo = getSession().selectOne("login", m_vo);
		System.out.println(mvo);
		return mvo;
	}

	//상품 추가
	public static int getProductInsert(VO vo) {
		int result = 0;
		result = getSession().insert("product_add", vo);
		
		return result;
	}
}