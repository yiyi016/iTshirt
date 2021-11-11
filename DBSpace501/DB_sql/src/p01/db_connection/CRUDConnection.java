package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CRUDC : Create Read Update Delete

//executeQuery(String sql) : select 문장을 사용 시 
// int	executeUpdate(String sql) : (결과가 숫자가 나옴) > insert, update, delete문 사용 시 
public class CRUDConnection {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//Class.forName("java.lang.String);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
			
				conn = DriverManager.getConnection(ur1,"javalink","javalink");
				stmt = conn.createStatement();
				String query = "select * from member";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) { // sql->java 숫자는 인식 못한 문자열로 가져와서 나중에 형변환해야함 
					String id = rs.getString(1);
					String password = rs.getString(2);
					String name = rs.getString(3);
					String age = rs.getString(4);
					String email = rs.getString(5);
					System.out.println(id + ": " + password + ":  " + name + ": " + age + ": " + email);
				}
					
				
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("정상종료"); // 항상 실행 
		try {
			conn.close();
		} catch (SQLException e) {
			
		}

	}

}
