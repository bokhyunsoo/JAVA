package ch14;

import java.util.LinkedList;

public class LinkedListExam {
	public static void main(String[] args) {
		//큐 구조 : FIFO(First Input First Out)
		//입력 offer, 출력 poll
		String[] fruits={"사과","배","포도","딸기","수박"};
		LinkedList<String> list = new LinkedList<>();
		for(String str : fruits){
			list.offer(str); //자료 입력
		}
		String str="";
		while((str = (String)list.poll()) != null){
			System.out.println(str+" 삭제되었습니다.");
		}
	}
}
