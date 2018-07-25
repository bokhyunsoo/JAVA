package ch21_jdbc.oracle;

public class StudentDTO {
	private int studno; //학번
	private String name; //이름
	private int grade; //학년
	private String jumin; //주민번호
	private String tel; //전화
	private int deptno1; //제1전공
	private int deptno2; //제2전공
	private int profno; //지도교수 사번
	private String dname; //학과명
	private String pname; //지도교수 이름
	private String img_path; //증명사진이 저장된 경로
	//getter,setter, toString(), 생성자
	public int getStudno() {
		return studno;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getDeptno1() {
		return deptno1;
	}
	public void setDeptno1(int deptno1) {
		this.deptno1 = deptno1;
	}
	public int getDeptno2() {
		return deptno2;
	}
	public void setDeptno2(int deptno2) {
		this.deptno2 = deptno2;
	}
	public int getProfno() {
		return profno;
	}
	public void setProfno(int profno) {
		this.profno = profno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	@Override
	public String toString() {
		return "StudentDTO [studno=" + studno + ", name=" + name + ", grade=" + grade + ", jumin=" + jumin + ", tel=" + tel
				+ ", deptno1=" + deptno1 + ", deptno2=" + deptno2 + ", profno=" + profno + ", dname=" + dname + ", pname="
				+ pname + ", img_path=" + img_path + "]";
	}
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(int studno, String name, int grade, String jumin, String tel, int deptno1, int deptno2, int profno,
			String dname, String pname, String img_path) {
		super();
		this.studno = studno;
		this.name = name;
		this.grade = grade;
		this.jumin = jumin;
		this.tel = tel;
		this.deptno1 = deptno1;
		this.deptno2 = deptno2;
		this.profno = profno;
		this.dname = dname;
		this.pname = pname;
		this.img_path = img_path;
	}
	
}

