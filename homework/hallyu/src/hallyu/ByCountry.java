package hallyu;

// 옵션으로 항목을 선택하도록 함
//
// 대륙 선택
// 선택한 대륙에 해당하는 나라 선택
// 선택한 나라의 한류 탑5(드라마, 영화, 배우, 가수, 캐릭터, 게임)을 나라에 맞게 저장된 파일을 읽어서 보여줌

import java.io.FileInputStream;

import javax.swing.JOptionPane;

public class ByCountry extends Option {
	String[] ArrayContinent = {"아시아", "아메리카", "유럽", "오세아니아", "아프리카"}; // 대륙을 담은 배열
	String[] AsiaCountry = {"중국", "일본", "대만", "태국", "인도", "베트남"}; // 아시아 국가를 담은 배열
	String[] AmericaCountry = {"미국", "브라질", "아르헨티나"}; // 아메리카 국가를 담은 배열
	String[] EuropeCountry = {"프랑스", "영국", "터키"}; // 유럽 국가를 담은 배열
	String[] OceaniaCountry = {"호주"}; // 오세아니아 국가를 담은 배열
	String[] AfricaCountry = {"남아공"}; // 아프리카 국가를 담은 배열

	Continent thisContinent; // 열거 타입 변수 선언
	
	int choice = 0; // 선택한 대륙/국가 번호
	
	// 파일 출력
	public void file(String filePath) {
		try {
			FileInputStream fileStream = new FileInputStream(filePath); // 파일 객체 생성
			byte[] readBuffer = new byte[fileStream.available()]; // 읽은 바이트를 담음
			while(fileStream.read(readBuffer) != -1) {} // 문자열 끝까지 바이트 단위로 읽음
			System.out.println(new String(readBuffer)); // 읽은 바이트를 모두 출력
			fileStream.close(); // 입력 스트림 닫음
		} catch (Exception e) {
			e.getStackTrace(); // 에러 발생 시 확인
		}
	}
	
	@Override
	public void run() {
		while(true) {
			// 대륙 옵션 선택
			choice = JOptionPane.showOptionDialog(null, "대륙을 선택하세요.", "Continent", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ArrayContinent, null);
			
			// x 누를 경우 Menu 실행
			if(choice == JOptionPane.CLOSED_OPTION) {
				Menu menu = new Menu();
				menu.run();
			}
			
			switch(choice) {
			// 아시아
			case 0:
				thisContinent = Continent.ASIA; // 열거 상수 == ASIA -> showOptionDialog 타이틀로 지정
				// 아시아 국가 옵션 선택
				choice = JOptionPane.showOptionDialog(null, "국가를 선택하세요.", thisContinent+"", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, AsiaCountry, null);
				switch(choice) {
				case 0: // 중국
					file("China.txt"); // China.txt 파일 출력
					break;
				case 1: // 일본
					file("Japan.txt"); // Japan.txt 파일 출력
					break;
				case 2: // 대만
					file("Taiwan.txt"); // Taiwan.txt 파일 출력
					break;
				case 3: // 태국
					file("Thailand.txt"); // Thailand.txt 파일 출력
					break;
				case 4: // 인도
					file("India.txt"); // India.txt 파일 출력
					break;
				case 5: // 베트남
					file("Vietnam.txt"); // Vietnam.txt 파일 출력
					break;
				}
				break;
				
			// 아메리카
			case 1:
				thisContinent = Continent.AMERICA; // 열거 상수 == AMERICA -> showOptionDialog 타이틀로 지정
				// 아메리카 국가 옵션 선택
				choice = JOptionPane.showOptionDialog(null, "국가를 선택하세요.", thisContinent+"", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, AmericaCountry, null);
				switch(choice) {
				case 0: // 미국
					file("USA.txt"); // USA.txt 파일 출력
					break;
				case 1: // 브라질
					file("Brazil.txt"); // Brazil.txt 파일 출력
					break;
				case 2: // 아르헨티나
					file("Argentina.txt"); // Argentina.txt 파일 출력
					break;
				}
				break;
				
			// 유럽
			case 2:
				thisContinent = Continent.EUROPE; // 열거 상수 == EUROPE -> showOptionDialog 타이틀로 지정
				// 유럽 국가 옵션 선택
				choice = JOptionPane.showOptionDialog(null, "국가를 선택하세요.", thisContinent+"", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, EuropeCountry, null);
				switch(choice) {
				case 0: // 프랑스
					file("France.txt"); // France.txt 파일 출력
					break;
				case 1: // 영국
					file("UK.txt"); // UK.txt 파일 출력
					break;
				case 2: // 터키
					file("Turkiye.txt"); // Turkiye.txt 파일 출력
					break;
				}
				break;
				
			// 오세아니아
			case 3:
				thisContinent = Continent.OCEANIA; // 열거 상수 == OCEANIA -> showOptionDialog 타이틀로 지정
				// 오세아니아 국가 옵션 선택
				choice = JOptionPane.showOptionDialog(null, "국가를 선택하세요.", thisContinent+"", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, OceaniaCountry, null);
				switch(choice) {
				case 0: // 호주
					file("Australia.txt"); // Australia.txt 파일 출력
					break;
				}
				break;

			// 아프리카
			case 4:
				thisContinent = Continent.AFRICA; // 열거 상수 == AFRICA -> showOptionDialog 타이틀로 지정
				// 아프리카 국가 옵션 선택
				choice = JOptionPane.showOptionDialog(null, "국가를 선택하세요.", thisContinent+"", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, AfricaCountry, null);
				switch(choice) {
				case 0: // 남아공
					file("RSA.txt"); // RSA.txt 파일 출력
					break;
				}
				break;
			}
			// 국가별 현황을 계속 볼지 말지 결정
			int result = JOptionPane.showConfirmDialog(null, "계속하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.CLOSED_OPTION) {
				// 예, 아니오 선택 없이 다이얼로그 창을 닫은 경우
				Menu menu = new Menu();
				menu.run();
			} else if(result == JOptionPane.YES_OPTION) {
				// 예를 선택한 경우
				continue;
			} else {
				// 아니오를 선택한 경우
				Menu menu = new Menu();
				menu.run();
			}
		}
	}
}
