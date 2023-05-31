package com.bp.app.memberReview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import com.bp.app.chat.room.vo.ChattingRoomVo;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.memberReview.vo.MemberReviewVo;

public class MemberReviewDao {

   public List<ChattingRoomVo> checkCanWriteReview(Connection conn, String loginMemberNo, String selectMemberNo) throws Exception {
      String sql = "SELECT CHATTING_ROOM_NO, CHATTING_USER_NO, CHATTING_USER2_NO, C.GUIDE_BOARD_NO, MATCHING_CHECK, MATCHING_CHECK2, CHATTING_STATUS ,M1.NICK AS NICK1,M2.NICK AS NICK2 , B.TITLE AS TITLE FROM CHATTING_ROOM C JOIN MEMBER M1 ON C.CHATTING_USER_NO = M1.MEMBER_NO JOIN MEMBER M2 ON C.CHATTING_USER2_NO = M2.MEMBER_NO JOIN GUIDE_BOARD B ON C.GUIDE_BOARD_NO = B.GUIDE_BOARD_NO WHERE ((CHATTING_USER_NO = ? AND CHATTING_USER2_NO = ?) OR (CHATTING_USER_NO = ? AND CHATTING_USER2_NO = ?))AND MATCHING_CHECK = 'Y' AND MATCHING_CHECK2='Y'";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, loginMemberNo);
      pstmt.setString(2, selectMemberNo);
      pstmt.setString(3, selectMemberNo);
      pstmt.setString(4, loginMemberNo);
      ResultSet rs = pstmt.executeQuery();
      
      //tx || rs
      List<ChattingRoomVo> crvList= new ArrayList<>();
      
      
      while(rs.next()) {
         String chattingRoomNo = rs.getString("CHATTING_ROOM_NO");
         String chattingUserNo = rs.getString("CHATTING_USER_NO");
         String chattingUser2No = rs.getString("CHATTING_USER2_NO");
         String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
         String matchingCheck = rs.getString("MATCHING_CHECK");
         String matchingCheck2 = rs.getString("MATCHING_CHECK2");
         String chattingStatus = rs.getString("CHATTING_STATUS");
         String chattingUserNick = rs.getString("NICK1");
         String chattingUser2Nick = rs.getString("NICK2");
         String guideBoardTitle = rs.getString("TITLE");
         
         ChattingRoomVo vo = null;
         
         
         vo = new ChattingRoomVo();
         
         vo.setChattingRoomNo(chattingRoomNo);
         vo.setChattingUserNo(chattingUserNo);
         vo.setChattingUser2No(chattingUser2No);
         vo.setGuideBoardNo(guideBoardNo);
         vo.setMatchingCheck(matchingCheck);
         vo.setMatchingCheck2(matchingCheck2);
         vo.setChattingStatus(chattingStatus);
         vo.setChattingUserNick(chattingUserNick);
         vo.setChattingUser2Nick(chattingUser2Nick);
         vo.setGuideBoardTitle(guideBoardTitle);
         
         crvList.add(vo);
      }
      
