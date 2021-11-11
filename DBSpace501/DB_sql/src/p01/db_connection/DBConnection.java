package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Java => Oracle DB 연결 유무 확인 방법 
public class DBConnection {
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//Class.forName("java.lang.String);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String ur1 = "jdbc:oracle:thin:@localhos:1521:orcl";
			
				conn = DriverManager.getConnection(ur1,"javalink","javalink");
				conn.close();
				
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("정상종료"); // 항상 실행 
		
		
	}
	

}
