package com.bp.app.scheduler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.TimetableVo;

@WebServlet("/schedulermake/userTimetable")
public class UserTimetable extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//데꺼
			String placeNo = req.getParameter("placeNo");
			String schedulerNo = req.getParameter("schedulerNo");
			String timetableDate = req.getParameter("timetableDate");
			String bespokePlace = req.getParameter("bespokePlace");
			String playTime = req.getParameter("timetableStartTime");
			
			TimetableVo vo = new TimetableVo();
			vo.setPlaceNo(placeNo);
			vo.setSchedulerNo(schedulerNo);
			vo.setTimetableDate(timetableDate);
			vo.setBespokePlace(bespokePlace);
			vo.setTimetableStartTime(playTime);
			
			
			SchedulerService ss = new SchedulerService();
			int result = ss.SetUser(vo);
			
			
			if(result!=1) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("사용자 insert 하다가 오류 ");
		}
		
		
		
	
	}

}
