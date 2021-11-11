package ttttt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx {
	
	//1. 변수선언 
	private static DBConnection db = new DBConnection(); // 전역변수 선언 
	private Connection con = null; 
	
	String sql  ="oracle.jdbc.driver.OracleDriver"; //드라이버 주소 ?
	String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";//드라이버 주소 ?
	
	
	//2. 생성자 
	private ConnectionEx () { // 기본 생성자 
		try {
			Class.forName(sql); //JDBC 드라이버 로드
			con =  DriverManager.getConnection(ur1) ; //Connection 생성
		} catch (ClassNotFoundException e) {
					System.out.println("driver를 찾을 수 없습니다. ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	
	//3. 메소드 
	 // private 선언으로 가져다 쓸수없으므로 메소드 선언
	public static DBConnection getInstance() { // singleton
		return db;  
	}
	
	public Connection getConnection() {
		return con;
	}
	
}
	



