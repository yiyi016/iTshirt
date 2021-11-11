package ttttt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
//1. JDBC 드라이버 로드 : Class.forName(“driver”)을 이용해서 Driver Class를 로딩하면 객체가 생성되고, DriverManager에 등록됩니다.
// Driver 클래스를 찾지 못할 경우, ClassNotFoundException 예외 발생 => try/catch
//2. Connection 생성 : 데이터 베이스와 연결하는 객체 
// DriverManager.getConnection(연결문자열, DB_ID, DB_PW) 으로 Connection 객체를 생성 (연결문자열 : "jdbc:Driver종류://IP:포트번호/DB명")								
// DriverManager 클래스  =>  JDBC 드라이버를 통하여 Connection을 만드는 역할

	public static void main(String[] args) {

		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String ur1 = "jdbc:oracle:thin:@localhos:1521:orcl"; // 연결문자열

			con = DriverManager.getConnection(ur1, "javalink", "javalink");// DB_ID, DB_PW - 틀릴수도있으니까 트라이케치
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());		
		}
		System.out.println("정상종료"); // 항상 실행 

	}
}
