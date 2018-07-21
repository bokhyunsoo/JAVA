package ch20_network;

import java.net.ServerSocket;

public class SocketExam {
	public static void main(String[] args) {
//서버소켓 : 서버에서 서비스를 위한 목적으로 만드는 소켓		
		ServerSocket socket=null;
		for(int i=0; i<=65535; i++){
			try {
				socket=new ServerSocket(i); //포트 개방
				// Socket s=new Socket("192.168.0.101",5000);
				socket.close(); //서비스 종료
			} catch (Exception e) {
				System.out.println(i+"번 포트는 사용중입니다.");
			}
		}
	}
}



