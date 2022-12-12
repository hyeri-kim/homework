package hallyu;

// 등록할 아이디와 비밀번호 입력
// 비밀번호는 확인용으로 한번 더 입력

// 다시 입력하는 조건
// 1. 아이디가 이미 HashMap에 존재할 경우
// 2. 입력한 비밀번호와 확인용 비밀번호가 일치하지 않을 경우
// 3. 비밀번호 길이가 4를 넘지 않을 경우

// 위 조건에 모두 해당되지 않을 경우 가입 성공 -> 다시 로그인 창 실행

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
public class JoinPage implements ActionListener {

	JFrame frame = new JFrame(); // 회원가입 창 생성
	
	JButton okButton = new JButton("등록"); // 등록 버튼
	JButton cancelButton = new JButton("취소"); // 취소 버튼
	JLabel userIDLabel = new JLabel("아이디");
	JLabel userPasswordLabel = new JLabel("비밀번호");
	JLabel userPasswordConfirmLabel = new JLabel("비밀번호 확인");
	JTextField userIDField = new JTextField(); // 아이디 입력 칸
	JPasswordField userPasswordField = new JPasswordField(); // 비밀번호 입력 칸
	JPasswordField userPasswordConfirmField = new JPasswordField(); // 비밀번호 확인 입력 칸
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();

	JoinPage(HashMap<String, String> loginInfoOriginal) // LoginPage 클래스에서 매개변수로 받은 HashMap을 그대로 사용
	{
		loginInfo = loginInfoOriginal; // HashMap 연결
		
		// 회원가입 창 디자인
		userIDLabel.setBounds(50,50,120,25);
		userPasswordLabel.setBounds(50,100,120,25);
		userPasswordConfirmLabel.setBounds(50, 150, 120, 25);
		
		userIDField.setBounds(150,50,200,25);
		userPasswordField.setBounds(150,100,200,25);
		userPasswordConfirmField.setBounds(150, 150, 200, 25);
		
		okButton.setBounds(150,200,100,25);
		okButton.setFocusable(false);
		okButton.addActionListener(this);
		
		cancelButton.setBounds(260,200,90,25);
		cancelButton.setFocusable(false);
		cancelButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(userPasswordConfirmLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(userPasswordConfirmField);
		frame.add(okButton);
		frame.add(cancelButton);
		
		frame.setTitle("회원가입");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 오른쪽 상단의 X버튼 눌렀을 때 System의 exit 메소드 사용하여 종료
		frame.setSize(420, 320); // 로그인 창 크기
		frame.setLocationRelativeTo(null); // 화면 가운데에 오도록
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 취소 버튼 눌렀을 때
		if(e.getSource()==cancelButton) {
			frame.dispose(); // 현재 창 닫기
			LoginPage loginPage = new LoginPage(loginInfo); // 로그인 페이지로 이동
		}
		
		// 등록 버튼 눌렀을 때
		if(e.getSource()==okButton) {
			
			// 입력으로 받은 텍스트 가져오기
			String userID = userIDField.getText();
			String password =  String.valueOf(userPasswordField.getPassword());
			String passwordConfirm =  String.valueOf(userPasswordConfirmField.getPassword());
			
			// 가입할 아이디와 비밀번호 check
			if(loginInfo.containsKey(userID)) { // HashMap의 key에 이미 같은 id가 존재할 경우 다시 입력
				JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
			} else if(password.equals(passwordConfirm) == false) { // 먼저 입력한 비밀번호와 확인 비밀번호가 다를 경우 다시 입력
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
			} else if(password.length() < 4) { // 비밀번호 길이가 4를 넘지 않을 경우 다시 입력
				JOptionPane.showMessageDialog(null, "비밀번호는 4자리 이상 입력해주세요.");
			} else {
				JOptionPane.showMessageDialog(null, "회원가입 성공 !");
				loginInfo.put(userID, password); // HashMap에 아이디(key)와 비밀번호(value) 추가
				frame.dispose(); // 현재 창 닫기
				LoginPage loginPage = new LoginPage(loginInfo); // 다시 로그인 페이지로 이동
			}
		}
	}
}
