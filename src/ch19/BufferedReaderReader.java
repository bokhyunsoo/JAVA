package ch19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderReader {
	// new BufferedReader(Reader객체(InputStream객체))
	public static void main(String[] args) {
		BufferedReader reader =
		new BufferedReader(new InputStreamReader(System.in));
		System.out.println("입력하세요:");
		try {
			//한 라인을 읽어들임
			String str = reader.readLine();
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
