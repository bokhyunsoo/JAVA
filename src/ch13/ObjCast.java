package ch13;

public class ObjCast {
	public static void main(String[] args) {
		int a = 10;
		Object obj = 20;
		// 부모 = 자식 ( o )
		// 자식 = 부모 ( x )
		//a = obj; //error
		//a = (Integer)obj;
		a = (int)obj;
		System.out.println(a);
		//배열 : 같은 자료형만 가능
		//Object 배열 : 다양한 자료형 사용 가능
		Object[] obj2 = {100,100.5,true,"hello",'A'};
		for(Object o : obj2){
			System.out.println(o);
		}
	}
}
