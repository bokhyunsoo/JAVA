package ch21_jdbc.oracle;

public class DepartmentDTO {
	private int deptno;
	private String dname;

	// getter,setter, toString(), 생성자
	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [deptno=" + deptno + ", dname=" + dname + "]";
	}

	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentDTO(int deptno, String dname) {
		super();
		this.deptno = deptno;
		this.dname = dname;
	}

}
