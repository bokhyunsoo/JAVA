package ch19;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileWrite {
	public static void main(String[] args) {
//프로그램 ===> 파일 (출력스트림이 필요함)
//OutputStream : 1byte 출력
//OutputStreamWriter : 1 char 출력		
		OutputStream os=null; 
		try {
			os=new FileOutputStream("d:\\test.txt");
			System.out.println("입력하세요:");
			while(true){
				int ch=System.in.read(); //1 byte 읽음
				System.out.println(ch+"==>"+(char)ch);
				if(ch==13) break; //엔터키를 만나면 종료
				os.write(ch); //파일에 1바이트 저장
			}
			System.out.println("저장되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
