package ch21_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3308/java"; //연결문자열
		String id="root"; //mysql 접속 아이디
		String password="1234"; //mysql 접속 비밀번호
//		String url="jdbc:mysql://localhost/java"; //연결문자열
//		String id="java"; //mysql 접속 아이디
//		String password="java1234"; //mysql 접속 비밀번호
		Connection conn=null; //DB접속처리
		Statement stmt=null; //sql실행
		ResultSet rs=null; //레코드 탐색
		try {
//jdbc driver를 로딩함			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버를 로딩했습니다.");
// getConnection(연결문자열, 아이디, 비밀번호)			
			conn=DriverManager.getConnection(url,id,password);
			System.out.println("mysql에 접속 성공...");
			
			String sql="select * from books";//sql 작성
			stmt = conn.createStatement();//sql 실행 객체
//select query를 실행한 결과가 결과셋에 전달됨			
			rs = stmt.executeQuery(sql);
			while(rs.next()){ //다음 레코드가 존재하면
//결과셋.get자료형("필드명")				
				int book_id=rs.getInt("book_id");
				//int book_id=rs.getInt(1);
				String title=rs.getString("title");
				String publisher=rs.getString("publisher");
				String year=rs.getString("year");
				int price=rs.getInt("price");
				System.out.println(
book_id+"\t"+title+"\t"+publisher+"\t"+year+"\t"+price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//open ( Connection => Statement => ResultSet )
			//close ( ResultSet => Statement => Connection )
			try {
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}









