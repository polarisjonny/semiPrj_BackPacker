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
		String sql = "SELECT * FROM PLACE WHERE COUNTRY_NO=? AND LOCATION_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, req.getParameter("countryNo"));
		pstmt.setString(2, req.getParameter("locationNo"));
		ResultSet rs = pstmt.executeQuery();
		//tx
		List<PlaceVo>list = new ArrayList<>();
		while(rs.next()) {
			String placeNo = rs.getString("PLACE_NO");
			String placeCategoryNo = rs.getString("LOCATION_NO");
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
			
			list.add(vo);
			
			
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		JDBCTemplate.close(conn);
		
		
		return list;
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
	
		String sql = "INSERT INTO TIMETABLE (TIMETABLE_NO,PLACE_NO,SCHEDULER_NO,TIMETABLE_DATE)VALUES(SEQ_TIMETABLE_NO.NEXTVAL,?,?,TO_TIMESTAMP(?, 'YYYY-MM-DD'))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tVo.getPlaceNo());
		pstmt.setString(2, tVo.getSchedulerNo());
		pstmt.setString(3, tVo.getTimetableDate());
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

	public List<TimetableVo> getTimetable() throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql="SELECT * FROM TIMETABLE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
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
			
			TimetableVo tVo = new TimetableVo();
			tVo.setTimetableNo(timetableNo);
			tVo.setPlaceNo(placeNo);
			tVo.setSchedulerNo(schedulerNo);
			tVo.setTimetableDate(timetableDate);
			tVo.setBespokePlace(bespokePlace);
			tVo.setTimetableStartTime(timetableStartTime);
			tVo.setBespokeTime(bespokeTime);
			
			list.add(tVo);
			
		}
		//close
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
	
		return list;
	}

	//예린추가 : 넘버로 스케쥴 따오기 =>게시글 상세조회시
	public TimetableVo getTimetable(String schedulerNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql="SELECT * FROM TIMETABLE WHERE SCHEDULER_NO =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, schedulerNo);
		ResultSet rs = pstmt.executeQuery();
		//rs
		TimetableVo tVo = null;
		while(rs.next()) {
			String timetableNo= rs.getString("TIMETABLE_NO");
			String placeNo =rs.getString("PLACE_NO");
			String timetableDate= rs.getString("TIMETABLE_DATE");
			String bespokePlace= rs.getString("BESPOKE_PLACE");
			String timetableStartTime= rs.getString("TIMETABLE_START_TIME");
			String bespokeTime= rs.getString("BESPOKE_TIME");
			
			tVo = new TimetableVo();
			tVo.setTimetableNo(timetableNo);
			tVo.setPlaceNo(placeNo);
			tVo.setSchedulerNo(schedulerNo);
			tVo.setTimetableDate(timetableDate);
			tVo.setBespokePlace(bespokePlace);
			tVo.setTimetableStartTime(timetableStartTime);
			tVo.setBespokeTime(bespokeTime);
			
		}
		//close
		JDBCTemplate.close(conn);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
	
		return tVo;
	}

}
