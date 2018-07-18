package ch14;

import java.util.Vector;

public class VectorExam {
	public static void main(String[] args) {
		Vector<Object> v = new Vector<>(); //벡터 인스턴스 생성
		//모든 자료형 처리 가능
		//사이즈가 자동으로 늘어남
		System.out.println("초기사이즈:"+v.capacity());
		v.add("first"); // add("추가할 자료")
		v.add(2);
		v.add(3.5);
		v.add(true);
		v.add(3.5);
		v.add(3.5);
		v.add(3.5);
		v.add(3.5);
		v.add(3.5);
		v.add(3.5);
		v.add(3.5);
		System.out.println("두번째사이즈:"+v.capacity());
		System.out.println("데이터의 갯수"+v.size());
		System.out.println("초기 데이터");
		for(int i=0; i<v.size(); i++){
			System.out.print(v.get(i)+"\t");
		}
		System.out.println();
		v.remove(0); //벡터의 인덱스 0번 요소 삭제
		for(int i=0; i<v.size(); i++){
			System.out.print(v.get(i)+"\t");
		}
		System.out.println();
		v.add(0, "hello"); //0번 인덱스에 데이터 추가
		for(int i=0; i<v.size(); i++){
			System.out.print(v.get(i)+"\t");
		}
	}
}
