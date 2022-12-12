package hallyu;

// 키워드 검색받아서 관련 이슈 보여주기
// 이슈 추가도 가능 	1. 예 : 이슈 추가 후 파일 출력
//				2. 아니오 : 파일만 출력
//				3. 취소 : 메인 메뉴로 이동

// VIEW
// [키워드를 입력하세요.]
// 입력 예시 : 방탄소년단, 블랙핑크, 미나리, 예능, 애니메이션, 오징어게임, 배틀그라운드(입력 예시와 똑같이 입력해야 함)

import java.io.FileInputStream;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Issue extends Option {
	
	int choice;
	String txt = ""; // 추가할 이슈를 저장할 변수

	// 파일 출력
	public void readFile(String filePath) {
		try {
			FileInputStream fileStream = new FileInputStream(filePath); // 파일 객체 생성
			byte[] readBuffer = new byte[fileStream.available()]; // 읽은 바이트를 담음
			while(fileStream.read(readBuffer) != -1) {} // 문자열 끝까지 바이트 단위로 읽음
			System.out.println(new String(readBuffer)); // 읽은 바이트를 모두 출력
			fileStream.close(); // 입력스트림 닫음
		} catch (Exception e) {
			e.getStackTrace(); // 에러 발생 시 확인
		}
	}
	
	// 기존 파일에 새 문자 쓰기
	public void writeFile(String filePath, String txt) {
		try {
			FileWriter fileWriter = new FileWriter(filePath, true); // FileWirter 객체 생성
			fileWriter.write(txt + "\n"); // 입력받은 문자열 txt를 기존 파일에 씀
			fileWriter.close(); // 출력스트림 닫음 
		} catch (Exception e) {
			e.printStackTrace(); // 에러 발생 시 확인
		}
	}
	
	// 이슈 추가 함수
	public void addIssue(String filePath) {
		choice = JOptionPane.showConfirmDialog(null, "추가할 이슈가 있나요?", "OptionMessage", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(choice == 0) { // "예" 클릭 -> 이슈 추가로 쓰고 파일 출력
			txt = JOptionPane.showInputDialog("추가할 이슈를 입력하세요.");
			
			// 취소버튼을 누르거나 x로 창을 닫으면 메인 메뉴로 이동
			if(txt == null || txt.equals("")) {
				Menu menu = new Menu();
				menu.run();
			}
			writeFile(filePath, txt); // 추가할 이슈 쓰기				
			readFile(filePath); // 해당 경로에 있는 파일 읽기
		} else if(choice == 1) { // "아니오" 클릭 -> 파일만 출력
			readFile(filePath); // 해당 경로에 있는 파일 읽기
		} else { // "취소" 클릭 -> 메인 메뉴로 이동
			Menu menu = new Menu();
			menu.run();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			input = JOptionPane.showInputDialog("[키워드를 입력하세요.]\n입력 예시 : 방탄소년단, 블랙핑크, 미나리, 예능, 애니메이션, 오징어게임, 배틀그라운드");
			
			// 취소버튼을 누르거나 x로 창을 닫으면 Menu 실행
			if(input == null || input.equals("")) {
				Menu menu = new Menu();
				menu.run();
			}
			if(input.equals("방탄소년단")) {
				addIssue("bts.txt"); // 파일 경로 : bts.txt
			} else if(input.equals("블랙핑크")) {
				addIssue("blackPink.txt"); // 파일 경로 : blackPink.txt
			} else if(input.equals("미나리")) {
				addIssue("yoon.txt"); // 파일 경로 : yoon.txt
			} else if(input.equals("예능")) {
				addIssue("ent.txt"); // 파일 경로 : ent.txt
			} else if(input.equals("애니메이션")) {
				addIssue("ani.txt"); // 파일 경로 : ani.txt
			} else if(input.equals("오징어게임")) {
				addIssue("drama.txt"); // 파일 경로 : drama.txt
			} else if(input.equals("배틀그라운드")) {
				addIssue("game.txt"); // 파일 경로 : game.txt
			} else { // 예시에 없는 문자열을 입력한 경우
				JOptionPane.showMessageDialog(null, "다시 입력해주세요.");
				continue;
			}
			
			// 키워드를 계속 입력 받을지 말지 결정
			int result = JOptionPane.showConfirmDialog(null, "계속하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.CLOSED_OPTION) {
				// "예", "아니오" 선택 없이 다이얼로그 창을 닫은 경우
				Menu menu = new Menu();
				menu.run();
			} else if(result == JOptionPane.YES_OPTION) {
				// "예"를 선택한 경우
				continue;
			} else {
				// "아니오"를 선택한 경우
				Menu menu = new Menu();
				menu.run();
			}
		}
	}
}
