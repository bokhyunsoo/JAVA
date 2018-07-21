package ch20_network;

import java.net.URL;

public class UrlInfo {
	//URL : url 정보를 분석하는 클래스
	public static void main(String[] args) {
		try {
			URL url=new URL(
"http://google.com");
			System.out.println("프로토콜:"+url.getProtocol());
			System.out.println("포트:"+url.getPort());
			System.out.println("호스트:"+url.getHost());
			System.out.println("파일:"+url.getFile());
			System.out.println("기타:"+url.toExternalForm());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
