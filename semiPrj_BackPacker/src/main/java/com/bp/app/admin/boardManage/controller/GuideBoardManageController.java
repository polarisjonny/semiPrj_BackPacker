package com.bp.app.admin.boardManage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.admin.boardManage.service.BoardManageService;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.vo.GuideBoardVo;
@WebServlet("/admin/guideBoard")
public class GuideBoardManageController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			BoardManageService bs = new BoardManageService();
			//서비스
			int cnt = bs.getGuideBoardListCnt(searchType, searchValue );
			int page = 1;
			if(req.getParameter("page") != null) {
				
				page = Integer.parseInt(req.getParameter("page"));
			}else {
				page = 1;
			}
			PageVo pv = new PageVo(cnt, page, 5, 5);
			List<GuideBoardVo> voList = null;
			if(searchType == null || searchType.equals("")) {
				
				voList = bs.getGuideBoardList(pv);
			}else {
				
				voList = bs.getGuideBoardList(pv,searchType, searchValue);
			}
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType",searchType);
			map.put("searchValue",searchValue);
			//화면
			req.setAttribute("pv", pv);
			req.setAttribute("voList", voList);
			req.setAttribute("searchVo", map);
			req.getRequestDispatcher("/WEB-INF/views/admin/report/guideBoard-report-list.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR] 동행,가이드 게시판 목록 조회 실패");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "동행,가이드 게시판 목록  조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
		
	}
}
