package com.bp.app.travelReview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.travelReview.service.TravelReviewService;
import com.bp.app.travelReview.vo.TravelReviewVo;

@WebServlet("/notice/travelReviewDetail")
public class TravelReviewDetailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String infoNo = req.getParameter("infoNo");
			
			
			//서비스
			TravelReviewService trs = new TravelReviewService();
			TravelReviewVo vo = trs.selectOneByNo(infoNo);
			
			//화면
			if(vo != null) {
				req.setAttribute("vo" , vo);
				req.getRequestDispatcher("/WEB-INF/views/notice/travelReviewDetail.jsp").forward(req, resp);
			}else {
				throw new Exception();
			}
			
			
		} catch (Exception e) {
			System.out.println("상세조회 에러");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "상세조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
	
}
