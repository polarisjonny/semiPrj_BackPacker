package com.bp.app.scheduler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.TimetableVo;

@WebServlet("/schedulermake/deTimetable")
public class DeTimetable extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//데이터
			String placeNo =req.getParameter("placeNo");
			String schedulerNo =req.getParameter("schedulerNo");
			String timetableDate =req.getParameter("timetableDate");
			
			TimetableVo vo = new TimetableVo();
			vo.setPlaceNo(placeNo);
			vo.setSchedulerNo(schedulerNo);
			vo.setTimetableDate(timetableDate);
			
			SchedulerService ss = new SchedulerService();
			int result = ss.deTimetable(vo);
			
			
			
		} catch (Exception e) {
			System.out.println("[ERROR] timetable삭제하다가 에러");
			e.printStackTrace();
		}
		
	
	
	}

}
