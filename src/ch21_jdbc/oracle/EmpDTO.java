package ch21_jdbc.oracle;

import java.sql.Date;

public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	private Date hiredate; //java.sql.Date
	private int sal;
// dname 필드는 emp 테이블에 없지만 출력에 필요하므로 추가
	private String dname;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + ", sal=" + sal
				+ ", dname=" + dname + "]";
	}
	public EmpDTO() {
	}
	public EmpDTO(int empno, String ename, String job, Date hiredate, int sal, String dname) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.sal = sal;
		this.dname = dname;
	}
	
}







