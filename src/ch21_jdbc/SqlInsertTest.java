package ch21_jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class SqlInsertTest {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\bok\\Desktop\\java_tutorials\\db.prop");
		// key와 value를 세트로 관리하는 객체
		Properties prop = new Properties();
		// db.prop 파일을 읽어서 key, value 구조로 변환
		prop.load(fis);
		// getProperty(key) value 리턴
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String id = prop.getProperty("id");
		String password = prop.getProperty("password");
		System.out.println(driver);
		System.out.println(url);
		System.out.println(id);
		System.out.println(password);
		Connection conn=null;
		//Statement stmt=null;
		PreparedStatement stmt=null;
		try {
			Class.forName(driver); //jdbc driver 로딩
			//DB에 접속
			conn= DriverManager.getConnection(url,id,password);
			String title="C언어";
			String publisher="금성출판사";
			String year="2017";
			int price=45000;
// inline sql			
			String sql=
"insert into books (title,publisher,year,price)"
+" values "
+" (?,?,?,?)";
			stmt = conn.prepareStatement(sql);//sql 실행준비
			stmt.setString(1, title); //1번 물음표에 입력될 값
			stmt.setString(2, publisher);
			stmt.setString(3, year);
			stmt.setInt(4, price);
			stmt.executeUpdate(); //sql 실행
//+"('"+title+"','"+publisher+"','"+year+"',"+price+")";
//			StringBuilder sb=new StringBuilder();
//			sb.append("insert into books (title,publisher,year,price)");
//			sb.append(" values ");
//			sb.append("('"+title+"','"+publisher+"','"+year+"',"+price+")");
//			stmt = conn.createStatement();
//			stmt.executeUpdate(sql);
			//stmt.executeUpdate(sb.toString());
			System.out.println("추가되었습니다.");
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
