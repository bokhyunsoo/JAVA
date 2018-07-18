package ch13;

public class Str {
	public static void main(String[] args) {
		String str="Java Programming";
		System.out.println(str);
		//대문자로 변경
		System.out.println(str.toUpperCase());
		//소문자로 변경
		System.out.println(str.toLowerCase());
		//원본은 바뀌지 않음(immutable, 불변성)
		System.out.println(str);
		str = str.toLowerCase();
		System.out.println(str);
		
		str = ""; //빈 문자열을 가리킴
		System.out.println("내용:"+str);
		str = null; // 참조하는 내용이 없음
		System.out.println("내용:"+str);
		
		char ch = '\0';
		System.out.println("내용:"+ch+",code:"+(int)ch);
		ch = ' ';
		System.out.println("내용:"+ch+",code:"+(int)ch);
	}
}
