package ch20_network;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatClient {
	static String nickName = null;
	static JTextArea ta;
	static JTextField tf;
	static DataOutputStream out;

	public static void main(String args[]) {
		nickName = JOptionPane.showInputDialog(
				"대화명을 입력하세요");
		new ClientScreen(nickName);
		Socket socket;
		try {
			String serverIp = "192.168.201.230";
			// 소켓을 생성하여 연결을 요청
			socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다");
			Thread receiveThread = new ClientReceiver(socket);
			receiveThread.start();
			Thread sender = 
					new ClientSender(socket, nickName);
			sender.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 메시지 전송 스레드
	static class ClientSender extends Thread {
		Socket socket;
		String name;

		ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				out = new DataOutputStream(
						socket.getOutputStream());
				this.name = name;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void run() {
			Scanner scanner = new Scanner(System.in);
			try {
				if (out != null) {
					out.writeUTF(name); // 대화명 보내기
				}
				while (out != null) {
					out.writeUTF("[" + name + "]" 
				+ scanner.nextLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// run
	}// clientSender
		// 메시지 수신용 스레드 클래스

	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;

		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(
						socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			while (in != null) {
				try {
					String s = in.readUTF();
					System.out.println(s);
					ta.append(s + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 화면 구성 클래스
	static class ClientScreen extends JFrame 
	implements ActionListener {
		public ClientScreen(String nick) {
			setSize(300, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle(nick + "의 채팅방 클라이언트!");
			setLayout(new BorderLayout());
			ta = new JTextArea(25, 40);
			tf = new JTextField(25);
			tf.addActionListener(this);
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.setComponentOrientation(
					ComponentOrientation.LEFT_TO_RIGHT);
			JLabel label_name = new JLabel(nick + "님 ");
			panel.add(label_name, BorderLayout.WEST);
			panel.add(tf, BorderLayout.CENTER);
			add(ta, BorderLayout.CENTER);
			add(panel, BorderLayout.SOUTH);
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tf) {
				try {
					out.writeUTF("[" + nickName + "]" + 
				tf.getText());
					tf.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
