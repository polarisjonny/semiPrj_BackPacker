package com.bp.app.member.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.memberReview.vo.MemberReviewVo;

public class GoProfileDao {

   public MemberVo selectMemberToProfile(Connection conn, String selectMemberNo) throws Exception {
      //SQL
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

   public List<MemberReviewVo> selectMemberReadReview(Connection conn, String selectMemberNo) throws Exception {
      //SQL
      String sql = "SELECT MR.NO AS NO, MR.GIVER_NO AS GIVER_NO, MR.MEMBER_NO, MR.CHATTING_ROOM_NO, MR.ENROLL_DATE AS ENROLL_DATE , MR.CONTENT, MR.SCORE ,M.ID AS ID, M.NICK AS NICK, M.PROFILE_IMAGE AS PROFILE, B.TITLE AS BOARDTITLE, B.MATCHING_STATE AS STATE FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM MEMBER_REVIEW WHERE MEMBER_NO=? ORDER BY NO DESC ) T )MR JOIN MEMBER M ON MR.GIVER_NO = M.MEMBER_NO JOIN CHATTING_ROOM C ON MR.CHATTING_ROOM_NO = C.CHATTING_ROOM_NO JOIN GUIDE_BOARD B ON B.GUIDE_BOARD_NO = C.GUIDE_BOARD_NO ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, selectMemberNo);
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
         String boardTitle = rs.getString("BOARDTITLE");
         String giverProfile = rs.getString("PROFILE") ;
         
         //tx || rs
         MemberReviewVo vo = new MemberReviewVo();
         
         vo.setGiverId(giverId);
         vo.setGiverNick(giverNick);
         vo.setNo(no);
         vo.setGiverNo(giverNo);
         vo.setMemberNo(memberNo);
         vo.setChattingRoomNo(chattingRoomNo);
         vo.setEnrollDate(enrollDate);
         vo.setContent(content);
         vo.setScore(score);;
         vo.setBoardTitle(boardTitle);
         vo.setGiverProfile(giverProfile);
         MemberReviewVolist.add(vo);
         }
         
         
         
         
      
      
      //close
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return MemberReviewVolist;
   }

   public int selectCnt(Connection conn, String selectMemberNo) throws SQLException {
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

   

}