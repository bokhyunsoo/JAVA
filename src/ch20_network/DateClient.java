package ch20_network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {
	public static void main(String[] args) 
			throws Exception {
// new Socket("서버주소", 포트번호)		
		Socket s=new Socket("192.168.201.230",8000);
		BufferedReader input=new BufferedReader(
				new InputStreamReader(s.getInputStream()));
// 서버에서 보낸 메시지를 받음		
		String res=input.readLine();
		System.out.println(res);
		s.close(); //소켓 닫기(연결 종료)
		System.exit(0); //프로그램 종료
	}
}




