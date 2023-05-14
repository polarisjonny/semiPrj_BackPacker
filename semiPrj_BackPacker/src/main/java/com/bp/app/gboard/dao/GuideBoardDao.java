package com.bp.app.gboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.member.vo.MemberVo;

public class GuideBoardDao {

	public int insertScheduler(Connection conn, GuideBoardVo vo, MemberVo loginMember) throws Exception {
		String sql = "INSERT INTO SCHEDULER (SCHEDULER_NO, MEMBER_NO,START_DATE,END_DATE) VALUES (SEQ_SCHEDULER_NO.NEXTVAL,?,TO_DATE('"+vo.getStartDate()+"','YYYY-MM-DD'),TO_DATE('"+vo.getEndDate()+"','YYYY-MM-DD'))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		return result;
	}

	public int insertGuideBoard(Connection conn, GuideBoardVo vo, MemberVo loginMember) throws Exception {
		String sql = "INSERT INTO GUIDE_BOARD (GUIDE_BOARD_NO,WRITER_NO,GUIDE_BOARD_CATEGORY_NO, SCHEDULER_NO, TITLE,CONTENT) VALUES (SEQ_GUIDE_BOARD_NO.NEXTVAL,?,?,SEQ_SCHEDULER_NO.CURRVAL,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		pstmt.setString(2, vo.getGuideBoardCategoryNo());
		pstmt.setString(3, vo.getTitle());
		pstmt.setString(4, vo.getContent());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		
		return result;
	}

	public int insertGuideIMG(Connection conn, GuideBoardVo vo) throws Exception {
		String sql="INSERT INTO GUIDE_BOARD_IMG_LIST (GUIDE_BOARD_IMG_NO, GUIDE_BOARD_NO ,CHANGE_NAME) VALUES (SEQ_GUIDE_BOARD_IMG_NO.NEXTVAL, SEQ_GUIDE_BOARD_NO.CURRVAL,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getChangeName());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		return result;
	}

}
