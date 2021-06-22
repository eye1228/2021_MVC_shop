package com.ict.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ict.db.DAO;
import com.ict.db.VO;

public class Cart {
	static List<VO> cartList ;  // īƮ�� ����� ��ǰ ����Ʈ
	static int total;           // īƮ ��ü �ݾ�
	static {
		cartList = new ArrayList<VO>();
	}
	
	// īƮ�� �ش� ��ǰ�� �ִ��� ������ �˻��ϴ� �޼ҵ� 
	public static VO findProduct(String idx) {
		VO cvo = null;
		Iterator<VO> it = cartList.iterator();
		while(it.hasNext()) {
			VO vo = (VO) it.next();
			if(vo.getIdx().equalsIgnoreCase(idx)) {
				cvo = vo;
				break;
			}
		}
		return cvo;
	}
	
	// īƮ�� ��ǰ�� ��� �޼ҵ�
	// īƮ�� ���� ��ǰ�� ���� īƮ�� �����ϸ� ������ ����
	// īƮ�� ���� ��ǰ�� ���� īƮ�� �������� ������ īƮ�� �߰�
	public static void addProduct(String idx) {
		VO vo = findProduct(idx);
		if(vo == null) {
			// ���� īƮ�� ��ǰ�� ���ٴ� ��(ī�忡 ��ǰ�� ��´�.)
			vo = DAO.getOneList(idx);
			vo.setQuant(1);    // ī�忡 �����ϴ� ��ǰ�� ����
			cartList.add(vo);
		}else {
			// īƮ�� �����ϴ� ��ǰ�� ������ ������ 1���� ��Ų��.
			vo.setQuant(vo.getQuant()+1);
		}
		// ������ǰ�� �ƴ� ��ǰ�� �����ؾ� �ȴ�.
		total = total + vo.getP_saleprice();
	}
	
	// īƮ���⿡�� īƮ�� ������ �����ϴ� �޼ҵ�
    public static void setQuant(String idx, int su) {
    	VO vo = findProduct(idx);
    	total = total - vo.getTotalPrice();
    	
    	vo.setQuant(su);
    	total = total +vo.getTotalPrice();
    }
	
	// īƮ���⿡�� īƮ���� ��ǰ�� �����ϴ� �޼ҵ�
	public static void setDelete(String idx) {
		VO vo = findProduct(idx);
		cartList.remove(vo);
		total = total - vo.getTotalPrice();
	}
	
}










