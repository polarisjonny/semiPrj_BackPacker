package com.bp.app.scheduler.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.scheduler.vo.PlaceVo;
import com.bp.app.scheduler.vo.SchedulerVo;
import com.bp.app.scheduler.vo.TimetableVo;

public class SchedulerService {

	public List<PlaceVo> selectPlace(HttpServletRequest req) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql = "SELECT * FROM PLACE WHERE COUNTRY_NO= ? AND LOCATION_NO= ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, req.getParameter("countryNo"));
		pstmt.setString(2, req.getParameter("locationNo"));
		ResultSet rs = pstmt.executeQuery();
		//tx
		List<PlaceVo>placeList = new ArrayList<>();

		
		while(rs.next()) {
			
			String placeNo = rs.getString("PLACE_NO");
			String placeCategoryNo = rs.getString("PLACE_CATEGORY_NO");
			String countryNo = rs.getString("COUNTRY_NO");
			String locationNo = rs.getString("LOCATION_NO");
			String placeName = rs.getString("PLACE_NAME");
			String placeIntroduce = rs.getString("PLACE_INTRODUCE");
			String placeImage = rs.getString("PLACE_IMAGE");
			String placeLat = rs.getString("PLACE_LAT");
			String placeLng = rs.getString("PLACE_LNG");
			String placeTime = rs.getString("PLACE_TIME");
			String placeExpense = rs.getString("PLACE_EXPENSE");
			
			PlaceVo vo = new PlaceVo();
			
			vo.setPlaceNo(placeNo);
			vo.setPlaceCategoryNo(placeCategoryNo);
			vo.setCountryNo(countryNo);
			vo.setLocationNo(locationNo);
			vo.setPlaceName(placeName);
			vo.setPlaceIntroduce(placeIntroduce);
			vo.setPlaceImage(placeImage);
			vo.setPlaceLat(placeLat);
			vo.setPlaceLng(placeLng);
			vo.setPlaceTime(placeTime);
			vo.setPlaceExpense(placeExpense);
			
			placeList.add(vo);
			
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		JDBCTemplate.close(conn);
		
		
		
		return placeList;
	}

	public int gbWrite(GuideBoardVo bgVo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql="INSERT INTO GUIDE_BOARD (GUIDE_BOARD_NO,WRITER_NO,GUIDE_BOARD_CATEGORY_NO,TITLE,CONTENT,ENROLL_DATE)VALUES(SEQ_GUIDE_BOARD_NO.NEXTVAL,1,?,?,?,SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bgVo.getGuideBoardCategoryNo());
		pstmt.setString(2, bgVo.getTitle());
		pstmt.setString(3, bgVo.getContent());
		
		System.out.println(bgVo.getTitle());
		int result = pstmt.executeUpdate();
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		
		
		return result;
	}

	public int setScheduler(SchedulerVo sVo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql="INSERT INTO SCHEDULER (SCHEDULER_NO,MEMBER_NO,START_DATE,END_DATE)VALUES(SEQ_SCHEDULER_NO.NEXTVAL,1,TO_TIMESTAMP(?, 'YYYY-MM-DD'),TO_TIMESTAMP(?, 'YYYY-MM-DD'))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(0, sVo.getMemberNo());  ==1
		pstmt.setString(1, sVo.getStartDate());
		pstmt.setString(2, sVo.getEndDate());
		int result = pstmt.executeUpdate();
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		

		
		
		
		return result;
	}

	public int setTimetable(TimetableVo tVo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
	
		String sql = "INSERT INTO TIMETABLE (TIMETABLE_NO,PLACE_NO,SCHEDULER_NO,TIMETABLE_DATE,TIMETABLE_START_TIME)VALUES(SEQ_TIMETABLE_NO.NEXTVAL,?,?,TO_TIMESTAMP(?, 'YYYY-MM-DD'),TO_TIMESTAMP(?, 'YYYY-MM-DD'))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tVo.getPlaceNo());
		pstmt.setString(2, tVo.getSchedulerNo());
		pstmt.setString(3, tVo.getTimetableDate());
		pstmt.setString(4, tVo.getTimetableStartTime());
		
		int result = pstmt.executeUpdate();
		
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);	
		
