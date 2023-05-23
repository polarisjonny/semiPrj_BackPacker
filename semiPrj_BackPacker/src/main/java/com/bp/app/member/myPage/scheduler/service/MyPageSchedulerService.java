package com.bp.app.member.myPage.scheduler.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.member.myPage.scheduler.dao.MyPageSchedulerDao;
import com.bp.app.scheduler.vo.SchedulerVo;

public class MyPageSchedulerService {

	public Map<Integer, SchedulerVo> selectScheduleList(String memberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MyPageSchedulerDao dao = new MyPageSchedulerDao();
		Map<Integer,SchedulerVo> map = dao.selectSchedulerList(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		
		
		return map;
	}

}
