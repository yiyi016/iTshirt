package test4_mvc.dto;

public class Product {
//VO=DTO=bin=getter/setter
	//DTO : 데이터를 담아 움직이는 객체 
	// 특별한 로직 없이 getter/setter를 가짐 
	
	// 1. 
	private int num;
	private String name;
	private int price;
	
	
	public Product(int num, String name, int price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
		public String toString() {
		String resulte = num+name+price;
			return resulte;
			
		}
	
	
	
	
}
