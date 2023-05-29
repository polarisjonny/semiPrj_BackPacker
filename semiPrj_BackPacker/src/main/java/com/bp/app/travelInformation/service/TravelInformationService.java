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
	public int selectCnt(String searchType, String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt(conn , searchType , searchValue);
		
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

	//여행정보 제목으로 검색
	public List<TravelReviewVo> selectList(PageVo pv, String searchType, String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<TravelReviewVo> tilist = dao.selectList(conn, pv, searchType , searchValue);
		
		JDBCTemplate.close(conn);
		
		return tilist;
	}

	//여행정보 게시글 삭제
	public int del(String infoNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.del(conn , infoNo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
		
	
	}

	//인기순으로 보기 페이징
	public int cnt(String searchType, String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.cnt(conn , searchType , searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
		
	
	}

	//인기순으로 보기 게시글 조회
	public List<TravelReviewVo> TopHitList(PageVo pv) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<TravelReviewVo> list = dao.TopHitList(conn,pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	
	}

	//인기순으로 보기 제목 검색 조회
	public List<TravelReviewVo> TopHitList(PageVo pv, String searchType, String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<TravelReviewVo> list = dao.TopHitList(conn, pv , searchType , searchValue);
	
		JDBCTemplate.close(conn);
		
		return list;
		
	}

}
