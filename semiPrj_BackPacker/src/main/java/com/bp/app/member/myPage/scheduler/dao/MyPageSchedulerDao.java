package com.bp.app.member.myPage.scheduler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.scheduler.vo.SchedulerVo;

public class MyPageSchedulerDao {

	public Map<Integer, SchedulerVo> selectSchedulerList(Connection conn, String memberNo) throws Exception {
		String sql = "SELECT S.MEMBER_NO AS MEMBER_NO, S.SCHEDULER_NO AS SCHEDULER_NO, TO_CHAR(S.START_DATE, 'YYYY-MM-DD') AS START_DATE, CC.COUNTRY_NAME AS COUNTRY_NAME, TO_CHAR(S.END_DATE, 'YYYY-MM-DD') AS END_DATE FROM SCHEDULER S JOIN TIMETABLE T ON S.SCHEDULER_NO = T.SCHEDULER_NO JOIN PLACE P ON P.PLACE_NO = T.PLACE_NO JOIN COUNTRY_CATEGORY CC ON CC.COUNTRY_NO = P.COUNTRY_NO WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		Map<Integer, SchedulerVo> map = new HashMap<>();
		
		while(rs.next()) {
			//vo
			int schedulerNo = rs.getInt("SCHEDULER_NO");
			
			
			//vo add
			
			String no = rs.getString("MEMBER_NO");
			String startDate = rs.getString("START_DATE");
			String endDate = rs.getString("END_DATE");
			String countryName = rs.getString("COUNTRY_NAME");
			
			
			SchedulerVo sVo = new SchedulerVo();
			sVo.setMemberNo(no);
			sVo.setStartDate(startDate);
			sVo.setEndDate(endDate);
			sVo.setCountryName(countryName);
			
			map.put(schedulerNo, sVo);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return map;
	}

}
