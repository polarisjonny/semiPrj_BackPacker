package com.bp.app.member.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws Exception {
		//SQL
		String sql = "INSERT INTO MEMBER( MEMBER_NO, IS_GUIDE, ID, PASSWORD, NAME, GENDER, AGE, ADDRESS, EMAIL, PHONE_NUMBER, NICK, PROFILE_IMAGE, ID_CARD, INTRO_MESSAGE ) VALUES(SEQ_MEMBER_NO.NEXTVAL , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getIsGuide());
		pstmt.setString(2, vo.getId());
		pstmt.setString(3, vo.getPassword());
		pstmt.setString(4, vo.getName());
		pstmt.setString(5, vo.getGender());
		pstmt.setString(6, vo.getAge());
		pstmt.setString(7, vo.getAddress());
		pstmt.setString(8, vo.getEmail());
		pstmt.setString(9, vo.getPhoneNumber());
		pstmt.setString(10, vo.getNick());
		pstmt.setString(11, vo.getProfileImage());
		pstmt.setString(12, vo.getIdCard());
		pstmt.setString(13, vo.getIntroMessage());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		
		//SQL
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ? AND MEMBER_STATUS = '1'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPassword());
		ResultSet rs = pstmt.executeQuery();
		//tx || rs 
		MemberVo loginMember = null;
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
			
			loginMember = new MemberVo();
			loginMember.setMemberNo(memberNo);
			loginMember.setIsGuide(isGuide);
			loginMember.setMemberStatus(memberStatus);
			loginMember.setId(id);
			loginMember.setPassword(password);
			loginMember.setName(name);
			loginMember.setGender(gender);
			loginMember.setAge(age);
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
	}//method

//	public int edit(Connection conn, MemberVo vo) throws Exception {
//		String sql = "UPDATE MEMBER SET NICK = ? , HOBBY = ? ";
//		if(vo.getPassword() != null && vo.getPassword().length() > 0) {
//			sql += ", PWD = ?";
//		}
//		sql += ", MODIFY_DATE = SYSDATE WHERE NO = ? AND STATUS = 'O'";
//		
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, vo.getNick());
//		pstmt.setString(2, vo.getHobby());
//		if(vo.getPwd() != null && vo.getPwd().length() > 0) {
//			pstmt.setString(3, vo.getPwd());
//			pstmt.setString(4, vo.getNo());
//		}else {
//			pstmt.setString(3, vo.getNo());
//		}
//		int result = pstmt.executeUpdate();
//		
//		JDBCTemplate.close(pstmt);
//		
//		return result;
//	}

//	public MemberVo selectOneByNo(Connection conn, String no) throws Exception {
//		
//		String sql = "SELECT * FROM MEMBER WHERE MEMBER_NO = ? AND MEMBER_STATUS = '1'";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, no);
//		ResultSet rs = pstmt.executeQuery();
//		
//		MemberVo vo = null;
//		if(rs.next()) {
//			String id = rs.getString("ID");
//			String pwd = rs.getString("PWD");
//			String nick = rs.getString("NICK");
//			String profile = rs.getString("PROFILE");
//			
//			vo = new MemberVo();
//			vo.setMemberNo(no);;
//			vo.setId(id);
//			vo.setNick(nick);
//			vo.setProfileImage(profile);
//		}
//		
//		JDBCTemplate.close(rs);
//		JDBCTemplate.close(pstmt);
//		
//		return vo;
//	}

	public int quit(Connection conn, String no) throws Exception {
		
		String sql = "UPDATE MEMBER SET MEMBER_STATUS = '2' WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	
	
	

}//class
