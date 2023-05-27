package com.bp.app.admin.boardManage.controller;

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

import com.bp.app.admin.boardManage.service.BoardManageService;
import com.bp.app.admin.boardManage.vo.GuideReportVo;
import com.bp.app.admin.boardManage.vo.InfoBoardReportVo;
import com.bp.app.common.page.PageVo;
@WebServlet("/admin/reviewInfoBoard/report")
public class ReviewInfoBoardReportDetailController extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			BoardManageService bs = new BoardManageService();
			String selectReviewInfoBoardNo = req.getParameter("selectReviewInfoBoardNo");
			
			//서비스
			int cnt = bs.getReviewInfoBoardReportDetailCnt(searchType, searchValue ,selectReviewInfoBoardNo );
			int page = 1;
			if(req.getParameter("page") != null) {
				
				page = Integer.parseInt(req.getParameter("page"));
			}else {
				page = 1;
			}
			PageVo pv = new PageVo(cnt, page, 5, 3);
			List<InfoBoardReportVo> voList = null;
			if(searchType == null || searchType.equals("")) {
				
				voList = bs.getReviewInfoBoardReportDetail(pv,selectReviewInfoBoardNo);
			}else {
				voList = bs.getReviewInfoBoardReportDetail(pv,searchType, searchValue,selectReviewInfoBoardNo);
			}
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType",searchType);
			map.put("searchValue",searchValue);
			//화면
			req.setAttribute("pv", pv);
			req.setAttribute("voList", voList);
			req.setAttribute("searchVo", map);
			req.setAttribute("selectReviewInfoBoardNo", selectReviewInfoBoardNo);
			req.getRequestDispatcher("/WEB-INF/views/admin/report/reviewInfoBoard-report-detail.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR] 게시글 목록 조회에러");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "목록조회실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
		
		
}
