package ch14;

import java.util.ArrayList;
import java.util.List;

public class ListStudent {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("2017001", "김철수", "국사", 1, "박교수"));
		list.add(new Student("2017002", "박찬호", "영문", 2, "최교수"));
		list.add(new Student("2017003", "송명호", "전산", 3, "김교수"));
		//리스트.size() 데이터의 갯수
		//확장 for문 (java 1.5부터 사용 가능)
		//for( 개별변수 : 집합변수 )
		System.out.println("학번\t이름\t전공\t학년\t지도교수");
		for(Student s : list){
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()
			+"\t"+s.getYear()+"\t"+s.getProfessor());
		}
//		System.out.println("학번\t이름\t전공\t학년\t지도교수");
//		for(int i=0; i<list.size(); i++){
//			Student s = list.get(i); //리스트.get(인덱스)
//			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()
//			+"\t"+s.getYear()+"\t"+s.getProfessor());
//		}
	}
}
