package com.bp.app.chat.room.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.chat.room.vo.ChattingRoomVo;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.member.vo.MemberVo;

public class ChatDao {

	public int openNewChatRoom(Connection conn, ChattingRoomVo crv, String loginMemberNo) throws Exception {
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
		String sql = "SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO WHERE C.CHATTING_USER_NO = ? AND C.CHATTING_USER2_NO = ? AND C.GUIDE_BOARD_NO = ? AND NOT (C.MATCHING_CHECK = 'Y' AND C.MATCHING_CHECK2 = 'Y')  AND NOT (C.CHATTING_STATUS >10)";
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
			String chattingUserProfile = rs.getString("CHATTINGUSERPROFILE");
			String chattingUser2Profile = rs.getString("CHATTINGUSER2PROFILE");
			if (chattingUserProfile ==null || chattingUserProfile.equals("")) {
            	chattingUserProfile = "profile_default.jpg";
				
			}
            if(chattingUser2Profile ==null || chattingUser2Profile.equals("")) {
            	chattingUser2Profile = "profile_default.jpg";
				
			}
			vo.setChattingRoomNo(chattingRoomNo);
			vo.setChattingUserNo(chattingUserNo);
			vo.setChattingUser2No(chattingUser2No);
			vo.setGuideBoardNo(guideBoardNo);
			vo.setMatchingCheck(matchingCheck);
			vo.setMatchingCheck2(matchingCheck2);
			vo.setChattingStatus(chattingStatus);
			vo.setChattingUserNick(chattingUserNick);
			vo.setChattingUser2Nick(chattingUser2Nick);
			vo.setChattingUserProfile(chattingUserProfile);
			vo.setChattingUser2Profile(chattingUser2Profile);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return vo;
	}

	public ChattingRoomVo getOldChatRoom(Connection conn, ChattingRoomVo crv) throws Exception {
		String sql = "SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO WHERE C.CHATTING_USER_NO = ? AND C.CHATTING_USER2_NO = ? AND C.GUIDE_BOARD_NO = ? ";
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
			String chattingUserProfile = rs.getString("CHATTINGUSERPROFILE");
			String chattingUser2Profile = rs.getString("CHATTINGUSER2PROFILE");
			
			if (chattingUserProfile ==null || chattingUserProfile.equals("")) {
            	chattingUserProfile = "profile_default.jpg";
				
			}
            if(chattingUser2Profile ==null || chattingUser2Profile.equals("")) {
            	chattingUser2Profile = "profile_default.jpg";
				
			}
			vo.setChattingRoomNo(chattingRoomNo);
			vo.setChattingUserNo(chattingUserNo);
			vo.setChattingUser2No(chattingUser2No);
			vo.setGuideBoardNo(guideBoardNo);
			vo.setMatchingCheck(matchingCheck);
			vo.setMatchingCheck2(matchingCheck2);
			vo.setChattingStatus(chattingStatus);
			vo.setChattingUserNick(chattingUserNick);
			vo.setChattingUser2Nick(chattingUser2Nick);
			vo.setChattingUserProfile(chattingUserProfile);
			vo.setChattingUser2Profile(chattingUser2Profile);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return vo;
	}

