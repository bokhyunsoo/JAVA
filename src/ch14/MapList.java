package ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {
	static void print(Map map){
		List<Student> list2 = (ArrayList<Student>)map.get("list");
		for(Student s : list2){
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getMajor()
			+"\t"+s.getYear()+"\t"+s.getProfessor());
		}
	}
	
	public static void main(String[] args) {
		// Map<key자료형,value자료형>
		Map<String,Object> map = new HashMap<>(); //맵 인스턴스
		List<Student> list = new ArrayList<>(); //리스트 인스턴스
		list.add(new Student("2017001", "김철수", "국사", 1, "박교수")); //리스트에 Student 추가
		list.add(new Student("2017002", "박찬호", "영문", 2, "최교수"));
		list.add(new Student("2017003", "송명호", "전산", 3, "김교수"));
		map.put("list", list); //맵에 리스트 추가
		
		print(map);
	}
}
