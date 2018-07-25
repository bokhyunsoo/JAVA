package ch21_jdbc.oracle;

public class ProfessorDTO {
	private int profno;
	private String name;
	//getter,setter,toString(),생성자
	public int getProfno() {
		return profno;
	}
	public void setProfno(int profno) {
		this.profno = profno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProfessorDTO [profno=" + profno + ", name=" + name + "]";
	}
	public ProfessorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfessorDTO(int profno, String name) {
		super();
		this.profno = profno;
		this.name = name;
	}
	
}
