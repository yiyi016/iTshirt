package test3;

public class SampleDTO {
//클래스 아넹 데이터를 넣고 끌어다가 쓰겟다 
	//DTO는 데이터를 얻어 보낼떄 사용, getter와 setter 메소드 사용 
	private String id;
	String name;
	int price;
	
//	public SampleDTO(String id, String name, int price) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
	
	
}
