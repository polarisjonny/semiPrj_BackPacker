package com.bp.app.travelInformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.travelReview.vo.TravelReviewVo;

public class TravelInformationDao {

	//페이징 처리
	public int selectCnt(Connection conn, String searchType, String searchValue) throws Exception {

		//sql
		String sql ="SELECT COUNT(*) FROM INFO_BOARD WHERE DELETE_YN = 'N' AND INFO_CATEGORY_NO = 2 AND TITLE LIKE '%'||?||'%'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		ResultSet rs = pstmt.executeQuery();
		
		//tx | rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	//여행정보 게시판 조회
	public List<TravelReviewVo> selectList(Connection conn, PageVo pv) throws Exception {

		String sql="SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG ,M.NICK AS NICK FROM INFO_BOARD I JOIN MEMBER M ON M.MEMBER_NO = I.WRITER_NO WHERE DELETE_YN ='N' AND INFO_CATEGORY_NO = 2 ORDER BY INFO_NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<TravelReviewVo> tiList = new ArrayList<>();
		while(rs.next()) {
			String infoNo = rs.getString("INFO_NO");
			String infoCategoryNo = rs.getString("INFO_CATEGORY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String deleteYn = rs.getString("DELETE_YN");
			String writerNick = rs.getString("NICK");
			String mainImg = rs.getString("MAIN_IMG");
			
			
			TravelReviewVo vo = new TravelReviewVo();
			vo.setInfoNo(infoNo);
			vo.setInfoCategoryNo(infoCategoryNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDeleteYn(deleteYn);
			vo.setWriterNick(writerNick);
			vo.setMainImg(mainImg);
			
			tiList.add(vo);
		}
		
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		
			return tiList;
	}//selectList

	//여행정보 게시판 상세조회
	public TravelReviewVo selectOneByNo(Connection conn, String infoNo) throws Exception {

		String sql="SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT ,I.MAIN_IMG ,M.PROFILE_IMAGE , M.NICK , M.ID FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO WHERE I.INFO_NO= ? AND I.INFO_CATEGORY_NO = 2 AND DELETE_YN='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, infoNo);
		ResultSet rs = pstmt.executeQuery();
		
		TravelReviewVo vo = new TravelReviewVo();
		if(rs.next()) {
			String infoCategoryNo = rs.getString("INFO_CATEGORY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String deleteYn = rs.getString("DELETE_YN");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String writerNick = rs.getString("NICK");
			String writerId = rs.getString("ID");
			String mainImg = rs.getString("MAIN_IMG");
			
			vo.setInfoNo(infoNo);
			vo.setInfoCategoryNo(infoCategoryNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDeleteYn(deleteYn);
			vo.setProfileImage(profileImage);
			vo.setWriterNick(writerNick);
			vo.setWriterId(writerId);
			vo.setChangeName(mainImg);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	//여행 정보 게시판 조회수 증가
	public int increaseHit(Connection conn, String infoNo) throws Exception {

		String sql="UPDATE INFO_BOARD SET HIT = HIT+1 WHERE INFO_NO = ? AND DELETE_YN ='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, infoNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

	//여행정보 제목으로 검색
	public List<TravelReviewVo> selectList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {

		String sql ="";
		
		if(searchType.equals("title")) {
			sql ="SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG ,C.INFO_CATEGORY_NAME , M.NICK FROM INFO_BOARD I JOIN INFO_BOARD_CATEGORY C ON (I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO) JOIN MEMBER M ON (I.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND I.TITLE LIKE '%'||?||'%' AND I.INFO_CATEGORY_NO = 2 ORDER BY INFO_NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		}else {
			return selectList(conn,pv);
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<TravelReviewVo> tiList = new ArrayList<>();
		while(rs.next()) {
			String infoNo = rs.getString("INFO_NO");
			String infoCategoryNo = rs.getString("INFO_CATEGORY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String deleteYn = rs.getString("DELETE_YN");
			String writerNick = rs.getString("NICK");
			String mainImg = rs.getString("MAIN_IMG");
			String infoCategoryName = rs.getString("INFO_CATEGORY_NAME");
			
			
			TravelReviewVo vo = new TravelReviewVo();
			vo.setInfoNo(infoNo);
			vo.setInfoCategoryNo(infoCategoryNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDeleteYn(deleteYn);
			vo.setWriterNick(writerNick);
			vo.setMainImg(mainImg);
			vo.setInfoCategoryName(infoCategoryName);
			
			tiList.add(vo);
		}
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return tiList;
	}

	//여행정보 게시글 삭제
	public int del(Connection conn, String infoNo) throws Exception {

		String sql = "UPDATE INFO_BOARD SET DELETE_YN = 'Y' WHERE INFO_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, infoNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//인기순으로 보기 페이징
	public int cnt(Connection conn, String searchType, String searchValue) throws Exception {

		String sql="SELECT COUNT(*) FROM INFO_BOARD WHERE DELETE_YN = 'N' AND INFO_CATEGORY_NO = 2 AND TITLE LIKE '%'||?||'%'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		
		return cnt;
		
	}

	//인기순으로 보기 게시글 조회
	public List<TravelReviewVo> TopHitList(Connection conn, PageVo pv) throws Exception {

		String sql="SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG ,M.NICK AS NICK FROM INFO_BOARD I JOIN MEMBER M ON M.MEMBER_NO = I.WRITER_NO WHERE DELETE_YN ='N' AND INFO_CATEGORY_NO = 2 ORDER BY HIT DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<TravelReviewVo> list = new ArrayList<>();
		while(rs.next()) {
			String infoNo = rs.getString("INFO_NO");
			String infoCategoryNo = rs.getString("INFO_CATEGORY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String deleteYn = rs.getString("DELETE_YN");
			String writerNick = rs.getString("NICK");
			String mainImg = rs.getString("MAIN_IMG");
			
			
			TravelReviewVo vo = new TravelReviewVo();
			vo.setInfoNo(infoNo);
			vo.setInfoCategoryNo(infoCategoryNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDeleteYn(deleteYn);
			vo.setWriterNick(writerNick);
			vo.setMainImg(mainImg);
			
			list.add(vo);
		}
		
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		
			return list;
		
	}

	//인기순으로 보고 제목으로 검색 조회
	public List<TravelReviewVo> TopHitList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {

		String sql ="";
		
		if(searchType.equals("title")) {
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG ,C.INFO_CATEGORY_NAME , M.NICK FROM INFO_BOARD I JOIN INFO_BOARD_CATEGORY C ON (I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO) JOIN MEMBER M ON (I.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND I.TITLE LIKE '%'||?||'%' AND I.INFO_CATEGORY_NO = 2 ORDER BY HIT DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<TravelReviewVo> list = new ArrayList<>();
		while(rs.next()) {
			String infoNo = rs.getString("INFO_NO");
			String infoCategoryNo = rs.getString("INFO_CATEGORY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String deleteYn = rs.getString("DELETE_YN");
			String writerNick = rs.getString("NICK");
			String mainImg = rs.getString("MAIN_IMG");
			String infoCategoryName = rs.getString("INFO_CATEGORY_NAME");
			
			
			TravelReviewVo vo = new TravelReviewVo();
			vo.setInfoNo(infoNo);
			vo.setInfoCategoryNo(infoCategoryNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDeleteYn(deleteYn);
			vo.setWriterNick(writerNick);
			vo.setMainImg(mainImg);
			vo.setInfoCategoryName(infoCategoryName);
			
			list.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;	
	}

}
