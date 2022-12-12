package hallyu;

// 아이디와 비밀번호 입력
// 입력한 값이 HashMap에 저장되어 있는 key, value값과 일치하는지 확인
// 일치할 경우 : Menu 실행
// 일치하지 않을 경우 : 다시 입력

// 회원가입을 원할 경우
// JoinPage 실행

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//ActionListener 인터페이스를 상속받아 actionPerformed 메소드 사용
public class LoginPage implements ActionListener {
	
	JFrame frame = new JFrame(); // 로그인 창 생성
	
	JButton loginButton = new JButton("로그인"); // 로그인 버튼
	JButton joinButton = new JButton("회원가입"); // 회원가입 버튼
	JLabel userIDLabel = new JLabel("아이디");
	JLabel userPasswordLabel = new JLabel("비밀번호");
	JTextField userIDField = new JTextField(); // 아이디 입력 칸
	JPasswordField userPasswordField = new JPasswordField(); // 비밀번호 입력 칸

	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	LoginPage(HashMap<String, String> loginInfoOriginal) // Main 클래스에서 매개변수로 받은 HashMap을 그대로 사용
	{
		loginInfo = loginInfoOriginal; // HashMap 연결
		
		// 로그인 창 디자인
		userIDLabel.setBounds(50,50,75,25);
		userPasswordLabel.setBounds(50,100,75,25);
		
		userIDField.setBounds(125,50,200,25);
		userPasswordField.setBounds(125,100,200,25);
		
		loginButton.setBounds(125,150,90,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		joinButton.setBounds(235,150,90,25);
		joinButton.setFocusable(false);
		joinButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(joinButton);
		
		frame.setTitle("로그인");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 오른쪽 상단의 X버튼 눌렀을 때 System의 exit 메소드 사용하여 종료
		frame.setSize(420, 270); // 로그인 창 크기
		frame.setLocationRelativeTo(null); // 화면 가운데에 오도록
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 회원가입 버튼 눌렀을 때
		if(e.getSource()==joinButton) {
			frame.dispose(); // 현재 창 닫기
			JoinPage joinPage = new JoinPage(loginInfo); // 회원가입 페이지로 이동
		}
		
		// 로그인 버튼 눌렀을 때
		if(e.getSource()==loginButton) {
			
			// 입력으로 받은 텍스트 가져오기
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			// 입력한 아이디와 비밀번호가 회원정보에 저장되어 있는지 확인(HashMap) 
			if(loginInfo.containsKey(userID)) { // HashMap의 key에 id가 존재할 경우
				if(loginInfo.get(userID).equals(password)) { // key와 value값이 매칭될 경우
					JOptionPane.showMessageDialog(null, "로그인 성공 !");
					frame.dispose(); // 현재 창 닫기
					Menu menu = new Menu();
					menu.run(); // 로그인 성공하면 Menu 실행
				}
				else { // key와 value값이 매칭 안될 경우
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
				}
			}
			else { // HashMap의 key에 id가 존재하지 않을 경우
				JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
			}
		}
	}
}
