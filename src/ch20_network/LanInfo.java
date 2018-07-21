package ch20_network;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class LanInfo {
	public static void main(String[] args) {
		try {
//NetworkInterface : 랜카드의 정보			
			Enumeration<NetworkInterface> enu=
					NetworkInterface.getNetworkInterfaces();
			while(enu.hasMoreElements()){ //다음 요소가 있으면
				NetworkInterface net=enu.nextElement();
				System.out.println(net);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

