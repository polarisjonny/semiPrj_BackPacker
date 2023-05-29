package com.bp.app.travelReview.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			//데이터 뭉치기
			int listCnt = trs.selectCnt(searchType , searchValue);
			String page = req.getParameter("page");
			if(page == null) {
				page = "1";
			}
			int currentPage = Integer.parseInt(page);
			int pageLimit = 5;
			int boardLimit = 4;
			
			PageVo pv = new PageVo(listCnt, currentPage, pageLimit, boardLimit);
			
			//서비스
			List<TravelReviewVo> trList = null;
			if(searchType == null || searchType.equals("")) {
				trList = trs.TopHit(pv);
			}else {
				trList = trs.TopHit(pv , searchType, searchValue);
			}
			
			Map<String,String> map = new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			
			//화면
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pv);
			req.setAttribute("trList", trList);
			req.getRequestDispatcher("/WEB-INF/views/notice/travelReviewListHit.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}//dopost
	
}//class