		return result;
		
	}

	public List<TimetableVo> getTimetable(HttpServletRequest req) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql="SELECT M.TIMETABLE_NO ,M.PLACE_NO ,M.SCHEDULER_NO ,M.TIMETABLE_DATE ,M.BESPOKE_PLACE ,M.BESPOKE_TIME ,M.TIMETABLE_START_TIME ,M.PLACE_NAME ,M.PLACE_IMAGE ,M.PLACE_TIME ,S.START_DATE ,S.END_DATE FROM (SELECT T.TIMETABLE_NO ,T.PLACE_NO ,T.SCHEDULER_NO ,T.TIMETABLE_DATE ,T.BESPOKE_PLACE ,T.BESPOKE_TIME ,T.TIMETABLE_START_TIME ,P.PLACE_NAME ,P.PLACE_IMAGE ,P.PLACE_TIME FROM TIMETABLE T JOIN PLACE P ON (T.PLACE_NO = P.PLACE_NO))M JOIN SCHEDULER S ON( M.SCHEDULER_NO = S.SCHEDULER_NO) WHERE M.SCHEDULER_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, req.getParameter("schedulerNo"));
		ResultSet rs = pstmt.executeQuery();
		//rs
		List<TimetableVo> list = new ArrayList<>();
		while(rs.next()) {
			String timetableNo= rs.getString("TIMETABLE_NO");
			String placeNo =rs.getString("PLACE_NO");
			String schedulerNo= rs.getString("SCHEDULER_NO");
			String timetableDate= rs.getString("TIMETABLE_DATE");
			String bespokePlace= rs.getString("BESPOKE_PLACE");
			String timetableStartTime= rs.getString("TIMETABLE_START_TIME");
			String bespokeTime= rs.getString("BESPOKE_TIME");
			String placeName = rs.getString("PLACE_NAME");
			String palceImage = rs.getString("PLACE_IMAGE");
			String palceTime = rs.getString("PLACE_TIME");
			String startDate = rs.getString("START_DATE");
			String endDate = rs.getString("END_DATE");
			
			TimetableVo tVo = new TimetableVo();
			tVo.setTimetableNo(timetableNo);
			tVo.setPlaceNo(placeNo);
			tVo.setSchedulerNo(schedulerNo);
			tVo.setTimetableDate(timetableDate);
			tVo.setBespokePlace(bespokePlace);
			tVo.setTimetableStartTime(timetableStartTime);
			tVo.setBespokeTime(bespokeTime);
			tVo.setPlaceName(placeName);
			tVo.setPlaceImage(palceImage);
			tVo.setPlaceTime(palceTime);
			tVo.setStartDate(startDate);
			tVo.setEndDate(endDate);
			
			list.add(tVo);
			
		}
		//close
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
	
		return list;
	}


	public List<SchedulerVo> getScheduler(SchedulerVo sVo) throws Exception {

		
		Connection conn = JDBCTemplate.getConnection();
		
		String sql="SELECT SCHEDULER_NO ,MEMBER_NO ,START_DATE ,END_DATE ,TOTAL_EXPENSE ,TO_CHAR(CAST(EXTRACT(DAY FROM (END_DATE - START_DATE))+1 AS VARCHAR2(10))) AS TOTAL_DATE FROM SCHEDULER WHERE MEMBER_NO=? AND START_DATE = TO_TIMESTAMP(?, 'YYYY-MM-DD')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sVo.getMemberNo());
		pstmt.setString(2, sVo.getStartDate());
		ResultSet rs = pstmt.executeQuery();
		
		List<SchedulerVo> sList = new ArrayList<>();
		if(rs.next()) {
			String schedulerNo =rs.getString("SCHEDULER_NO");
			String memberNo =rs.getString("MEMBER_NO");
			String startDate =rs.getString("START_DATE");
			String endDate =rs.getString("END_DATE");
			String totalDay = rs.getString("TOTAL_DATE");
			
			sVo.setSchedulerNo(schedulerNo);
			sVo.setMemberNo(memberNo);
			sVo.setStartDate(startDate);
			sVo.setEndDate(endDate);
			sVo.setTotalDay(totalDay);
			
			sList.add(sVo);
			
		}
	
		
		return sList;

	}

}
