package ch17;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MessageExam extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageExam frame = new MessageExam();
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
	public MessageExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnMessage = new JButton("Message");
		btnMessage.addActionListener(new ActionListener() {
			// showMessageDialog(parent , message)
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MessageExam.this, "Message");
			}
		});
		contentPane.add(btnMessage);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//사용자의 확인을 받는 대화상자
				int result = JOptionPane.showConfirmDialog(MessageExam.this, "종료할까요?", null, JOptionPane.YES_NO_OPTION);
				//yes 버튼을 누르면 프로그램 종료
//				if(result == JOptionPane.YES_OPTION){
//					JOptionPane.showMessageDialog(MessageExam.this, "프로그램을 종료합니다.");
//					System.exit(0);
//				}
				switch(result){
				case JOptionPane.YES_OPTION:
				JOptionPane.showMessageDialog(MessageExam.this, "프로그램을 종료합니다.");
				System.exit(0);
				break;
				case JOptionPane.NO_OPTION:
				JOptionPane.showMessageDialog(MessageExam.this, "NO 버튼을 눌렀습니다.");
				break;
				case JOptionPane.CANCEL_OPTION:
				JOptionPane.showMessageDialog(MessageExam.this, "Cancel 버튼을 눌렀습니다.");
				break;
				}
			}
		});
		contentPane.add(btnConfirm);
		
		JButton btnInput = new JButton("Input");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//사용자가 입력한 값을 좌변에 저장
				String name = JOptionPane.showInputDialog(MessageExam.this, "이름을 입력하세요");
				JOptionPane.showMessageDialog(MessageExam.this, name+"님 환영합니다.");
			}
		});
		contentPane.add(btnInput);
		
		JButton btnOption = new JButton("btnOption");
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str={"추가","수정","삭제"};
				//showOptionDialog(parent, message, title, button option, message type, icon, options, 초기값)
				JOptionPane.showOptionDialog(MessageExam.this, "선택하세요.", "작업선택", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
			}
		});
		contentPane.add(btnOption);
	}

}