	public int selectCnt1(Connection conn, String searchType, String searchValue, String no) throws Exception {
		String sql = "SELECT COUNT(*) FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE, B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE,  BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON  C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO  JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO ) S WHERE (S.CHATTING_USER2_NO =?  OR S.CHATTING_USER_NO=?) AND NOT ( S.MATCHING_CHECK = 'Y' AND S.MATCHING_CHECK2 = 'Y' ) AND S.CHATTING_STATUS < 11 AND (S.MATCHING_CHECK = 'N' OR S.MATCHING_CHECK2 = 'N')";

		if("CHATTINGUSERNICK".equals(searchType)){
			sql += " AND (" +searchType + " LIKE '%" + searchValue + "%' OR CHATTINGUSER2NICK LIKE '%"+ searchValue + "%')";
			
		}else if("BOARDTITLE".equals(searchType)) {
			sql += " AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("BOARDCATEGORYNAME".equals(searchType)) {
			sql += " AND " +searchType + " LIKE '%" + searchValue + "%'";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, no);
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
//	public int selectCnt2(Connection conn, String searchType, String searchValue, String no) throws Exception {
//		String sql = "SELECT COUNT(*) FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE, B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE,  BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON  C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO  JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO ) S WHERE (S.CHATTING_USER2_NO = ? OR S.CHATTING_USER_NO=?) AND NOT ( S.MATCHING_CHECK = 'Y' AND S.MATCHING_CHECK2 = 'Y' ) AND S.CHATTING_STATUS < 11 AND NOT S.MATCHING_CHECK2  = 'O'";
//
//		if("CHATTINGUSERNICK".equals(searchType)){
//			sql += " AND (" +searchType + " LIKE '%" + searchValue + "%' OR CHATTINGUSER2NICK LIKE '%"+ searchValue + "%')";
//			
//		}else if("BOARDTITLE".equals(searchType)) {
//			sql += " AND " +searchType + " LIKE '%" + searchValue + "%'";
//			
//		}else if("BOARDCATEGORYNAME".equals(searchType)) {
//			sql += " AND " +searchType + " LIKE '%" + searchValue + "%'";
//		}
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, no);
//		pstmt.setString(2, no);
//		ResultSet rs = pstmt.executeQuery();
//		
//		//tx||rs
//		int cnt = 0;
//		if(rs.next()) {
//			cnt = rs.getInt(1);
//		}
//		JDBCTemplate.close(rs);
//		JDBCTemplate.close(pstmt);
//		
//		return cnt;
//	}
	public List<ChattingRoomVo> openRoomList1(Connection conn, ChattingRoomVo crv, PageVo pv) throws Exception {
		 String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT S.CHATTING_ROOM_NO, S.CHATTING_USER_NO, S.CHATTING_USER2_NO, S.GUIDE_BOARD_NO, S.MATCHING_CHECK, S.MATCHING_CHECK2, S.CHATTING_STATUS, S.BOARDTITLE, S.CHATTINGUSERNICK, S.CHATTINGUSER2NICK, S.BOARDIMG, S.CHATTINGUSER2PROFILE, S.CHATTINGUSERPROFILE, S.BOARDCATEGORYNAME,S.CHATTINGUSERID, S.CHATTINGUSER2ID FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE, B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, M.ID AS CHATTINGUSERID, MT.ID AS CHATTINGUSER2ID,MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE, BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO ) S WHERE  NOT (S.CHATTING_STATUS >10) AND (CHATTING_USER_NO=? OR CHATTING_USER2_NO= ?) AND  NOT (MATCHING_CHECK = 'Y' AND MATCHING_CHECK2 = 'Y') ORDER BY CHATTING_ROOM_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, crv.getChattingUserNo());
         pstmt.setString(2, crv.getChattingUserNo());
         pstmt.setInt(3, pv.getBeginRow());
         pstmt.setInt(4, pv.getLastRow());
         ResultSet rs = pstmt.executeQuery();
         
         
         List<ChattingRoomVo> roomList = new ArrayList<>();
         while(rs.next()) {
            String chattingRoomNo = rs.getString("CHATTING_ROOM_NO");
            String chattingUserNo = rs.getString("CHATTING_USER_NO");
            String chattingUser2No = rs.getString("CHATTING_USER2_NO");
            String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
            String matchingCheck = rs.getString("MATCHING_CHECK");
            String matchingCheck2 = rs.getString("MATCHING_CHECK2");
            String chattingStatus = rs.getString("CHATTING_STATUS");
            String boardTitle = rs.getString("BOARDTITLE");
            String chattingUserNick = rs.getString("CHATTINGUSERNICK");
            String chattingUser2Nick = rs.getString("CHATTINGUSER2NICK");
            String chattingUserProfile = rs.getString("CHATTINGUSERPROFILE");
            String chattingUser2Profile = rs.getString("CHATTINGUSER2PROFILE");
            String chattingUserId = rs.getString("CHATTINGUSERID");
            String chattingUser2Id = rs.getString("CHATTINGUSER2ID");
            String boardCategoryName = rs.getString("BOARDCATEGORYNAME");
            ChattingRoomVo vo = new ChattingRoomVo();
            if (chattingUserProfile ==null || chattingUserProfile.equals("")) {
            	chattingUserProfile = "profile_default.jpg";
				
			}
            if(chattingUser2Profile ==null || chattingUser2Profile.equals("")) {
            	chattingUser2Profile = "profile_default.jpg";
				
			}
            
            vo.setChattingRoomNo(chattingRoomNo);
            vo.setChattingStatus(chattingStatus);
            vo.setChattingUser2Nick(chattingUser2Nick);
            vo.setChattingUser2No(chattingUser2No);
            vo.setChattingUserNick(chattingUserNick);
            vo.setChattingUserNo(chattingUserNo);
            vo.setGuideBoardNo(guideBoardNo);
            vo.setMatchingCheck(matchingCheck);
            vo.setMatchingCheck2(matchingCheck2);
            vo.setBoardTitle(boardTitle);
            vo.setChattingUserProfile(chattingUserProfile);
            vo.setChattingUser2Profile(chattingUser2Profile);
            vo.setBoardCategoryName(boardCategoryName);
            vo.setChattingUserId(chattingUserId);
            vo.setChattingUser2Id(chattingUser2Id);
            System.out.println("openRoomList1(Connection conn, ChattingRoomVo crv, PageVo pv)"+vo);
            roomList.add(vo);
         }
         
         JDBCTemplate.close(rs);
         JDBCTemplate.close(pstmt);
