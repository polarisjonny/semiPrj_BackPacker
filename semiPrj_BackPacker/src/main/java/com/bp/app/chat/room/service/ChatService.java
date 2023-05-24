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
	public ChattingRoomVo openNewChatRoom(ChattingRoomVo crv) throws Exception {
		ChattingRoomVo vo = null;
		Connection conn = JDBCTemplate.getConnection()	;
			//UPDATE
		int result = dao.openNewChatRoom(conn, crv);
		if(result != 1) {
			JDBCTemplate.rollback(conn);
			throw new Exception();
		}
			JDBCTemplate.commit(conn);
		//SELECT
		
		vo = dao.getNewChatRoom(conn, crv);
		JDBCTemplate.close(conn);
		return vo; 
		
	}
	public ChattingRoomVo openOldChatRoom(ChattingRoomVo crv) throws Exception {
		ChattingRoomVo vo = null;
		Connection conn = JDBCTemplate.getConnection()	;
			
		//SELECT
		
		vo = dao.getOldChatRoom(conn, crv);
		JDBCTemplate.close(conn);
		return vo; 
	}
	public int selectCnt(String searchType, String searchValue) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt(conn, searchType, searchValue);
		
		//close
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}
	public List<ChattingRoomVo> openRoomList(PageVo pv, ChattingRoomVo crv) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
	      
		List<ChattingRoomVo> roomList =  dao.openRoomList(conn,crv,pv);
	      
	      //close
	      JDBCTemplate.close(conn);
	      
	      return roomList;
	}
	public List<ChattingRoomVo> openRoomList(PageVo pv, String searchType, String searchValue, ChattingRoomVo crv) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		List<ChattingRoomVo> roomList =  dao.openRoomList(conn,crv,pv,searchType, searchValue);
		
		JDBCTemplate.close(conn);
		return roomList;
	}
	public ChattingRoomVo openOldChatRoomByRoomNo(ChattingRoomVo crv) throws Exception {
		ChattingRoomVo vo = null;
		Connection conn = JDBCTemplate.getConnection()	;
			
		//SELECT
		
		vo = dao.getOldChatRoomByRoomNo(conn, crv);
		JDBCTemplate.close(conn);
		return vo; 
	}
	
	

}
