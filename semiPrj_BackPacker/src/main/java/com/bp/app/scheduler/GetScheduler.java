package com.bp.app.scheduler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.SchedulerVo;
import com.bp.app.scheduler.vo.TimetableVo;
import com.google.gson.Gson;

@WebServlet("/schedulermake/getScheduler")
public class GetScheduler extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String memberNo =  req.getParameter("memberNo");
			String startDate =  req.getParameter("startDate");
			
			SchedulerVo sVo = new SchedulerVo();
			sVo.setMemberNo(memberNo);
			sVo.setStartDate(startDate);
			
			SchedulerService ss = new SchedulerService();
			List<SchedulerVo> sList = ss.getScheduler(sVo);
			
			System.out.println(sList);
			//자바객체를 JSON 형태의 문자열로 변환
			Gson gson = new Gson();
			String sjsonStr = gson.toJson(sList);
			
			//문자열 내보내기
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(sjsonStr);
			
//			HttpSession session = req.getSession();
//			session.setAttribute("scheduler", sjsonStr);
			
			
			
		} catch (Exception e) {
			System.out.println("[ERROR] scheduler가져오다가 에러");
			e.printStackTrace();
		}
	
	
	}
}
