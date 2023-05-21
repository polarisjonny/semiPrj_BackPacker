package com.bp.app.member.myPage.matchingMemberDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.member.vo.MemberVo;

public class MyPageMatchingMemberDao {
	

	public List<MemberVo> selectMatchingMemberList(Connection conn, String memberNo) throws Exception {

		String sql = "SELECT M.MEMBER_NO AS MEMBER_NO, M.NICK AS NICK, M.PROFILE_IMAGE AS PROFILE_IMAGE FROM MEMBER M JOIN CHATTING_ROOM C ON (M.MEMBER_NO = C.CHATTING_USER_NO OR M.MEMBER_NO = C.CHATTING_USER2_NO) WHERE (C.CHATTING_USER_NO = ? OR C.CHATTING_USER2_NO = ?) AND C.MATCHING_CHECK = 'Y' AND C.MATCHING_CHECK2 = 'Y' AND C.CHATTING_STATUS = 1 AND M.MEMBER_NO <> ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  memberNo);
		pstmt.setString(2,  memberNo);
		pstmt.setString(3,  memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<MemberVo> list = new ArrayList<>();
		//rs || tx
		while(rs.next()) {
			String no = rs.getString("MEMBER_NO");
			String nick = rs.getString("NICK");
			String profileImage = rs.getString("PROFILE_IMAGE");
			
			MemberVo vo = new MemberVo();
			vo.setMemberNo(no);
			vo.setNick(nick);
			vo.setProfileImage(profileImage);
			
			list.add(vo);
		}
		
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}

	public List<MemberVo> selectMatchingMemberListForPage(Connection conn, PageVo pv, String memberNo) throws Exception {
		String sql = "SELECT M.MEMBER_NO AS MEMBER_NO, M.NICK AS NICK, M.PROFILE_IMAGE AS PROFILE_IMAGE FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM CHATTING_ROOM WHERE (CHATTING_USER_NO = ? OR CHATTING_USER2_NO = ?) AND MATCHING_CHECK = 'Y' AND MATCHING_CHECK2 = 'Y' AND CHATTING_STATUS = 1 ORDER BY CHATTING_ROOM_NO DESC ) T ) C JOIN MEMBER M ON ( (M.MEMBER_NO = C.CHATTING_USER_NO OR M.MEMBER_NO = C.CHATTING_USER2_NO) AND M.MEMBER_NO <> ? ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2,  memberNo);
		pstmt.setString(3,  memberNo);
		int endRow = pv.getCurrentPage() * pv.getBoardLimit();
		int startRow = endRow - pv.getBoardLimit() + 1;
		pstmt.setInt(4, startRow);
		pstmt.setInt(5,  endRow);
		ResultSet rs = pstmt.executeQuery();
		
		List<MemberVo> list = new ArrayList<>();
		//rs || tx
		while(rs.next()) {
			String no = rs.getString("MEMBER_NO");
			String nick = rs.getString("NICK");
			String profileImage = rs.getString("PROFILE_IMAGE");
			
			MemberVo vo = new MemberVo();
			vo.setMemberNo(no);
			vo.setNick(nick);
			vo.setProfileImage(profileImage);
			
			list.add(vo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}
}
