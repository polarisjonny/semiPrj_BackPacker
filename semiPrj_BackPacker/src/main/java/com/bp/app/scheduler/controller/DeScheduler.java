package com.bp.app.scheduler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.scheduler.service.SchedulerService;

@WebServlet("/schedulermake/deleteScheduler")
public class DeScheduler extends HttpServlet{
	
	//사용안함
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			SchedulerService ss = new SchedulerService();
			int result = ss.deScheduler(req);
			
			System.out.println(req.getParameter("schedulerNo"));
			
			if(result==1) {
				System.out.println("스케줄 번호 삭제 완료");
			}else {
				System.out.println("실패");
			}
			
			
		} catch (Exception e) {
			System.out.println("[ERROR] timetable삭제하다가 에러");
			e.printStackTrace();
			
		}
		
	
	}

}
