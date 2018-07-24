package ch21_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ScoreDAO {
	public int insertScore(ScoreDTO dto){
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = DB.dbConn(); //DB접속
			String sql=
"insert into score values (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
//물음표 7개에 입력될 값 설정			
			pstmt.setString(1, dto.getStudent_no());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			pstmt.setInt(6, dto.getTot());
			pstmt.setDouble(7, dto.getAvg());
//insert query 실행 후 성공한 레코드갯수를 result에 저장			
			result=pstmt.executeUpdate();
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
		return result;
	}
	public int deleteScore(String student_no){
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = DB.dbConn();
			String sql="delete from score where student_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, student_no);
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
	public int updateScore(ScoreDTO dto){
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn = DB.dbConn(); //DB접속
			String sql=
"update score "
+ " set name=?,kor=?,eng=?,mat=?,tot=?,avg=? "
+ " where student_no=?";
			pstmt = conn.prepareStatement(sql);
//물음표 7개에 입력될 값 설정			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setInt(5, dto.getTot());
			pstmt.setDouble(6, dto.getAvg());
			pstmt.setString(7, dto.getStudent_no());
//insert query 실행 후 성공한 레코드갯수를 result에 저장			
			result=pstmt.executeUpdate();
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
		return result;
	}
	//학생 검색
	public Vector searchScore(String name){
		Vector items=new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn(); //mysql 접속
			String sql=
"select student_no,name,kor,eng,mat "
+",(kor+eng+mat) tot, round(((kor+eng+mat)/3.0),1) avg"
+" from score where name like ? order by name";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery(); //sql 실행
			while(rs.next()){ //다음 레코드가 존재하면
				Vector row=new Vector();
				row.add(rs.getString("student_no"));
				row.add(rs.getString("name"));
				row.add(rs.getInt("kor"));
				row.add(rs.getInt("eng"));
				row.add(rs.getInt("mat"));
				row.add(rs.getInt("tot"));
				row.add(rs.getDouble("avg"));
				items.add(row); //레코드 1개를 벡터에 추가
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
	
// JTable에 전달할 벡터 데이터 리턴	
//	public Vector listScore(){
//		Vector items=new Vector();
//		Connection conn=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			conn=DB.dbConn(); //mysql 접속
//			String sql=
//"select student_no,name,kor,eng,mat "
//+",(kor+eng+mat) tot, round(((kor+eng+mat)/3.0),1) avg"
//+" from score order by name";
//			System.out.println(sql);
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery(); //sql 실행
//			while(rs.next()){ //다음 레코드가 존재하면
//				Vector row=new Vector();
//				row.add(rs.getString("student_no"));
//				row.add(rs.getString("name"));
//				row.add(rs.getInt("kor"));
//				row.add(rs.getInt("eng"));
//				row.add(rs.getInt("mat"));
//				row.add(rs.getInt("tot"));
//				row.add(rs.getDouble("avg"));
//				items.add(row); //레코드 1개를 벡터에 추가
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if(pstmt!=null) pstmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if(conn!=null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return items;
//	}
}








