package test4_mvc.controller;

import java.util.Scanner;
import java.util.Vector;
import test4_mvc.dto.Product;
import test4_mvc.service.Service;
import test4_mvc.service.ServiceImpl;

public class ProductMain {

	public static void main(String[] args) {
		
		Service service = new ServiceImpl(); //부모의 인터페이스 눈으로 생성된 자식 보기 
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		int menu;
		Product p = null;
		Vector<Product> v = null; // 밖으로 뺴기, 공유변수  , 안해도딤
		while (flag) {
			System.out.println("1.제품등록 | 2.제품검색 | 3.전체검색 | 4.수정 | 5.삭제 | 6.종료");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1: 
				//1. insert
				service.addProduct();
				break;
			case 2: 
				//2. 제품 검색 select one 
				p =  service.getProduct();
				System.out.println(p);
				break;
			case 3 :
				//3. select All
				v = service.getProducts(); // select all 벡터의 주소값
				for(int i = 0; i<v.size();i++) 
					System.out.println(v.get(i));
				break;
			case 4 :
				//4. update
				service.editProduct();
				break;
				
			case 5 : 
				//5. delete
				service.delProduct(); 
				break;
			case 6 :
				flag = false;
			break;	
			default :
				System.out.println("다시 입력 하세요");
			}
		}
		sc.close();
	}

}
