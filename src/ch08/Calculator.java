package ch08;

public class Calculator {
	private int left;
	private int right;
	public Calculator() {
		System.out.println("기본 생성자 호출...");
	}
	public Calculator(int left, int right) {
		System.out.println("매개변수가 있는 생성자 호출...");
		this.left = left;
		this.right = right;
	}
	//getter, setter 추가
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public void sum(){
		System.out.println(left + right);
	}
	public void avg(){
		System.out.println((left + right)/2);
	}
}
