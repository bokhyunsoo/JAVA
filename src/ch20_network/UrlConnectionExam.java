package ch20_network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionExam {
	public static void main(String[] args) {
		URL url=null;
		try {
			url = new URL("http://google.com"); //url 생성
			//url에 접속
			HttpURLConnection conn=
					(HttpURLConnection)url.openConnection();
			if(conn != null){ //접속되었으면
				//서버에서 일정 시간 응답이 없으면 연결을 종료시킴
				conn.setConnectTimeout(3000);
				StringBuilder sb=new StringBuilder();
				//정상적으로 처리된 경우
// http status code(상태코드)				
				if(conn.getResponseCode() == 
						HttpURLConnection.HTTP_OK){
					//스트림을 이용하여 html source code를 읽어옴
//new BufferedReader(Reader객체(스트림객체)))		
//new InputStreamReader(InputStream객체, 인코딩방식)					
					BufferedReader br=new BufferedReader(
new InputStreamReader(conn.getInputStream(),"utf-8"));
					while(true){
						String line=br.readLine(); //한 라인을 읽음
						if(line == null) break; //내용이 없으면 종료
						sb.append(line+"\r\n"); //줄바꿈 문자 추가
					}
					br.close(); //버퍼 닫기
				}
				conn.disconnect(); //http 연결 종료
				System.out.println(sb); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





