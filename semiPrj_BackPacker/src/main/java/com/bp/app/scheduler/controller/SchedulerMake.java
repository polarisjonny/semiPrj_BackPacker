package com.bp.app.scheduler.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			
			double lat=0;
			double lng=0;
			
			if("1".equals(req.getParameter("countryNo"))){
				lat = 33.4996213;
				lng = 126.5311884;
			}else if("2".equals(req.getParameter("countryNo"))) {
				lat = 34.6936;
				lng = 135.502;
			}else if("3".equals(req.getParameter("countryNo"))) {
				lat = 39.904211;
				lng = 116.407395;
			}else if("4".equals(req.getParameter("countryNo"))) {
				lat = 1.2800945;
				lng = 103.8509491;
			}else if("5".equals(req.getParameter("countryNo"))) {
				lat = 34.6936;
				lng = 135.502;
			}
			
			String counrtyNo = req.getParameter("countryNo");
			String locationNo = req.getParameter("locationNo");
			
			
			SchedulerService ss = new SchedulerService();
			List<PlaceVo>placeList = ss.selectPlace(counrtyNo,locationNo);
			
			System.out.println(placeList);
			
			req.setAttribute("lat", lat);
			req.setAttribute("lng", lng);
			req.setAttribute("placeList", placeList);
			req.getRequestDispatcher("/WEB-INF/views/scheduler/makeScheduler.jsp").forward(req, resp);
			
			
		} catch (Exception e) {
			System.out.println("여행지 가져오기 실패");
			e.printStackTrace();
			req.setAttribute("errorMsg", "여행지 가져오기 실패 ");
			req.getRequestDispatcher("error-page").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	
	}

}
