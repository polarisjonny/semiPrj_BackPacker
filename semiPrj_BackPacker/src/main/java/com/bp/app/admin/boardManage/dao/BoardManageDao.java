package com.bp.app.admin.boardManage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.admin.boardManage.vo.GuideReportVo;
import com.bp.app.admin.boardManage.vo.InfoBoardReportVo;
import com.bp.app.admin.boardManage.vo.QnaBoardVo;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.travelReview.vo.TravelReviewVo;

public class BoardManageDao {

	public int getGuideBoardListCnt(Connection conn, String searchType, String searchValue) throws Exception {
		String sql = "SELECT COUNT(*) FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT AS REPORTCNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.CATEGORY_NAME AS CATEGORY FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO JOIN GUIDE_BOARD_CATEGORY  C ON B.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO ) WHERE DELETE_YN = 'N'";

		if("title".equals(searchType)){
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerNick".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerId".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("category".equals(searchType)){
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

	public List<GuideBoardVo> getGuideBoardList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT *FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, C.CATEGORY_NAME AS CATEGORY, M.NICK AS WRITERNICK, M.ID AS WRITERID FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO JOIN GUIDE_BOARD_CATEGORY  C ON B.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO WHERE DELETE_YN = 'N' ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		
		List<GuideBoardVo> voList = new ArrayList<>();
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
			String categoryName = rs.getString("CATEGORY");
			GuideBoardVo vo = new GuideBoardVo();
		
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
			vo.setCategoryName(categoryName);
			
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	
	public List<GuideBoardVo> getGuideBoardList(Connection conn, PageVo pv, String searchType,String searchValue) throws Exception {
		
		String sql = "";
		
		if("title".equals(searchType)) {
			//sql(제목으로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.CATEGORY_NAME AS CATEGORY FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO JOIN GUIDE_BOARD_CATEGORY  C ON B.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO WHERE DELETE_YN = 'N' AND B.TITLE LIKE ('%'||?||'%') ORDER BY GUIDE_BOARD_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if("writerNick".equals(searchType)) {
			//sql(작성자로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.CATEGORY_NAME AS CATEGORY FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO JOIN GUIDE_BOARD_CATEGORY  C ON B.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO WHERE DELETE_YN = 'N' AND M.NICK LIKE ('%'||?||'%') ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			
		}else if ("writerId".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.CATEGORY_NAME AS CATEGORY FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO JOIN GUIDE_BOARD_CATEGORY  C ON B.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO WHERE DELETE_YN = 'N' AND M.ID LIKE ('%'||?||'%') ORDER BY GUIDE_BOARD_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if ("reportCnt".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.CATEGORY_NAME AS CATEGORY FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO JOIN GUIDE_BOARD_CATEGORY  C ON B.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO WHERE DELETE_YN = 'N' AND REPORT_CNT >= ? ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}else if ("category".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.GUIDE_BOARD_NO, B.WRITER_NO, B.GUIDE_BOARD_CATEGORY_NO, B.TITLE, B.CONTENT, B.ENROLL_DATE, B.MODIFY_DATE, B.HIT, B.MATCHING_STATE, B.TRAVEL_EXPENSE, B.DELETE_YN, B.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.CATEGORY_NAME AS CATEGORY FROM GUIDE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.MEMBER_NO JOIN GUIDE_BOARD_CATEGORY  C ON B.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO WHERE DELETE_YN = 'N' AND C.CATEGORY_NAME LIKE ('%'||?||'%') ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE  RNUM BETWEEN ? AND ?";
			
		}else {
			getGuideBoardList(conn, pv);
		}
		

		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		//rs
		List<GuideBoardVo> voList = new ArrayList<>();
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
			String categoryName = rs.getString("CATEGORY");
			
			GuideBoardVo vo = new GuideBoardVo();
			
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
			vo.setCategoryName(categoryName);
			
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	public int getReviewInfoBoardListCnt(Connection conn, String searchType, String searchValue) throws Exception {
		String sql = "SELECT COUNT(*) FROM ( SELECT I.INFO_NO, I.WRITER_NO, I.INFO_CATEGORY_NO, I.TITLE, I.CONTENT, I.ENROLL_DATE, I.MODIFY_DATE, I.HIT, I.DELETE_YN, I.REPORT_CNT AS REPORTCNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.INFO_CATEGORY_NAME AS CATEGORY FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO JOIN INFO_BOARD_CATEGORY  C ON I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO ) WHERE DELETE_YN = 'N'";

		if("title".equals(searchType)){
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerNick".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerId".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("category".equals(searchType)){
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

	public List<TravelReviewVo> getReviewInfoBoardList(Connection conn, PageVo pv) throws Exception {
		
		String sql = "SELECT *FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT I.INFO_NO, I.WRITER_NO, I.INFO_CATEGORY_NO, I.TITLE, I.CONTENT, I.ENROLL_DATE, I.MODIFY_DATE, I.HIT, I.DELETE_YN, I.REPORT_CNT, C.INFO_CATEGORY_NAME AS CATEGORY, M.NICK AS WRITERNICK, M.ID AS WRITERID FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO JOIN INFO_BOARD_CATEGORY C ON I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO WHERE DELETE_YN = 'N' ORDER BY INFO_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		
		List<TravelReviewVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String infoNo = rs.getString("INFO_NO");
			String writerNo = rs.getString("WRITER_NO");
			String infoCategoryNo = rs.getString("INFO_CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String deleteYn = rs.getString("DELETE_YN");
			String reportCnt = rs.getString("REPORT_CNT");
			String writerId = rs.getString("WRITERID");
			String writerNick =rs.getString("WRITERNICK");
			String categoryName = rs.getString("CATEGORY");
			TravelReviewVo vo = new TravelReviewVo();
		
			vo.setInfoNo(infoNo);
			vo.setWriterNo(writerNo);
			vo.setInfoCategoryNo(infoCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDeleteYn(deleteYn);
			vo.setReportCnt(reportCnt);
			vo.setWriterId(writerId);
			vo.setWriterNick(writerNick);
			vo.setCategoryName(categoryName);
			
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	public List<TravelReviewVo> getReviewInfoBoardList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {
		String sql = "";
		
		if("title".equals(searchType)) {
			//sql(제목으로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT I.INFO_NO, I.WRITER_NO, I.INFO_CATEGORY_NO, I.TITLE, I.CONTENT, I.ENROLL_DATE, I.MODIFY_DATE, I.HIT, I.DELETE_YN, I.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.INFO_CATEGORY_NAME AS CATEGORY FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO JOIN INFO_BOARD_CATEGORY  C ON I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO WHERE DELETE_YN = 'N' AND I.TITLE LIKE ('%'||?||'%') ORDER BY INFO_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if("writerNick".equals(searchType)) {
			//sql(작성자로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT I.INFO_NO, I.WRITER_NO, I.INFO_CATEGORY_NO, I.TITLE, I.CONTENT, I.ENROLL_DATE, I.MODIFY_DATE, I.HIT, I.DELETE_YN, I.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.INFO_CATEGORY_NAME AS CATEGORY FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO JOIN INFO_BOARD_CATEGORY  C ON I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO WHERE DELETE_YN = 'N' AND M.NICK LIKE ('%'||?||'%') ORDER BY INFO_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			
		}else if ("writerId".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT I.INFO_NO, I.WRITER_NO, I.INFO_CATEGORY_NO, I.TITLE, I.CONTENT, I.ENROLL_DATE, I.MODIFY_DATE, I.HIT, I.DELETE_YN, I.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.INFO_CATEGORY_NAME AS CATEGORY FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO JOIN INFO_BOARD_CATEGORY  C ON I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO WHERE DELETE_YN = 'N' AND M.ID LIKE ('%'||?||'%') ORDER BY INFO_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if ("reportCnt".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT I.INFO_NO, I.WRITER_NO, I.INFO_CATEGORY_NO, I.TITLE, I.CONTENT, I.ENROLL_DATE, I.MODIFY_DATE, I.HIT, I.DELETE_YN, I.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.INFO_CATEGORY_NAME AS CATEGORY FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO JOIN INFO_BOARD_CATEGORY  C ON I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO WHERE DELETE_YN = 'N' AND REPORT_CNT >= ? ORDER BY INFO_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		}else if ("category".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT I.INFO_NO, I.WRITER_NO, I.INFO_CATEGORY_NO, I.TITLE, I.CONTENT, I.ENROLL_DATE, I.MODIFY_DATE, I.HIT, I.DELETE_YN, I.REPORT_CNT, M.NICK AS WRITERNICK, M.ID AS WRITERID, C.INFO_CATEGORY_NAME AS CATEGORY FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO JOIN INFO_BOARD_CATEGORY  C ON I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO WHERE DELETE_YN = 'N' AND C.INFO_CATEGORY_NAME LIKE ('%'||?||'%') ORDER BY INFO_NO DESC ) T ) WHERE  RNUM BETWEEN ? AND ?";
			
		}else {
			getGuideBoardList(conn, pv);
		}
		

		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		//rs
		List<TravelReviewVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String infoNo = rs.getString("INFO_NO");
			String writerNo = rs.getString("WRITER_NO");
			String infoCategoryNo = rs.getString("INFO_CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String deleteYn = rs.getString("DELETE_YN");
			String reportCnt = rs.getString("REPORT_CNT");
			String writerId = rs.getString("WRITERID");
			String writerNick =rs.getString("WRITERNICK");
			String categoryName = rs.getString("CATEGORY");
			TravelReviewVo vo = new TravelReviewVo();
		
			vo.setInfoNo(infoNo);
			vo.setWriterNo(writerNo);
			vo.setInfoCategoryNo(infoCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDeleteYn(deleteYn);
			vo.setReportCnt(reportCnt);
			vo.setWriterId(writerId);
			vo.setWriterNick(writerNick);
			vo.setCategoryName(categoryName);
			
			voList.add(vo);
			
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	public int getGuideBoardReportDetailCnt(Connection conn, String searchType, String searchValue,String selectGuideBoardNo) throws Exception {
		String sql = "SELECT COUNT(*) FROM (SELECT R.REPORT_NO, R.MEMBER_NO, R.GUIDE_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM GUIDE_REPORT R JOIN GUIDE_BOARD B ON B.GUIDE_BOARD_NO = R.GUIDE_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO ) WHERE GUIDE_BOARD_NO = ?";

		if("content".equals(searchType)){
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerNick".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerId".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writetName".equals(searchType)){
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}
		
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, selectGuideBoardNo);
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

	public List<GuideReportVo> getGuideBoardReportDetail(Connection conn, PageVo pv, String selectGuideBoardNo) throws Exception {

		String sql = "SELECT *FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.GUIDE_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM GUIDE_REPORT R JOIN GUIDE_BOARD B ON B.GUIDE_BOARD_NO = R.GUIDE_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.GUIDE_BOARD_NO = ? ORDER BY R.REPORT_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, selectGuideBoardNo);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		
		List<GuideReportVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String reportNo = rs.getString("REPORT_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String reportContent= rs.getString("CONTENT");
			String writerId = rs.getString("WRITERID");
			String writerName = rs.getString("WRITERNAME");
			String writerNick = rs.getString("WRITERNICK");
			GuideReportVo vo = new GuideReportVo();
		
			vo.setReportNo(reportNo);
			vo.setMemberNo(memberNo);
			vo.setGuideBoardNo(guideBoardNo);
			vo.setReportContent(reportContent);
			vo.setWriterId(writerId);
			vo.setWriterName(writerName);
			vo.setWriterNick(writerNick);
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	public List<GuideReportVo> getGuideBoardReportDetail(Connection conn, PageVo pv, String searchType, String searchValue, String selectGuideBoardNo) throws Exception {
		String sql = "";
		if("content".equals(searchType)) {
			//sql(내용으로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.GUIDE_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM GUIDE_REPORT R JOIN GUIDE_BOARD B ON B.GUIDE_BOARD_NO = R.GUIDE_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.GUIDE_BOARD_NO = ? AND R.REPORT_CONTENT LIKE ('%'||?||'%') ORDER BY REPORT_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
		}else if("writerNick".equals(searchType)) {
			//sql(작성자로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.GUIDE_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM GUIDE_REPORT R JOIN GUIDE_BOARD B ON B.GUIDE_BOARD_NO = R.GUIDE_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.GUIDE_BOARD_NO = ? AND M.NICK LIKE ('%'||?||'%') ORDER BY REPORT_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if ("writerId".equals(searchType)) {
			//sql(작성자아이디검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.GUIDE_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM GUIDE_REPORT R JOIN GUIDE_BOARD B ON B.GUIDE_BOARD_NO = R.GUIDE_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.GUIDE_BOARD_NO = ? AND M.ID LIKE ('%'||?||'%') ORDER BY REPORT_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if ("writerName".equals(searchType)) {
			//sql(작성자 이름)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.GUIDE_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM GUIDE_REPORT R JOIN GUIDE_BOARD B ON B.GUIDE_BOARD_NO = R.GUIDE_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.GUIDE_BOARD_NO = ? AND M.NAME LIKE ('%'||?||'%') ORDER BY REPORT_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else {
			getGuideBoardReportDetail(conn, pv, selectGuideBoardNo);
		}
		

		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, selectGuideBoardNo);
		pstmt.setString(2, searchValue);
		pstmt.setInt(3, pv.getBeginRow());
		pstmt.setInt(4, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		//rs
		List<GuideReportVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String reportNo = rs.getString("REPORT_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String reportContent= rs.getString("CONTENT");
			String writerId = rs.getString("WRITERID");
			String writerName = rs.getString("WRITERNAME");
			String writerNick = rs.getString("WRITERNICK");
			GuideReportVo vo = new GuideReportVo();
		
			vo.setReportNo(reportNo);
			vo.setMemberNo(memberNo);
			vo.setGuideBoardNo(guideBoardNo);
			vo.setReportContent(reportContent);
			vo.setWriterId(writerId);
			vo.setWriterName(writerName);
			vo.setWriterNick(writerNick);
			
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
			
		
	}

	public int getReviewInfoBoardReportDetailCnt(Connection conn, String searchType, String searchValue, String selectReviewInfoBoardNo) throws Exception {
		String sql = "SELECT COUNT(*) FROM (SELECT B.INFO_NO, R.REPORT_NO, R.MEMBER_NO, R.INFO_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM INFO_BOARD_REPORT R JOIN INFO_BOARD B ON B.INFO_NO = R.INFO_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO ) WHERE INFO_NO = ?";

		if("content".equals(searchType)){
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerNick".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writerId".equals(searchType)) {
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("writetName".equals(searchType)){
			sql += "AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}
		
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, selectReviewInfoBoardNo);
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

	public List<InfoBoardReportVo> getReviewInfoBoardReportDetail(Connection conn, PageVo pv, String selectReviewInfoBoardNo) throws Exception {
		
		String sql = "SELECT *FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.INFO_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM INFO_BOARD_REPORT R JOIN INFO_BOARD B ON B.INFO_NO = R.INFO_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.INFO_NO = ? ORDER BY R.REPORT_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, selectReviewInfoBoardNo);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		
		List<InfoBoardReportVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String reportNo = rs.getString("REPORT_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String infoBoardNo = rs.getString("INFO_BOARD_NO");
			String reportContent= rs.getString("CONTENT");
			String writerId = rs.getString("WRITERID");
			String writerName = rs.getString("WRITERNAME");
			String writerNick = rs.getString("WRITERNICK");
			InfoBoardReportVo vo = new InfoBoardReportVo();
		
			vo.setReportNo(reportNo);
			vo.setMemberNo(memberNo);
			vo.setInfoBoardNo(infoBoardNo);
			vo.setReportContent(reportContent);
			vo.setWriterId(writerId);
			vo.setWriterName(writerName);
			vo.setWriterNick(writerNick);
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;

	}

	public List<InfoBoardReportVo> getReviewInfoBoardReportDetail(Connection conn, PageVo pv, String searchType, String searchValue, String selectReviewInfoBoardNo) throws Exception {
		String sql = "";
		if("content".equals(searchType)) {
			//sql(내용으로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.INFO_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM INFO_BOARD_REPORT R JOIN INFO_BOARD B ON B.INFO_NO = R.INFO_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.INFO_NO = ? AND R.REPORT_CONTENT LIKE ('%'||?||'%') ORDER BY REPORT_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
		}else if("writerNick".equals(searchType)) {
			//sql(작성자로검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.INFO_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM INFO_BOARD_REPORT R JOIN INFO_BOARD B ON B.INFO_NO = R.INFO_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.INFO_NO = ? AND M.NICK LIKE ('%'||?||'%') ORDER BY REPORT_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if ("writerId".equals(searchType)) {
			//sql(작성자아이디검색)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.INFO_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM INFO_BOARD_REPORT R JOIN INFO_BOARD B ON B.INFO_NO = R.INFO_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.INFO_NO = ? AND M.ID LIKE ('%'||?||'%') ORDER BY REPORT_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if ("writerName".equals(searchType)) {
			//sql(작성자 이름)
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT R.REPORT_NO, R.MEMBER_NO, R.INFO_BOARD_NO, R.REPORT_CONTENT AS CONTENT, M.ID AS WRITERID , M.NICK AS WRITERNICK, M.NAME AS WRITERNAME FROM INFO_BOARD_REPORT R JOIN INFO_BOARD B ON B.INFO_NO = R.INFO_BOARD_NO JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO WHERE B.INFO_NO = ? AND M.NAME LIKE ('%'||?||'%') ORDER BY REPORT_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else {
			getReviewInfoBoardReportDetail(conn, pv, selectReviewInfoBoardNo);
		}
		

		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, selectReviewInfoBoardNo);
		pstmt.setString(2, searchValue);
		pstmt.setInt(3, pv.getBeginRow());
		pstmt.setInt(4, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		//rs
		List<InfoBoardReportVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String reportNo = rs.getString("REPORT_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String infoBoardNo = rs.getString("INFO_BOARD_NO");
			String reportContent= rs.getString("CONTENT");
			String writerId = rs.getString("WRITERID");
			String writerName = rs.getString("WRITERNAME");
			String writerNick = rs.getString("WRITERNICK");
			InfoBoardReportVo vo = new InfoBoardReportVo();
		
			vo.setReportNo(reportNo);
			vo.setMemberNo(memberNo);
			vo.setInfoBoardNo(infoBoardNo);
			vo.setReportContent(reportContent);
			vo.setWriterId(writerId);
			vo.setWriterName(writerName);
			vo.setWriterNick(writerNick);
			
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	public int writeQnaBoard(Connection conn, QnaBoardVo qvo) throws Exception {
		String sql = "INSERT INTO QNA_BOARD (QNA_NO , WRITER_NO , QNA_CATEGORY_NO , TITLE , CONTENT) VALUES (SEQ_QNA_BOARD_NO.NEXTVAL ,?  , ? , ? , ?)"	;
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qvo.getWriterNo());
		pstmt.setString(2, qvo.getQnaCategoryNo());
		pstmt.setString(3, qvo.getTitle());
		pstmt.setString(4, qvo.getContent());
		
		int result = pstmt.executeUpdate();
		//tx||rs
		
		
		JDBCTemplate.close(pstmt);
		
		return result;
	
	}



}
