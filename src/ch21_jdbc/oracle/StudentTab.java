package ch21_jdbc.oracle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class StudentTab extends JFrame {
	private JPanel contentPane;
	private JList list;
	//변수 추가
	private StudentDAO studentDao;
	private DepartmentDAO departmentDao;
	private ProfessorDAO professorDao;
	private StudentDTO dto;
	private String img_path;
	private ArrayList<DepartmentDTO> departmentList;
	private ArrayList<ProfessorDTO> professorList;
	private JTextField tfName;
	private JTextField tfStudno;
	private JTextField tfTel;
	private JComboBox cboDeptno;
	private JComboBox cboProfno;
	private Vector cols; //JTable의 제목컬럼
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTab frame = new StudentTab();
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
	public StudentTab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("학생정보", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("사진");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(12, 10, 77, 100);
		panel.add(lblImage);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(126, 13, 57, 15);
		panel.add(lblNewLabel_1);
		
		tfName = new JTextField();
		tfName.setBounds(195, 10, 116, 21);
		panel.add(tfName);
		tfName.setColumns(10);
		
		tfStudno = new JTextField();
		tfStudno.setColumns(10);
		tfStudno.setBounds(195, 38, 116, 21);
		panel.add(tfStudno);
		
		JLabel label = new JLabel("학번");
		label.setBounds(126, 41, 57, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("학과");
		label_1.setBounds(126, 72, 57, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("지도교수");
		label_2.setBounds(126, 103, 57, 15);
		panel.add(label_2);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(195, 131, 116, 21);
		panel.add(tfTel);
		
		JLabel label_3 = new JLabel("전화번호");
		label_3.setBounds(126, 134, 57, 15);
		panel.add(label_3);
		
		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDTO dto=new StudentDTO();
				dto.setStudno(Integer.parseInt(
						tfStudno.getText()));
				dto.setName(tfName.getText());
				dto.setTel(tfTel.getText());
				int index=cboDeptno.getSelectedIndex(); 
				dto.setDeptno1(
						departmentList.get(index).getDeptno());
				index=cboProfno.getSelectedIndex()-1; 
				if(index!=-1){ //미배정이 아니면
					dto.setProfno(
						professorList.get(index).getProfno());
				}
				dto.setImg_path(img_path);
				int result=studentDao.updateStudent(dto);
				if(result==1){
					JOptionPane.showMessageDialog(
							StudentTab.this, "저장되었습니다.");
				}
			}
		});
		btnSave.setBounds(194, 170, 97, 23);
		panel.add(btnSave);
		
		cboDeptno = new JComboBox();
		cboDeptno.setBounds(195, 69, 116, 21);
		panel.add(cboDeptno);
		
		cboProfno = new JComboBox();
		cboProfno.setBounds(195, 100, 116, 21);
		panel.add(cboProfno);
		
		JButton btnImage = new JButton("사진등록");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//파일 선택 대화상자
				JFileChooser fc=new JFileChooser();
				int result=fc.showOpenDialog(StudentTab.this);
				if(result==JFileChooser.APPROVE_OPTION){
					//선택한 이미지 파일의 절대경로 
					img_path = 
							fc.getSelectedFile().getAbsolutePath();
					System.out.println(img_path);
					File file=fc.getSelectedFile();//파일 참조변수
					try {
						//이미지 아이콘 생성
						ImageIcon icon=
								new ImageIcon(ImageIO.read(file));
						//원본 이미지
						Image imageSrc=icon.getImage();
						BufferedImage bi=ImageIO.read(file);
						File copyFile=new File("test.jpg");
						ImageIO.write(bi, "jpg", copyFile);
						//사이즈가 조절된 이미지
						Image imageNew=imageSrc.getScaledInstance(
								80,100,Image.SCALE_AREA_AVERAGING);
						icon=new ImageIcon(imageNew);
						//JLabel에 이미지를 아이콘으로 표시
						lblImage.setIcon(icon);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnImage.setBounds(12, 120, 89, 23);
		panel.add(btnImage);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("수강정보", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.WEST);
		
		//인스턴스 생성
		studentDao=new StudentDAO();
		departmentDao=new DepartmentDAO();
		professorDao=new ProfessorDAO();
		professorList=professorDao.listProfessor();
		departmentList=departmentDao.listDepartment();
		ArrayList<String> studentList
			=studentDao.listStudent();
		//JTable의 제목 행 구성
		cols=new Vector();
		cols.add("학번");
		cols.add("이름");
		cols.add("과목명");
		cols.add("담당교수");
		cols.add("학점");
		cols.add("등급");
// ArrayList를 배열로 변환 : List객체.toArray()		
		list = new JList(studentList.toArray());
		list.addListSelectionListener(
				new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//JList에서 선택한 값을 저장
				String str=list.getSelectedValue().toString();
				System.out.println(str);
				//split(구분자)
				String[] arr=str.split(" ");
				int studno=Integer.valueOf(arr[0]);
				System.out.println("학번:"+studno);
				//JTable에 수강목록 출력
				DefaultTableModel model
					=new DefaultTableModel(
							studentDao.listLecture(studno), cols); 
				table.setModel(model);
				
				dto=studentDao.detailStudent(studno);
				if(dto != null){
					tfStudno.setText(studno+"");
					tfName.setText(dto.getName());
					tfTel.setText(dto.getTel()); 
					//학과 목록 출력
					int cboIndex=0;
					int count=0;
					cboDeptno.removeAllItems(); //콤보박스 초기화
					for(DepartmentDTO dto2 : departmentList){
						//학과 콤보박스에 아이템 추가
						cboDeptno.addItem(dto2.getDname());
						if(dto.getDeptno1() == dto2.getDeptno()){
							cboIndex=count; //학생의 학과인덱스 저장
						}
						count++;
					}
					//학생의 학과 선택
					cboDeptno.setSelectedIndex(cboIndex);
					
					//지도교수 목록 출력
					cboIndex=0;
					boolean assign=false;
					cboProfno.removeAllItems();//콤보박스 초기화
//ArrayList.size() 리스트의 사이즈	
//ArrayList.get(인덱스)
					cboProfno.addItem("미배정");
					for(int i=0; i<professorList.size(); i++){
						int profno=professorList.get(i).getProfno();
						String name=professorList.get(i).getName();
						cboProfno.addItem(name); //콤보박스에 추가
						if(profno==dto.getProfno()){
							assign=true;
							cboIndex=i;
						}
					}
					//지도교수 미배정의 경우
					if(assign){
						cboProfno.setSelectedIndex(cboIndex+1);
					}else{
						cboProfno.setSelectedIndex(0);
					}
					//사진 표시
					img_path = dto.getImg_path();
					if(img_path == null){
						lblImage.setText("사진미등록");
						lblImage.setIcon(null);
					}else{ //JLabel에 사진 표시
						ImageIcon icon=new ImageIcon(img_path);
						Image imageSrc=icon.getImage();
						Image imageNew=imageSrc.getScaledInstance(
								80,100,Image.SCALE_AREA_AVERAGING);
						icon=new ImageIcon(imageNew);
						lblImage.setIcon(icon);
					}
				}
			}
		});
//스크롤페인의 뷰포트 영역에 JList를 배치		
		scrollPane.setViewportView(list);
		//contentPane.add(list, BorderLayout.NORTH);
	}
}






