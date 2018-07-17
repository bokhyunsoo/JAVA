package ch05;

public class StringArray {
	public static void main(String[] args) {
		String[] str = {"Java","JSP","Android","Html5"};
//		for(int i=0; i<str.length; i++){
//			System.out.println(str[i]);
//		}
		//확장for문(향상된 for문) , java1.5부터 사용가능
		//for(개별값 저장 변수 : 집합변수)
		//집합변수의 모든 값을 반복처리
		for(String ss : str){
			System.out.println(ss);
		}
	}
}
