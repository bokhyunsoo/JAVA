package ch20_network;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class GuguClient extends JFrame {

	private JPanel contentPane;
	private JComboBox cboDan;
	private JTextArea taResult;
	//변수 추가
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuguClient frame = new GuguClient();
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
	public GuguClient() {
		try {
			//서버에 접속
			socket = new Socket("192.168.201.230",9999);
			//데이터 입출력을 위한 스트림 생성
			dis=new DataInputStream(socket.getInputStream());
			dos=new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 242, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("단을 입력하세요");
		lblNewLabel.setBounds(12, 10, 107, 15);
		contentPane.add(lblNewLabel);
		
		cboDan = new JComboBox();
		cboDan.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
//새로운 아이템을 선택할 때				
				if(e.getStateChange()==ItemEvent.SELECTED){
					int dan=
Integer.parseInt(cboDan.getSelectedItem().toString());
					try {
						dos.writeInt(dan); //서버에 전송
//서버에서 계산하는 과정						
//서버에서 넘어온 값을 JTextArea에 출력시킴						
						taResult.setText(dis.readUTF());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		cboDan.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9"}));
		cboDan.setBounds(115, 7, 52, 21);
		contentPane.add(cboDan);
		
		taResult = new JTextArea();
		taResult.setBounds(12, 35, 189, 194);
		contentPane.add(taResult);
	}
}
