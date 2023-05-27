package com.bp.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.member.dao.MemberDao;
import com.bp.app.member.vo.MemberVo;

public class MemberService {

	private final MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
	}

	public int join(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.join(conn , vo);
		
		//tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}//method

	public MemberVo login(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberVo loginMember = dao.login(conn, vo);
		
		//close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}

//	public MemberVo edit(MemberVo vo) throws Exception {
//		
//		//conn
//		Connection conn = JDBCTemplate.getConnection();
//		
//		MemberVo updatedMember = null;
//		try {
//			//SQL
//			int result = dao.edit(conn , vo);
//			
//			//tx || rs
//			if(result == 1) {
//				updatedMember = dao.selectOneByNo(conn , vo.getNo());
//				if(updatedMember == null) {
//					throw new Exception();
//				}
//				JDBCTemplate.commit(conn);
//			}else {
//				JDBCTemplate.rollback(conn);
//			}
//			
//		}finally {
//			//close
//			JDBCTemplate.close(conn);
//		}
//		
//		return updatedMember;
//	}

	public int quit(MemberVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL
		int result = dao.quit(conn , vo);
		
		//tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	public MemberVo registerFpacker(String idChangeName, String memberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo updatedMember = null;
		try {
			//SQL
			int result = dao.registerFpacker(idChangeName, memberNo, conn);
			
			//tx || rs
			if(result == 1) {
				updatedMember = dao.selectOneByNo(conn , memberNo);
				if(updatedMember == null) {
					throw new Exception();
				}
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
		}finally {
			//close
			JDBCTemplate.close(conn);
		}
		
		return updatedMember;
	}

	public MemberVo editMemberInfo(MemberVo vo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		MemberVo updatedMember = null;
		
		MemberDao dao = new MemberDao();
		
		try {			
			int result = dao.editMemberInfo(conn, vo);
			if(result == 1) {
				updatedMember = dao.selectOneByNo(conn, vo.getMemberNo());
				if(updatedMember == null) {
					throw new Exception();
				}
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} finally {			
			JDBCTemplate.close(conn);
		}
		
		return updatedMember;
	}

	public MemberVo changePassword(String memberNo, String password) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		
		
		MemberVo updatedMember = null;
		try {
			int result = dao.changePassword(conn, memberNo, password);
			
			if(result == 1) {
				updatedMember = dao.selectOneByNo(conn, memberNo);
				if(updatedMember == null) {
					throw new Exception();
				}
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} finally {
			JDBCTemplate.close(conn);
		}
		
		
		return updatedMember;
	}

	public MemberVo findId(String name, String phoneNumber) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo tempMember = dao.findId(conn, name, phoneNumber);
		
		return tempMember;
		
	}

	public MemberVo findPassword(String id, String phoneNumber, String email) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo tempMember = dao.findPassword(conn, id, phoneNumber, email);
		
		JDBCTemplate.close(conn);
		
		return tempMember;
	}

	public boolean checkId(String id) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		boolean result = dao.checkId(conn, id);
		
		
		JDBCTemplate.close(conn);
		
		
		//return
		return result;	
	}

	public boolean checkNick(String nick) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		boolean result = dao.checkNick(conn, nick);
		
		JDBCTemplate.close(conn);
		
		
		//return
		return result; 
	}
}//class
