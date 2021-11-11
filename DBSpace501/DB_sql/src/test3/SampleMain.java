package test3;

import java.sql.SQLException;
import java.util.ArrayList;

public class SampleMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SampleDAO dao = new SampleDAO();
		ArrayList<SampleDTO> books = dao.findAll(); // findALL에 있는 내용을 ArrayLIst<>에 넣어주기 
		
		//for 출력
		for(SampleDTO s : books) {
			System.out.println("id: "+ s.getId());
			System.out.println("name: "+ s.getName());
			System.out.println("price: "+ s.getPrice());
			System.out.println();
		}
	}
}