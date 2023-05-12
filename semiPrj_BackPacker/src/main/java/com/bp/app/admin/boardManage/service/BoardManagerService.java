package com.bp.app.admin.boardManage.service;

import java.sql.Connection;
import java.util.List;

import com.bp.app.admin.boardManage.dao.BoardManagerDao;
import com.bp.app.admin.boardManage.vo.GuideBoardVo;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;

public class BoardManagerService {
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

}
