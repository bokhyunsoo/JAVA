package ch21_jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ScoreList extends JFrame {

	//추가
	private ScoreDAO dao;
	private Vector<String> col;
	private DefaultTableModel model;
	private ScoreDTO dto;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField tfStudentNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMat;
	private JScrollPane scrollPane;
	private JButton btnSave;
	private JButton btnUpdate;
	private JTextField tfSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreList frame = new ScoreList();
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
	public ScoreList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 175, 399, 217);
		contentPane.add(scrollPane);
		
		//추가
		dao=new ScoreDAO(); //dao 인스턴스 생성
	//제목열을 위한 벡터 생성 
		col=new Vector<String>(); 
		col.add("학번");
		col.add("이름");
		col.add("국어");
		col.add("영어");
		col.add("수학");
		col.add("총점");
		col.add("평균");
		//JTable에 데이터를 출력시키기 위한 테이블 모델 생성
		list();
		//JTable에 테이블 모델을 연결시킴
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//현재 클릭한 행의 인덱스값
				int idx=table.getSelectedRow();
				//수정 모드에서는 학번 입력 제한
				tfStudentNo.setEditable(false);
				
//테이블.getValueAt(row index, column index)				
				tfStudentNo.setText(table.getValueAt(idx,0)+"");
				tfName.setText(table.getValueAt(idx,1)+"");
				tfKor.setText(table.getValueAt(idx,2)+"");
				tfEng.setText(table.getValueAt(idx,3)+"");
				tfMat.setText(table.getValueAt(idx,4)+"");
			}
		});
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("학번");
		lblNewLabel.setBounds(12, 10, 49, 15);
		contentPane.add(lblNewLabel);
		
		tfStudentNo = new JTextField();
		tfStudentNo.setEditable(false);
		tfStudentNo.setBounds(61, 7, 116, 21);
		contentPane.add(tfStudentNo);
		tfStudentNo.setColumns(10);
		
		JLabel label = new JLabel("이름");
		label.setBounds(12, 38, 49, 15);
		contentPane.add(label);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(61, 35, 116, 21);
		contentPane.add(tfName);
		
		JLabel label_1 = new JLabel("국어");
		label_1.setBounds(12, 66, 49, 15);
		contentPane.add(label_1);
		
		tfKor = new JTextField();
		tfKor.setColumns(10);
		tfKor.setBounds(61, 63, 116, 21);
		contentPane.add(tfKor);
		
		JLabel label_2 = new JLabel("영어");
		label_2.setBounds(12, 94, 49, 15);
		contentPane.add(label_2);
		
		tfEng = new JTextField();
		tfEng.setColumns(10);
		tfEng.setBounds(61, 91, 116, 21);
		contentPane.add(tfEng);
		
		JLabel label_3 = new JLabel("수학");
		label_3.setBounds(12, 122, 49, 15);
		contentPane.add(label_3);
		
		tfMat = new JTextField();
		tfMat.setColumns(10);
		tfMat.setBounds(61, 119, 116, 21);
		contentPane.add(tfMat);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//사용자가 입력한 값을 dto에 저장
				input();
				//레코드 저장
				int result=dao.insertScore(dto);
				if(result==1){ //insert 성공
					JOptionPane.showMessageDialog(
							ScoreList.this, "저장되었습니다.");
					//테이블 목록 갱신
					list();
					table.setModel(model);
					clear(); //입력값 초기화
				}
			}
		});
		btnSave.setBounds(189, 6, 97, 23);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//수정한 값
				input();
				//update method 호출
				int result=dao.updateScore(dto);
				//화면 갱신
				if(result==1){
					JOptionPane.showMessageDialog(
							ScoreList.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(189, 34, 97, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//현재 선택한 행의 학번
				String student_no=tfStudentNo.getText();
				int result=0;
				int response=JOptionPane.showConfirmDialog(
						ScoreList.this, "삭제하시겠습니까?");
				//yes 버튼을 눌렀을 때
				if(response==JOptionPane.YES_OPTION){
					result=dao.deleteScore(student_no);//삭제처리
				}
				if(result==1){//삭제된 레코드의 갯수가 1이면
					JOptionPane.showMessageDialog(
							ScoreList.this, "삭제되었습니다.");
					list(); //테이블 갱신
					table.setModel(model);
					clear(); //텍스트필드 초기화					
				}
			}
		});
		btnDelete.setBounds(189, 62, 97, 23);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("이름을 입력하세요");
		lblNewLabel_1.setBounds(12, 147, 127, 15);
		contentPane.add(lblNewLabel_1);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});



		tfSearch.setBounds(125, 144, 116, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("찾기");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(253, 143, 97, 23);
		contentPane.add(btnSearch);
	}
	public void search(){
		String name=tfSearch.getText();
		model=new DefaultTableModel(
				dao.searchScore(name), col){
			@Override
			public boolean isCellEditable(
					int row, int column) {
				return false;
			}
		};		
		table.setModel(model); 		
	}
	public void input(){
		String student_no=tfStudentNo.getText();
		String name=tfName.getText();
		int kor=Integer.parseInt(tfKor.getText());
		int eng=Integer.parseInt(tfEng.getText());
		int mat=Integer.parseInt(tfMat.getText());
		dto=new ScoreDTO(student_no, name, kor, eng, mat);		
	}
	public void clear(){
		tfStudentNo.setText("");
		tfName.setText("");
		tfKor.setText("");
		tfEng.setText("");
		tfMat.setText("");
		tfStudentNo.requestFocus();
		//수정이 끝나면 학번 입력을 활성화시킴
		tfStudentNo.setEditable(true);
	}
	public void list(){
		model=new DefaultTableModel(dao.listScore(), col){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};		
	}
}





