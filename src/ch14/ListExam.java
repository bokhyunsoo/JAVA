package ch14;

import java.util.ArrayList;
import java.util.List;

public class ListExam {
	// 제네릭 처리가 되어 있는 클래스
	// new 클래스<자료형>
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		//모든 자료형을 저장할 수 있음
		list.add("하나"); // 리스트.add(추가할 값)
		list.add(2);
		list.add(5.5);
		list.add(false);
		list.add(3,4); //리스트.add(인덱스, 추가할 값)
		list.remove(0); //리스트.remove(삭제할 인덱스)
		//리스트.size()데이터 갯수
		for(int i=0; i<list.size(); i++){
		//리스트.get(인덱스) 데이터 조회
			System.out.print(list.get(i) + "\t");
		}
	}
}
