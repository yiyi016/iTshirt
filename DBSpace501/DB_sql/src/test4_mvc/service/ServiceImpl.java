package test4_mvc.service;

import java.util.Scanner;
import java.util.Vector;

import test4_mvc.dao.Dao;
import test4_mvc.dao.OracleDao;
import test4_mvc.dto.Product;
public class ServiceImpl implements Service {
	Scanner sc = new Scanner(System.in);
	Dao dao = new OracleDao(); // 부모으 눈으로 자식 

	@Override
	public void addProduct() { //insert 할떄
	// Scanner 키보드 입력 부분 
		System.out.println("제품이름은?");
		String name = sc.next();
		System.out.println("제품가격은?");
		int price = sc.nextInt();
		//Product  p = new Product(0,name,price); //1
		//dao.insert(p);
		
		dao.insert(new Product(0,name,price));//1과 동일한 것
	}
	
	@Override
	public Product getProduct() { //  select one
		System.out.println("검색할 번호는?");
		int num = sc.nextInt();
		Product p = dao.select(num);
		return p;
	}

	@Override
	public void editProduct() { // update
	 System.out.println("수정할 제품 번호 : ");
	 
	 int num = sc.nextInt();
	 Product p = dao.select(num);
	 System.out.println(p);
	 
	 System.out.println("새 제품 이름 :");
	 String name = sc.next();
	 
	 System.out.println("새 제품 가격 :");
	 int price = sc.nextInt();
	 p.setName(name);
	 p.setPrice(price);
	 dao.update(p.getNum(), p);//num과 product가 와야함 바뀌는 내용을 넣어준다 
	}

	@Override
	public void delProduct() { // delete
		System.out.println("삭제할 제품 번호");
		 int num = sc.nextInt(); // 숫자를 입력받아서 
		 dao.delete(num); // dao의 del로 감ㅁ
		
	}

	@Override
	public Vector<Product> getProducts() { // select all 
		//1. dao에 있는 Vector<Product> selectAll();를 가져옴 
		Vector<Product> v = dao.selectAll();
		return v ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	

}
