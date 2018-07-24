package ch21_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TableInfo {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//테이블에 대한 부가적인 설명 데이터
		ResultSetMetaData meta=null;
		try {
			conn = DB.dbConn();
			String sql="select * from score";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			meta = rs.getMetaData();//테이블의 메타데이터 리턴 
			int cols=meta.getColumnCount();//컬럼의 갯수
			System.out.println("필드명\t\t자료형\tNull여부");
			for(int i=1; i<=cols; i++){
				String colName=meta.getColumnName(i);//필드명
				String colType=meta.getColumnTypeName(i);//자료형
				int isNull = meta.isNullable(i); //null 여부
				System.out.println(
						colName+"\t\t"+colType+"\t"+isNull);
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
	}
}
