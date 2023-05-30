package com.bp.app.chat.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.chat.message.vo.MessageVo;
import com.bp.app.common.db.JDBCTemplate;

public class MessageDao {

	public int sendMessage(Connection conn, MessageVo vo) throws Exception {
		String sql = "INSERT INTO MESSAGE(MESSAGE_NO, SENDER_NO,RECEIVER_NO, CHATTING_ROOM_NO,CONTENT) VALUES(SEQ_MESSAGE_NO.NEXTVAL, ? ,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getSenderNo());
		pstmt.setString(2, vo.getReceiverNo());
		pstmt.setString(3, vo.getChattingRoomNo());
		pstmt.setString(4, vo.getContent());
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<MessageVo> selecMessageList(Connection conn, String chattingRoomNo) throws Exception {
		String sql = "SELECT MS.*,M.NICK AS SENDERNICK, M.PROFILE_IMAGE AS SENDERPROFILEIMAGE , CR.CHATTING_ROOM_NO, CR.CHATTING_USER_NO, CR.CHATTING_USER2_NO, CR.GUIDE_BOARD_NO, CR.MATCHING_CHECK, CR.MATCHING_CHECK2, CR.CHATTING_STATUS FROM MESSAGE MS JOIN CHATTING_ROOM CR ON(MS.CHATTING_ROOM_NO = CR.CHATTING_ROOM_NO) JOIN MEMBER M ON (M.MEMBER_NO = MS.SENDER_NO) WHERE CR.CHATTING_ROOM_NO = ? AND CR.CHATTING_STATUS < 3 ORDER BY MS.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, chattingRoomNo);
		ResultSet rs = pstmt.executeQuery();
		List<MessageVo> list = new ArrayList<>();
		while(rs.next()) {
			String messageNo = rs.getString("MESSAGE_NO");
			String senderNo = rs.getString("SENDER_NO");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String checkYn = rs.getString("CHECK_YN");
			String receiverNo = rs.getString("RECEIVER_NO");
			String senderNick = rs.getString("SENDERNICK");
			String senderProfileImage = rs.getString("SENDERPROFILEIMAGE");
			if(senderProfileImage== null || "".equals(senderProfileImage)) {
				senderProfileImage="profile_default.jpg";
			}
			System.out.println(senderProfileImage);
			MessageVo vo = new MessageVo();
			vo.setChattingRoomNo(chattingRoomNo);
			vo.setCheckYn(checkYn);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setMessageNo(messageNo);
			vo.setSenderNo(senderNo);
			vo.setSenderProfileImage(senderProfileImage);
			vo.setSenderNick(senderNick);
			vo.setReceiverNo(receiverNo);
			
			list.add(vo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}

	public int newMessageCnt(Connection conn, String receiverNo) throws Exception {
		String sql = "SELECT COUNT(*) FROM ( SELECT M.MESSAGE_NO, M.SENDER_NO, M.RECEIVER_NO, M.CHATTING_ROOM_NO, M.CONTENT, M.ENROLL_DATE, M.CHECK_YN, C.CHATTING_STATUS, C.MATCHING_CHECK, C.MATCHING_CHECK2 FROM MESSAGE M JOIN CHATTING_ROOM C ON M.CHATTING_ROOM_NO = C.CHATTING_ROOM_NO WHERE M.RECEIVER_NO = ? AND C.CHATTING_STATUS <3 AND  M.CHECK_YN = 'N' AND  NOT (C.MATCHING_CHECK = 'O' OR C.MATCHING_CHECK2 = 'O') AND NOT(C.MATCHING_CHECK = 'Y' AND C.MATCHING_CHECK2 = 'Y')  )  S";
	
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, receiverNo);
		ResultSet rs = pstmt.executeQuery();
		
		//tx||rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	public int newMessageCnt(Connection conn, String receiverNo, String chattingRoomNo) throws Exception {
String sql = "SELECT COUNT(*) FROM ( SELECT M.MESSAGE_NO, M.SENDER_NO, M.RECEIVER_NO, M.CHATTING_ROOM_NO, M.CONTENT, M.ENROLL_DATE, M.CHECK_YN, C.CHATTING_STATUS, C.MATCHING_CHECK, C.MATCHING_CHECK2 FROM MESSAGE M JOIN CHATTING_ROOM C ON M.CHATTING_ROOM_NO = C.CHATTING_ROOM_NO WHERE M.RECEIVER_NO = ? AND C.CHATTING_ROOM_NO=? AND C.CHATTING_STATUS < 3 AND M.CHECK_YN = 'N' AND  NOT (C.MATCHING_CHECK = 'O' OR C.MATCHING_CHECK2 = 'O')AND NOT(C.MATCHING_CHECK = 'Y' AND C.MATCHING_CHECK2 = 'Y') )  S";
	
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, receiverNo);
		pstmt.setString(2, chattingRoomNo);
		ResultSet rs = pstmt.executeQuery();
		
		//tx||rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

}
