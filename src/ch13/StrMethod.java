package ch13;

public class StrMethod {
	public static void main(String[] args) {
		String str1 = "java";
		str1 += " programming"; //문자열 연결
		System.out.println(str1.length()); //문자열 길이
		String str2 = str1.concat(" programming"); //연결
		System.out.println(str2);
		System.out.println(str1);
		System.out.println(str1.charAt(2)); //n번째 문자
		System.out.println(str2.indexOf("program")); //문자열의 위치
		//내용이 없으면 -1
		System.out.println(str2.indexOf("z"));
		// substring(start,end-1)
		System.out.println(str2.substring(0,4));//0~3
		System.out.println(str2.substring(5));//5~끝까지
		//문자열.replace(A,B) A를 B로 변경
		System.out.println(str2.replace("java", "jsp"));
		System.out.println(str2);
		
	}
}