//         List<ChattingRoomVo> roomList3  = null;
//         roomList3 = openRoomList2(conn, crv, pv, roomList);
         return roomList;
         
         
	}
	
//	public List<ChattingRoomVo> openRoomList2(Connection conn, ChattingRoomVo crv, PageVo pv, List<ChattingRoomVo> roomList) throws Exception {
//		 String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT S.CHATTING_ROOM_NO, S.CHATTING_USER_NO, S.CHATTING_USER2_NO, S.GUIDE_BOARD_NO, S.MATCHING_CHECK, S.MATCHING_CHECK2, S.CHATTING_STATUS, S.BOARDTITLE, S.CHATTINGUSERNICK, S.CHATTINGUSER2NICK, S.BOARDIMG, S.CHATTINGUSER2PROFILE, S.CHATTINGUSERPROFILE, S.BOARDCATEGORYNAME,S.CHATTINGUSERID, S.CHATTINGUSER2ID FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE, B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, M.ID AS CHATTINGUSERID, MT.ID AS CHATTINGUSER2ID,MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE, BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO ) S WHERE CHATTING_USER2_NO = ?   AND NOT (S.CHATTING_STATUS >10)  ORDER BY CHATTING_ROOM_NO DESC ) T ) WHERE NOT (MATCHING_CHECK = 'Y' AND MATCHING_CHECK2 = 'Y') AND RNUM BETWEEN ? AND ?";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, crv.getChattingUserNo());
//        pstmt.setInt(2, pv.getBeginRow());
//        pstmt.setInt(3, pv.getLastRow());
//        ResultSet rs = pstmt.executeQuery();
//        
//        while(rs.next()) {
//           String chattingRoomNo = rs.getString("CHATTING_ROOM_NO");
//           String chattingUserNo = rs.getString("CHATTING_USER_NO");
//           String chattingUser2No = rs.getString("CHATTING_USER2_NO");
//           String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
//           String matchingCheck = rs.getString("MATCHING_CHECK");
//           String matchingCheck2 = rs.getString("MATCHING_CHECK2");
//           String chattingStatus = rs.getString("CHATTING_STATUS");
//           String boardTitle = rs.getString("BOARDTITLE");
//           String chattingUserNick = rs.getString("CHATTINGUSERNICK");
//           String chattingUser2Nick = rs.getString("CHATTINGUSER2NICK");
//           String chattingUserProfile = rs.getString("CHATTINGUSERPROFILE");
//           String chattingUser2Profile = rs.getString("CHATTINGUSER2PROFILE");
//           String chattingUserId = rs.getString("CHATTINGUSERID");
//           String chattingUser2Id = rs.getString("CHATTINGUSER2ID");
//           String boardCategoryName = rs.getString("BOARDCATEGORYNAME");
//           
//           ChattingRoomVo vo = new ChattingRoomVo();
//           if (chattingUserProfile ==null || chattingUserProfile.equals("")) {
//           	chattingUserProfile = "profile_default.jpg";
//				
//			}
//           if(chattingUser2Profile ==null || chattingUser2Profile.equals("")) {
//           	chattingUser2Profile = "profile_default.jpg";
//				
//			}
//           
//           vo.setChattingRoomNo(chattingRoomNo);
//           vo.setChattingStatus(chattingStatus);
//           vo.setChattingUser2Nick(chattingUser2Nick);
//           vo.setChattingUser2No(chattingUser2No);
//           vo.setChattingUserNick(chattingUserNick);
//           vo.setChattingUserNo(chattingUserNo);
//           vo.setGuideBoardNo(guideBoardNo);
//           vo.setMatchingCheck(matchingCheck);
//           vo.setMatchingCheck2(matchingCheck2);
//           vo.setBoardTitle(boardTitle);
//           vo.setChattingUserProfile(chattingUserProfile);
//           vo.setChattingUser2Profile(chattingUser2Profile);
//           vo.setBoardCategoryName(boardCategoryName);
//           vo.setChattingUserId(chattingUserId);
//           vo.setChattingUser2Id(chattingUser2Id);
//           roomList.add(vo);
//        }
//        
//        JDBCTemplate.close(rs);
//        JDBCTemplate.close(pstmt);
//        System.out.println(roomList);
//        return roomList;
//        
//        
//	}

	public List<ChattingRoomVo> openRoomList1(Connection conn, ChattingRoomVo crv, PageVo pv, String searchType, String searchValue) throws Exception {
		String sql = "";
	      
	      if("CHATTINGUSERNICK".equals(searchType)) {
	         //SQL (1번유저)
	         sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT S.CHATTING_ROOM_NO, S.CHATTING_USER_NO, S.CHATTING_USER2_NO, S.GUIDE_BOARD_NO, S.MATCHING_CHECK, S.MATCHING_CHECK2, S.CHATTING_STATUS, S.BOARDTITLE, S.CHATTINGUSERNICK, S.CHATTINGUSER2NICK ,S.BOARDIMG, S.CHATTINGUSER2PROFILE, S.CHATTINGUSERPROFILE, S.BOARDCATEGORYNAME, S.CHATTINGUSERID, S.CHATTINGUSER2ID  FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE,B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, M.ID AS CHATTINGUSERID, MT.ID AS CHATTINGUSER2ID, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE, BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO) S WHERE NOT (S.MATCHING_CHECK = 'Y' AND S.MATCHING_CHECK2 = 'Y')  AND NOT (S.CHATTING_STATUS >10) AND (CHATTING_USER_NO=? OR CHATTING_USER2_NO= ?) AND (CHATTINGUSERNICK LIKE '%'||?||'%' OR CHATTINGUSER2NICK LIKE '%'||?||'%')ORDER BY CHATTING_ROOM_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
	      }else if("BOARDTITLE".equals(searchType)) {
	         //SQL (게시판제목 검색)
	         sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT S.CHATTING_ROOM_NO, S.CHATTING_USER_NO, S.CHATTING_USER2_NO, S.GUIDE_BOARD_NO, S.MATCHING_CHECK, S.MATCHING_CHECK2, S.CHATTING_STATUS, S.BOARDTITLE, S.CHATTINGUSERNICK, S.CHATTINGUSER2NICK ,S.BOARDIMG, S.CHATTINGUSER2PROFILE, S.CHATTINGUSERPROFILE , S.BOARDCATEGORYNAME, S.CHATTINGUSERID, S.CHATTINGUSER2ID  FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE,B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, M.ID AS CHATTINGUSERID, MT.ID AS CHATTINGUSER2ID, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE, BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO) S WHERE  NOT (S.MATCHING_CHECK = 'Y' AND S.MATCHING_CHECK2 = 'Y')  AND NOT (S.CHATTING_STATUS >10) AND (CHATTING_USER_NO=? OR CHATTING_USER2_NO= ?) AND (BOARDTITLE LIKE '%'||?||'%' OR BOARDTITLE LIKE '%'||?||'%') ORDER BY CHATTING_ROOM_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
	      }else if("BOARDCATEGORYNAME".equals(searchType)) {
		     //SQL (게시판제목 타입)
		     sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT S.CHATTING_ROOM_NO, S.CHATTING_USER_NO, S.CHATTING_USER2_NO, S.GUIDE_BOARD_NO, S.MATCHING_CHECK, S.MATCHING_CHECK2, S.CHATTING_STATUS, S.BOARDTITLE, S.CHATTINGUSERNICK, S.CHATTINGUSER2NICK ,S.BOARDIMG, S.CHATTINGUSER2PROFILE, S.CHATTINGUSERPROFILE , S.BOARDCATEGORYNAME, S.CHATTINGUSERID, S.CHATTINGUSER2ID  FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE,B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, M.ID AS CHATTINGUSERID, MT.ID AS CHATTINGUSER2ID, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE, BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO) S WHERE NOT (S.MATCHING_CHECK = 'Y' AND S.MATCHING_CHECK2 = 'Y')  AND NOT (S.CHATTING_STATUS >10) AND (CHATTING_USER_NO=? OR CHATTING_USER2_NO= ?) AND  (BOARDCATEGORYNAME LIKE '%'||?||'%' OR  BOARDCATEGORYNAME LIKE '%'||?||'%' ) ORDER BY CHATTING_ROOM_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
	      } else {
	         //값이 이상함 => 기본 목록 조회
	         return openRoomList1(conn, crv, pv);
	      }
	      
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString   (1, crv.getChattingUserNo());
	      pstmt.setString   (2, crv.getChattingUserNo());
	      pstmt.setString   (3, searchValue);
	      pstmt.setString   (4, searchValue);
	      pstmt.setInt   (5, pv.getBeginRow());
	      pstmt.setInt   (6, pv.getLastRow());
	      ResultSet rs = pstmt.executeQuery();
	      
	      //tx || rs
	      List<ChattingRoomVo> roomList = new ArrayList<>();
	         while(rs.next()) {
	            String chattingRoomNo = rs.getString("CHATTING_ROOM_NO");
	            String chattingUserNo = rs.getString("CHATTING_USER_NO");
	            String chattingUser2No = rs.getString("CHATTING_USER2_NO");
	            String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
	            String matchingCheck = rs.getString("MATCHING_CHECK");
	            String matchingCheck2 = rs.getString("MATCHING_CHECK2");
	            String chattingStatus = rs.getString("CHATTING_STATUS");
	            String boardTitle = rs.getString("BOARDTITLE");
	            String chattingUserNick = rs.getString("CHATTINGUSERNICK");
	            String chattingUser2Nick = rs.getString("CHATTINGUSER2NICK");
	            String chattingUserProfile = rs.getString("CHATTINGUSERPROFILE");
	            String chattingUser2Profile = rs.getString("CHATTINGUSER2PROFILE");
	            String boardCategoryName = rs.getString("BOARDCATEGORYNAME");
	            String chattingUserId = rs.getString("CHATTINGUSERID");
	            String chattingUser2Id = rs.getString("CHATTINGUSER2ID");
	            
	          
	            
	            ChattingRoomVo vo = new ChattingRoomVo();
	            if (chattingUserProfile ==null || chattingUserProfile.equals("")) {
	            	chattingUserProfile = "profile_default.jpg";
					
				}
	            if(chattingUser2Profile ==null || chattingUser2Profile.equals("")) {
	            	chattingUser2Profile = "profile_default.jpg";
					
				}
	            vo.setChattingRoomNo(chattingRoomNo);
	            vo.setChattingStatus(chattingStatus);
	            vo.setChattingUser2Nick(chattingUser2Nick);
	            vo.setChattingUser2No(chattingUser2No);
	            vo.setChattingUserNick(chattingUserNick);
	            vo.setChattingUserNo(chattingUserNo);
	            vo.setGuideBoardNo(guideBoardNo);
	            vo.setMatchingCheck(matchingCheck);
	            vo.setMatchingCheck2(matchingCheck2);
	            vo.setBoardTitle(boardTitle);
	            vo.setChattingUserProfile(chattingUserProfile);
	            vo.setChattingUser2Profile(chattingUser2Profile);
	            vo.setBoardCategoryName(boardCategoryName);
	            vo.setChattingUserId(chattingUserId);
	            vo.setChattingUser2Id(chattingUser2Id);
	            System.out.println("openRoomList1(Connection conn, ChattingRoomVo crv, PageVo pv, String searchType, String searchValue)"+vo);
	            roomList.add(vo);
	         }
	         
	         JDBCTemplate.close(rs);
	         JDBCTemplate.close(pstmt);
