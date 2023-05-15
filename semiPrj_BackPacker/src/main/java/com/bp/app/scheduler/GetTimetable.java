package com.bp.app.scheduler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.TimetableVo;
import com.google.gson.Gson;

@WebServlet("/schedulermake/getTimetable")
public class GetTimetable extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//데이터 
			//서비스
			SchedulerService ss = new SchedulerService();
			List<TimetableVo>list =  ss.getTimetable();
			
			//자바객체를 JSON 형태의 문자열로 변환
			Gson gson = new Gson();
			String jsonStr = gson.toJson(list);
			
			//문자열 내보내기
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
			
			
			
		} catch (Exception e) {
			System.out.println("[ERROR] timetable가져오다가 에러");
			e.printStackTrace();
		}
		
	
	}
	
	
}
