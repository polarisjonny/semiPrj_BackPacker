package com.bp.app.gboard.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.Jdbc41Bridge;

import com.bp.app.admin.boardManage.dao.BoardManageDao;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.dao.GuideBoardDao;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.gboard.vo.GuideReplyVo;
import com.bp.app.member.dao.MemberDao;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.report.vo.ReportVo;

public class GuideBoardService {
	private final GuideBoardDao dao;
	public GuideBoardService() {
		dao= new GuideBoardDao();
	}
	

	public int write(GuideBoardVo vo, MemberVo loginMember) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		int result1 =dao.insertScheduler(conn,vo,loginMember);
		int result2= dao.insertGuideBoard(conn,vo,loginMember);
		
		
		//tx
		int result =0;
		if(result1==1&&result2==1) {//셋다 1이면커밋 
			JDBCTemplate.commit(conn);
			result=1;
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//리스트(게시글넘버,제목,아이디,닉네임,연령,프사,성별,글쓴이,썸네일,시작날짜,끝날짜 조회)
	public List<GuideBoardVo> getList(int i, PageVo pvo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		GuideBoardDao dao = new GuideBoardDao();
		List<GuideBoardVo> voList = dao.getList(conn,i,pvo);
		
		JDBCTemplate.close(conn);
		
		return voList; 
	}

	//리스트(게시글넘버,제목,아이디,닉네임,연령,프사,성별,글쓴이,썸네일,시작날짜,끝날짜 조회) 검색해서 불러오기
	//동행게시판만해당됨 (검색 제목,작성자아이디,잗성자닉네임) 이대로 냅둬도 될듯 굳이 모든 항목을 가져오지 않아도 된다고 판단됨.
	public List<GuideBoardVo> getList(int i ,PageVo pvo,String searchType,String searchValue) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		GuideBoardDao dao = new GuideBoardDao();
		List<GuideBoardVo> bvoList =dao.getList(conn,i , pvo,searchType,searchValue);
		
		JDBCTemplate.close(conn);
		
		return bvoList; 
	}
	
	//페이징 게시글 개수세기 (게시판카테고리 매개변수)
	public int countCnt(int i, String searchType, String searchValue) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		GuideBoardDao dao = new GuideBoardDao();
		int listCnt = dao.countCnt(conn, i, searchType, searchValue);
		
		JDBCTemplate.close(conn);
		
		return listCnt;
	}

	//자기소개및 작성자정보 조회
	public MemberVo selectMemberByNo(GuideBoardVo bvo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberVo writerMember = dao.selectMemberByNo(conn,bvo);
		
		JDBCTemplate.close(conn);
		
		return writerMember;
	}

	//게시글 상세조회
	public GuideBoardVo selectOneByNo(GuideBoardVo bvo, String lmNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result=0;
		//작성자가 본 조회수는오르지 않는 코드
		if(lmNo.equals(bvo.getWriterNo())) {
			result=1;
		}else {
			result = dao.increaseHit(conn,bvo);			
		}
		GuideBoardVo selectedBvo =  dao.selectOneByNo(conn,bvo);
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return selectedBvo;
		
	}

	//댓글쓰기
	public int replyWrite(GuideReplyVo rvo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql = "INSERT INTO GUIDE_REPLY(GUIDE_REPLY_NO, WRITER_NO, GUIDE_BOARD_NO,CONTENT) VALUES(SEQ_GUIDE_REPLY_NO.NEXTVAL, ? ,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rvo.getWriterNo());
		pstmt.setString(2, rvo.getGuideBoardNo());
		pstmt.setString(3, rvo.getContent());
		int result = pstmt.executeUpdate();
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return result;
	}


	public List<GuideReplyVo> selectReplyList(String accomNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql = "SELECT GR.*,M.NICK, M.PROFILE_IMAGE FROM GUIDE_REPLY GR JOIN MEMBER M ON (M.MEMBER_NO = GR.WRITER_NO) WHERE GUIDE_BOARD_NO = ? AND DELETE_YN ='N' ORDER BY GR.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, accomNo);
		ResultSet rs = pstmt.executeQuery();
		
		//rx
		List<GuideReplyVo> list = new ArrayList<>();
		while(rs.next()) {
			String guideReplyNo = rs.getString("GUIDE_REPLY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			
			String nick = rs.getString("NICK");
			String profileImage = rs.getString("PROFILE_IMAGE");
			
			GuideReplyVo rvo = new GuideReplyVo();
			rvo.setGuideReplyNo(guideReplyNo);
			rvo.setWriterNo(writerNo);
			rvo.setGuideBoardNo(guideBoardNo);
			rvo.setContent(content);
			rvo.setEnrollDate(enrollDate);
			rvo.setDeleteYn(deleteYn);
			rvo.setNick(nick);
			rvo.setProfile(profileImage);
			
			list.add(rvo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		//close
		
		return list;
	}


	public int deleteReply(String replyNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//sql
		String sql = "UPDATE GUIDE_REPLY SET DELETE_YN = 'Y' WHERE GUIDE_REPLY_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, replyNo);
		int result = pstmt.executeUpdate();
		
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return result;
		
	}


	public int modify(GuideBoardVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		GuideBoardDao dao = new GuideBoardDao();
		int result = dao.modify(conn,vo);
		
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		
		JDBCTemplate.close(conn);
		
		return result;
	}


	public int report(ReportVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//Guide_Report테이블에 인서트
		GuideBoardDao dao = new GuideBoardDao();
		int result1=dao.insertReport(conn,vo);
		int result2=dao.reportCnt(conn,vo);
		//tx
		
		int result=0;
		if(result1==result2) {
			JDBCTemplate.commit(conn);
			result=1;
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		
		// TODO Auto-generated method stub
		return result;
	}


	public int delete(String no) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		GuideBoardDao dao = new GuideBoardDao();
		int result = dao.delete(conn,no);
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
