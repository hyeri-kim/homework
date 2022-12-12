package hallyu;

// 메인 메뉴
// 메뉴 번호를 입력하면 해당 클래스의 run() 메소드 실행

// VIEW
// ★원하시는 메뉴를 선택하세요★
// ①연간 주요 이슈
// ②한류 국가별 현황
// ③추천 콘텐츠

import javax.swing.JOptionPane;

public class Menu {
	String guideMsg = "★원하시는 메뉴를 선택하세요★\n";
	String menuMsg = "①연간 주요 이슈\n②한류 국가별 현황\n③추천 콘텐츠\n④종료\n";
	String choice = "";
	
	// 사용할 자식클래스 객체화
	Issue issue = new Issue();
	ByCountry byCountry = new ByCountry();
	Detail detail = new Detail();
	
	// 부모 타입으로 자식 객체 선언
	// 자식클래스에서 재정의된 메소드 run() 호출
	public void move(Option option) {
		option.run();
	}
	
	public void run() {
		while(true) {
			choice = JOptionPane.showInputDialog(guideMsg + menuMsg);
			
			// 취소버튼을 누르거나 x로 창을 닫으면 프로그램 종료
			if(choice == null || choice.equals("")) {
				System.exit(0);
			}

			if(choice.equals("1")) { // 연간 주요 이슈 영역
				move(issue); // Issue 클래스의 run() 메소드 실행
				break;
			} else if(choice.equals("2")) { // 한류 국가별 현황 영역
				move(byCountry); // ByCountry 클래스의 run() 메소드 실행
				break;
			} else if(choice.equals("3")) { // 추천 콘텐츠 영역
				move(detail); // Detail 클래스의 run() 메소드 실행
				break;
			} else if(choice.equals("4")) { // 프로그램 종료
				System.exit(0);
			} else { // 잘못된 입력일 경우
				JOptionPane.showMessageDialog(null, "다시 입력해주세요.");
				continue;
			}
		}
	}
}
