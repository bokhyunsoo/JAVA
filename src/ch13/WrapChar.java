package ch13;

public class WrapChar {
	public static void main(String[] args) {
		char[] data={'J','a','v','a','1','#'};
		for(int i=0; i<data.length; i++){
			//소문자를 대문자로 변경
			data[i] = Character.toUpperCase(data[i]);
			//대문자를 소문자로 변경
//			data[i] = Character.toLowerCase(data[i]);
			if(Character.isUpperCase(data[i])){
				System.out.println(data[i]+"==> 대문자");
			}else if(Character.isLowerCase(data[i])){
				System.out.println(data[i]+"==> 소문자");
			}else if(Character.isDigit(data[i])){
				System.out.println(data[i]+"==> 숫자");
			}else{
				System.out.println(data[i]+"==> 기타문자");
			}
		}
	}
}
