package com.bp.app.inquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.inquiry.vo.InquiryVo;

public class InquiryDao {

	//문의게시판 조회 초기화면
	public List<InquiryVo> getTotalList(Connection conn) throws Exception {
		
		String sql="SELECT T.QNA_NO ,T.WRITER_NO ,T.QNA_CATEGORY_NO ,T.TITLE ,T.CONTENT ,T.ANSWER ,T.ENROLL_DATE ,T.DELETE_YN ,T.QNA_CATEGORY_NAME ,M.ID ,M.NAME ,M.NICK FROM ( SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,C.QNA_CATEGORY_NAME FROM QNA_BOARD Q JOIN QNA_CATEGORY C ON( Q.QNA_CATEGORY_NO = C.QNA_CATEGORY_NO) )T JOIN MEMBER M ON(T.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN='N' ORDER BY QNA_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<InquiryVo> list = new ArrayList<>();
		while(rs.next()) {
			
			String qnaNo = rs.getString("QNA_NO");
			String writerNo = rs.getString("WRITER_NO");
			String qnaCategoryNo = rs.getString("QNA_CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String answer = rs.getString("ANSWER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			String qnaCategoryName = rs.getString("QNA_CATEGORY_NAME");
			String name = rs.getString("NAME");
			String nick = rs.getString("NICK");
			String id = rs.getString("ID");
			
			InquiryVo vo = new InquiryVo();
			
			vo.setQnaNo(qnaNo);
			vo.setWriterNo(writerNo);
			vo.setQnaCategoryNo(qnaCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setEnrollDate(enrollDate);
			vo.setDeleteYn(deleteYn);
			vo.setQnaCategoryName(qnaCategoryName);
			vo.setName(name);
			vo.setNick(nick);
			vo.setId(id);
			
			list.add(vo);
		}
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return list;
	}

	//문의게시판 공지사항 페이징
	public int boardCnt(Connection conn) throws Exception {

		String sql="SELECT COUNT(*) FROM QNA_BOARD WHERE QNA_CATEGORY_NO = 1 AND DELETE_YN='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		int cnt=0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
	
		return cnt;
	}//boardCnt
	
	//문의게시판 1:1문의 페이징
	public int qnaCnt(String qnaCategoryNo, Connection conn) throws Exception {

		String sql="SELECT COUNT(*)FROM QNA_BOARD WHERE QNA_CATEGORY_NO=? AND DELETE_YN='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,qnaCategoryNo );
		ResultSet rs = pstmt.executeQuery();
		int cnt=0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return cnt;
	}//qnaCnt
	
	//문의게시판 FAQ 페이징 
	public int FAQCnt(Connection conn) throws Exception {

		String sql="SELECT COUNT(*)FROM QNA_BOARD WHERE QNA_CATEGORY_NO = 2 AND DELETE_YN='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int cnt= 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return cnt;
	}
	
	//문의게시판 서비스문의 페이징
	public int ServiceCnt(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM QNA_BOARD WHERE QNA_CATEGORY_NO = 3 AND DELETE_YN ='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int cnt =0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return cnt;
	}

	//문의게시판에서 공지사항 더보기 조회
	public List<InquiryVo> boardList(Connection conn, PageVo pv) throws Exception {

		String sql="SELECT * FROM (SELECT  ROWNUM RNUM , T.* FROM ( SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,C.QNA_CATEGORY_NAME ,M.NICK FROM QNA_BOARD Q JOIN QNA_CATEGORY C ON (Q.QNA_CATEGORY_NO = C.QNA_CATEGORY_NO) JOIN MEMBER M ON(Q.WRITER_NO = M.MEMBER_NO) WHERE Q.DELETE_YN='N' AND Q.QNA_CATEGORY_NO = 1 ORDER BY ENROLL_DATE DESC )T) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		List<InquiryVo> list = new ArrayList<>();
		while(rs.next()) {
			String  qnaNo = rs.getString("QNA_NO");
			String  writerNo  = rs.getString("WRITER_NO");
			String  qnaCategoryNo= rs.getString("QNA_CATEGORY_NO");
			String  title = rs.getString("TITLE");
			String  content = rs.getString("CONTENT");
			String  answer = rs.getString("ANSWER");
			String  enrollDate = rs.getString("ENROLL_DATE");
			String  deleteYn = rs.getString("DELETE_YN");
			String  qnaCategoryName = rs.getString("QNA_CATEGORY_NAME");
			String  nick = rs.getString("NICK");
			
			InquiryVo vo = new InquiryVo();
			vo.setQnaNo(qnaNo);
			vo.setWriterNo(writerNo);
			vo.setQnaCategoryNo(qnaCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setEnrollDate(enrollDate);
			vo.setDeleteYn(deleteYn);
			vo.setQnaCategoryName(qnaCategoryName);
			vo.setNick(nick);
			
			
			list.add(vo);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return list;
	}

	//문의게시판에서 1:1문의 더보기 조회
	public List<InquiryVo> qnaList(PageVo pv, String qnaCategoryNo, Connection conn) throws Exception {

		String sql="SELECT * FROM (SELECT  ROWNUM RNUM , T.* FROM ( SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,C.QNA_CATEGORY_NAME ,M.ID ,M.NICK ,M.NAME FROM QNA_BOARD Q JOIN QNA_CATEGORY C ON (Q.QNA_CATEGORY_NO = C.QNA_CATEGORY_NO) JOIN MEMBER M ON(Q.WRITER_NO = M.MEMBER_NO) WHERE Q.DELETE_YN='N' AND Q.QNA_CATEGORY_NO = ? ORDER BY QNA_CATEGORY_NO DESC )T) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaCategoryNo);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<InquiryVo>list=new ArrayList<>();
		while(rs.next()) {
			String  qnaNo = rs.getString("QNA_NO");
			String writerNo  = rs.getString("WRITER_NO");
			qnaCategoryNo= rs.getString("QNA_CATEGORY_NO");
			String  title = rs.getString("TITLE");
			String  content = rs.getString("CONTENT");
			String  answer = rs.getString("ANSWER");
			String  enrollDate = rs.getString("ENROLL_DATE");
			String  deleteYn = rs.getString("DELETE_YN");
			String  qnaCategoryName = rs.getString("QNA_CATEGORY_NAME");
			String  id = rs.getString("ID");
			String  nick = rs.getString("NICK");
			String  name = rs.getString("NAME");
			
			InquiryVo vo = new InquiryVo();
			vo.setQnaNo(qnaNo);
			vo.setWriterNo(writerNo);
			vo.setQnaCategoryNo(qnaCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setEnrollDate(enrollDate);
			vo.setDeleteYn(deleteYn);
			vo.setQnaCategoryName(qnaCategoryName);
			vo.setId(id);
			vo.setNick(nick);
			vo.setName(name);
			
			
			list.add(vo);
			
		}
		
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			return list;
	}

	//문의게시판 FAQ 더보기 조회
	public List<InquiryVo> FAQList(Connection conn, PageVo pv) throws Exception {

		String sql="SELECT * FROM (SELECT  ROWNUM RNUM , T.* FROM ( SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,C.QNA_CATEGORY_NAME ,M.NICK FROM QNA_BOARD Q JOIN QNA_CATEGORY C ON (Q.QNA_CATEGORY_NO = C.QNA_CATEGORY_NO) JOIN MEMBER M ON(Q.WRITER_NO = M.MEMBER_NO) WHERE Q.DELETE_YN='N' AND Q.QNA_CATEGORY_NO = 2 ORDER BY ENROLL_DATE DESC )T) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<InquiryVo> list = new ArrayList<>();
		while(rs.next()) {
			String  qnaNo = rs.getString("QNA_NO");
			String  writerNo  = rs.getString("WRITER_NO");
			String  qnaCategoryNo= rs.getString("QNA_CATEGORY_NO");
			String  title = rs.getString("TITLE");
			String  content = rs.getString("CONTENT");
			String  answer = rs.getString("ANSWER");
			String  enrollDate = rs.getString("ENROLL_DATE");
			String  deleteYn = rs.getString("DELETE_YN");
			String  qnaCategoryName = rs.getString("QNA_CATEGORY_NAME");
			String  nick = rs.getString("NICK");
			
			InquiryVo vo = new InquiryVo();
			vo.setQnaNo(qnaNo);
			vo.setWriterNo(writerNo);
			vo.setQnaCategoryNo(qnaCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setEnrollDate(enrollDate);
			vo.setDeleteYn(deleteYn);
			vo.setQnaCategoryName(qnaCategoryName);
			vo.setNick(nick);
			
			
			list.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return list;
	}

	//문의게시판 서비스문의 더보기 조회
	public List<InquiryVo> ServiceList(PageVo pv, Connection conn) throws Exception {

		String sql="SELECT * FROM (SELECT  ROWNUM RNUM , T.* FROM ( SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,C.QNA_CATEGORY_NAME ,M.NICK FROM QNA_BOARD Q JOIN QNA_CATEGORY C ON (Q.QNA_CATEGORY_NO = C.QNA_CATEGORY_NO) JOIN MEMBER M ON(Q.WRITER_NO = M.MEMBER_NO) WHERE Q.DELETE_YN='N' AND Q.QNA_CATEGORY_NO = 3 ORDER BY ENROLL_DATE DESC )T) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		

		List<InquiryVo> list = new ArrayList<>();
		while(rs.next()) {
			String  qnaNo = rs.getString("QNA_NO");
			String  writerNo  = rs.getString("WRITER_NO");
			String  qnaCategoryNo= rs.getString("QNA_CATEGORY_NO");
			String  title = rs.getString("TITLE");
			String  content = rs.getString("CONTENT");
			String  answer = rs.getString("ANSWER");
			String  enrollDate = rs.getString("ENROLL_DATE");
			String  deleteYn = rs.getString("DELETE_YN");
			String  qnaCategoryName = rs.getString("QNA_CATEGORY_NAME");
			String  nick = rs.getString("NICK");
			
			InquiryVo vo = new InquiryVo();
			vo.setQnaNo(qnaNo);
			vo.setWriterNo(writerNo);
			vo.setQnaCategoryNo(qnaCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setEnrollDate(enrollDate);
			vo.setDeleteYn(deleteYn);
			vo.setQnaCategoryName(qnaCategoryName);
			vo.setNick(nick);
			
			
			list.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}

	//문의사항 작성하기
	public int write(Connection conn, InquiryVo vo, String categoryType) throws Exception {

		String sql = "";
		if(categoryType.equals("service")) {
			sql = "INSERT INTO QNA_BOARD(QNA_NO,WRITER_NO,QNA_CATEGORY_NO,TITLE,CONTENT) VALUES(SEQ_QNA_BOARD_NO.NEXTVAL , ? , 3 , ? , ?)";

		}else if(categoryType.equals("QNA")){
			sql="INSERT INTO QNA_BOARD(QNA_NO,WRITER_NO,QNA_CATEGORY_NO,TITLE,CONTENT) VALUES(SEQ_QNA_BOARD_NO.NEXTVAL , ? , 4 , ? , ?)";
		}else {
			return write(conn, vo, categoryType);
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getWriterNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//1:1 문의 상세조회
	public InquiryVo detail(Connection conn, String qnaNo) throws Exception {

		String sql ="SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,M.NICK FROM QNA_BOARD Q JOIN MEMBER M ON (Q.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND QNA_CATEGORY_NO =4 AND QNA_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaNo);
		ResultSet rs = pstmt.executeQuery();
		
		InquiryVo vo = null;
		while(rs.next()) {
			qnaNo = rs.getString("QNA_NO");
			String writerNo = rs.getString("WRITER_NO");
			String qnaCategoryNo = rs.getString("QNA_CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String answer = rs.getString("ANSWER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			String nick = rs.getString("NICK");
			
			vo = new InquiryVo();
			vo.setQnaNo(qnaNo);
			vo.setWriterNo(writerNo);
			vo.setQnaCategoryNo(qnaCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setEnrollDate(enrollDate);
			vo.setDeleteYn(deleteYn);
			vo.setNick(nick);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
	}

	//서비스 문의 상세 조회
	public InquiryVo serviceDetail(Connection conn, String qnaNo) throws Exception {

		String sql ="SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,M.NICK FROM QNA_BOARD Q JOIN MEMBER M ON (Q.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND QNA_CATEGORY_NO =3 AND QNA_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaNo);
		ResultSet rs = pstmt.executeQuery();
		
		InquiryVo vo = null;
		while(rs.next()) {
			qnaNo = rs.getString("QNA_NO");
			String writerNo = rs.getString("WRITER_NO");
			String qnaCategoryNo = rs.getString("QNA_CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String answer = rs.getString("ANSWER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			String nick = rs.getString("NICK");
			
			vo = new InquiryVo();
			vo.setQnaNo(qnaNo);
			vo.setWriterNo(writerNo);
			vo.setQnaCategoryNo(qnaCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setEnrollDate(enrollDate);
			vo.setDeleteYn(deleteYn);
			vo.setNick(nick);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
	}

	//FAQ상세 조회
	public InquiryVo FAQdetail(Connection conn, String qnaNo) throws Exception {

		String sql ="SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,M.NICK FROM QNA_BOARD Q JOIN MEMBER M ON (Q.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND QNA_CATEGORY_NO =2 AND QNA_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaNo);
		ResultSet rs = pstmt.executeQuery();
		
		InquiryVo vo = null;
		while(rs.next()) {
			qnaNo = rs.getString("QNA_NO");
			String writerNo = rs.getString("WRITER_NO");
			String qnaCategoryNo = rs.getString("QNA_CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String answer = rs.getString("ANSWER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			String nick = rs.getString("NICK");
			
			vo = new InquiryVo();
			vo.setQnaNo(qnaNo);
			vo.setWriterNo(writerNo);
			vo.setQnaCategoryNo(qnaCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setEnrollDate(enrollDate);
			vo.setDeleteYn(deleteYn);
			vo.setNick(nick);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
	}

	//공지사항 상세조회
	public InquiryVo BoardDetail(Connection conn, String qnaNo) throws Exception {

		String sql ="SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,M.NICK FROM QNA_BOARD Q JOIN MEMBER M ON (Q.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND QNA_CATEGORY_NO =1 AND QNA_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaNo);
		ResultSet rs = pstmt.executeQuery();
		
		InquiryVo vo = null;
		while(rs.next()) {
			qnaNo = rs.getString("QNA_NO");
			String writerNo = rs.getString("WRITER_NO");
			String qnaCategoryNo = rs.getString("QNA_CATEGORY_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String answer = rs.getString("ANSWER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			String nick = rs.getString("NICK");
			
			vo = new InquiryVo();
			vo.setQnaNo(qnaNo);
			vo.setWriterNo(writerNo);
			vo.setQnaCategoryNo(qnaCategoryNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setAnswer(answer);
			vo.setEnrollDate(enrollDate);
			vo.setDeleteYn(deleteYn);
			vo.setNick(nick);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
	
	}

	

	

	

	
}//class
