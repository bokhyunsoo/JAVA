package ch20_network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) 
			throws Exception {
		Socket socket=null;
		PrintWriter writer=null;
		BufferedReader reader=null;
		try {
			//new Socket("서버의ip",포트번호)
			socket=new Socket("localhost",5555);
			writer=
new PrintWriter(socket.getOutputStream(),true);
			reader=new BufferedReader(
new InputStreamReader(socket.getInputStream())); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		String receive="";
		String send;
		Scanner sc=new Scanner(System.in);
		while(true){
			receive=reader.readLine(); //메시지 읽음
			System.out.println("[server] "+receive);
			if(receive.equals("quit")) break;
			System.out.println("입력하세요(종료:quit):");
			send=sc.nextLine(); //키보드 입력
			if(send.equals("quit")) break;
			if(send != null){ 
				writer.println(send); //메시지 보내기
			}
		}
		//리소스 정리
		sc.close();
		writer.close();
		reader.close();
		socket.close();
	}
}













