package test3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SampleDAO {
	//DAO : 데이터를 DB에 가서 찾아오는 역할 DB에접근 
	
	//DB 내용을 찾아서 SampleDTO에 넣은 후 ㅁ어레이리스트에 
	public ArrayList<SampleDTO> findAll() throws ClassNotFoundException, SQLException {
		ArrayList<SampleDTO> sampleDTOs = new ArrayList<SampleDTO>();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
		//2. 계정 연결
			Connection conn = DriverManager.getConnection(ur1,"javalink","javalink");
			Statement stmt = conn.createStatement();
		//3. Query
			String query = "select * from book";
		//4. 실행과 리턴
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) { // 여러사람 출력하고 싶을떄는 while
				SampleDTO dto = new SampleDTO();
				dto.setId(rs. getString(1));
				dto.setName(rs. getString(2));
				dto.setPrice(rs. getInt(3));
				
				sampleDTOs.add(dto);
				
			}

		
		return sampleDTOs;
		
		
	
	
	
}
	

}
