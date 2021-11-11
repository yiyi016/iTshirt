package plsapl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class PlsqlProcedure {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// 오라클 연결 (DB연결)
		//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		//변수선언
		int p1Invalue = Integer.parseInt(args[0]); //2 // 아규먼트에 값 넣어주기
		int p2InOutvalue = Integer.parseInt(args[1]); //3 // 아규먼트에 값 넣어주기
		int p3Outvalue;
		//2. 계정 연결
			Connection conn = DriverManager.getConnection(ur1,"javalink","javalink");
			CallableStatement cs = conn.prepareCall("{call computer_power(?,?,?)}"); 
			//call computer_power => 저장된 데이터를 불러옴  plsql에서 많이 쓰이는 방법 
			
			cs.setInt(1, p1Invalue);
			
			cs.setInt(2, p2InOutvalue);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.INTEGER); // 3번쨰 값에 인티저타입이 와야한다
			
			cs.execute();
			
			p2InOutvalue = cs.getInt(2);
			p3Outvalue = cs.getInt(3);
		
			System.out.println(p1Invalue+"^" + p2InOutvalue + "=" + p3Outvalue);
	}

}
