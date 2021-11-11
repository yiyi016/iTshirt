package test4_mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import test4_mvc.dto.Product;
import test4_mvc.util.DBConnect;

public class OracleDao implements Dao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	// 기본생성자
	public OracleDao() {
		DBConnect dbconn = DBConnect.getInstance(); // 1.singleton 갹체ㅡㄹ 계속 생성하면 메모리 효율 떠렁지니까 한번만 가져다 쓰겟다
		conn = dbconn.getConnection();// 2. db 연결 완료
	}

	public Connection getConn() {
		return conn;
	}

	@Override
	public void insert(Product p) { // insert p=주소값
		String sql = "insert into product values(p_seq.nextval,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
			int count = pstmt.executeUpdate(); // getname getprice가 있으면 변수에 담아
			if (count > 0) {
				System.out.println("데이터가 저장되었습니다.");
			} else
				System.out.println("데이터가 저장되지않았습니다.");

		} catch (SQLException e) {
		}
	
	}

	@Override
	public Product select(int num) { // select one
		Product p = null;
		ResultSet rs = null;
		try {
			String query = "select * from product where num=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// int num2 = rs.getInt(1); // 생략 가능, num을 받아서 출력하니까
				String name = rs.getString("name"); // 2
				int price = rs.getInt("price"); // 3
				p = new Product(num, name, price);
				//System.out.println(num + ": " + name + ": " + price );
			}

		} catch (SQLException e) {

		}
		return p;
	}

	@Override
	public Vector<Product> selectAll() { // 전부검색
		System.out.println("Oracle selectAll");
		Vector<Product> v = new Vector<Product>();
		String query = "select * from product order by num"; // 모두 검색해서 보여줌
		try {
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(); // ResultSet : 쿼리를 조회할때 사용됨 executeQuery(String sql) 메소드통해서 저장되는것
			while (rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);

				v.add(new Product(num, name, price));
			}

		} catch (SQLException e) {

		}

		return v;
	}

	@Override
	public void delete(int num) { // void : 리턴값없음
		try {
			String query = "DELETE product where num=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("데이터가 삭제되었습니다.");
			} else {
				System.out.println("데이터가 입력되지 않았습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	@Override
	public void update(int num, Product p) {
		String query = "update product set name=?, price=? where num=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setInt(3, num); // num 대신 p.getNum도 가능

			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("업데이트가 저장되었습니다.");
			} else {
				System.out.println("데이터가 입력되지 않았습니다.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		// Connection 되어 있으므로 close하면 다음 수행 작업인 delete 수행 불가 

	}

}
