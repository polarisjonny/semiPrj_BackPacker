package com.bp.app.admin.boardManage.service;

import java.sql.Connection;
import java.util.List;

import com.bp.app.admin.boardManage.dao.BoardManagerDao;
import com.bp.app.admin.boardManage.vo.AccompanyBoardVo;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;

public class BoardManagerService {
	private BoardManagerDao dao = new BoardManagerDao();
	public int getAccompanyBoardListCnt(String searchType, String searchValue) throws Exception {
		//conn
			Connection conn = JDBCTemplate.getConnection();
			
			int cnt = dao.getBoardListCnt(conn, searchType, searchValue);
			
			//close
			
			JDBCTemplate.close(conn);
			
			return cnt;
	}
	public List<AccompanyBoardVo> getAccompanyBoardList(PageVo pv) throws Exception {
		//conn
			Connection conn = JDBCTemplate.getConnection();
			List<AccompanyBoardVo>voList = dao.getAccompanyBoardList(conn, pv);
			//sql

			//close
			
			JDBCTemplate.close(conn);
			
			return voList;
	}
	public List<AccompanyBoardVo> getAccompanyBoardList(PageVo pv, String searchType, String searchValue) throws Exception {
		//conn
			Connection conn = JDBCTemplate.getConnection();
			
			List<AccompanyBoardVo>voList = dao.getAccompanyBoardList(conn, pv, searchType, searchValue);
			//sql

			//close
			
			JDBCTemplate.close(conn);
			
			return voList;
	}

}
