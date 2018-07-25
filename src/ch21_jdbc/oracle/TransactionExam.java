package ch21_jdbc.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch21_jdbc.DB;

public class TransactionExam {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		boolean success=false;
		try {
			conn = DB.hrConn(); //hr 계정으로 접속 
			conn.setAutoCommit(false); //auto commit 해제
//			conn.setAutoCommit(true); //기본 옵션
			StringBuilder sb=new StringBuilder();
			sb.append("insert into emp_copy (empno,ename,sal)");
			sb.append("values (?,?,?)"); 
			pstmt = conn.prepareStatement(sb.toString());
			long start=System.currentTimeMillis();//현재 시각
			for(int i=1; i<=100000; i++){ //레코드 10만건 입력
				pstmt.setInt(1, i);
				pstmt.setString(2, "kim");
				pstmt.setInt(3, 4500);
				System.out.println(i);
				//pstmt.executeUpdate();
				pstmt.addBatch(); //일괄처리 작업 추가
			}
			pstmt.executeBatch(); //일괄처리 작업 실행
			success=true;
			long end=System.currentTimeMillis();
			System.out.println("작업수행시간:"+(end-start)); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(success){
					System.out.println("커밋되었습니다.");
					conn.commit();
				}else{
					System.out.println("롤백되었습니다.");
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
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
	}
}






