package study02_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginSVC {
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
	
	public User login (String id, String passwd) {
		connect(); // 인스턴스 메소드는 인스턴스 메소에서 사용할때 그냥 쓸수잇음 객체 생성 없이 login()수행할때 connect도 같이 끌고가서 쓸거라서 객체 생성 안함 
		User user = null;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "select *from member1 where id = '" +id + "' AND " + "password ='" + passwd + "'";
			ResultSet rs = stmt.executeQuery(sql); // 이거수행항면 오라클데이터베이스 갓다온거임 ('aaa','aaa','홍길동',22,'서울시','a@a.com'); => 한사람꺼
			if (rs.next()) { // 여러사람 출력하고 싶을떄는 while
				 id = rs.getString(1);
				 passwd = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt("age"); // getInt => 문자열을 숫자로 바꿔주는 메소드 
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				user = new User(id, passwd, name, age, addr, email);
			}

			
		}	
		
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return user;
		
	}
}
















