package com.bp.app.admin.boardManage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.admin.boardManage.vo.AccompanyBoardVo;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;

public class BoardManagerDao {

	public int getBoardListCnt(Connection conn, String searchType, String searchValue) throws Exception {
		String sql = "SELECT COUNT(*) FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT AS REPORTCNT, M.NICK AS WRITERNICK, M.ID AS WRITERID FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN = 'N' AND GUIDE_BOARD_CATEGORY_NO = 1 ";

		if("title".equals(searchType)){
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerNick".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerId".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("reportCnt".equals(searchType)){
			sql += "AND " +searchType + " >= " + searchValue;
			
		}
		
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//tx||rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	public List<AccompanyBoardVo> getAccompanyBoardList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO WHERE DELETE_YN = 'N' ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE GUIDE_BOARD_CATEGORY_NO = 1 AND RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		
		List<AccompanyBoardVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String writerNo = rs.getString("WRITER_NO");
			String guideBoardCategoryNo = rs.getString("GUIDE_BOARD_CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String matchingState = rs.getString("MATCHING_STATE");
			String travelExpense = rs.getString("TRAVEL_EXPENSE");
			String deleteYn = rs.getString("DELETE_YN");
			String reportCnt = rs.getString("REPORT_CNT");
			String writerId = rs.getString("WRITERID");
			String writerNick =rs.getString("WRITERNICK");
			AccompanyBoardVo vo = new AccompanyBoardVo();
			
			vo.setGuideBoardNo(guideBoardNo);
			vo.setWriterNo(writerNo);
			vo.setGuideBoardCategoryNo(guideBoardCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setMatchingState(matchingState);
			vo.setTravelExpense(travelExpense);
			vo.setDeleteYn(deleteYn);
			vo.setReportCnt(reportCnt);
			vo.setWriterId(writerId);
			vo.setWriterNick(writerNick);
			
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	
	public List<AccompanyBoardVo> getAccompanyBoardList(Connection conn, PageVo pv, String searchType,String searchValue) throws Exception {
		
		String sql = "";
		
		if("title".equals(searchType)) {
			//sql(제목으로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO WHERE DELETE_YN = 'N' AND B.TITLE LIKE ('%'||?||'%') ORDER BY  GUIDE_BOARD_NO DESC ) T ) WHERE GUIDE_BOARD_CATEGORY_NO = 1 AND RNUM BETWEEN ? AND ?";
			
		}else if("writerNick".equals(searchType)) {
			//sql(작성자로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO WHERE DELETE_YN = 'N' AND M.NICK LIKE ('%'||?||'%') ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE GUIDE_BOARD_CATEGORY_NO = 1 AND  RNUM BETWEEN ? AND ?";
			
		}else if ("writerId".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO WHERE DELETE_YN = 'N' AND M.ID LIKE ('%'||?||'%') ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE GUIDE_BOARD_CATEGORY_NO = 1 AND  RNUM BETWEEN ? AND ?";
			
		}else if ("reportCnt".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO WHERE DELETE_YN = 'N' AND REPORT_CNT >= ? ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE GUIDE_BOARD_CATEGORY_NO = 1 AND  RNUM BETWEEN ? AND ?";
		}else {
			getAccompanyBoardList(conn, pv);
		}
		

		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		//rs
		List<AccompanyBoardVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String writerNo = rs.getString("WRITER_NO");
			String guideBoardCategoryNo = rs.getString("GUIDE_BOARD_CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String matchingState = rs.getString("MATCHING_STATE");
			String travelExpense = rs.getString("TRAVEL_EXPENSE");
			String deleteYn = rs.getString("DELETE_YN");
			String reportCnt = rs.getString("REPORT_CNT");
			String writerId = rs.getString("WRITERID");
			String writerNick =rs.getString("WRITERNICK");
			
			AccompanyBoardVo vo = new AccompanyBoardVo();
			
			vo.setGuideBoardNo(guideBoardNo);
			vo.setWriterNo(writerNo);
			vo.setGuideBoardCategoryNo(guideBoardCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setMatchingState(matchingState);
			vo.setTravelExpense(travelExpense);
			vo.setDeleteYn(deleteYn);
			vo.setReportCnt(reportCnt);
			vo.setWriterId(writerId);
			vo.setWriterNick(writerNick);
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

}
