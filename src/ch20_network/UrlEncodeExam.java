package ch20_network;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncodeExam {
	//url encode: 한글,특수문자 등을 인코딩
	//url decode: 인코딩된 문자열을 다시 복원
	public static void main(String[] args) {
		try {
			String str="김철수";
			System.out.println(URLEncoder.encode(str,"utf-8"));
			System.out.println(URLDecoder.decode("%EA%B9%80%EC%B2%A0%EC%88%98","utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




