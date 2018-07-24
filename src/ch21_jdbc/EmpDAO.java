package ch21_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//dao : Data Access Object
public class EmpDAO {
	public int deleteEmp(int empno){
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = DB.dbConn();
			String sql="delete from emp where empno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
	public List<EmpDTO> listEmp(){
		List<EmpDTO> items=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn(); //mysql에 접속 처리
			String sql="select * from emp";
			pstmt=conn.prepareStatement(sql);//sql 실행 객체
			rs=pstmt.executeQuery(); //sql실행
			while(rs.next()){ //다음 레코드가 존재하면 true
				// 결과셋.get자료형("필드명")
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
			//java.sql.Date
				Date hiredate=rs.getDate("hiredate");
				int sal=rs.getInt("sal");
				//ArrayList에 dto를 추가
				items.add(new EmpDTO(empno,ename,hiredate,sal));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { //역순으로 닫음
			try {
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return items;
	}

	public void insertEmp(EmpDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = DB.dbConn();
			String sql=
"insert into emp (empno,ename,hiredate,sal) "
+ "values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setDate(3, dto.getHiredate());
			pstmt.setInt(4, dto.getSal());
			pstmt.executeUpdate();
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


}








