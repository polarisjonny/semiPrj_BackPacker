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
import com.bp.app.member.vo.MemberVo;
import com.bp.app.scheduler.dao.SchedulerDao;
import com.bp.app.scheduler.vo.PlaceVo;
import com.bp.app.scheduler.vo.SchedulerVo;
import com.bp.app.scheduler.vo.TimetableVo;

public class SchedulerService {
	
	private final SchedulerDao dao = new SchedulerDao();

	public List<PlaceVo> selectPlace(String countryNo,String locationNo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<PlaceVo>placeList = dao.selectPlace(countryNo,locationNo,conn);
		
		JDBCTemplate.close(conn);
		
		
		
		return placeList;
	}

	public int gbWrite(GuideBoardVo bgVo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.gbWrite(bgVo,conn);
		
		JDBCTemplate.close(conn);
		
		
		return result;
	}

	public int setScheduler(SchedulerVo sVo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.setScheduler(sVo,conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int setTimetable(TimetableVo tVo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.setTimetable(conn,tVo);
	
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public List<TimetableVo> getTimetable(String scheduler , String timetableDate) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<TimetableVo>list = dao.getTimetable(scheduler,timetableDate,conn);
	
		JDBCTemplate.close(conn);
	
		return list;
	}


	public List<SchedulerVo> getScheduler(HttpServletRequest req) throws Exception {

		
		Connection conn = JDBCTemplate.getConnection();
		
		List<SchedulerVo> sList=dao.getScheduler(req,conn);
		
		
		JDBCTemplate.close(conn);
		
		return sList;

	}
	
//	//예린추가 : 넘버로 스케쥴 따오기 =>게시글 상세조회시
//	public TimetableVo getTimetable(String schedulerNo) throws Exception {
//		//conn
//		Connection conn = JDBCTemplate.getConnection();
//		//sql
//		String sql="SELECT * FROM TIMETABLE WHERE SCHEDULER_NO =?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, schedulerNo);
//		ResultSet rs = pstmt.executeQuery();
//		//rs
//		TimetableVo tVo = null;
//		while(rs.next()) {
//			String timetableNo= rs.getString("TIMETABLE_NO");
//			String placeNo =rs.getString("PLACE_NO");
//			String timetableDate= rs.getString("TIMETABLE_DATE");
//			String bespokePlace= rs.getString("BESPOKE_PLACE");
//			String timetableStartTime= rs.getString("TIMETABLE_START_TIME");
//			String bespokeTime= rs.getString("BESPOKE_TIME");
//			
//			tVo = new TimetableVo();
//			tVo.setTimetableNo(timetableNo);
//			tVo.setPlaceNo(placeNo);
//			tVo.setSchedulerNo(schedulerNo);
//			tVo.setTimetableDate(timetableDate);
//			tVo.setBespokePlace(bespokePlace);
//			tVo.setTimetableStartTime(timetableStartTime);
//			tVo.setBespokeTime(bespokeTime);
//			
//		}
//		//close
//		JDBCTemplate.close(conn);
//		JDBCTemplate.close(pstmt);
//		JDBCTemplate.close(rs);
//	
//		return tVo;
//}

	public int deTimetable(TimetableVo vo) throws Exception {
	
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.deTimetable(vo,conn);
		
		
		JDBCTemplate.close(conn);
		
		
		return result;
	}

	public List<TimetableVo> totalTimetable(HttpServletRequest req) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<TimetableVo> list = dao.totalTimetable(req,conn);
		
		
		JDBCTemplate.close(conn);
		
		
		
		
		return list;
	}

	public int updateTimetable(TimetableVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.updateTimetable(vo,conn);
		
		
		JDBCTemplate.close(conn);
		
		
		return result;
	}

	public int SetUser(TimetableVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.SetUser(vo,conn);
		
		
		JDBCTemplate.close(conn);
		
		
		
		return result;
	}

	public List<PlaceVo> search(String searchPlace, String countryNo) throws Exception {
	
		Connection conn = JDBCTemplate.getConnection();
		
		List<PlaceVo> list = dao.search(searchPlace,countryNo,conn);
		
		
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	public int deScheduler(String schedulerNo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		String sql="DELETE FROM SCHEDULER WHERE SCHEDULER_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, schedulerNo);
		int result = pstmt.executeUpdate();
		
		if(result==1) {
			System.out.println("삭제");
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return result;
	}

}
