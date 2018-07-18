package ch13;

import java.util.StringTokenizer;

public class StrToken {
	public static void main(String[] args) {
		String str = "apple/bannana/grape/melon";
		// 문자열.split("구분자") 문자열을 배열로 리턴
		String[] items = str.split("/");
		for(String s : items){
			System.out.println(s);
		}
		//new StringTokenizer(문자열,"구분자")
		StringTokenizer st = new StringTokenizer(str,"/");
		int cnt = st.countTokens(); //토큰의 갯수
		System.out.println("토큰의 갯수"+cnt);
		//다음 요소가 있으면
		while(st.hasMoreElements()){
			//다음 요소의 내용
			System.out.println(st.nextToken());
		}
	}
}