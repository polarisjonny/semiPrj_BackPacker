package com.bp.app.member.profile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.member.vo.MemberVo;

public class EditProfileDao {

   public int editImg(Connection conn, MemberVo vo) throws Exception {
      String sql = "UPDATE MEMBER SET  PROFILE_IMAGE = ? WHERE MEMBER_NO = ? ";
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, vo.getProfileImage());
      pstmt.setString(2, vo.getMemberNo());
      int result = pstmt.executeUpdate();
      
      JDBCTemplate.close(pstmt);
      
      return result;
   }

   public MemberVo selectOneByNo(Connection conn, String memberNo) throws SQLException {
      String sql = "SELECT * FROM MEMBER WHERE MEMBER_NO = ?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memberNo);
      ResultSet rs = pstmt.executeQuery();
      
      MemberVo loginMember = null;
      if(rs.next()) {
         
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
         
         loginMember = new MemberVo();
         loginMember.setMemberNo(memberNo);;
         loginMember.setIsGuide(isGuide);;
         loginMember.setMemberStatus(memberStatus);;
         loginMember.setId(id);;
         loginMember.setPassword(password);;
         loginMember.setName(name);;
         loginMember.setGender(gender);;
         loginMember.setAge(age);;
         loginMember.setAddress(address);
         loginMember.setEmail(email);
         loginMember.setPhoneNumber(phoneNumber);
         loginMember.setNick(nick);
         loginMember.setProfileImage(profileImage);
         loginMember.setIdCard(idCard);
         loginMember.setEnrollDate(enrollDate);
         loginMember.setIntroMessage(introMessage);
         loginMember.setMemberScore(memberScore);
      }
      
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return loginMember;
   }

   public int editIntMsg(Connection conn, MemberVo vo) throws Exception {
      String sql = "UPDATE MEMBER SET  INTRO_MESSAGE = ? WHERE MEMBER_NO = ? ";
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, vo.getIntroMessage());
      pstmt.setString(2, vo.getMemberNo());
      int result = pstmt.executeUpdate();
      
      JDBCTemplate.close(pstmt);
      
      return result;
   }

}
