package ch17;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginExam extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pwd;
	private JLabel lblResult;
	//추가
	private Map<String,String> map;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginExam frame = new LoginExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//절대좌표 레이아웃(null)
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(62, 57, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(62, 88, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		userid = new JTextField();
		userid.setBounds(131, 54, 121, 21);
		contentPane.add(userid);
		userid.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(131, 85, 121, 19);
		contentPane.add(pwd);
		
		//맵에 데이터 추가
		map = new HashMap<>();
		map.put("kim", "1234");
		map.put("park", "2222");
		map.put("hong", "3333");
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userid.getText();
				// 비밀번호를 스트링으로 변환
				String pw = String.valueOf(pwd.getPassword());
				String strId = map.get(id);
				if(strId != null && strId.equals(pw)){
					//전경색(글자색) 변경
					lblResult.setForeground(Color.blue);
					lblResult.setText(id+"님 환영합니다.");
				}else{
					lblResult.setForeground(Color.red);
					lblResult.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
				}
			}
		});
		btnLogin.setBounds(145, 129, 97, 23);
		contentPane.add(btnLogin);
		
		lblResult = new JLabel("");
		lblResult.setBounds(56, 191, 334, 21);
		contentPane.add(lblResult);
		
	}
}
