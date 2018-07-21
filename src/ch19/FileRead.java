package ch19;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FileRead extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileRead frame = new FileRead();
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
	public FileRead() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("파일이름");
		panel.add(lblNewLabel);
		
		tf = new JTextField();
		panel.add(tf);
		tf.setColumns(10);
		
		JButton button1 = new JButton("확인");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file=tf.getText();
				String str="";
				BufferedReader reader=null;
//				InputStreamReader ir=null;
//				FileInputStream fi=null;
				try {
//프로그램    <===       텍스트파일					
//new FileInputStream(파일이름)		InputStream생성			
					reader=new BufferedReader(
new InputStreamReader(new FileInputStream(file)));
//					fi=new FileInputStream(file);
//					ir=new InputStreamReader(fi);
//					reader=new BufferedReader(ir);
					ta.setText(""); //텍스트 초기화
					while((str=reader.readLine())!=null){
						ta.append(str+"\n");
					}
//					while(true){
//						str=reader.readLine(); //한 라인을 읽음
//					//더이상 내용이 없으면 반복문 종료
//						if(str==null) break; 
//						ta.append(str+"\n");
//					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					try {
						if(reader!=null) reader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panel.add(button1);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		ta = new JTextArea();
		scrollPane.setViewportView(ta);
	}

}
