package com.bp.app.travelReview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.common.page.PageVo;
import com.bp.app.travelReview.service.TravelReviewService;
import com.bp.app.travelReview.vo.TravelReviewVo;
import com.google.gson.Gson;

@WebServlet("/notice/review-top-hit")
public class TravelReviewTopHit extends HttpServlet{

	@Override
	//SELECT * FROM INFO_BOARD WHERE INFO_CATEGORY_NO = 1 AND DELETE_YN='N' ORDER BY HIT DESC
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			TravelReviewService trs = new TravelReviewService();
			
			
			List<TravelReviewVo> list = trs.TopHit();
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("/WEB-INF/views/notice/travelReivewList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}//dopost
	
}//class
