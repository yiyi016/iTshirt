package ttttt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import test4_mvc.dto.Product;

public class DAOoverride implements DAO {
	// 데이터 베이스에 접근하여 수정, 검색, 생성 삭제 가능 (CRUD) - 접근해서 뭘 가져올건지..?
		// 객체간 연결은 인터페이스 사용 
	private Connection con = null;
	private PreparedStatement pstmt = null;
	
	public DAOoverride() { //기본생성자 : db 연결 
		//ConnectionEx dbcon = ConnectionEx.getInstance(); // 만든 객체를 계속 사용 => 싱글톤
		//conn = dbcon.getConnection();
		
	}
	
	
	@Override
	public void insert(Product p) {
//1. 쿼리문
		String sql = "insert into product values (p_seq.nextval,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("데이터가 저장되었습니다.");
			} else
				System.out.println("데이터가 저장되지않았습니다.");
			
		} catch (SQLException e) {
			
		}
		
		
//2. 실행문
	}

	@Override
	public Product select(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int num) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<Product> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
