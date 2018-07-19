package ch14;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {
	public static void main(String[] args) {
		//Set<String> hs = new HashSet<>();
		//집합의 데이터를 자동 정렬시킴
		Set<String> hs = new TreeSet<>();
		hs.add("korea");
		hs.add("japan");
		hs.add("america");
		hs.add("britain");
		hs.add("korea"); //중복값은 입력되지 않음
		System.out.println(hs); //순서대로 저장되지 않음
		for(String str : hs){
			System.out.println(str);
		}
		//Iterator 반복 처리를 위한 클래스
		Iterator<String> it = hs.iterator();
		while(it.hasNext()){//다음 요소가 있으면 true
			System.out.println(it.next());//다음 요소를 꺼냄
		}
	}
}
