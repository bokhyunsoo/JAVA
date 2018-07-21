package ch19;

import java.io.Serializable;
//객체직렬화를 하기 위해서는 
//Serializable 인터페이스를 구현해야 함
public class MemberDTO implements Serializable {
	private String name;
	private int age;
// transient 객체직렬화에서 제외하고 싶은 요소	
	private transient MemberInfoDTO memberInfo;
	//기본생성자,매개변수가 있는 생성자
	public MemberDTO() {
	}
	public MemberDTO(String name, int age
			, String jumin, String pwd) {
		super();
		this.name = name;
		this.age = age;
		memberInfo = new MemberInfoDTO(jumin,pwd);
	}
	//getter,setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MemberInfoDTO getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MemberInfoDTO memberInfo) {
		this.memberInfo = memberInfo;
	}
	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", age=" + age + ", memberInfo=" + memberInfo + "]";
	}
	
	//toString()
	
}
