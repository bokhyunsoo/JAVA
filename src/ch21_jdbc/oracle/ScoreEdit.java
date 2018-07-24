package ch21_jdbc.oracle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreEdit extends JFrame {

	//변수 추가
	private ScoreList parent;
	private ScoreDAO dao;
	private ScoreDTO dto;
	private String student_no;
	
	private JPanel contentPane;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	

	/**
	 * Create the frame.
	 */
	//생성자 수정
//	public ScoreEdit(ScoreList parent, ScoreDTO dto) {
	public ScoreEdit(ScoreList parent, String student_no) {
		//ScoreList 프레임의 주소값을 저장
		this.parent = parent;
		this.student_no=student_no;
		//ScoreList에서 넘어온 점수데이터(dto)를 저장
		//this.dto = dto;
		System.out.println(parent);
		//System.out.println(dto);
		
		setTitle("점수 편집");
		//현재 창만 닫는 옵션으로 변경
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 218, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("학번");
		lblNewLabel.setBounds(12, 22, 42, 15);
		contentPane.add(lblNewLabel);
		
		tfStudentNo = new JTextField();
		tfStudentNo.setBounds(51, 19, 116, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);
		
		JLabel label = new JLabel("이름");
		label.setBounds(12, 50, 42, 15);
		contentPane.add(label);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(51, 47, 116, 21);
		contentPane.add(tfName);
		
		JLabel label_1 = new JLabel("국어");
		label_1.setBounds(12, 78, 42, 15);
		contentPane.add(label_1);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(51, 75, 116, 21);
		contentPane.add(tfKor);
		
		JLabel label_2 = new JLabel("영어");
		label_2.setBounds(12, 106, 42, 15);
		contentPane.add(label_2);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(51, 103, 116, 21);
		contentPane.add(tfEng);
		
		JLabel label_3 = new JLabel("수학");
		label_3.setBounds(12, 134, 42, 15);
		contentPane.add(label_3);
		
		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(51, 131, 116, 21);
		contentPane.add(tfMat);
		
		//dto의 값을 텍스트필드에 출력
		dao=new ScoreDAO();
		dto=dao.viewScore(student_no);
		tfStudentNo.setText(dto.getStudent_no());
		tfName.setText(dto.getName());
		//텍스트필드에는 문자열 입력만 가능함
		tfKor.setText(dto.getKor()+"");
		tfEng.setText(dto.getEng()+"");
		tfMat.setText(dto.getMat()+"");
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//사용자의 입력값
				String student_no=tfStudentNo.getText();
				String name=tfName.getText();
				int kor=Integer.parseInt(tfKor.getText());
				int eng=Integer.parseInt(tfEng.getText());
				int mat=Integer.parseInt(tfMat.getText());
				ScoreDTO dto
=new ScoreDTO(student_no, name, kor, eng, mat);
				
				//dao에 수정 요청
				int result=dao.updateScore(dto);
				if(result==1){ //update 성공
					JOptionPane.showMessageDialog(
							ScoreEdit.this, "수정되었습니다.");
					parent.refreshTable(); //ScoreList 갱신
					dispose(); //현재 프레임 닫기
				}
			}
		});
		btnUpdate.setBounds(12, 172, 64, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(88, 172, 64, 23);
		contentPane.add(btnDelete);
	}

}
