package ch21_jdbc.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch21_jdbc.DB;

public class ProfessorDAO {
	public ArrayList<ProfessorDTO> listProfessor(){
		ArrayList<ProfessorDTO> items=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = DB.hrConn(); //Oracle hr 계정에 접속
			String sql="select * from professor order by name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int profno=rs.getInt("profno");
				String name=rs.getString("name");
				ProfessorDTO dto=new ProfessorDTO(profno, name);
				items.add(dto); //ArrayList에 레코드 1건 추가
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