      //close
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      return crvList;
   }

   public int writeReview(Connection conn, MemberReviewVo mrv) throws Exception {
      
      //SQL
      String sql = "INSERT INTO MEMBER_REVIEW( NO, GIVER_NO, MEMBER_NO, CHATTING_ROOM_NO, CONTENT, SCORE) VALUES(SEQ_MEMBER_REVIEW_NO.NEXTVAL , ?, ?, ?, ?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      pstmt.setString(1, mrv.getGiverNo());
      pstmt.setString(2,mrv.getMemberNo());
      pstmt.setString(3,mrv.getChattingRoomNo());
      pstmt.setString(4,mrv.getContent());
      pstmt.setString(5, mrv.getScore());
      int result = pstmt.executeUpdate();
      JDBCTemplate.close(pstmt);
      return result;
   }
   
   public int plusScore(Connection conn, MemberReviewVo mrv, String originScore) throws Exception {
		
		String sql = "UPDATE MEMBER SET MEMBER_SCORE = ? WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int Score = Integer.parseInt(mrv.getScore());
		int mScore = Integer.parseInt(originScore);
		int plusScore = Score*10 + mScore;
		String pScore = Integer.toString(plusScore);
		pstmt.setString(1, pScore);
		pstmt.setString(2, mrv.getMemberNo());
		
		int result = pstmt.executeUpdate();
	     JDBCTemplate.close(pstmt);
	     return result;
		
	}
   
   public MemberVo selectMemberGetScore(Connection conn, String memberNo) throws Exception {
			
	   String sql = "SELECT * FROM MEMBER WHERE MEMBER_NO =?";
	   PreparedStatement pstmt = conn.prepareStatement(sql);
	   pstmt.setString(1, memberNo);
	   ResultSet rs = pstmt.executeQuery();
	   MemberVo vo = null;
	   
	   if(rs.next()) {
	         
	         
	         String mNo = rs.getString("MEMBER_NO");
	         String isGuide = rs.getString("IS_GUIDE");
	         String memberStatus = rs.getString("MEMBER_STATUS");
	         String id = rs.getString("ID");
	         String password = rs.getString("PASSWORD");
	         String name = rs.getString("NAME");
	         String gender = rs.getString("GENDER");
	         String age = rs.getString("AGE");
	         String address = rs.getString("ADDRESS");
	         String email = rs.getString("EMAIL");
	         String phoneNumber = rs.getString("PHONE_NUMBER");
	         String nick = rs.getString("NICK");
	         String profileImage = rs.getString("PROFILE_IMAGE");
	         String idCard = rs.getString("ID_CARD");
	         String enrollDate = rs.getString("ENROLL_DATE");
	         String introMessage = rs.getString("INTRO_MESSAGE");
	         String memberScore = rs.getString("MEMBER_SCORE");
	         
	         
	         
	         vo = new MemberVo();
	         
	         vo.setMemberNo(mNo);
	         vo.setIsGuide(isGuide);
	         vo.setMemberStatus(memberStatus);
	         vo.setId(id);
	         vo.setPassword(password);
	         vo.setName(name);
	         vo.setGender(gender);
	         vo.setAge(age);
	         vo.setAddress(address);
	         vo.setEmail(email);
	         vo.setPhoneNumber(phoneNumber);
	         vo.setNick(nick);
	         vo.setProfileImage(profileImage);
	         vo.setIdCard(idCard);
	         vo.setEnrollDate(enrollDate);
	         vo.setIntroMessage(introMessage);
	         vo.setMemberScore(memberScore);
	         
	      }
	      
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      
	      return vo;
	}


   public MemberVo selectMemberToProfile(Connection conn, String selectMemberNo) throws Exception {
      String sql = "SELECT MEMBER_NO, IS_GUIDE, MEMBER_STATUS, ID, PASSWORD, NAME, GENDER, AGE, ADDRESS, EMAIL, PHONE_NUMBER, NICK, PROFILE_IMAGE, ID_CARD, ENROLL_DATE, INTRO_MESSAGE, MEMBER_SCORE FROM MEMBER WHERE MEMBER_NO = ?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, selectMemberNo);
      ResultSet rs = pstmt.executeQuery();
      
      //tx || rs
      MemberVo vo = null;
      if(rs.next()) {
         
         
         String memberNo = rs.getString("MEMBER_NO");
         String isGuide = rs.getString("IS_GUIDE");
         String memberStatus = rs.getString("MEMBER_STATUS");
         String id = rs.getString("ID");
         String password = rs.getString("PASSWORD");
         String name = rs.getString("NAME");
         String gender = rs.getString("GENDER");
         String age = rs.getString("AGE");
         String address = rs.getString("ADDRESS");
         String email = rs.getString("EMAIL");
         String phoneNumber = rs.getString("PHONE_NUMBER");
         String nick = rs.getString("NICK");
         String profileImage = rs.getString("PROFILE_IMAGE");
         String idCard = rs.getString("ID_CARD");
         String enrollDate = rs.getString("ENROLL_DATE");
         String introMessage = rs.getString("INTRO_MESSAGE");
         String memberScore = rs.getString("MEMBER_SCORE");
         
         
         
         vo = new MemberVo();
         
         vo.setMemberNo(memberNo);
         vo.setIsGuide(isGuide);
         vo.setMemberStatus(memberStatus);
         vo.setId(id);
         vo.setPassword(password);
         vo.setName(name);
         vo.setGender(gender);
         vo.setAge(age);
         vo.setAddress(address);
         vo.setEmail(email);
         vo.setPhoneNumber(phoneNumber);
         vo.setNick(nick);
         vo.setProfileImage(profileImage);
         vo.setIdCard(idCard);
         vo.setEnrollDate(enrollDate);
         vo.setIntroMessage(introMessage);
         vo.setMemberScore(memberScore);
         
      }
      
      //close
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return vo;
   }

   public List<MemberReviewVo> selectMemberReviewDetail(Connection conn, String selectMemberNo, PageVo pv) throws Exception {
      String sql = "SELECT NO, GIVER_NO, MR.MEMBER_NO, CHATTING_ROOM_NO, MR.ENROLL_DATE AS ENROLL_DATE, CONTENT, SCORE ,M.ID AS ID, M.NICK AS NICK, M.PROFILE_IMAGE AS PROFILEIMAGE FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM MEMBER_REVIEW WHERE MEMBER_NO=? ORDER BY NO DESC ) T )MR JOIN MEMBER M ON MR.GIVER_NO = M.MEMBER_NO WHERE RNUM BETWEEN ? AND ? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, selectMemberNo);
      pstmt.setInt(2, pv.getBeginRow());
      pstmt.setInt(3, pv.getLastRow());
      
      ResultSet rs = pstmt.executeQuery();
      
      //tx || rs
      List<MemberReviewVo> MemberReviewVolist = new ArrayList<>();
      while(rs.next()) {
         
         
         String no = rs.getString("NO");
         String giverNo = rs.getString("GIVER_NO");
         String memberNo = rs.getString("MEMBER_NO");
         String chattingRoomNo = rs.getString("CHATTING_ROOM_NO");
         String enrollDate = rs.getString("ENROLL_DATE");
         String content = rs.getString("CONTENT");
         String score = rs.getString("SCORE");
         String giverId = rs.getString("ID");
         String giverNick = rs.getString("NICK");
         String profileImage = rs.getString("PROFILEIMAGE");
         //tx || rs
         MemberReviewVo vo = new MemberReviewVo();
         vo = new MemberReviewVo();
         vo.setGiverId(giverId);
         vo.setGiverNick(giverNick);
         vo.setNo(no);
         vo.setGiverNo(giverNo);
         vo.setMemberNo(memberNo);
         vo.setChattingRoomNo(chattingRoomNo);
         vo.setEnrollDate(enrollDate);
         vo.setContent(content);
         vo.setScore(score);;
         vo.setGiverProfile(profileImage);
         MemberReviewVolist.add(vo);
         }
         
         
         
         
      
      
      //close
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return MemberReviewVolist;
   }

   public int selectCnt(Connection conn, String selectMemberNo) throws Exception {
      //SQL
      String sql = "SELECT COUNT(*) FROM MEMBER_REVIEW WHERE MEMBER_NO=?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, selectMemberNo);
      ResultSet rs = pstmt.executeQuery();
      
      //tx || rs
      int cnt = 0;
      if(rs.next()) {
         cnt = rs.getInt(1);
      }
      
      //close
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return cnt;
   }

