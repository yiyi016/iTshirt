package study02_DB;

import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		boolean isStop = false;
		LoginSVC loginSVC = new LoginSVC();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("로그인 화면입니다.");
			System.out.println("아이디와 비밀번호를 입력하세요.");
			System.out.println("아이디 : ");
			String id = sc.next();
			System.out.println("비밀번호 : ");
			String passwd = sc.next();
			
			User user = loginSVC.login(id, passwd); // user안에 'aaa','aaa','홍길동',22,'남','a@a.com' 이거 다 들어있음 
			
			if(user == null) { 
				System.out.println("아이디나 비밀번호가 일치하지 않습니다.");
			}else {
				System.out.println("로그인한 사용자 정보");
				System.out.println(user); // user가 null 아니면 user값 => 주소값나옴 => toString
				//break, ture
				isStop = true;
			}
		}while (!isStop);
		
	}

}
