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
import com.bp.app.common.page.PageVo;
@WebServlet("/admin/guideBoard/report")
public class GuideBoardReportDetailController extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			BoardManageService bs = new BoardManageService();
			String selectGuideBoardNo = req.getParameter("selectGuideBoardNo");
			
			//서비스
			int cnt = bs.getGuideBoardReportDetailCnt(searchType, searchValue ,selectGuideBoardNo );
			int page = 1;
			if(req.getParameter("page") != null) {
				
				page = Integer.parseInt(req.getParameter("page"));
			}else {
				page = 1;
			}
			PageVo pv = new PageVo(cnt, page, 5, 3);
			List<GuideReportVo> voList = null;
			if(searchType == null || searchType.equals("")) {
				
				voList = bs.getGuideBoardReportDetail(pv,selectGuideBoardNo);
			}else {
				voList = bs.getGuideBoardReportDetail(pv,searchType, searchValue,selectGuideBoardNo);
			}
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType",searchType);
			map.put("searchValue",searchValue);
			//화면
			req.setAttribute("pv", pv);
			req.setAttribute("voList", voList);
			req.setAttribute("searchVo", map);
			req.setAttribute("selectGuideBoardNo", selectGuideBoardNo);
			req.getRequestDispatcher("/WEB-INF/views/admin/report/guideBoard-report-detail.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR] 게시글 목록 조회에러");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "목록조회실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
		
		
}
