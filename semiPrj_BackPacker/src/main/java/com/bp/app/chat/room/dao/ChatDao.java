package com.bp.app.chat.room.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bp.app.chat.room.vo.ChattingRoomVo;
import com.bp.app.common.db.JDBCTemplate;

public class ChatDao {

	public int openNewChatRoom(Connection conn, ChattingRoomVo crv) throws Exception {
		String sql = "INSERT INTO CHATTING_ROOM( CHATTING_ROOM_NO, CHATTING_USER_NO, CHATTING_USER2_NO, GUIDE_BOARD_NO ) VALUES(SEQ_CHATTING_ROOM_NO.NEXTVAL ,? ,? ,?) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, crv.getChattingUserNo());
		pstmt.setString(2, crv.getChattingUser2No());
		pstmt.setString(3, crv.getGuideBoardNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	public ChattingRoomVo getNewChatRoom(Connection conn, ChattingRoomVo crv) throws Exception {
		String sql = "SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, M.NICK AS CHATTINGUSERNICK, MT.NICK AS CHATTINGUSER2NICK FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO WHERE C.CHATTING_USER_NO = ? AND C.CHATTING_USER2_NO = ? AND C.GUIDE_BOARD_NO = ? AND NOT (C.MATCHING_CHECK = 'Y' AND C.MATCHING_CHECK2 = 'Y')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, crv.getChattingUserNo());
		pstmt.setString(2, crv.getChattingUser2No());
		pstmt.setString(3, crv.getGuideBoardNo());
		ResultSet rs = pstmt.executeQuery();
		ChattingRoomVo vo = new ChattingRoomVo();
		while(rs.next()) {
			String chattingRoomNo = rs.getString("CHATTING_ROOM_NO");
			String chattingUserNo = rs.getString("CHATTING_USER_NO");
			String chattingUser2No = rs.getString("CHATTING_USER2_NO");
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String matchingCheck = rs.getString("MATCHING_CHECK");
			String matchingCheck2 = rs.getString("MATCHING_CHECK2");
			String chattingStatus = rs.getString("CHATTING_STATUS");
			String chattingUserNick = rs.getString("CHATTINGUSERNICK");
			String chattingUser2Nick = rs.getString("CHATTINGUSER2NICK");
			
			vo.setChattingRoomNo(chattingRoomNo);
			vo.setChattingUserNo(chattingUserNo);
			vo.setChattingUser2No(chattingUser2No);
			vo.setGuideBoardNo(guideBoardNo);
			vo.setMatchingCheck(matchingCheck);
			vo.setMatchingCheck2(matchingCheck2);
			vo.setChattingStatus(chattingStatus);
			vo.setChattingUserNick(chattingUserNick);
			vo.setChattingUser2Nick(chattingUser2Nick);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return vo;
	}

	public ChattingRoomVo getOldChatRoom(Connection conn, ChattingRoomVo crv) throws Exception {
		String sql = "SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, M.NICK AS CHATTINGUSERNICK, MT.NICK AS CHATTINGUSER2NICK FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO WHERE C.CHATTING_USER_NO = ? AND C.CHATTING_USER2_NO = ? AND C.GUIDE_BOARD_NO = ? AND NOT (C.MATCHING_CHECK = 'Y' AND C.MATCHING_CHECK2 = 'Y')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, crv.getChattingUserNo());
		pstmt.setString(2, crv.getChattingUser2No());
		pstmt.setString(3, crv.getGuideBoardNo());
		ResultSet rs = pstmt.executeQuery();
		ChattingRoomVo vo = new ChattingRoomVo();
		while(rs.next()) {
			String chattingRoomNo = rs.getString("CHATTING_ROOM_NO");
			String chattingUserNo = rs.getString("CHATTING_USER_NO");
			String chattingUser2No = rs.getString("CHATTING_USER2_NO");
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String matchingCheck = rs.getString("MATCHING_CHECK");
			String matchingCheck2 = rs.getString("MATCHING_CHECK2");
			String chattingStatus = rs.getString("CHATTING_STATUS");
			String chattingUserNick = rs.getString("CHATTINGUSERNICK");
			String chattingUser2Nick = rs.getString("CHATTINGUSER2NICK");
			
			vo.setChattingRoomNo(chattingRoomNo);
			vo.setChattingUserNo(chattingUserNo);
			vo.setChattingUser2No(chattingUser2No);
			vo.setGuideBoardNo(guideBoardNo);
			vo.setMatchingCheck(matchingCheck);
			vo.setMatchingCheck2(matchingCheck2);
			vo.setChattingStatus(chattingStatus);
			vo.setChattingUserNick(chattingUserNick);
			vo.setChattingUser2Nick(chattingUser2Nick);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return vo;
	}

}
