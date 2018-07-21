package ch20_network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownloadImage {
	public static void main(String[] args) 
				throws Exception {
		String website="http://img.specialone.co.kr/editor/default_1429605186.jpg";
		System.out.println("다운로드를 시작합니다.");
		URL url=new URL(website); //url 생성
//byte 배열		
		byte[] buffer=new byte[4096];
		
// 파일로 저장 <==== 프로그램 <========= 서버의 이미지 파일		
		
//try~with문		
		try(InputStream in=url.openStream();
OutputStream out=new FileOutputStream("d:\\test.jpg")){
			int length=0;
// 읽은바이트수=스트림.read(버퍼)			
// 더이상 읽을 내용이 없으면 -1			
			while((length=in.read(buffer)) != -1){
				System.out.println(length+"바이트 읽음.");
// 출력스트림.write(버퍼,시작인덱스,길이)				
				out.write(buffer, 0, length);
			} 
			System.out.println("다운로드가 완료되었습니다.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}






