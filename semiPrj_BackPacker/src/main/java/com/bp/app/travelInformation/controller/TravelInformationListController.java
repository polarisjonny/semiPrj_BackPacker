package com.bp.app.travelInformation.controller;

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
import com.bp.app.travelInformation.service.TravelInformationService;
import com.bp.app.travelReview.vo.TravelReviewVo;

@WebServlet("/notice/travelInformation")
public class TravelInformationListController extends HttpServlet{

	private final TravelInformationService tis = new TravelInformationService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			//데이터 뭉치기
			int listCnt = tis.selectCnt(searchType , searchValue);
			String page = req.getParameter("page");
			if(page == null) {
				page = "1";
			}
			int currentPage = Integer.parseInt(page);
			int pageLimit = 5;
			int boardLimit = 4;
			
			PageVo pv = new PageVo(listCnt, currentPage, pageLimit, boardLimit);
			
			List<TravelReviewVo> tiList = null;
			if(searchType == null || searchType.equals("")) {
				tiList = tis.selectList(pv);
			}else {
				tiList = tis.selectList(pv,searchType , searchValue);
			}
			
			Map<String,String> map = new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pv);
			req.setAttribute("tiList", tiList);
			req.getRequestDispatcher("/WEB-INF/views/notice/travelInformation.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "여행정보 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	
	}//doget
	
}
