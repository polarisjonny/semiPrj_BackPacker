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
		String sql="INSERT INTO GUIDE_BOARD (GUIDE_BOARD_NO,WRITER_NO,GUIDE_BOARD_CATEGORY_NO,TITLE,CONTENT,SCHEDULER_NO,ENROLL_DATE)VALUES(SEQ_GUIDE_BOARD_NO.NEXTVAL,1,?,?,?,?,SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bgVo.getGuideBoardCategoryNo());
		pstmt.setString(2, bgVo.getTitle());
		pstmt.setString(3, bgVo.getContent());
		pstmt.setString(4, bgVo.getSchedulerNo());
		
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
	
		String sql = "INSERT INTO TIMETABLE (TIMETABLE_NO,PLACE_NO,SCHEDULER_NO,TIMETABLE_DATE,TIMETABLE_START_TIME)VALUES(SEQ_TIMETABLE_NO.NEXTVAL,?,?,?,TO_TIMESTAMP(?, 'YYYY-MM-DD'))";
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
		String sql="SELECT M.TIMETABLE_NO ,M.PLACE_NO ,M.SCHEDULER_NO ,M.TIMETABLE_DATE ,M.BESPOKE_PLACE ,M.BESPOKE_TIME ,M.TIMETABLE_START_TIME ,M.PLACE_NAME ,M.PLACE_IMAGE ,M.PLACE_TIME ,S.START_DATE ,S.END_DATE FROM (SELECT T.TIMETABLE_NO ,T.PLACE_NO ,T.SCHEDULER_NO ,T.TIMETABLE_DATE ,T.BESPOKE_PLACE ,T.BESPOKE_TIME ,T.TIMETABLE_START_TIME ,P.PLACE_NAME ,P.PLACE_IMAGE ,P.PLACE_TIME FROM TIMETABLE T JOIN PLACE P ON (T.PLACE_NO = P.PLACE_NO))M JOIN SCHEDULER S ON( M.SCHEDULER_NO = S.SCHEDULER_NO) WHERE M.SCHEDULER_NO=? AND TIMETABLE_DATE=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, req.getParameter("schedulerNo"));
		pstmt.setString(2,req.getParameter("timetableDate"));
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


	public List<SchedulerVo> getScheduler(HttpServletRequest req) throws Exception {

		
		Connection conn = JDBCTemplate.getConnection();
		
		String sql="SELECT SCHEDULER_NO ,MEMBER_NO ,START_DATE ,END_DATE ,TOTAL_EXPENSE ,TO_CHAR(CAST(EXTRACT(DAY FROM (END_DATE - START_DATE))+1 AS VARCHAR2(10))) AS TOTAL_DATE FROM SCHEDULER WHERE MEMBER_NO=? AND START_DATE = TO_TIMESTAMP(?, 'YYYY-MM-DD')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,req.getParameter("memberNo"));
		pstmt.setString(2,req.getParameter("startDate"));
		ResultSet rs = pstmt.executeQuery();
		
		List<SchedulerVo> sList = new ArrayList<>();
		if(rs.next()) {
			String schedulerNo =rs.getString("SCHEDULER_NO");
			String memberNo =rs.getString("MEMBER_NO");
			String startDate =rs.getString("START_DATE");
			String endDate =rs.getString("END_DATE");
			String totalDay = rs.getString("TOTAL_DATE");
			
			SchedulerVo sVo = new SchedulerVo();
			sVo.setSchedulerNo(schedulerNo);
			sVo.setMemberNo(memberNo);
			sVo.setStartDate(startDate);
			sVo.setEndDate(endDate);
			sVo.setTotalDay(totalDay);
			
			sList.add(sVo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return sList;

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

	public int deTimetable(TimetableVo vo) throws Exception {
	
		Connection conn = JDBCTemplate.getConnection();
		
		String sql="DELETE FROM TIMETABLE WHERE PLACE_NO = ? AND SCHEDULER_NO = ? AND TIMETABLE_DATE = ? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPlaceNo());
		pstmt.setString(2, vo.getSchedulerNo());
		pstmt.setString(3, vo.getTimetableDate());
		int result = pstmt.executeUpdate();
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		
		return result;
	}

	public List<TimetableVo> totalTimetable(HttpServletRequest req) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT * FROM ( SELECT M.TIMETABLE_NO ,M.PLACE_NO ,M.SCHEDULER_NO ,M.TIMETABLE_DATE ,M.BESPOKE_PLACE ,M.BESPOKE_TIME ,M.TIMETABLE_START_TIME ,M.TOTAL_DATE ,M.MEMBER_NO ,M.START_DATE ,M.END_DATE FROM ( SELECT T.TIMETABLE_NO ,T.PLACE_NO ,T.SCHEDULER_NO ,T.TIMETABLE_DATE ,T.BESPOKE_PLACE ,T.BESPOKE_TIME ,T.TIMETABLE_START_TIME ,TO_CHAR(CAST(EXTRACT(DAY FROM (S.END_DATE - S.START_DATE))+1 AS VARCHAR2(10))) AS TOTAL_DATE ,S.MEMBER_NO ,TO_CHAR(S.START_DATE, 'yyyy-mm-dd') AS START_DATE ,TO_CHAR(S.END_DATE, 'yyyy-mm-dd') AS END_DATE FROM TIMETABLE T JOIN SCHEDULER S ON T.SCHEDULER_NO = S.SCHEDULER_NO )M WHERE M.SCHEDULER_NO=?) K JOIN PLACE P ON( K.PLACE_NO = P.PLACE_NO)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//로그인멤버도 체크할거면 AND M.MEMBER_NO=?
		pstmt.setString(1, req.getParameter("schedulerNo"));
		ResultSet rs = pstmt.executeQuery();
		List<TimetableVo> list = new ArrayList<>();
		while(rs.next()) {
			String timetableNo = rs.getString("TIMETABLE_NO");
			String placeNo = rs.getString("PLACE_NO");
			String schedulerNo = rs.getString("SCHEDULER_NO");
			String timetableDate = rs.getString("TIMETABLE_DATE");
			String bespokePlace = rs.getString("BESPOKE_PLACE");
			String bespokeTime = rs.getString("BESPOKE_TIME");
			String timetableStartTime = rs.getString("TIMETABLE_START_TIME");
			String totalDate = rs.getString("TOTAL_DATE");
			String placeName = rs.getString("PLACE_NAME");
			String placeImage = rs.getString("PLACE_IMAGE");
			String startDate = rs.getString("START_DATE");
			String endDate = rs.getString("END_DATE");
			
			TimetableVo vo = new TimetableVo();
			vo.setTimetableNo(timetableNo);
			vo.setPlaceNo(placeNo);
			vo.setSchedulerNo(schedulerNo);
			vo.setTimetableDate(timetableDate);
			vo.setBespokePlace(bespokePlace);
			vo.setBespokeTime(bespokeTime);
			vo.setTimetableStartTime(timetableStartTime);
			vo.setTotalDate(totalDate);
			vo.setPlaceName(placeName);
			vo.setPlaceImage(placeImage);
			vo.setStartDate(startDate);
			vo.setEndDate(endDate);
			
			list.add(vo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		
		
		
		return list;
	}

}
