package com.bp.app.scheduler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.PlaceVo;

@WebServlet("/schedulermake")
public class SchedulerMake extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
//			String countryNo = req.getParameter("countryNo");
//			String locationNo = req.getParameter("locationNo");
//			
//			PlaceVo vo = new PlaceVo();
//			vo.setCountryNo(countryNo);
//			vo.setLocationNo(locationNo);
			
			
			SchedulerService ss = new SchedulerService();
			List<PlaceVo>placeList = ss.selectPlace(req);
			
//			HttpSession session = req.getSession();
//			session.setAttribute("placeList",placeList);
			
			
//			req.getSession().setAttribute("placeList", placeList);
			req.setAttribute("placeList", placeList);
			req.getRequestDispatcher("/WEB-INF/views/scheduler/makeScheduler.jsp").forward(req, resp);
			
			
		} catch (Exception e) {
			System.out.println("여행지 가져오는중 에러");
			e.printStackTrace();
			req.setAttribute("errorMsg", "여행지 가져오는중 에러 ");
			req.getRequestDispatcher("error-page").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
