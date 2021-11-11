package plsapl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallInoutProc extends Object{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		//DB접속 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		//변수 선언 
		String p1value = new String ("a");
		String p2value = new String ("b");
		String p3value;
		
		//연결
		Connection conn = DriverManager.getConnection(ur1,"javalink","javalink");
		CallableStatement cs = conn.prepareCall("{call javatest(?,?,?)}"); 
		cs.setString(1, p1value);
		
		cs.setString(2, p2value);
		cs.registerOutParameter(2, Types.VARCHAR);
		
		cs.registerOutParameter(3, Types.VARCHAR);
		cs.execute();
		
		p2value=cs.getString(2);
		p3value=cs.getString(3);
		
	System.out.println("p2 : " + p2value); // ab
	System.out.println("p3 : " + p3value); //a
}
}
