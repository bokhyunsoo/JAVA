package ch14;

public class Type1 {
//	int value;
	double value;
	
//	public int getValue() {
//		return value;
//	}
	

//	public void setValue(int value) {
//		this.value = value;
//	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public static void main(String[] args) {
		Type1 t = new Type1();
		t.setValue(100);
//		t.setValue(100.5);
//		t.setValue("hello");
//		System.out.println(t.getValue());
		
	}
}
