package test4_mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// 싱글톤 : 어떤 클래스가 최초 한번만 메모리에 할당하고 (static) 그 메모리에 객체를 만들어 사용하는 디자인 패턴이 싱글톤 
// 생성자 호출이 반복적이어도 실제로 생생성되는 객체는 최초 생성된 객체를 반환해줌 

public class DBConnect {
	// 전역변수 선언, static으로 인스턴스화 하지 않고 바로 사용 가능 , private 사용으로 직접적 사용 불가능 
	// => public static DBConnect getInstance()  메소드로 사용 가능 
	private static DBConnect db = new DBConnect(); 
	private Connection conn = null; //제 3자가 가져다 쓸수없음, 메소드로 사용 
	
	String jdbc_driver =  "oracle.jdbc.driver.OracleDriver";
	String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	
	private DBConnect() { // 기본생성자
		try {
				Class.forName(jdbc_driver);
				conn = DriverManager.getConnection(ur1, "javalink", "javalink");
			
		} catch (ClassNotFoundException e) {  //Connection 생성
		
		} catch (SQLException e) {
	}
}
	
	// Singleton : 메소드르 통한 객체생성을 한번만, 현재 클래스에서 생성
	public static DBConnect getInstance() { // 싱글통레 해당
		return db;
	}

	//db연결 완료된 상태 
	public Connection getConnection() { // 연결하려는 내용을 가져다 쓰겠다 
		return conn ;
	}
}
