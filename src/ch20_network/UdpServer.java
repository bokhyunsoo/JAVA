package ch20_network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

// UDP 방식의 통신을 위한 서버측 프로그램
//TCP방식 - 연결성(서버와 클라이언트가 연결된 상태에서 데이터 송수신)
//UDP방식 - 비연결성(단방향 전송)
public class UdpServer {
	public static void main(String[] args) {
		// udp 방식은 데이터를 바이트배열로 전송함, 바이트배열의 최대크기는 65508
		byte[] data = new byte[65508];
//udp 방식의 통신은 데이터를 패킷(데이터 조각)으로 만들어 전송
		DatagramPacket packet 
= new DatagramPacket(data, data.length);
		try {
			// 서비스 제공을 위하여 7777번 포트를 개방
			DatagramSocket socket = new DatagramSocket(7777);
			System.out.println("서비스가 시작되었습니다.");
			// 클라이언트가 보낸 메시지를 수신
			// 소켓을 통해 수신된 클라이언트의 메시지를 packet에 저장
			socket.receive(packet);
			// 소켓 닫기(udp 방식은 비연결성 - 연결된 상태에서 통신하는 것이 아님)
			// socket.close();
			System.out.println("클라이언트의 ip주소:" 
			+ packet.getAddress().getHostAddress());
			// 클라이언트에서 보낸 메시지(바이트배열)를 스트링으로 변환
			// new String( 바이트배열 ) ==> 문자열로 변환
			String receive = new String(packet.getData());
			System.out.println("클라이언트의 메시지:" 
			+ receive);
			// 클라이언트에 데이터 전송
			System.out.println("클라이언트에게 응답할 메시지를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			String msg = scan.next();
			scan.close();
			// 클라이언트에게 전송할 패킷객체 생성
			// ( 바이트배열, 바이트배열크기, ip주소, 포트번호 )
			packet = new DatagramPacket(msg.getBytes()
					, msg.getBytes().length, packet.getAddress()
					, 8888);
			// 클라이언트에게 자료 전송
			socket.send(packet);
			// 소켓 닫기
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}