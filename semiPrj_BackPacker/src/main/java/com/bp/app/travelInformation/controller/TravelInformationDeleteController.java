package com.bp.app.travelInformation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.travelInformation.service.TravelInformationService;

@WebServlet("/notice/informationDelete")
public class TravelInformationDeleteController extends HttpServlet{

	//여행정보 게시판 삭제
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String infoNo = req.getParameter("infoNo");
			
			System.out.println(infoNo);
			TravelInformationService tis = new TravelInformationService();
			int result = tis.del(infoNo);
			
			if(result != 1) {
				throw new IllegalStateException();
			}
			
			resp.sendRedirect(req.getContextPath()+"/notice/travelInformation");
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "여행정보 삭제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);		}
		
	}//doget
	
}