public MemberVo getSelectMemberVo(Connection conn, String selectMemberNo) throws Exception {
	String sql = "SELECT * FROM MEMBER WHERE MEMBER_NO =?";
	   PreparedStatement pstmt = conn.prepareStatement(sql);
	   pstmt.setString(1, selectMemberNo);
	   ResultSet rs = pstmt.executeQuery();
	   MemberVo vo = null;
	   
	   if(rs.next()) {
	         
	         
	         String mNo = rs.getString("MEMBER_NO");
	         String isGuide = rs.getString("IS_GUIDE");
	         String memberStatus = rs.getString("MEMBER_STATUS");
	         String id = rs.getString("ID");
	         String password = rs.getString("PASSWORD");
	         String name = rs.getString("NAME");
	         String gender = rs.getString("GENDER");
	         String age = rs.getString("AGE");
	         String address = rs.getString("ADDRESS");
	         String email = rs.getString("EMAIL");
	         String phoneNumber = rs.getString("PHONE_NUMBER");
	         String nick = rs.getString("NICK");
	         String profileImage = rs.getString("PROFILE_IMAGE");
	         String idCard = rs.getString("ID_CARD");
	         String enrollDate = rs.getString("ENROLL_DATE");
	         String introMessage = rs.getString("INTRO_MESSAGE");
	         String memberScore = rs.getString("MEMBER_SCORE");
	         
	         
	         
	         vo = new MemberVo();
	         
	         vo.setMemberNo(mNo);
	         vo.setIsGuide(isGuide);
	         vo.setMemberStatus(memberStatus);
	         vo.setId(id);
	         vo.setPassword(password);
	         vo.setName(name);
	         vo.setGender(gender);
	         vo.setAge(age);
	         vo.setAddress(address);
	         vo.setEmail(email);
	         vo.setPhoneNumber(phoneNumber);
	         vo.setNick(nick);
	         vo.setProfileImage(profileImage);
	         vo.setIdCard(idCard);
	         vo.setEnrollDate(enrollDate);
	         vo.setIntroMessage(introMessage);
	         vo.setMemberScore(memberScore);
	         
	      }
	      
	      //close
	      JDBCTemplate.close(rs);
	      JDBCTemplate.close(pstmt);
	      
	      return vo;
}






}
