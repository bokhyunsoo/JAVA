package ch21_jdbc.oracle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ScoreSave extends JFrame {

	private JPanel contentPane;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	//변수 추가
	private ScoreList frm;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ScoreSave frame = new ScoreSave();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	//ScoreList 프레임의 주소값을 받기 위해 매개변수 추가
	public ScoreSave(ScoreList frm){
		this(); //기본 생성자 호출
		this.frm = frm;
	}
	public ScoreSave() {
		//모든 창을 닫고 종료
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면에서 표시하지 않음(종료가 아님)
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//현재 창만 닫음
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 244, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("학번");
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(56, 7, 116, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);
		
		JLabel label = new JLabel("이름");
		label.setBounds(12, 39, 57, 15);
		contentPane.add(label);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(56, 36, 116, 21);
		contentPane.add(tfName);
		
		JLabel label_1 = new JLabel("국어");
		label_1.setBounds(12, 70, 57, 15);
		contentPane.add(label_1);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(56, 67, 116, 21);
		contentPane.add(tfKor);
		
		JLabel label_2 = new JLabel("영어");
		label_2.setBounds(12, 105, 57, 15);
		contentPane.add(label_2);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(56, 102, 116, 21);
		contentPane.add(tfEng);
		
		JLabel label_3 = new JLabel("수학");
		label_3.setBounds(12, 136, 57, 15);
		contentPane.add(label_3);
		
		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(56, 133, 116, 21);
		contentPane.add(tfMat);
		
		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//사용자가 입력한 값
				String student_no=tfStudentNo.getText();
				String name=tfName.getText();
				int kor=Integer.parseInt(tfKor.getText());
				int eng=Integer.parseInt(tfEng.getText());
				int mat=Integer.parseInt(tfMat.getText());
				ScoreDTO dto
=new ScoreDTO(student_no, name, kor, eng, mat);
				ScoreDAO dao=new ScoreDAO();
				int result=dao.insertScore(dto);
				if(result==1){ //insert가 성공하면 메시지 출력
					JOptionPane.showMessageDialog(
							ScoreSave.this, "저장되었습니다");
					//ScoreList의 refreshTable() 호출
					frm.refreshTable();
					dispose(); //현재 프레임을 닫음
				}
			}
		});
		btnSave.setBounds(55, 177, 97, 23);
		contentPane.add(btnSave);
	}
}




