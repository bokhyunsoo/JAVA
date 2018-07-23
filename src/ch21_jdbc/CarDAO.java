package ch21_jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//dao : Data Access Object, 데이터 처리를 담당하는 클래스
public class CarDAO {
	//DB접속, 커넥션 리턴
	public Connection dbConn(){
		Connection conn=null;
		try {
			FileInputStream fis=
					new FileInputStream("C:\\Users\\bok\\Desktop\\java_tutorials\\db.prop");
			Properties prop=new Properties();
			prop.load(fis); 
			String url=prop.getProperty("url");
			String id=prop.getProperty("id");
			String password=prop.getProperty("password");
			conn=DriverManager.getConnection(url,id,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	//car 테이블의 레코드들을 ArrayList로 리턴하는 코드
	public List<CarDTO> listCar(){
		List<CarDTO> items=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//DB접속
			conn=dbConn();
			//sql 실행
			String sql="select * from car";
			//각각의 레코드를 dto에 저장=>list에 추가
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){ //다음 레코드가 존재하면
				String license_number=
						rs.getString("license_number");
				String company=rs.getString("company");
				String type=rs.getString("type");
				int year=rs.getInt("year");
				int efficiency=rs.getInt("efficiency");
				CarDTO dto
=new CarDTO(license_number,company,type,year,efficiency);
				items.add(dto); //ArrayList에 dto를 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return items;
	}
	
	public void insertCar(CarDTO dto){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=dbConn(); //DB접속
			String sql="insert into car "
+"(license_number,company,type,year,efficiency)"
+"values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getLicense_number());
			pstmt.setString(2, dto.getCompany());
			pstmt.setString(3, dto.getType());
			pstmt.setInt(4, dto.getYear());
			pstmt.setInt(5, dto.getEfficiency());
			pstmt.executeUpdate(); //sql 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public int deleteCar(String license_number){
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=dbConn();
			String sql=
"delete from car where license_number=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, license_number);
//affected rows(영향을 받은 레코드수)			
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}














