package ch19;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Directory extends JFrame {

	private JPanel contentPane;
	private JTextArea ta;
	private JTextField tfDirectory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Directory frame = new Directory();
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
	public Directory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("디렉토리");
		panel.add(lblNewLabel);
		
		tfDirectory = new JTextField();
		panel.add(tfDirectory);
		tfDirectory.setColumns(20);
		
		JButton button1 = new JButton("확인");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directory = tfDirectory.getText();
				File file = new File(directory);
				String[] list = file.list(); //파일목록을 배열로
				for(int i=0; i<list.length; i++){
					//new File(디렉토리,파일이름)
					File f = new File(directory,list[i]);
					//isDirectory() 디렉토리이면 true
					String str = f.isDirectory() ? "디렉토리" : "파일";
					ta.append(str+":"+list[i]+"\n");
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
