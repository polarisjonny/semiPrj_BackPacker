package com.bp.app.scheduler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.PlaceVo;
import com.bp.app.scheduler.vo.SchedulerVo;
import com.bp.app.scheduler.vo.TimetableVo;

@WebServlet("/schedulerwrite")
public class SchedulerWrite extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			SchedulerService ss = new SchedulerService();
			List<TimetableVo>timetableVo = ss.totalTimetable(req);
			
			System.out.println(timetableVo);
			req.setAttribute("timetableVo", timetableVo);
			
			req.getRequestDispatcher("/WEB-INF/views/scheduler/writeScheduler.jsp").forward(req, resp);
			
		} catch (Exception e) {
			req.setAttribute("errorMsg", "동행 게시판 timtable 가져오다가 작성중 오류");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	
	}//get
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {
			
			//데이터 꺼내기
			String category = req.getParameter("category");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			//데이터 뭉치기
			GuideBoardVo bgVo = new GuideBoardVo();
			bgVo.setGuideBoardCategoryNo(category);
			bgVo.setTitle(title);
			bgVo.setContent(content);
			
			//서비스
			SchedulerService ss = new SchedulerService();
			int result = ss.gbWrite(bgVo);
			
			//화면
			if(result==1) {
				resp.sendRedirect("/semi/doPpacker/list");
			}else {
				throw new IllegalStateException("작성결과 1아님");
			}
			
		} catch (Exception e) {

			req.setAttribute("errorMsg", "동행 게시판 작성중 오류");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		
		}
		
	
	}//post
	

	
}
