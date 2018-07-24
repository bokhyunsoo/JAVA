package ch21_jdbc.oracle;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class MemberInsert {
	public static void main(String[] args) 
			throws Exception {
		FileInputStream fis
=new FileInputStream("C:\\Users\\bok\\Desktop\\java_tutorials\\oracle.prop");
		//key와 value를 세트로 관리하는 객체
		Properties prop=new Properties();
		prop.load(fis);
		String driver=prop.getProperty("driver");
		String url=prop.getProperty("url");
		String id=prop.getProperty("id");
		String password=prop.getProperty("password");
		Connection conn=null;
		//Statement stmt=null;
		PreparedStatement stmt=null;
		try {
			//Class.forName(driver); //jdbc driver loading
			//오라클 서버에 접속
			conn=DriverManager.getConnection(url,id,password);
			Scanner scan=new Scanner(System.in);
			System.out.print("아이디:");
			String userid=scan.nextLine(); //한 라인을 입력
			System.out.print("비밀번호:");
			String passwd=scan.nextLine();
			System.out.print("이름:");
			String name=scan.nextLine();
// Statement를 사용하는 경우(권장하지 않음)			
//			String sql=
//"insert into member (userid,passwd,name) values"
//+ " ('"+userid+"','"+passwd+"','"+name+"')";
//			System.out.println(sql);
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
// PreparedStatement를 사용하는 경우
// SQL의 틀을 먼저 만든 후 값을 나중에 입력			
			String sql=
"insert into member (userid,passwd,name) values"
+"(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userid);
			stmt.setString(2, passwd);
			stmt.setString(3, name);
			stmt.executeUpdate(); 
			System.out.println("저장되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}










