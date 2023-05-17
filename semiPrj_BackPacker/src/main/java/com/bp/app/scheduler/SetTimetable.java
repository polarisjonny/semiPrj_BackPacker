package com.bp.app.scheduler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.TimetableVo;
import com.google.gson.Gson;

@WebServlet("/schedulermake/setTimetable")
public class SetTimetable extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			
			//데꺼
			String placeNo = req.getParameter("placeNo");
			String SchedulerNo = req.getParameter("schedulerNo");
			String timetableDate = req.getParameter("timetableDate");
			String timetableStartTime = req.getParameter("timetableStartTime");
			
			//데뭉
			TimetableVo tVo = new TimetableVo();
			tVo.setPlaceNo(placeNo);
			tVo.setSchedulerNo(SchedulerNo);
			tVo.setTimetableDate(timetableDate);
			tVo.setTimetableStartTime(timetableStartTime);
			
			//서비스
			
			SchedulerService ss = new SchedulerService();
			int result = ss.setTimetable(tVo);
			
//			Gson gson = new Gson();
//			String jsonTVo = gson.toJson(tVo);
//			
//			//문자열 내보내기
//			resp.setCharacterEncoding("UTF-8");
//			PrintWriter out = resp.getWriter();
//			out.write(jsonTVo);
			
			
			//화면
			
		} catch (Exception e) {
			System.out.println("error setScheduler 에러");
			e.printStackTrace();		}
	
	}

}
