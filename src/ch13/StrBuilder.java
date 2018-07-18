package ch13;

public class StrBuilder {
	public static void main(String[] args) {
		//String 불변(immutable), StringBuilder 가변(mutable)
		//StringBuffer str1 = new StringBuffer();
		StringBuilder str1 = new StringBuilder();
		str1.append("java"); //문자열 내용 추가
		System.out.println(str1);
		str1.append(" programming");
		System.out.println(str1);
		
		str1.replace(0, 4, "jsp");//0~3 인덱스 내용을 변경
		System.out.println(str1);
		String str2 = str1.substring(3);//인덱스 3부터 끝까지
		System.out.println(str1);
		System.out.println(str2);
		//StringBuilder를 String으로 바꿀 때
		String str3 = str1.toString();
		//str1 = str3;
		//String을 StringBuilder에 저장할 때
		str1 = new StringBuilder(str3);
	}	
}
