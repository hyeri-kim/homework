package hallyu;

// 궁금한 콘텐츠의 번호를 입력하면 해당 콘텐츠의 탑5 순위를 보여주고,
// 그 중 원하는 순위를 입력하면 상세 정보를 보여줌

// 상세정보
// 드라마, 영화 : 출연진
// 게임 : 장르

// 바로 이전 창으로 돌아가려면 :D 임력
// 메인 메뉴 창으로 돌아가려면 취소버튼 또는 X 클릭하기

// VIEW
// ★궁금하신 콘텐츠가 있나요?★
// ①드라마
// ②영화
// ③게임

import javax.swing.JOptionPane;

public class Detail extends Option {
	
	String contentsMenu = "★궁금하신 콘텐츠가 있나요?★\n①드라마\n②영화\n③게임";
	String dramaMenu = "★인기 드라마 추천★\n①오징어 게임\n②사랑의 불시착\n③빈센조\n④펜트하우스\n⑤갯마을 차차차\n\n뒤로가기를 원하시면 :D 를 입력하세요.";
	String movieMenu = "★인기 영화 추천★\n①기생충\n②부산행\n③서복\n④미드나이트\n⑤승리호\n\n뒤로가기를 원하시면 :D 를 입력하세요.";
	String gameMenu = "★인기 게임 추천★\n①라그나로크\n②크로스파이어\n③배틀그라운드\n④검은사막\n⑤던전앤파이터\n\n뒤로가기를 원하시면 :D 를 입력하세요.";
		
	String contents = ""; // 선택한 콘텐츠 번호

	@Override
	public void run() {
		while(true) {
			contents = JOptionPane.showInputDialog(contentsMenu); // 콘텐츠 메뉴를 보여주고 번호 입력받음
			
			// 취소버튼을 누르거나 x로 창을 닫으면 Menu로 이동
			if(contents == null || contents.equals("")) {
				Menu menu = new Menu();
				menu.run();
			}
			
			switch(contents) {
			
			// 드라마 추천 영역
			case "1":
				input = JOptionPane.showInputDialog(dramaMenu); // 드라마 종류를 보여주고 번호 입력받음
				if(input == null || input.equals("")) { // 취소버튼을 누르거나 x로 창을 닫으면 Menu로 이동
					Menu menu = new Menu();
					menu.run();
				}
				if(input.equals("1")) { // 오징어 게임 선택
					JOptionPane.showMessageDialog(null, "[오징어 게임]\n출연 : 이정재, 박해수, 위하준");
				} else if(input.equals("2")) { // 사랑의 불시착 선택
					JOptionPane.showMessageDialog(null, "[사랑의 불시착]\n출연 : 현빈, 손예진");
				} else if(input.equals("3")) { // 빈센조 선택
					JOptionPane.showMessageDialog(null, "[빈센조]\n출연 : 송중기, 전여빈, 옥택연");
				} else if(input.equals("4")) { // 펜트하우스 선택
					JOptionPane.showMessageDialog(null, "[펜트하우스]\n출연 : 김소연, 엄기준, 유진, 이지아");
				} else if(input.equals("5")) { // 갯마을 차차차 선택
					JOptionPane.showMessageDialog(null, "[갯마을 차차차]\n출연 : 신민아, 김선호, 이상이");
				} else if(input.equals(":D")) { // 뒤로가기 입력
					break;
				}
				break;
				
			// 영화 추천 영역
			case "2":
				input = JOptionPane.showInputDialog(movieMenu);
				if(input == null || input.equals("")) { // 취소버튼을 누르거나 x로 창을 닫으면 Menu로 이동
					Menu menu = new Menu();
					menu.run();
				}
				if(input.equals("1")) { // 기생충 선택
					JOptionPane.showMessageDialog(null, "[기생충]\n출연 : 송강호, 이선균, 조여정, 최우식, 박소담");
				} else if(input.equals("2")) { // 부산행 선택
					JOptionPane.showMessageDialog(null, "[부산행]\n출연 : 공유, 마동석, 정유미, 김수안");
				} else if(input.equals("3")) { // 서복 선택
					JOptionPane.showMessageDialog(null, "[서복]\n출연 : 공유, 박보검, 조우진");
				} else if(input.equals("4")) { // 미트나이트 선택
					JOptionPane.showMessageDialog(null, "[미드나이트]\n출연 : 진기주, 위하준");
				} else if(input.equals("5")) { // 승리호 선택
					JOptionPane.showMessageDialog(null, "[승리호]\n출연 : 송중기, 김태리, 진선규, 유해진");
				} else if(input.equals(":D")) { // 뒤로가기 입력
					break;
				}
				break;
				
			// 게임 추천 영역
			case "3":
				input = JOptionPane.showInputDialog(gameMenu);
				if(input == null || input.equals("")) { // 취소버튼을 누르거나 x로 창을 닫으면 Menu로 이동
					Menu menu = new Menu();
					menu.run();
				}
				if(input.equals("1")) { // 라그나로크 선택
					JOptionPane.showMessageDialog(null, "[라그나로크]\n장르 : MMORPG");
				} else if(input.equals("2")) { // 크로스파이어 선택
					JOptionPane.showMessageDialog(null, "[크로스파이어]\n장르 : FPS");
				} else if(input.equals("3")) { // 배틀그라운드 선택
					JOptionPane.showMessageDialog(null, "[배틀그라운드]\n장르 : Battle Royale");
				} else if(input.equals("4")) { // 검은사막 선택
					JOptionPane.showMessageDialog(null, "[검은사막]\n장르 : MMORPG");
				} else if(input.equals("5")) { // 던전앤파이터 선택
					JOptionPane.showMessageDialog(null, "[던전앤파이터]\n장르 : MORPG");
				} else if(input.equals(":D")) { // 뒤로가기 입력
					break;
				}
				break;
			}
		}
	}
}
