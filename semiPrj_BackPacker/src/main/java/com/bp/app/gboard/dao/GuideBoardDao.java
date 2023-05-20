package com.bp.app.gboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.member.vo.MemberVo;

public class GuideBoardDao {
	//스케쥴러인서트
	public int insertScheduler(Connection conn, GuideBoardVo vo, MemberVo loginMember) throws Exception {
		String sql = "INSERT INTO SCHEDULER (SCHEDULER_NO, MEMBER_NO,START_DATE,END_DATE) VALUES (SEQ_SCHEDULER_NO.NEXTVAL,?,TO_DATE('"+vo.getStartDate()+"','YYYY-MM-DD'),TO_DATE('"+vo.getEndDate()+"','YYYY-MM-DD'))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		return result;
	}
	
	//가이드 보드에 인서트
	public int insertGuideBoard(Connection conn, GuideBoardVo vo, MemberVo loginMember) throws Exception {
		String sql = "INSERT INTO GUIDE_BOARD (GUIDE_BOARD_NO,WRITER_NO,GUIDE_BOARD_CATEGORY_NO, SCHEDULER_NO, TITLE,CONTENT,MAIN_IMG) VALUES (SEQ_GUIDE_BOARD_NO.NEXTVAL,?,?,SEQ_SCHEDULER_NO.CURRVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		pstmt.setString(2, vo.getGuideBoardCategoryNo());
		pstmt.setString(3, vo.getTitle());
		pstmt.setString(4, vo.getContent());
		pstmt.setString(5, vo.getMainImg());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		
		return result;
	}

	
	//작성자 정보 가져오기
	public MemberVo selectMemberByNo(Connection conn, GuideBoardVo bvo) throws Exception {
		//sql
		String sql = "SELECT NICK,ID,PROFILE_IMAGE,INTRO_MESSAGE FROM MEMBER WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bvo.getWriterNo());
		ResultSet rs =  pstmt.executeQuery();
		
		//rs
		MemberVo writerMember = null;
		if(rs.next()) {
			String nick = rs.getString("NICK");
			String id = rs.getString("ID");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String introMessage = rs.getString("INTRO_MESSAGE");
			
			writerMember = new MemberVo();
			writerMember.setMemberNo(bvo.getWriterNo());
			writerMember.setNick(nick);;
			writerMember.setId(id);
			writerMember.setProfileImage(profileImage);
			writerMember.setIntroMessage(introMessage);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return writerMember;
	}
	//게시글한개가져오기
	public GuideBoardVo selectOneByNo(Connection conn, GuideBoardVo bvo) throws Exception {
		//sql
		String sql ="SELECT TITLE,CONTENT,ENROLL_DATE,MODIFY_DATE,HIT,MATCHING_STATE,SCHEDULER_NO, MAIN_IMG FROM GUIDE_BOARD WHERE GUIDE_BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bvo.getGuideBoardNo());
		ResultSet rs = pstmt.executeQuery();
				
		//rs
		GuideBoardVo selectedBvo = null; 
		if(rs.next()) {
			String title =rs.getString("TITLE");
			String content =rs.getString("CONTENT");
			String enrollDate =rs.getString("ENROLL_DATE");
			String modifyDate =rs.getString("MODIFY_DATE");
			String hit =rs.getString("HIT");
			String matchingState =rs.getString("MATCHING_STATE");
			String schedulerNo =rs.getString("SCHEDULER_NO");
			String mainImg = rs.getString("MAIN_IMG");
			
			selectedBvo = new GuideBoardVo();
			selectedBvo.setTitle(title);
			selectedBvo.setContent(content);	
			selectedBvo.setEnrollDate(enrollDate);
			selectedBvo.setModifyDate(modifyDate);
			selectedBvo.setHit(hit);
			selectedBvo.setMatchingState(matchingState);
			selectedBvo.setSchedulerNo(schedulerNo);
			selectedBvo.setGuideBoardNo(bvo.getGuideBoardNo());
			selectedBvo.setMainImg(mainImg);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return selectedBvo;
	}

}
