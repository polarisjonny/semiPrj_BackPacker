package com.bp.app.admin.boardManage.service;

import java.sql.Connection;
import java.util.List;

import com.bp.app.admin.boardManage.dao.BoardManagerDao;
import com.bp.app.admin.boardManage.vo.GuideBoardVo;
import com.bp.app.admin.boardManage.vo.GuideReportVo;
import com.bp.app.admin.boardManage.vo.InfoBoardVo;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;

public class BoardManageService {
	private BoardManagerDao dao = new BoardManagerDao();
	public int getGuideBoardListCnt(String searchType, String searchValue) throws Exception {
		
		//conn
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getGuideBoardListCnt(conn, searchType, searchValue);
		
		//close
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	public List<GuideBoardVo> getGuideBoardList(PageVo pv) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		List<GuideBoardVo>voList = dao.getGuideBoardList(conn, pv);
		//sql

		//close
		
		JDBCTemplate.close(conn);
		
		return voList;
	}
	public List<GuideBoardVo> getGuideBoardList(PageVo pv, String searchType, String searchValue) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<GuideBoardVo>voList = dao.getGuideBoardList(conn, pv, searchType, searchValue);
		//sql

		//close
		
		JDBCTemplate.close(conn);
			
		return voList;
	}
	public int getReviewInfoBoardListCnt(String searchType, String searchValue) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getReviewInfoBoardListCnt(conn, searchType, searchValue);
		
		//close
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	public List<InfoBoardVo> getReviewInfoBoardList(PageVo pv) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		List<InfoBoardVo>voList = dao.getReviewInfoBoardList(conn, pv);
		//sql

		//close
		
		JDBCTemplate.close(conn);
		
		return voList;
	}
	public List<InfoBoardVo> getReviewInfoBoardList(PageVo pv, String searchType, String searchValue) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<InfoBoardVo>voList = dao.getReviewInfoBoardList(conn, pv, searchType, searchValue);
		//sql

		//close
		
		JDBCTemplate.close(conn);
		
		return voList;
	}
	public int getGuideBoardReportDetailCnt(String searchType, String searchValue, String selectGuideBoardNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getGuideBoardReportDetailCnt(conn, searchType, searchValue ,selectGuideBoardNo);
		
		//close
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	public List<GuideReportVo> getGuideBoardReportDetail(PageVo pv, String selectGuideBoardNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		List<GuideReportVo>voList = dao.getGuideBoardReportDetail(conn, pv,selectGuideBoardNo);
		//sql

		//close
		
		JDBCTemplate.close(conn);
		
		return voList;
		
	}
	public List<GuideReportVo> getGuideBoardReportDetail(PageVo pv, String searchType, String searchValue, String selectGuideBoardNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<GuideReportVo>voList = dao.getGuideBoardReportDetail(conn, pv, searchType, searchValue, selectGuideBoardNo);
		//sql

		//close
		
		JDBCTemplate.close(conn);
		
		return voList;
	}
	

}
