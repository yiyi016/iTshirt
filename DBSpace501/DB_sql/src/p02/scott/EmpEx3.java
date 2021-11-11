package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import study02_DB.User;

public class EmpEx3 {
	//scott DB에 있는 EMP테이블 데이터를 자바에서 출력하기 
	//Scanner 입력을 받아서 empno=7902에 해당 레코드(tuple) 출력하기 
	//statement => PerparedStatement
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
		//2. 계정 연결
			Connection conn = DriverManager.getConnection(ur1,"scott","scott");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("[EMPNO 입력 : ]");
			int no = sc.nextInt(); // 7902
			
			String query = "select * from emp where empno=?"; 
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no); //setint => 저장 
			
		//3. Query
			
	
		//4. 실행과 리턴
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { // 여러사람 출력하고 싶을떄는 while
				int empno = rs.getInt(1);
				String ename= rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4); // getInt => 문자열을 숫자로 바꿔주는 메소드 
				Date hirdate = rs.getDate(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				System.out.println(empno + " : " + ename + " : " + job + " : " + mgr + " : " + hirdate+ " : "+ sal + " : "+ comm+ " : "+ deptno);
				
				
			}

				
		//5. DB 종료 
		sc.close();
		rs.close();
		pstmt.close();
		conn.close();
				


	}

}
