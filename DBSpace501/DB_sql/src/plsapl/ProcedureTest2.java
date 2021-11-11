package plsapl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureTest2 {
	
	//저장프로시저 호출전 데이터 입력 
	Connection con = null;
	PreparedStatement pstmt = null;
	static { // 항상 메모리에 잇음
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다. ");
		}
	}
	
	public void connect() {
		
		String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(ur1, "javalink", "javalink");
			System.out.println("Connection Success!!!");
		} catch (SQLException e) {
	
		}
	}
			public void insert(){
			connect();
			try {
			String query = "insert into member2 values(?,?,?,?,?,?)";
			 pstmt = con.prepareStatement(query);
			pstmt.setString(1, "Alpha");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "AI");
			pstmt.setInt(4, 20);
			pstmt.setString(5, "LA");
			pstmt.setString(6, "go@ai.com");
			int count =pstmt.executeUpdate();
			if(count>0)
				System.out.print("insert success!!");
			else
				System.out.println("insert fail");
		}
			catch (SQLException e) {
	
		}finally {
			try {
				con.close();
				pstmt.close();
			} catch (SQLException e) {
			
			}
		}
		}
		
		public void select(){ 
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			connect();
			
			try {
				String sql = "select * from member2";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
		
			while (rs.next()) {
				System.out.println("아이디 : " +rs.getString(1) + "비밀번호 : " + rs.getString(2)+
						"이름 : " + rs.getString(3)+
						"나이 : " + rs.getString(4)+ // 화면에 출력만해주는거니까 문자로 해도 ㄱㅊㄱ
						"주소 : " + rs.getString(5)+
						"이메일 : " + rs.getString(6));
			} 
			}catch (SQLException e) {
					
				}finally {
					try {
						con.close();
						pstmt.close();
					} catch (SQLException e) {
					
					}
				}
				}
		//저장프로시저 호출 후 데이터 입력 

		public void insertMember(){ 
			CallableStatement cs = null;
			connect();
			try {
			String sql = "{call user_insert(?,?,?,?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setString(1, "Proceduer");
			cs.setString(2, "1234");
			cs.setString(3, "홍길동");
			cs.setInt(4, 19);
			cs.setString(5, "강원도");
			cs.setString(6, "hong@aa.com");
			int count =cs.executeUpdate();
			if(count>0)
				System.out.print("insert success!!");
			else
				System.out.println("insert fail");
		}
			catch (SQLException e) {
	
		}finally {
			try {
				con.close();
				cs.close();
			} catch (SQLException e) {
			
			}
		}
		}
		
		
		public static void main(String[] args) { 
			ProcedureTest2 pt = new ProcedureTest2();
			
			System.out.println("**** 저장 프로시저 호출 전 데이터 **** ");
			pt.insert();
			pt.select();
			
			System.out.println("**** 저장 프로시저 호출 후 데이터 **** ");
			//pt.insert();
		//	pt.select();
			

		}	 

	}

