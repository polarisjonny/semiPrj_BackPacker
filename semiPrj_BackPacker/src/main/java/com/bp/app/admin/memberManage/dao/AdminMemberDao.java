package com.bp.app.admin.memberManage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.member.vo.MemberVo;

public class AdminMemberDao {
      


   public MemberVo selectOneByNo(Connection conn, MemberVo vo) throws Exception {
      String sql = "SELECT * FROM MEMBER WHERE MEMBER_NO=?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, vo.getMemberNo());
      ResultSet rs = pstmt.executeQuery();
      
      //tx || rs
      MemberVo mvo = null;
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
         
         
         mvo = new MemberVo();
         mvo.setMemberNo(memberNo);
         mvo.setIsGuide(isGuide);
         mvo.setMemberStatus(memberStatus);
         mvo.setId(id);
         mvo.setPassword(password);
         mvo.setName(name);
         mvo.setGender(gender);
         mvo.setAge(age);
         mvo.setAddress(address);
         mvo.setEmail(email);
         mvo.setPhoneNumber(phoneNumber);
         mvo.setNick(nick);
         mvo.setProfileImage(profileImage);
         mvo.setIdCard(idCard);
         mvo.setEnrollDate(enrollDate);
         mvo.setIntroMessage(introMessage);
         mvo.setMemberScore(memberScore);
         
      }
      
      //close
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return mvo;
   }

   public int editStatus(Connection conn, MemberVo vo, String status) throws Exception {
      String no = vo.getMemberNo();
      String sql = "UPDATE MEMBER SET MEMBER_STATUS = ? WHERE MEMBER_NO = ? ";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,   status );
      pstmt.setString(2, no);
      int result = pstmt.executeUpdate();
      
      JDBCTemplate.close(pstmt);
      
      return result;
   }

   public List<MemberVo> getMemberList(Connection conn) throws Exception {

      String sql = "SELECT * FROM MEMBER ORDER BY MEMBER_STATUS DESC";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
       List<MemberVo> voList = new ArrayList<>();
      while(rs.next()) {
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
         MemberVo mvo = new MemberVo();
         mvo.setMemberNo(memberNo);
         mvo.setIsGuide(isGuide);
         mvo.setMemberStatus(memberStatus);
         mvo.setId(id);
         mvo.setPassword(password);
         mvo.setName(name);
         mvo.setGender(gender);
         mvo.setAge(age);
         mvo.setAddress(address);
         mvo.setEmail(email);
         mvo.setPhoneNumber(phoneNumber);
         mvo.setNick(nick);
         mvo.setProfileImage(profileImage);
         mvo.setIdCard(idCard);
         mvo.setEnrollDate(enrollDate);
         mvo.setIntroMessage(introMessage);
         mvo.setMemberScore(memberScore);
         
         voList.add(mvo);
      }
      //close
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return voList;
   }

   public int getMemberListCnt(Connection conn, String searchType, String searchValue) throws Exception {
      //SQL
            String sql = "SELECT COUNT(*) FROM ( SELECT * FROM MEMBER)";
            if("memberName".equals(searchType)) {
               sql += "WHERE NAME LIKE '%" + searchValue + "%'";
            }else if("memberId".equals(searchType)) {
               sql += "WHERE ID LIKE '%" + searchValue + "%'";
            }else if("memberStatus".equals(searchType)) {
               sql += "WHERE MEMBER_STATUS = " + searchValue;
            }
            
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            //tx || rs
            int cnt = 0;
            if(rs.next()) {
               cnt = rs.getInt(1);
            }
            
            JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
            
            return cnt;
   }

   public List<MemberVo> getMemberList(Connection conn, PageVo pv) throws Exception {
         String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT * FROM MEMBER ORDER BY MEMBER_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?;";
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, pv.getBeginRow());
         pstmt.setInt(2, pv.getLastRow());
         ResultSet rs = pstmt.executeQuery();
         
         
         List<MemberVo> voList = new ArrayList<>();
         while(rs.next()) {
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
            
            MemberVo mvo = new MemberVo();
            
            mvo.setMemberNo(memberNo);
            mvo.setIsGuide(isGuide);
            mvo.setMemberStatus(memberStatus);
            mvo.setId(id);
            mvo.setPassword(password);
            mvo.setName(name);
            mvo.setGender(gender);
            mvo.setAge(age);
            mvo.setAddress(address);
            mvo.setEmail(email);
            mvo.setPhoneNumber(phoneNumber);
            mvo.setNick(nick);
            mvo.setProfileImage(profileImage);
            mvo.setIdCard(idCard);
            mvo.setEnrollDate(enrollDate);
            mvo.setIntroMessage(introMessage);
            mvo.setMemberScore(memberScore);
            
            voList.add(mvo);
         }
         
         JDBCTemplate.close(rs);
         JDBCTemplate.close(pstmt);
         
         return voList;
         
         
         
         
         
   }

   public List<MemberVo> getMemberList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {
      
      String sql = "";
      
      if("memberName".equals(searchType)) {
         //SQL (이름   검색)
         sql = "SELECT * FROM (SELECT ROWNUM RNUM, T.* FROM (SELECT * FROM MEMBER WHERE NAME LIKE '%'||?||'%' ORDER BY  MEMBER_NO) T) WHERE RNUM BETWEEN ? AND ?";
      }else if("memberId".equals(searchType)) {
         //SQL (아이디   검색)
         sql = "SELECT * FROM (SELECT ROWNUM RNUM, T.* FROM (SELECT * FROM MEMBER WHERE ID LIKE '%'||?||'%' ORDER BY  MEMBER_NO) T) WHERE RNUM BETWEEN ? AND ?";
      }else if("memberStatus".equals(searchType)) {
         //SQL (카테고리 검색)
         sql = "SELECT * FROM (SELECT ROWNUM RNUM, T.* FROM (SELECT * FROM MEMBER WHERE MEMBER_STATUS = ?  ORDER BY MEMBER_NO) T) WHERE RNUM BETWEEN ? AND ?";
      }else {
         //값이 이상함 => 기본 목록 조회
         return getMemberList(conn, pv);
      }
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString   (1, searchValue);
      pstmt.setInt   (2, pv.getBeginRow());
      pstmt.setInt   (3, pv.getLastRow());
      ResultSet rs = pstmt.executeQuery();
      
      //tx || rs
      List<MemberVo> voList = new ArrayList<>();
      while(rs.next()) {
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
         
         MemberVo mvo = new MemberVo();
         
         mvo.setMemberNo(memberNo);
         mvo.setIsGuide(isGuide);
         mvo.setMemberStatus(memberStatus);
         mvo.setId(id);
         mvo.setPassword(password);
         mvo.setName(name);
         mvo.setGender(gender);
         mvo.setAge(age);
         mvo.setAddress(address);
         mvo.setEmail(email);
         mvo.setPhoneNumber(phoneNumber);
         mvo.setNick(nick);
         mvo.setProfileImage(profileImage);
         mvo.setIdCard(idCard);
         mvo.setEnrollDate(enrollDate);
         mvo.setIntroMessage(introMessage);
         mvo.setMemberScore(memberScore);
         
         voList.add(mvo);
      }
      
      JDBCTemplate.close(rs);
      JDBCTemplate.close(pstmt);
      
      return voList;
   }

   

}   