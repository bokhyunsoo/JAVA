package ch19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamExam {
// Stream : 데이터의 논리적인 통로, 바이트 단위	
// 프로그램   ==========>    외부자원 : 출력스트림
// 프로그램   <==========    외부자원 : 입력스트림
	public static void main(String[] args) {
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		MemberDTO m1
=new MemberDTO("kim",30,"871231-1111111","1234");
		MemberDTO m2
=new MemberDTO("park",28,"891231-1111111","2222");
		MemberDTO m3
=new MemberDTO("hong",25,"921231-1111111","3333");
		try {
//파일저장을 위한 출력 스트림			
			fos=new FileOutputStream("d:\\object.dat");
//메모리에 있는 객체를 파일로 저장하기 위한 스트림			
			oos=new ObjectOutputStream(fos);
			oos.writeObject(m1); //m1 객체를 파일에 저장
			oos.writeObject(m2);
			oos.writeObject(m3);
			System.out.println("객체를 파일로 저장했습니다.");
//객체직렬화 : serialization		
//역직렬화			
//NotSerializableException: 객체직렬화를 할 수 없는 클래스

		} catch (Exception e) {
			e.printStackTrace();
		}
		//역직렬화 코드
// 메모리 <===  프로그램 <========= 파일		
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis=new FileInputStream("d:\\object.dat");
			ois=new ObjectInputStream(fis);
			MemberDTO dto1=(MemberDTO)ois.readObject();
			MemberDTO dto2=(MemberDTO)ois.readObject();
			MemberDTO dto3=(MemberDTO)ois.readObject();
			System.out.println(dto1);
			System.out.println(dto2);
			System.out.println(dto3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}












