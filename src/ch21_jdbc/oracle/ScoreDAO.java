package ch21_jdbc.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import ch21_jdbc.DB;

public class ScoreDAO {

	public int updateScore(ScoreDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("update score ");
			sb.append(" set name=?,kor=?,eng=?,mat=?");
			sb.append(" where student_no=?");
			pstmt = conn.prepareStatement(sb.toString());
			// ? 순번과 자료형이 일치해야 함
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setString(5, dto.getStudent_no());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int insertScore(ScoreDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try { // java code에서는 auto commit
			conn = DB.oraConn(); // 오라클 서버에 접속
			StringBuilder sb = new StringBuilder();
			sb.append("insert into score ");
			sb.append("values (?,?,?,?,?)");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getStudent_no());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			// 성공하면 1, 실패하면 0가 리턴
			// affected rows(영향을 받은 행의 수)
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ScoreDTO viewScore(String student_no) {
		ScoreDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			StringBuilder sb = new StringBuilder();
			sb.append("select student_no,name,kor,eng,mat ");
			sb.append(",(kor+eng+mat) tot ");
			sb.append(", round( (kor+eng+mat)/3.0 ,2) avg ");
			sb.append(" from score");
			sb.append(" where student_no=?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, student_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				dto = new ScoreDTO(student_no, name, kor, eng, mat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public Vector listScore() {
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			// String sql="select student_no,name,kor,eng,mat "
			// +",(kor+eng+mat) tot "
			// +", round( (kor+eng+mat)/3.0 ,2) avg "
			// +"from score";
			StringBuilder sb = new StringBuilder();
			sb.append("select student_no,name,kor,eng,mat ");
			sb.append(",(kor+eng+mat) tot ");
			sb.append(", round( (kor+eng+mat)/3.0 ,2) avg ");
			sb.append(" from score");
			sb.append(" order by name");
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vector row = new Vector();
				String student_no = rs.getString("student_no");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				double avg = rs.getDouble("avg");
				row.add(student_no);
				row.add(name);
				row.add(kor);
				row.add(eng);
				row.add(mat);
				row.add(tot);
				row.add(avg);
				items.add(row); // 벡터에 1개의 행을 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}
