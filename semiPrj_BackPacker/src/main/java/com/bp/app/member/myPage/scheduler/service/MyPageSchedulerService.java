package com.bp.app.member.myPage.scheduler.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.member.myPage.scheduler.dao.MyPageSchedulerDao;
import com.bp.app.scheduler.vo.SchedulerVo;
import com.bp.app.scheduler.vo.TimetableVo;

public class MyPageSchedulerService {

	public Map<Integer, SchedulerVo> selectScheduleList(String memberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MyPageSchedulerDao dao = new MyPageSchedulerDao();
		Map<Integer,SchedulerVo> map = dao.selectSchedulerList(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		
		
		return map;
	}

	public List<TimetableVo> getScheduleDetailPage(String schedulerNo, String memberNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		MyPageSchedulerDao dao = new MyPageSchedulerDao();
		List<TimetableVo> list = dao.getScheduleDetailPage(conn, schedulerNo, memberNo);
		//sql
		
		JDBCTemplate.close(conn);
		
		
		
		
		return list;
	}

}
