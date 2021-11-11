package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpEx1 {
	//scott DB에 있는 EMP테이블 데이터를 자바에서 출력하기 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
		//2. 계정 연결
			Connection conn = DriverManager.getConnection(ur1,"scott","scott");
			Statement stmt = conn.createStatement();
		//3. Query
			String query = "select * from emp";
		//4. 실행과 리턴
			ResultSet rs = stmt.executeQuery(query); // 이거수행항면 오라클데이터베이스 갓다온거임 ('aaa','aaa','홍길동',22,'서울시','a@a.com'); => 한사람꺼
			while (rs.next()) { // 여러사람 출력하고 싶을떄는 while
				int empno = rs.getInt(1);
				String ename= rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4); // getInt => 문자열을 숫자로 바꿔주는 메소드 
				Date hirdate = rs.getDate(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				System.out.println(empno + " :" + ename + ":" + job + " :" + mgr + ":" + hirdate+":"+ sal + ":"+ comm+ ":"+deptno);
			}

				
		//5. DB 종료 
		
				


	}

}
