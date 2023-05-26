package com.bp.app.inquiry.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.inquiry.vo.QNABoardVo;

public class QNAService {

	public List<QNABoardVo> getTotalList() throws Exception {
		
		
		Connection conn = JDBCTemplate.getConnection();
		String sql="SELECT T.QNA_NO ,T.WRITER_NO ,T.QNA_CATEGORY_NO ,T.TITLE ,T.CONTENT ,T.ANSWER ,T.ENROLL_DATE ,T.DELETE_YN ,T.QNA_CATEGORY_NAME ,M.ID ,M.NAME ,M.NICK FROM ( SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,C.QNA_CATEGORY_NAME FROM QNA_BOARD Q JOIN QNA_CATEGORY C ON( Q.QNA_CATEGORY_NO = C.QNA_CATEGORY_NO) )T JOIN MEMBER M ON(T.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN='N' ORDER BY QNA_NO DESC";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<QNABoardVo> list = new ArrayList<>();
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
			
			QNABoardVo vo = new QNABoardVo();
			
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
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	public int qnaCnt(String qnaCategoryNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		String sql="SELECT COUNT(*)FROM QNA_BOARD WHERE QNA_CATEGORY_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,qnaCategoryNo );
		ResultSet rs = pstmt.executeQuery();
		int cnt=0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<QNABoardVo> qnaList(PageVo pv, String qnaCategoryNo) throws Exception {
	
		Connection conn = JDBCTemplate.getConnection();
		String sql="SELECT * FROM (SELECT  ROWNUM RNUM , T.* FROM ( SELECT Q.QNA_NO ,Q.WRITER_NO ,Q.QNA_CATEGORY_NO ,Q.TITLE ,Q.CONTENT ,Q.ANSWER ,Q.ENROLL_DATE ,Q.DELETE_YN ,C.QNA_CATEGORY_NAME ,M.ID ,M.NICK ,M.NAME FROM QNA_BOARD Q JOIN QNA_CATEGORY C ON (Q.QNA_CATEGORY_NO = C.QNA_CATEGORY_NO) JOIN MEMBER M ON(Q.WRITER_NO = M.MEMBER_NO) WHERE Q.DELETE_YN='N' AND Q.QNA_CATEGORY_NO = ? ORDER BY QNA_CATEGORY_NO DESC )T) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qnaCategoryNo);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<QNABoardVo>list=new ArrayList<>();
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
			
			QNABoardVo vo = new QNABoardVo();
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
		
		JDBCTemplate.close(conn);
		
		return list;
	}

}
