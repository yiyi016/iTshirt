package test4_mvc.dao;

import java.util.Vector;

import test4_mvc.dto.Product;
// 인터페이스 : 강제성, 일관성
public interface Dao {
//추상메소드만 들어있는??? 구현한 클래스를 하나 만들어랑 
	
	
	void insert(Product p); // Product 객체의 주소값이 insert 추상메소드에 들어있음
	
	Product select (int num);
	Vector<Product> selectAll(); // selectAll 메소드를 수행하면 배열에 product가 순차적으로 드렁있음 
	void delete (int num);
	void update (int num, Product p); // 기본키를 넣고 
	
	
}
