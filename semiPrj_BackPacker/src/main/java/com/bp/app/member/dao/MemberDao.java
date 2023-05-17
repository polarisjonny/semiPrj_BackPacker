package com.bp.app.member.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws Exception {
		int result = 0;
		
		//프로필 사진을 넣었을 경우
		if(vo.getProfileImage() != null && !vo.getProfileImage().isEmpty()) {
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
			result = pstmt.executeUpdate();
			JDBCTemplate.close(pstmt);
		} else {
			String sql = "INSERT INTO MEMBER( MEMBER_NO, IS_GUIDE, ID, PASSWORD, NAME, GENDER, AGE, ADDRESS, EMAIL, PHONE_NUMBER, NICK, ID_CARD, INTRO_MESSAGE ) VALUES(SEQ_MEMBER_NO.NEXTVAL , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
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
			pstmt.setString(11, vo.getIdCard());
			pstmt.setString(12, vo.getIntroMessage());
			result = pstmt.executeUpdate();
			JDBCTemplate.close(pstmt);
		}
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

	public int quit(Connection conn, MemberVo vo) throws Exception {
		
		String sql = "UPDATE MEMBER SET MEMBER_STATUS = '3' WHERE ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	
	
	public int registerFpacker(String idChangeName, String memberNo, Connection conn) throws Exception {
		//SQL
		String sql = "UPDATE MEMBER SET IS_GUIDE = 'O', ID_CARD = ? WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, idChangeName);
		pstmt.setInt(2,  Integer.parseInt(memberNo));
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(pstmt);
		
		
		//result
		return result;
		
	}

	public int editMemberInfo(Connection conn, MemberVo vo) throws Exception {
		String sql = "UPDATE MEMBER SET PHONE_NUMBER = ?, EMAIL = ?, ADDRESS = ?, AGE = ?, PROFILE_IMAGE = ?, INTRO_MESSAGE = ? WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getPhoneNumber());
		pstmt.setString(2,  vo.getEmail());
		pstmt.setString(3,  vo.getAddress());
		pstmt.setString(4,  vo.getAge());
		pstmt.setString(5,  vo.getProfileImage());
		pstmt.setString(6,  vo.getIntroMessage());
		pstmt.setInt(7,  Integer.parseInt(vo.getMemberNo()));
		
		int result = pstmt.executeUpdate();
		
		
		JDBCTemplate.close(pstmt);
		
		
		return result;
	}

	public MemberVo selectOneByNo(Connection conn, String memberNo) throws Exception {
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_NO = ? AND MEMBER_STATUS = '1'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,  Integer.parseInt(memberNo));
		
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo updatedMember = null;
		if(rs.next()) {
			String no = rs.getString("MEMBER_NO");
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
			
			updatedMember = new MemberVo();
			
			
			updatedMember.setMemberNo(no);
			updatedMember.setIsGuide(isGuide);
			updatedMember.setMemberStatus(memberStatus);
			updatedMember.setId(id);
			updatedMember.setPassword(password);
			updatedMember.setName(name);
			updatedMember.setGender(gender);
			updatedMember.setAge(age);
			updatedMember.setAddress(address);
			updatedMember.setEmail(email);
			updatedMember.setPhoneNumber(phoneNumber);
			updatedMember.setIdCard(idCard);
			updatedMember.setNick(nick);
			updatedMember.setProfileImage(profileImage);
			updatedMember.setEnrollDate(enrollDate);
			updatedMember.setIntroMessage(introMessage);
			updatedMember.setMemberScore(memberScore);
			
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return updatedMember;
 	}

	public int changePassword(Connection conn, String memberNo, String password) throws Exception {
		String sql = "UPDATE MEMBER SET PASSWORD = ? WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, memberNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public MemberVo findId(Connection conn, String name, String phoneNumber) throws Exception {
		String sql = "SELECT ID, NICK FROM MEMBER WHERE NAME = ? AND PHONE_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, phoneNumber);
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo tempMember = null;
		
		if(rs.next()) {
			String id = rs.getString("ID");
			String nick = rs.getString("NICK");
			
			tempMember = new MemberVo();
			tempMember.setId(id);
			tempMember.setNick(nick);
			tempMember.setName(name);
			tempMember.setPhoneNumber(phoneNumber);
		} else {
			throw new Exception("[ERROR]찾으시는 정보가 없습니다.");
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return tempMember;
	}

	public MemberVo findPassword(Connection conn, String id, String phoneNumber, String email) throws Exception {
		String sql = "SELECT PASSWORD, NICK FROM MEMBER WHERE ID = ? AND PHONE_NUMBER = ? AND EMAIL = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, phoneNumber);
		pstmt.setString(3,  email);
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo tempMember = null;
		
		if(rs.next()) {
			String password = rs.getString("PASSWORD");
			String nick = rs.getString("NICK");
			
			tempMember = new MemberVo();
			tempMember.setPassword(password);
			tempMember.setNick(nick);
			tempMember.setEmail(email);
			tempMember.setPhoneNumber(phoneNumber);
		} else {
			throw new Exception("[ERROR]찾으시는 정보가 없습니다.");
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return tempMember;
	}
}//class
