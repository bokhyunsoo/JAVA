package ch20_network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExam {
	public static void main(String[] args) {
		try {
			InetAddress address
				=InetAddress.getByName("naver.com");
			System.out.println(address);
			//모든 ip 주소들을 배열로 저장
			InetAddress[] addresses
=InetAddress.getAllByName("naver.com");
			for(InetAddress i : addresses){
				System.out.println(i);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}





