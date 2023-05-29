package com.bp.app.inquiry.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.inquiry.dao.InquiryDao;
import com.bp.app.inquiry.vo.InquiryVo;

public class InquiryService {

	private final InquiryDao dao = new InquiryDao();

	//문의게시판 초기화면 보여주기
	public List<InquiryVo> getTotalList() throws Exception {
		
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<InquiryVo> list = dao.getTotalList(conn);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	//문의게시판 1:1문의 화면 페이징
	public int qnaCnt(String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.qnaCnt(conn , searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	// 문의게시판 1:1문의더보기 조회
	public List<InquiryVo> qnaList(PageVo pv) throws Exception {
	
		Connection conn = JDBCTemplate.getConnection();
		
		List<InquiryVo> list = dao.qnaList(pv,conn);
		
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//문의게시판 공지사항 페이징처리
	public int boardCnt(String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.boardCnt(conn, searchValue);
		
		JDBCTemplate.close(conn);
		return cnt;
		
	}

	//문의게시판 공지사항더보기 조회
	public List<InquiryVo> boardList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<InquiryVo> list = dao.boardList(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}//boardList

	//문의게시판 FAQ 페이징처리
	public int FAQCnt(String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.FAQCnt(conn , searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//문의게시판 FAQ더보기 조회
	public List<InquiryVo> FAQList(PageVo pv) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<InquiryVo> list = dao.FAQList(conn,pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//문의게시판 서비스문의 페이징
	public int ServiceCnt(String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.ServiceCnt(conn,searchValue);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//문의게시판 서비스문의더보기 조회
	public List<InquiryVo> ServiceList(PageVo pv) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<InquiryVo> list = dao.ServiceList(pv,conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//문의사항 작성하기
	public int write(InquiryVo vo, String categoryType) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.write(conn,vo,categoryType);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	//1:1 문의 상세조회
	public InquiryVo detail(String qnaNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		InquiryVo vo = dao.detail(conn,qnaNo);
		
		JDBCTemplate.close(conn);
		return vo;
	}

	//서비스 문의 상세 조회
	public InquiryVo serviceDetail(String qnaNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		InquiryVo vo = dao.serviceDetail(conn,qnaNo);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//FAQ 상세 조회
	public InquiryVo FAQdetail(String qnaNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		InquiryVo vo = dao.FAQdetail(conn,qnaNo);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//공지사항 상세 조회
	public InquiryVo BoardDetail(String qnaNo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		InquiryVo vo = dao.BoardDetail(conn,qnaNo);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//공지사항 검색조회
	public List<InquiryVo> boardList(PageVo pv, String searchType, String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<InquiryVo> list = dao.boardList(conn, pv , searchType , searchValue);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//FAQ 검색조회
	public List<InquiryVo> FAQList(PageVo pv, String searchType, String searchValue) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<InquiryVo> list = dao.FAQList(conn, pv , searchType , searchValue);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//1:1문의 검색 조회
	public List<InquiryVo> qnaList(PageVo pv,String searchType, String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<InquiryVo> list = dao.qnaList(conn, pv , searchType , searchValue);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}

	//서비스문의 검색 조회
	public List<InquiryVo> ServiceList(PageVo pv, String searchType, String searchValue) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<InquiryVo> list = dao.ServiceList(pv, conn , searchType,searchValue);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

}
