package ch20_network;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class GuguServer implements Runnable {
	private ServerSocket serverSocket; //서비스용 소켓
	private Socket socket; //클라이언트와의 통신용 소켓
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public GuguServer() {
		try {
			//서비스용 소켓 생성
			serverSocket=new ServerSocket(9999);
			System.out.println(
					"구구단 서비스가 시작되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(true){
			try {
				//클라이언트의 접속을 기다림=>접속=>소켓 생성(연결)
				socket = serverSocket.accept();
				InetAddress ip=socket.getInetAddress();
				System.out.println("클라이언트의 ip:"+ip);
				dis=new DataInputStream(socket.getInputStream());
				dos=new DataOutputStream(
						socket.getOutputStream());
				//구구단 계산을 위한 백그라운드 스레드 생성
				Thread th=new Thread(this);
				th.start(); // run() 실행
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new GuguServer();
	}
	@Override
	public void run() {
		try {
			while(true){
				int dan=dis.readInt(); //클라이언트가 입력한 dan
				System.out.println("클라이언트의 요청값:"+dan);
				StringBuilder sb=new StringBuilder();
				for(int i=1; i<=9; i++){
					sb.append(dan+"x"+i+"="+dan*i+"\r\n");
				}
				//결과값을 클라이언트에게 보냄
				dos.writeUTF(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









