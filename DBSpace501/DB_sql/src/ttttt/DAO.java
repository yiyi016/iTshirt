package ttttt;

import java.util.Vector;
import test4_mvc.dto.Product;

public interface DAO {
	// 데이터 베이스에 접근하여 수정, 검색, 생성 삭제 가능 (CRUD) - 접근해서 뭘 가져올건지 ? 
	// 객체간 연결은 인터페이스 사용 
	
	void insert(Product p); // Product에 담긴 데이터를 insert  하겠다 (제품등록)
	Product select (int num); //Product 갹체에 있는 num을 검색 (select) (제품 검색)
	void delete (int num); // 객체를 삭제 (5. 삭제)
	void update (int num); // 객체를 수정 (4. 수정 )
	Vector<Product> selectAll();
	
	 // Vector에 담긴 객체(3. 전체 검색) 
// Vector는 ArrayList와 동일한 내부 구조 , 내부의 값이 추가되면 자동으로 크기가 조절되어 그다음 객체들은 한자리씩 뒤로 이동 
	// 동기화 가능,  Vector<E> v = new Vector<E> (); => 객체생성 ????

}
