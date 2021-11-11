package study07_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDtest {
	Connection con = null;
	Statement stmt = null;

	static { // 항상 메모리에 잇음
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다. ");
		}
	}

	public void connect() { // 객체가 생성이 되어야 사용 가능
		String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			con = DriverManager.getConnection(ur1, "javalink", "javalink");
			System.out.println("Connection Success!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("주소, id, pw가 다릅니다. ");
		}
	}

	public void insert() {
		// Insert = > 'aaa','1111','홍길동','22','서울시','a@a.com'"

		try {
			// Class.forName("java.lang.String);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";

			con = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = con.createStatement();

			String query = "insert into member1 values('aaa', '1111', '홍길동', 22, '서울시', 'a@a.com')";
			int count = stmt.executeUpdate(query);
			if (count > 0) {
				System.out.println("데이터가 저장되었습니다.");
			} else {
				System.out.println("데이터가 입력되지 않았습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("정상종료"); // 항상 실행
		try {
			con.close();
		} catch (SQLException e) {

		}

	}

	public void select() {

		try {
			// Class.forName("java.lang.String);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";

			con = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = con.createStatement();
			String query = "select * from member1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String age = rs.getString(4);
				String email = rs.getString(5);
				System.out.println(id + ": " + password + ":  " + name + ": " + age + ": " + email);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("정상종료"); // 항상 실행
		try {
			con.close();
		} catch (SQLException e) {

		}

	}

	public void update() {
		// id=aaa 를 찾아서 addr=부산시

		try {
			// Class.forName("java.lang.String);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";

			con = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = con.createStatement();

			String query = "update member1 set addr='부산시' where id='aaa'";
			int count = stmt.executeUpdate(query);
			if (count > 0) {
				System.out.println("업데이트가 저장되었습니다.");
			} else {
				System.out.println("데이터가 입력되지 않았습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("정상종료"); // 항상 실행
		try {
			con.close();
		} catch (SQLException e) {

		}

	}

	public void delete() {
		// id=aaa 삭제
		try {
			// Class.forName("java.lang.String);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String ur1 = "jdbc:oracle:thin:@localhost:1521:orcl";

			con = DriverManager.getConnection(ur1, "javalink", "javalink");
			stmt = con.createStatement();

			String query = "DELETE member1  where id = 'aaa'";
			int resulte = stmt.executeUpdate(query);
			if (resulte > 0) {
				System.out.println("데이터가 삭제되었습니다.");
			} else {
				System.out.println("데이터가 입력되지 않았습니다.");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음 :: 해당 클래스를 찾을 수 없습니다.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("정상종료"); // 항상 실행
		try {
			con.close();
		} catch (SQLException e) {

		}

	}

	public static void main(String[] args) {
		CRUDtest st = new CRUDtest();
		st.connect();
		st.insert();
		System.out.println("insert 수행 후");
		st.connect();
		st.select();

		st.connect();
		st.update();
		System.out.println("update 수행 후");
		st.connect();
		st.select();

		st.connect();
		st.delete();
		System.out.println("delete 수행 후");
		st.connect();
		st.select();

	}
}
