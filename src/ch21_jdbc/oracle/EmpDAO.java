package ch21_jdbc.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch21_jdbc.DB;

public class EmpDAO {
	//public ArrayList<EmpDTO> listEmp(String dname){
	public ArrayList<EmpDTO> listEmp(int deptno){
		ArrayList<EmpDTO> items=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = DB.hrConn();
			StringBuilder sb=new StringBuilder();
			sb.append("select empno,ename,e.deptno,dname");
			sb.append(" from emp e, dept d ");
			sb.append(" where e.deptno=d.deptno");
			//sb.append("   and dname=? " );
			sb.append(" and e.deptno=? ");
			sb.append(" order by ename ");
			pstmt = conn.prepareStatement(sb.toString());
			//pstmt.setString(1, dname); // ?에 입력될 값
			pstmt.setInt(1, deptno); 
			rs = pstmt.executeQuery();
			while(rs.next()){
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				EmpDTO dto=new EmpDTO();
				dto.setEmpno(empno);
				dto.setEname(ename);
				items.add(dto); //ArrayList에 dto 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
}








