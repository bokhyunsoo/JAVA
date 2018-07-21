package ch19;

import java.io.IOException;

//스트림 : 데이터의 논리적인 통로
// 1 byte 단위로 처리됨
// InputStream(입력스트림)
// OutputStream(출력스트림)
public class InputStreamExam {
//	프로그램 <= 키보드
	public static void main(String[] args) {
		int var = 0;
//		System.in => InputStream(입력스트림)
		try {
			System.out.println("내용을 입력하세요:");
			//1byte를 읽음
			var = System.in.read();
			while(var != 13){ //엔터키가 아니면
				System.out.println(var+"==>"+(char)var);
				var = System.in.read();
			}
			
		} catch (IOException e) { //입출력관련 예외처리
			e.printStackTrace();
		} 
	}
}
