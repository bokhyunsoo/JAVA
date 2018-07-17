package ch07;

public class Employee {
	private String name;
	private String part;
	private String position;
	private int basic;
	private int bonus;
	private int total;
	private int tax;
	private int salary;
	public void input(String name, String part, String position, int basic) {
		this.name = name;
		this.part = part;
		this.position = position;
		this.basic = basic;
	}
	public void calc(){
		bonus = basic * 3;
		total = basic + bonus;
		tax = (int)(total*0.033);
		salary = total - tax;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", part=" + part + ", position=" + position + ", basic=" + basic + ", bonus=" + bonus + ", total=" + total
				+ ", tax=" + tax + ", salary=" + salary + "]";
	}
}
