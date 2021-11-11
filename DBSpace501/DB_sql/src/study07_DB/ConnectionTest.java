package study07_DB;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class ConnectionTest {
	//연결 
	Connection con;
	static{ // 항상 메모리에 잇음 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다. ");
		}
	}
	public void connect(){ // 객체가 생성이 되어야 사용 가능 
		String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(ur1,"javalink","javalink");
			System.out.println("Connection Success!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("주소, id, pw가 다릅니다. ");
		}
	}

	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.connect();

		
		

	}
}



