package ch19;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
// InputStream : 바이트 단위로 읽음
// InputStreamReader 문자 단위로 읽음
public class ReaderExam {
	public static void main(String[] args) {
		int var = 0;
		Reader input = new InputStreamReader(System.in);
		System.out.println("입력하세요:");
		try {
			while(true){
				// 1문자를 읽어들임
				var = input.read();
				//문자코드 13번 : 엔터문자
				if(var == 13) break; //엔터문자를 읽으면 종료
				System.out.println(var+"==>"+(char)var);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		System.out.println();
	}
}
