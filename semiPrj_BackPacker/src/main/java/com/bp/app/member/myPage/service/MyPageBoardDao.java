package com.bp.app.member.myPage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.vo.GuideBoardVo;

public class MyPageBoardDao {

	public List<GuideBoardVo> selectGuideBoardList(Connection conn, String memberNo) throws Exception {
		String sql = "SELECT WRITER_NO, GUIDE_BOARD_NO, CATEGORY_NAME, MAIN_IMG, SUBSTR(TITLE, 1, 5) AS TITLE, TO_CHAR(ENROLL_DATE, 'YY-MM-DD') AS ENROLL_DATE, HIT FROM GUIDE_BOARD G JOIN GUIDE_BOARD_CATEGORY C ON GUIDE_BOARD_CATEGORY_NO = CATEGORY_NO WHERE WRITER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		
		
		List<GuideBoardVo> list = new ArrayList<>();
		
		//tx || rs
		while(rs.next()) {
			String writerNo = rs.getString("WRITER_NO");
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String categoryName = rs.getString("CATEGORY_NAME");
			String mainImg = rs.getString("MAIN_IMG");
			String title = rs.getString("TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");
			String hit = rs.getString("HIT");
			
			GuideBoardVo vo = new GuideBoardVo();
			vo.setWriterNo(writerNo);
			vo.setGuideBoardNo(guideBoardNo);
			vo.setCategoryName(categoryName);
			vo.setMainImg(mainImg);
			vo.setTitle(title);
			vo.setEnrollDate(enrollDate);
			vo.setHit(hit);
			
			list.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}

	public int selectCountAccompanyBoard(Connection conn, String writerNo) throws Exception {
		String sql = "SELECT COUNT(*) FROM GUIDE_BOARD WHERE WRITER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, writerNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		int count = 0;
		
		
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return count;
	}

	public List<GuideBoardVo> selectAccompanyBoardList(Connection conn, PageVo pv, String writerNo) throws Exception {
		String sql = "SELECT G.GUIDE_BOARD_NO AS NO, C.CATEGORY_NAME AS CATEGORY_NAME, G.WRITER_NO AS WRITER_NO, G.TITLE AS TITLE, TO_CHAR(G.ENROLL_DATE, 'YY-MM-DD') AS ENROLL_DATE, G.HIT AS HIT, G.MAIN_IMG AS MAIN_IMG FROM (SELECT ROWNUM AS RNUM, T.* FROM (SELECT * FROM GUIDE_BOARD WHERE WRITER_NO = ? AND DELETE_YN = 'N' ORDER BY GUIDE_BOARD_NO DESC) T) G JOIN GUIDE_BOARD_CATEGORY C ON G.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int endRow = pv.getCurrentPage() * pv.getBoardLimit();
		int startRow = endRow - pv.getBoardLimit() + 1;
		pstmt.setString(1,  writerNo);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3,  endRow);
		ResultSet rs = pstmt.executeQuery();
		
		List<GuideBoardVo> list = new ArrayList<>();
		
		while(rs.next()) {
			String guideBoardNo = rs.getString("NO");
			String no = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");
			String hit = rs.getString("HIT");
			String mainImg = rs.getString("MAIN_IMG");
			String categoryName = rs.getString("CATEGORY_NAME");
			
			GuideBoardVo vo = new GuideBoardVo();
			vo.setGuideBoardNo(guideBoardNo);
			vo.setWriterNo(no);
			vo.setTitle(title);
			vo.setEnrollDate(enrollDate);
			vo.setHit(hit);
			vo.setMainImg(mainImg);
			vo.setCategoryName(categoryName);
			
			list.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}

}