//	         List<ChattingRoomVo> roomList3 = null;
//	         roomList3 = openRoomList2(conn, crv, pv, searchType,searchValue, roomList);
	         return roomList;
	         
	}
//	public List<ChattingRoomVo> openRoomList2(Connection conn, ChattingRoomVo crv, PageVo pv, String searchType, String searchValue,List<ChattingRoomVo> roomList) throws Exception {
//		String sql = "";
//	      
//	      if("CHATTINGUSERNICK".equals(searchType)) {
//	         //SQL (1번유저)
//	         sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT S.CHATTING_ROOM_NO, S.CHATTING_USER_NO, S.CHATTING_USER2_NO, S.GUIDE_BOARD_NO, S.MATCHING_CHECK, S.MATCHING_CHECK2, S.CHATTING_STATUS, S.BOARDTITLE, S.CHATTINGUSERNICK, S.CHATTINGUSER2NICK ,S.BOARDIMG, S.CHATTINGUSER2PROFILE, S.CHATTINGUSERPROFILE, S.BOARDCATEGORYNAME, S.CHATTINGUSERID, S.CHATTINGUSER2ID  FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE,B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, M.ID AS CHATTINGUSERID, MT.ID AS CHATTINGUSER2ID, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE, BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO) S WHERE CHATTING_USER2_NO = ? AND NOT (S.MATCHING_CHECK = 'Y' AND S.MATCHING_CHECK2 = 'Y')   AND NOT (S.CHATTING_STATUS >10) AND (CHATTINGUSERNICK LIKE '%'||?||'%' OR CHATTINGUSER2NICK LIKE '%'||?||'%')ORDER BY CHATTING_ROOM_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
//	      }else if("BOARDTITLE".equals(searchType)) {
//	         //SQL (게시판제목 검색)
//	         sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT S.CHATTING_ROOM_NO, S.CHATTING_USER_NO, S.CHATTING_USER2_NO, S.GUIDE_BOARD_NO, S.MATCHING_CHECK, S.MATCHING_CHECK2, S.CHATTING_STATUS, S.BOARDTITLE, S.CHATTINGUSERNICK, S.CHATTINGUSER2NICK ,S.BOARDIMG, S.CHATTINGUSER2PROFILE, S.CHATTINGUSERPROFILE , S.BOARDCATEGORYNAME, S.CHATTINGUSERID, S.CHATTINGUSER2ID  FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE,B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, M.ID AS CHATTINGUSERID, MT.ID AS CHATTINGUSER2ID, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE, BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO) S WHERE CHATTING_USER2_NO = ?  AND NOT (S.MATCHING_CHECK = 'Y' AND S.MATCHING_CHECK2 = 'Y')   AND NOT (S.CHATTING_STATUS >10)  AND  (BOARDTITLE LIKE '%'||?||'%' OR BOARDTITLE LIKE '%'||?||'%') ORDER BY CHATTING_ROOM_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
//	      }else if("BOARDCATEGORYNAME".equals(searchType)) {
//		     //SQL (게시판제목 타입)
//		     sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT S.CHATTING_ROOM_NO, S.CHATTING_USER_NO, S.CHATTING_USER2_NO, S.GUIDE_BOARD_NO, S.MATCHING_CHECK, S.MATCHING_CHECK2, S.CHATTING_STATUS, S.BOARDTITLE, S.CHATTINGUSERNICK, S.CHATTINGUSER2NICK ,S.BOARDIMG, S.CHATTINGUSER2PROFILE, S.CHATTINGUSERPROFILE , S.BOARDCATEGORYNAME, S.CHATTINGUSERID, S.CHATTINGUSER2ID  FROM ( SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, B.TITLE AS BOARDTITLE,B.MAIN_IMG AS BOARDIMG, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, M.ID AS CHATTINGUSERID, MT.ID AS CHATTINGUSER2ID, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE, BC.CATEGORY_NAME AS BOARDCATEGORYNAME FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO JOIN GUIDE_BOARD B ON C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO JOIN GUIDE_BOARD_CATEGORY BC ON B.GUIDE_BOARD_CATEGORY_NO = BC.CATEGORY_NO) S WHERE CHATTING_USER2_NO = ?  AND NOT (S.MATCHING_CHECK = 'Y' AND S.MATCHING_CHECK2 = 'Y')   AND NOT (S.CHATTING_STATUS >10)  AND  (BOARDCATEGORYNAME LIKE '%'||?||'%' OR  BOARDCATEGORYNAME LIKE '%'||?||'%' ) ORDER BY CHATTING_ROOM_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
//	      } else {
//	         //값이 이상함 => 기본 목록 조회
//	         return openRoomList1(conn, crv, pv);
//	      }
//	      
//	      PreparedStatement pstmt = conn.prepareStatement(sql);
//	      pstmt.setString   (1, crv.getChattingUserNo());
//	      pstmt.setString   (2, searchValue);
//	      pstmt.setString   (3, searchValue);
//	      pstmt.setInt   (4, pv.getBeginRow());
//	      pstmt.setInt   (5, pv.getLastRow());
//	      ResultSet rs = pstmt.executeQuery();
//	      
//	      //tx || rs
//	      
//	         while(rs.next()) {
//	            String chattingRoomNo = rs.getString("CHATTING_ROOM_NO");
//	            String chattingUserNo = rs.getString("CHATTING_USER_NO");
//	            String chattingUser2No = rs.getString("CHATTING_USER2_NO");
//	            String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
//	            String matchingCheck = rs.getString("MATCHING_CHECK");
//	            String matchingCheck2 = rs.getString("MATCHING_CHECK2");
//	            String chattingStatus = rs.getString("CHATTING_STATUS");
//	            String boardTitle = rs.getString("BOARDTITLE");
//	            String chattingUserNick = rs.getString("CHATTINGUSERNICK");
//	            String chattingUser2Nick = rs.getString("CHATTINGUSER2NICK");
//	            String chattingUserProfile = rs.getString("CHATTINGUSERPROFILE");
//	            String chattingUser2Profile = rs.getString("CHATTINGUSER2PROFILE");
//	            String boardCategoryName = rs.getString("BOARDCATEGORYNAME");
//	            String chattingUserId = rs.getString("CHATTINGUSERID");
//	            String chattingUser2Id = rs.getString("CHATTINGUSER2ID");
//	         
//	            ChattingRoomVo vo = new ChattingRoomVo();
//	            if (chattingUserProfile ==null || chattingUserProfile.equals("")) {
//	            	chattingUserProfile = "profile_default.jpg";
//					
//				}
//	            if(chattingUser2Profile ==null || chattingUser2Profile.equals("")) {
//	            	chattingUser2Profile = "profile_default.jpg";
//					
//				}
//	            vo.setChattingRoomNo(chattingRoomNo);
//	            vo.setChattingStatus(chattingStatus);
//	            vo.setChattingUser2Nick(chattingUser2Nick);
//	            vo.setChattingUser2No(chattingUser2No);
//	            vo.setChattingUserNick(chattingUserNick);
//	            vo.setChattingUserNo(chattingUserNo);
//	            vo.setGuideBoardNo(guideBoardNo);
//	            vo.setMatchingCheck(matchingCheck);
//	            vo.setMatchingCheck2(matchingCheck2);
//	            vo.setBoardTitle(boardTitle);
//	            vo.setChattingUserProfile(chattingUserProfile);
//	            vo.setChattingUser2Profile(chattingUser2Profile);
//	            vo.setBoardCategoryName(boardCategoryName);
//	            vo.setChattingUserId(chattingUserId);
//	            vo.setChattingUser2Id(chattingUser2Id);
//	            roomList.add(vo);
//	         }
//	         
//	         JDBCTemplate.close(rs);
//	         JDBCTemplate.close(pstmt);
//	         
//	         return roomList;
//	         
//	}

	public ChattingRoomVo getOldChatRoomByRoomNo(Connection conn, ChattingRoomVo crv) throws Exception {
		String sql = "SELECT C.CHATTING_ROOM_NO, C.CHATTING_USER_NO, C.CHATTING_USER2_NO, C.GUIDE_BOARD_NO, C.MATCHING_CHECK, C.MATCHING_CHECK2, C.CHATTING_STATUS, M.NICK AS CHATTINGUSERNICK, M.PROFILE_IMAGE AS CHATTINGUSERPROFILE, MT.NICK AS CHATTINGUSER2NICK, MT.PROFILE_IMAGE AS CHATTINGUSER2PROFILE FROM CHATTING_ROOM C JOIN MEMBER M ON C.CHATTING_USER_NO = M.MEMBER_NO JOIN MEMBER MT ON C.CHATTING_USER2_NO = MT.MEMBER_NO WHERE CHATTING_ROOM_NO=? AND NOT (C.MATCHING_CHECK = 'Y' AND C.MATCHING_CHECK2 = 'Y')  AND NOT (C.CHATTING_STATUS >10)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, crv.getChattingRoomNo());
		
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
			String chattingUserProfile = rs.getString("CHATTINGUSERPROFILE");
            String chattingUser2Profile = rs.getString("CHATTINGUSER2PROFILE");
            if (chattingUserProfile ==null || chattingUserProfile.equals("")) {
            	chattingUserProfile = "profile_default.jpg";
				
			}
            if(chattingUser2Profile ==null || chattingUser2Profile.equals("")) {
            	chattingUser2Profile = "profile_default.jpg";
				
			}	
			vo.setChattingRoomNo(chattingRoomNo);
			vo.setChattingUserNo(chattingUserNo);
			vo.setChattingUser2No(chattingUser2No);
			vo.setGuideBoardNo(guideBoardNo);
			vo.setMatchingCheck(matchingCheck);
			vo.setMatchingCheck2(matchingCheck2);
			vo.setChattingStatus(chattingStatus);
			vo.setChattingUserNick(chattingUserNick);
			vo.setChattingUser2Nick(chattingUser2Nick);
			vo.setChattingUserProfile(chattingUserProfile);
			vo.setChattingUser2Profile(chattingUser2Profile);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return vo;
	}

	public int outChatRoom(Connection conn, ChattingRoomVo vo) throws Exception {
		String sql = "UPDATE CHATTING_ROOM SET MATCHING_CHECK2 = 'O', CHATTING_STATUS = CHATTING_STATUS + 10 WHERE MATCHING_CHECK2 = 'N' AND CHATTING_ROOM_NO = ? AND CHATTING_USER2_NO = ?  AND NOT (CHATTING_STATUS >10)";

		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getChattingRoomNo());
		pstmt.setString(2, vo.getChattingUser2No());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int outMyBoardChatRoom(Connection conn, ChattingRoomVo vo) throws Exception {
		String sql = "UPDATE CHATTING_ROOM SET MATCHING_CHECK = 'O', CHATTING_STATUS = CHATTING_STATUS + 10 WHERE MATCHING_CHECK = 'N' AND CHATTING_ROOM_NO = ? AND CHATTING_USER_NO = ?  AND NOT (CHATTING_STATUS >10)";

		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getChattingRoomNo());
		pstmt.setString(2, vo.getChattingUserNo());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int submitMyBoardChatRoom(Connection conn, ChattingRoomVo vo) throws Exception {
		String sql = "UPDATE CHATTING_ROOM SET MATCHING_CHECK = 'Y' WHERE CHATTING_ROOM_NO = ?  AND MATCHING_CHECK = 'N' AND CHATTING_USER_NO = ? AND NOT (CHATTING_STATUS >10)";

		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getChattingRoomNo());
		pstmt.setString(2, vo.getChattingUserNo());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int submitChatRoom(Connection conn, ChattingRoomVo vo) throws Exception {
		String sql = "UPDATE CHATTING_ROOM SET MATCHING_CHECK2 = 'Y' WHERE CHATTING_ROOM_NO = ? AND MATCHING_CHECK2 = 'N' AND CHATTING_USER2_NO = ? AND NOT (CHATTING_STATUS >10)";

		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getChattingRoomNo());
		pstmt.setString(2, vo.getChattingUser2No());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int deleteCnt(Connection conn, ChattingRoomVo crv, String loginMemberNo) throws Exception {
		String sql = "UPDATE MESSAGE SET CHECK_YN = 'Y' WHERE CHATTING_ROOM_NO = ?  AND RECEIVER_NO = ? AND CHECK_YN ='N'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, crv.getChattingRoomNo());
		pstmt.setString(2, loginMemberNo);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}
}
