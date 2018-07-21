package ch20_network;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//서버용 프로그램
public class DateServer {
	public static void main(String[] args) 
			throws Exception {
//네트워크 관련 작업은 예외 처리가 필수임		
//ServerSocket : 서비스용 소켓
//Socket : ServerSocket에 접속하는 소켓	
//new ServerSocket(포트번호) 0~65535		
		ServerSocket ss=new ServerSocket(8000);
		System.out.println("서비스가 시작되었습니다.");
		while(true){
			// accept() 클라이언트가 접속할 때까지 대기 상태
			// 접속하면 소켓이 연결(논리적인 회선 연결)
			Socket socket=ss.accept();
			PrintWriter out=new PrintWriter(
					socket.getOutputStream(), true);
			SimpleDateFormat sdf=new SimpleDateFormat(
					"yyyy년 MM월 dd일 HH시 mm분 ss초");
			String str=sdf.format(new Date()); //java.util.Date
			//클라이언트에게 데이터 전송
			out.println(str);
			//소켓 종료(연결 종료)
			socket.close();
		}
	}
}


