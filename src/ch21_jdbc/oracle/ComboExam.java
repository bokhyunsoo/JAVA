package ch21_jdbc.oracle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ComboExam extends JFrame {

	private JPanel contentPane;
	private JComboBox combo;
	private List list;
	//변수 추가
	private DeptDAO deptDao;
	private ArrayList<DeptDTO> deptList;
	private EmpDAO empDao;
	private ArrayList<EmpDTO> empList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboExam frame = new ComboExam();
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
	public ComboExam() {
		deptDao=new DeptDAO();
		//부서목록을 ArrayList로 받아옴
		deptList=deptDao.listDept();
		empDao=new EmpDAO();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		list = new List();
		contentPane.add(list, BorderLayout.CENTER);
		
		combo = new JComboBox();
		combo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//콤보박스에서 선택된 값
				//String dname=combo.getSelectedItem().toString();
				//해당 부서의 직원 목록을 ArrayList로 받아옴
				//empList=empDao.listEmp(dname);
//콤보박스에서 선택한 아이템의 인덱스값				
				int idx=combo.getSelectedIndex();
				int deptno=deptList.get(idx).getDeptno();
				System.out.println("deptno:"+deptno);
				empList=empDao.listEmp(deptno);
				
				list.removeAll(); //리스트의 목록 초기화
				for(EmpDTO dto : empList){
					//List에 사원 추가 
					list.add(dto.getEname()); 
				}
			}
		});
		for(DeptDTO dto : deptList){
			combo.addItem(dto.getDname());
		}
		contentPane.add(combo, BorderLayout.NORTH);
		

	}

}




