package com.bp.app.travelInformation.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.travelInformation.dao.TravelInformationDao;
import com.bp.app.travelReview.vo.TravelReviewVo;

public class TravelInformationService {

	private final TravelInformationDao dao = new TravelInformationDao();
	
	//페이지 개수
	public int selectCnt() throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	
	}

	//여행정보 게시판 조회
	public List<TravelReviewVo> selectList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<TravelReviewVo> tiList = dao.selectList(conn,pv);
			
		JDBCTemplate.close(conn);
			
		return tiList;
		
	}

	//여행정보 게시판 상세조회
	public TravelReviewVo selectOneByNo(String infoNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.increaseHit(conn , infoNo);
		if(result != 1) {
			JDBCTemplate.rollback(conn);
			throw new Exception("조회수 증가 쿼리문 실패");
		}
		TravelReviewVo vo = dao.selectOneByNo(conn,infoNo);
		
		JDBCTemplate.commit(conn);
		JDBCTemplate.close(conn);
		
		return vo;
	}

}
