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
	public PlaceVo getPlaceOneByNo(String placeNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		PlaceVo vo = dao.getPlaceOneByNo(conn, placeNo);
		//sql

		//close
		
		JDBCTemplate.close(conn);
			
		return vo;
	}
	public int deletePlace(String placeNo) throws Exception {
		//conn

		Connection conn = JDBCTemplate.getConnection();
		PlaceVo vo = new PlaceVo();
		int result = dao.deletePlace(conn, placeNo);
		
		
		
		
		//close
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	public int addPlace(PlaceVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		System.out.println(vo.getPlaceCategory());
		int result = dao.addPlace(conn , vo);
		
		//tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}
	public int editPlace(PlaceVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.editPlace(conn , vo);
		
		//tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

}
