package ch20_network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	public static void main(String[] args) {
		try {
			// 서버의 IP주소(또는 DNS)
			InetAddress address = InetAddress.getByName(
					"192.168.201.230");
			// 서버에 전송할 데이터
			System.out.println(
					"서버에 전송할 메시지를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			String data = scan.next();
			scan.close();
			// 스트링 ==> 바이트배열 : 스트링.getBytes()
			// 바이트배열 ==> 스트링 : new String(바이트배열)
			// 스트링을 바이트배열로 변환(UDP통신에서는 바이트배열로 전송해야 함)
			byte[] send = data.getBytes();
			// 데이터그램패킷 객체 생성( 전송할 바이트배열, 배열크기, ip주소,포트번호
			DatagramPacket packet = 
					new DatagramPacket(
							send, send.length, address, 7777);
			// 소켓 생성
			DatagramSocket socket = new DatagramSocket();
			// 소켓을 이용하여 패킷을 서버에 전송
			socket.send(packet);
			// 소켓 닫기
			socket.close();
			System.out.println("전송이 완료되었습니다.");
			// 서버에서 보낸 메시지를 받기 위한 객체 생성
			// 8888번 포트를 개방
			DatagramSocket socket2 = new DatagramSocket(8888);
			// 바이트배열 생성
			byte[] data2 = new byte[65508];
			// 서버에서 보낸 메시지를 저장하기 위한 패킷객체
			DatagramPacket packet2 = new DatagramPacket(
					data2, data2.length);
			// 서버에서 보낸 메시지를 수신
			socket2.receive(packet2);
			// 소켓 연결 닫기
			socket2.close();
			// 바이트배열을 스트링으로 변환
			String message = new String(data2);
			System.out.println("서버에서 보낸 메시지:" 
			+ message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
