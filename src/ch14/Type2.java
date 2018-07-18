package ch14;

public class Type2 {
	Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
		Type2 t = new Type2();
//		Object value= new String("kim");
		t.setValue("kim");
//		Object value= new String(100);
		t.setValue(100);
		System.out.println(t.getValue());
	}
}
