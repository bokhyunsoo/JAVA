package ch14;

public class Type3<T> { // 자료형이 미정인 상태
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	// generic(일반화)
	public static void main(String[] args) {
		//인스턴스를 생성할 때 자료형이 결정됨
		Type3<String> t = new Type3<String>();
		t.setT("100");
//		t.setT(100);
		System.out.println(t.getT());
		Type3<Integer> t2 = new Type3<Integer>();
		t2.setT(100);
		System.out.println(t2.getT());
		//warning(경고)
		Type3 t3 = new Type3();
		t3.setT(100.5);
		t3.setT("hello");
		System.out.println(t3.getT());
	}
}
