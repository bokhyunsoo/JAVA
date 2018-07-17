package ch05;

public class CharArray {
	public static void main(String[] args) {
		//char[] ch={'J','a','v','a'};
		char[] ch; // 배열참조변수 선언
		ch=new char[4];// 배열생성, 시작번지=>참조변수에 복사
		ch[0]='J';
		ch[1]='a';
		ch[2]='v';
		ch[3]='a';
		//ch[4]='k';
		//배열참조변수.length=>배열의 사이즈
		for(int i=0; i<ch.length; i++){
			System.out.println(i+"번째 문자:"+ch[i]);
		}
	}
}
