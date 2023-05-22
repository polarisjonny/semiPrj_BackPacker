package com.bp.app.travelReview.controller;

import java.io.IOException;
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
import com.bp.app.util.file.AttachmentVo;

@WebServlet("/notice/travelReview")
public class TravelReviewListController extends HttpServlet{

	
	private final TravelReviewService trs = new TravelReviewService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			//데이터 뭉치기
			int listCnt = trs.selectCnt();
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
				trList = trs.selectReviewList(pv);
			}else {
				trList = trs.selectReviewList(pv , searchType, searchValue);
			}
			
			Map<String,String> map = new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			
			//화면
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pv);
			req.setAttribute("trList", trList);
			req.getRequestDispatcher("/WEB-INF/views/notice/travelReviewList.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("errorMsg", "리뷰 조회 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			e.printStackTrace();
		}
	
	}
	
	
	
}
