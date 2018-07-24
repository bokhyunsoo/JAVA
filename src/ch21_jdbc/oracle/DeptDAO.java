package ch21_jdbc.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch21_jdbc.DB;

public class DeptDAO {
	public ArrayList<DeptDTO> listDept(){
		ArrayList<DeptDTO> items=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.hrConn(); //DB커넥션
			String sql="select * from dept order by dname";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){ //다음 레코드가 있으면
				//결과셋.get자료형("필드명")
				int deptno=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc"); 
				DeptDTO dto=new DeptDTO(deptno, dname, loc);
				items.add(dto); //ArrayList에 dto 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if( pstmt != null ) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if( conn != null ) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}

