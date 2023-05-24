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
import com.bp.app.travelReview.vo.TravelReviewVo;

public class MyPageBoardService {

	public List<GuideBoardVo> selectGuideBoardList(String memberNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MyPageBoardDao mpbd = new MyPageBoardDao();
		List<GuideBoardVo> list = mpbd.selectGuideBoardList(conn, memberNo);
		
		//SQL
		
		JDBCTemplate.close(conn);
		
		//return
		return list;
		
	}

	public int selectCountAccompanyBoard(String writerNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		
		MyPageBoardDao mpbd = new MyPageBoardDao();
		int count = mpbd.selectCountAccompanyBoard(conn, writerNo);
		
		JDBCTemplate.close(conn);
		
		
		return count;
	}
	

	public List<GuideBoardVo> selectAccompanyBoardList(PageVo pv, String writerNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MyPageBoardDao dao = new MyPageBoardDao();
		List<GuideBoardVo> list = dao.selectAccompanyBoardList(conn, pv, writerNo);
		
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<TravelReviewVo> selectMyTravelReviewList(String memberNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		String sql = "SELECT * FROM INFO_BOARD WHERE WRITER_NO = ? AND DELETE_YN = 'N' AND INFO_CATEGORY_NO = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<TravelReviewVo> tList = new ArrayList<>();
		
		//tx || rs
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
			String reportCnt = rs.getString("REPORT_CNT");
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
			vo.setReportCnt(reportCnt);
			vo.setMainImg(mainImg);
			
			tList.add(vo);
		}
		
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		
		//return
		return tList;
	}
}
