package com.bp.app.chat.room.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bp.app.admin.placeManage.dao.PlaceManageDao;
import com.bp.app.chat.message.vo.MessageVo;
import com.bp.app.chat.room.dao.ChatDao;
import com.bp.app.chat.room.vo.ChattingRoomVo;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.vo.GuideReplyVo;
import com.bp.app.member.vo.MemberVo;

public class ChatService {
	private final ChatDao dao;
	
	public ChatService() {
		dao=new ChatDao();
	}
	public ChattingRoomVo openNewChatRoom(ChattingRoomVo crv, String loginMemberNo) throws Exception {
		ChattingRoomVo vo = null;
		Connection conn = JDBCTemplate.getConnection()	;
			//UPDATE
		int result = dao.openNewChatRoom(conn, crv ,loginMemberNo);
		if(result < 1) {
			JDBCTemplate.rollback(conn);
			throw new Exception();
		}
			JDBCTemplate.commit(conn);
		//SELECT
		
		vo = dao.getNewChatRoom(conn, crv);
		JDBCTemplate.close(conn);
		return vo; 
		
	}
	public ChattingRoomVo openOldChatRoom(ChattingRoomVo crv, String loginMemberNo) throws Exception {
		ChattingRoomVo vo = null;
		Connection conn = JDBCTemplate.getConnection()	;
			
		//SELECT
		int result = dao.deleteCnt(conn,crv,loginMemberNo);
		vo = dao.getOldChatRoom(conn, crv);
		if(result >=1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		JDBCTemplate.close(conn);
		return vo; 
	}
	public int selectCnt1(String searchType, String searchValue, String no) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt2(conn, searchType, searchValue,no);
		
		//close
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	public int selectCnt2(String searchType, String searchValue, String no) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt1(conn, searchType, searchValue,no);
		
		//close
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	public List<ChattingRoomVo> openRoomList(PageVo pv, ChattingRoomVo crv) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
	      
		List<ChattingRoomVo> roomList =  dao.openRoomList1(conn,crv,pv);
	      
	      //close
	      JDBCTemplate.close(conn);
	      
	      return roomList;
	}
	public List<ChattingRoomVo> openRoomList(PageVo pv, String searchType, String searchValue, ChattingRoomVo crv) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		List<ChattingRoomVo> roomList =  dao.openRoomList1(conn,crv,pv,searchType, searchValue);
		
		JDBCTemplate.close(conn);
		return roomList;
	}
	public ChattingRoomVo openOldChatRoomByRoomNo(ChattingRoomVo crv, String loginMemberNo) throws Exception {
		ChattingRoomVo vo = null;
		Connection conn = JDBCTemplate.getConnection()	;
			
		//SELECT
		int result = dao.deleteCnt(conn,crv,loginMemberNo);
		vo = dao.getOldChatRoomByRoomNo(conn, crv);
		if(result >=1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return vo; 
	}
	public int outChatRoom(ChattingRoomVo vo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.outChatRoom(conn, vo);
		
		//close
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	public int outMyBoardChatRoom(ChattingRoomVo vo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.outMyBoardChatRoom(conn, vo);
		
		//close
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	public int submitMyBoardChatRoom(ChattingRoomVo vo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.submitMyBoardChatRoom(conn, vo);
		
		//close
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	public int submitChatRoom(ChattingRoomVo vo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.submitChatRoom(conn, vo);
		
		//close
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	

}
