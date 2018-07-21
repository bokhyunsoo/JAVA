package ch19;

import java.io.Serializable;

// DTO : Data Transfer Object(데이터 전달 객체)
// VO : Vector Object, Value Object
public class MemberInfoDTO  implements Serializable{
	private String juminNo;
	private String passwd;
	//기본생성자,매개변수가 있는 생성자
	public MemberInfoDTO() {
	}
	public MemberInfoDTO(String juminNo, String passwd) {
		super();
		this.juminNo = juminNo;
		this.passwd = passwd;
	}
	//getter,setter
	//toString()
	public String getJuminNo() {
		return juminNo;
	}
	public void setJuminNo(String juminNo) {
		this.juminNo = juminNo;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "MemberInfoDTO [juminNo=" + juminNo + ", passwd=" + passwd + "]";
	}
	
}
