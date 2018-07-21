package ch19;

import java.io.RandomAccessFile;

public class RandomFile {
	public static void main(String[] args) {
		StringBuilder output=new StringBuilder();
		String str=null;
		try {
// r 읽기전용, w 쓰기전용, rw 읽기쓰기			
			RandomAccessFile file=new RandomAccessFile(
					"d:\\test.txt","rw"); //읽기쓰기 모드
//파일포인터(파일을 어디까지 읽었는지 가리킴)			
			//파일 포인터를 이동시킴
			file.seek(89);
// write(바이트배열)			
			file.write("추가한 내용".getBytes());
			file.seek(0);
			//파일포인터(파일을 어디까지 읽었는지 가리킴)
			while(file.getFilePointer() < file.length()){
				output.append(file.getFilePointer()+":");
				str=file.readLine();
				//한글 처리
//스트링.getBytes() 스트링을 바이트배열로 변환
//new String( 문자열, 캐릭터셋 ) 인코딩 방식 변환	
// iso-8859-1, 				8859_1 서유럽언어 인코딩방식
				str = new String(str.getBytes("8859_1"),"utf-8");
				output.append(str+"\r\n");
			}
			file.close();
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



