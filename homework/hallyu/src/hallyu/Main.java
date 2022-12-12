package hallyu;

// 실행 페이지 : Main
// 메인메뉴 페이지 : Menu
// 로그인 페이지 : LoginPage
// 회원가입 페이지 : JoinPage

// 부모클래스 : Option
// 자식클래스 : Issue, ByCountry, Detail

// 프로그램 실행하면 제일 먼저 로그인 화면 띄우기

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		// 컬렉션 프레임워크로 HashMap 사용
		// key : 아이디
		// value : 비밀번호
		HashMap<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("java", "2022"); // (기본) 관리자 아이디 & 비밀번호
		
		LoginPage loginPage = new LoginPage(loginInfo); // 프로그램 실행 시 로그인 먼저 하도록 구현
	}
}
