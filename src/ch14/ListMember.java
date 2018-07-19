package ch14;

import java.util.ArrayList;
import java.util.List;

public class ListMember {
	public static void main(String[] args) {
		//ArrayList 생성
		List<Member> list = new ArrayList<>();
		//Member 인스턴스 생성
		Member m1 = new Member();
		m1.setName("김철수");
		m1.setUserid("kim");
		m1.setPasswd("1234");
		m1.setTel("02-999-8888");
		m1.setEmail("kim@naver.com");
		//List에 Member 인스턴스 추가
		list.add(m1);
		
		Member m2 = new Member("hong","1234","홍길동","02-988-9999","hong@nate.com");
		list.add(m2);
		
		list.add(new Member("choi","1234","최철수","031-555-5555","choi@gmail.com"));
		
		System.out.println("이름\t아이디\t비번\t전화\t\t이메일");
		for(int i=0; i<list.size(); i++){
			Member m = list.get(i);
			System.out.println(m.getName()+"\t"+m.getUserid()+"\t"
					+m.getPasswd()+"\t"+m.getTel()+"\t"+m.getEmail()+"\t");
		}
	}
}
