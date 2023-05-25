package com.bp.app.travelInformation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.travelInformation.service.TravelInformationService;
import com.bp.app.travelReview.vo.TravelReviewVo;

@WebServlet("/notice/travelInformationDetail")
public class TravelInformationDetail extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String infoNo = req.getParameter("infoNo");
			
			TravelInformationService tis = new TravelInformationService();
			
			TravelReviewVo vo = tis.selectOneByNo(infoNo);

			if(vo == null) {
				throw new IllegalStateException();
			}
			
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/notice/travelInformationDetail.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "여행정보 게시글 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
	}//service
	
}//class
