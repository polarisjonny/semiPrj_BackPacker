package com.bp.app.member.myPage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.vo.GuideBoardVo;

public class MyPageBoardService {

	public List<GuideBoardVo> selectGuideBoardList(String memberNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MyPageBoardDao mpbd = new MyPageBoardDao();
		List<GuideBoardVo> list = mpbd.selectGuideBoardList(conn, memberNo);
		
		//SQL
		
		JDBCTemplate.close(conn);
		
		//return
		return list;
		
	}

	public int selectCountAccompanyBoard(String writerNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		
		MyPageBoardDao mpbd = new MyPageBoardDao();
		int count = mpbd.selectCountAccompanyBoard(conn, writerNo);
		
		JDBCTemplate.close(conn);
		
		
		return count;
	}
	

	public List<GuideBoardVo> selectAccompanyBoardList(PageVo pv, String writerNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MyPageBoardDao dao = new MyPageBoardDao();
		List<GuideBoardVo> list = dao.selectAccompanyBoardList(conn, pv, writerNo);
		
		
		JDBCTemplate.close(conn);
		
		return list;
	}
}
