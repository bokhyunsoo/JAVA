package ch10;
//1 class 1 file
//다 class 1 file => 파일명과 public 클래스 이름이 같아야 함
//					public class는 1개만
class Test11 {
	public void print(){
		System.out.println("test1");
	}
}
class Test22 extends Test11 {
	@Override
	//override(method 재정의)
	public void print() {
		System.out.println("test2");
	}
}

public class OverrideExam {
	public static void main(String[] args) {
		Test22 t = new Test22();
		t.print();
	}
}
