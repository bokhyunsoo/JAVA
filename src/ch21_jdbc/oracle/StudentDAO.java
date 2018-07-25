package ch21_jdbc.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import ch21_jdbc.DB;

public class StudentDAO {
	
	public Vector listLecture(int studno){
		Vector items=new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.hrConn();
			StringBuilder sb=new StringBuilder();
			sb.append("select st.studno, st.name sname");
			sb.append(", sb.subject_name, p.name pname");
			sb.append(", sb.point, l.grade");
			sb.append(" from student st, lecture l");
			sb.append(", subject sb, professor p");
			sb.append(" where st.studno=l.studno");
			sb.append(" and l.subject_code=sb.subject_code");
			sb.append(" and p.profno=sb.profno");
			sb.append(" and st.studno=?");
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setInt(1, studno);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Vector row=new Vector();
				row.add(rs.getInt("studno"));
				row.add(rs.getString("sname"));
				row.add(rs.getString("subject_name"));
				row.add(rs.getString("pname"));
				row.add(rs.getDouble("point"));
				row.add(rs.getString("grade"));
				items.add(row);
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
	
	//학생 정보 수정
	public int updateStudent(StudentDTO dto){
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = DB.hrConn();
			String sql="update student "
+ " set name=?,deptno1=?,profno=?,tel=?,img_path=?"
+ " where studno=?";					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getDeptno1());
			pstmt.setInt(3, dto.getProfno());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getImg_path());
			pstmt.setInt(6, dto.getStudno());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	
	//학생의 세부 정보 리턴
	public StudentDTO detailStudent(int studno){
		StudentDTO dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.hrConn();
			StringBuilder sb=new StringBuilder();
			sb.append(" select s.studno, s.name sname");
			sb.append(" , d.deptno, d.dname, p.profno");
			sb.append(" , p.name pname, s.tel, s.img_path");
			sb.append(" from student s, department d");
			sb.append(" , professor p ");
			sb.append(" where s.deptno1=d.deptno ");
			sb.append(" and s.profno=p.profno(+)");
			sb.append(" and s.studno=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, studno);
			rs = pstmt.executeQuery();
			if(rs.next()){ //레코드가 1건일 경우 if
				dto = new StudentDTO();
				dto.setProfno(rs.getInt("profno"));
				dto.setStudno(rs.getInt("studno"));
				dto.setDeptno1(rs.getInt("deptno"));
				dto.setName(rs.getString("sname"));
				dto.setDname(rs.getString("dname"));
				dto.setPname(rs.getString("pname"));
				dto.setTel(rs.getString("tel"));
				dto.setImg_path(rs.getString("img_path")); 
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
		return dto;
	}
	
	public ArrayList<String> listStudent(){
		ArrayList<String> items=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = DB.hrConn(); //hr 계정에 접속
			String sql=
"select (studno ||' '|| name) name from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				items.add(rs.getString("name"));
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
