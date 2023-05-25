package com.bp.app.member.myPage.scheduler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.scheduler.vo.SchedulerVo;
import com.bp.app.scheduler.vo.TimetableVo;

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
			sVo.setSchedulerNo(Integer.toString(schedulerNo));
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

	public List<TimetableVo> getScheduleDetailPage(Connection conn, String schedulerNo, String memberNo) throws Exception {
		String sql = "SELECT * FROM ( SELECT M.TIMETABLE_NO ,M.PLACE_NO ,M.SCHEDULER_NO ,M.TIMETABLE_DATE ,M.BESPOKE_PLACE ,M.BESPOKE_TIME ,M.TIMETABLE_START_TIME ,M.PLAY_TIME,M.TOTAL_DATE ,M.MEMBER_NO ,M.START_DATE ,M.END_DATE FROM ( SELECT T.TIMETABLE_NO ,T.PLACE_NO ,T.SCHEDULER_NO ,T.TIMETABLE_DATE ,T.BESPOKE_PLACE ,T.BESPOKE_TIME ,TO_CHAR(T.TIMETABLE_START_TIME , 'HH24:MI') AS TIMETABLE_START_TIME,T.PLAY_TIME ,TO_CHAR(CAST(EXTRACT(DAY FROM (S.END_DATE - S.START_DATE))+1 AS VARCHAR2(10))) AS TOTAL_DATE ,S.MEMBER_NO ,TO_CHAR(S.START_DATE, 'yyyy-mm-dd') AS START_DATE ,TO_CHAR(S.END_DATE, 'yyyy-mm-dd') AS END_DATE FROM TIMETABLE T JOIN SCHEDULER S ON T.SCHEDULER_NO = S.SCHEDULER_NO )M WHERE M.SCHEDULER_NO= ? AND M.MEMBER_NO = ?) K JOIN PLACE P ON( K.PLACE_NO = P.PLACE_NO)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  schedulerNo);
		pstmt.setString(2,  memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<TimetableVo> list = new ArrayList<>();
		while(rs.next()) {
			String timetableNo = rs.getString("TIMETABLE_NO");
			String placeNo = rs.getString("PLACE_NO");
			String sNo = rs.getString("SCHEDULER_NO");
			String timetableDate = rs.getString("TIMETABLE_DATE");
			String bespokePlace = rs.getString("BESPOKE_PLACE");
			String bespokeTime = rs.getString("BESPOKE_TIME");
			String timetableStartTime = rs.getString("TIMETABLE_START_TIME");
			String totalDate = rs.getString("TOTAL_DATE");
			String placeName = rs.getString("PLACE_NAME");
			String placeImage = rs.getString("PLACE_IMAGE");
			String startDate = rs.getString("START_DATE");
			String endDate = rs.getString("END_DATE");
			String playTime = rs.getString("PLAY_TIME");
			
			TimetableVo vo = new TimetableVo();
			vo.setTimetableNo(timetableNo);
			vo.setPlaceNo(placeNo);
			vo.setSchedulerNo(sNo);
			vo.setTimetableDate(timetableDate);
			vo.setBespokePlace(bespokePlace);
			vo.setBespokeTime(bespokeTime);
			vo.setTimetableStartTime(timetableStartTime);
			vo.setTotalDate(totalDate);
			vo.setPlaceName(placeName);
			vo.setPlaceImage(placeImage);
			vo.setStartDate(startDate);
			vo.setEndDate(endDate);
			vo.setPlayTime(playTime);
			
			list.add(vo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return list;
	}
}
