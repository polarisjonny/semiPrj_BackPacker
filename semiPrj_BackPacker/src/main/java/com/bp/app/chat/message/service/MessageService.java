package com.bp.app.chat.message.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.chat.message.dao.MessageDao;
import com.bp.app.chat.message.vo.MessageVo;
import com.bp.app.common.db.JDBCTemplate;

public class MessageService {
	private final MessageDao dao = new MessageDao();
	public int sendMessage(MessageVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		
		int result = dao.sendMessage(conn,vo);
		//sql
		
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public List<MessageVo> selecMessageList(String chattingRoomNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		
		//rx 
		List<MessageVo> list = dao.selecMessageList(conn,chattingRoomNo);
		
		JDBCTemplate.close(conn);
		
		//close
		
		return list;
	}	
}
