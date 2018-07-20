package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;

public class TreeExam extends JFrame {

	private JPanel contentPane;
	//코드 추가
	private Object[] obj={"프로그램","시스템","디자인"};
	private Vector<Vector> node1 = new Vector<Vector>(){
		@Override
		public String toString() {
			return "Lesson";
		}
	};
	private Vector<String> node2 = new Vector<String>(){
		@Override
		public String toString() {
			return "Java";
		}
	};
	private Vector<String> node3 = new Vector<String>(){
		@Override
		public String toString() {
			return "XML";
		}
	};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeExam frame = new TreeExam();
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
	public TreeExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
//		JTree tree = new JTree();
//		tree.setModel(new DefaultTreeModel(
//			new DefaultMutableTreeNode("과일") {
//				{
//					add(new DefaultMutableTreeNode("수박"));
//					add(new DefaultMutableTreeNode("사과"));
//					add(new DefaultMutableTreeNode("참외"));
//				}
//			}
//		));
		node1.add(node2); //node1에 node2를 붙임
		node1.add(node3); //node1에 node3를 붙임
		node2.add("C++"); //node2에 아이템 추가
		node2.add("Java");
		node2.add("Java");
		node3.add("XSLT");
		node3.addElement("DOM");
		obj[0] = node1; //node1을 root node로 설정
		JTree tree = new JTree(obj); //트리 인스턴스 생성
		tree.setRootVisible(true); //root node 표시
		scrollPane.setViewportView(tree);
	}

}

