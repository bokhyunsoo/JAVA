package ch19;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FileExam extends JFrame {

	private JPanel contentPane;
	private JTextField tfFileName;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileExam frame = new FileExam();
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
	public FileExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("파일이름");
		label.setBounds(31, 23, 57, 15);
		contentPane.add(label);
		
		tfFileName = new JTextField();
		tfFileName.setBounds(102, 20, 233, 22);
		contentPane.add(tfFileName);
		tfFileName.setColumns(10);
		
		JButton button1 = new JButton("확인");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//File : 파일의 정보를 가리키는 클래스
				File file = new File(tfFileName.getText());
				if(!file.exists()){ //파일이 존재하지 않으면
					try {
						file.createNewFile();//빈 파일 생성
					} catch (IOException e1) {
						e1.printStackTrace();
					} //빈 파일 생성
				}
				String str="파일이름:"+file.getName()+"\n"
						+"파일크기:"+file.length()+"\n"
						+"상위폴더:"+file.getParent();
				textArea.setText(str);
			}
		});
		button1.setBounds(347, 19, 73, 23);
		contentPane.add(button1);
		
		textArea = new JTextArea();
		textArea.setBounds(27, 64, 393, 175);
		contentPane.add(textArea);
	}
}
