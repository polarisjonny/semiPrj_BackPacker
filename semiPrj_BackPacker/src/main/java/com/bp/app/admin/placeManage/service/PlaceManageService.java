package com.bp.app.admin.placeManage.service;

import java.sql.Connection;
import java.util.List;

import com.bp.app.admin.boardManage.dao.BoardManageDao;
import com.bp.app.admin.placeManage.dao.PlaceManageDao;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.scheduler.vo.PlaceVo;

public class PlaceManageService {

	private PlaceManageDao dao = new PlaceManageDao();
	public int getPlaceListCnt(String searchType, String searchValue) throws Exception {
		//conn

		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.getPlaceListCnt(conn, searchType, searchValue);
		
		//close
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	public List<PlaceVo> getPlaceList(PageVo pv) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		List<PlaceVo>voList = dao.getPlaceList(conn, pv);
		//sql

		//close
		
		JDBCTemplate.close(conn);
		
		return voList;
	}
	public List<PlaceVo> getPlaceList(PageVo pv, String searchType, String searchValue) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<PlaceVo>voList = dao.getPlaceList(conn, pv, searchType, searchValue);
		//sql

		//close
		
		JDBCTemplate.close(conn);
			
		return voList;
	}

}
