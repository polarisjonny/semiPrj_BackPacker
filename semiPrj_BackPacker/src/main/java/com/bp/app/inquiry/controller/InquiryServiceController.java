package com.bp.app.inquiry.controller;

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
import com.bp.app.inquiry.service.InquiryService;
import com.bp.app.inquiry.vo.InquiryVo;

@WebServlet("/notice/inquiryService")
public class InquiryServiceController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			InquiryService is = new InquiryService();
			int listCnt = is.ServiceCnt(searchValue);
			String page = req.getParameter("page");
			if(page == null) {
				page ="1";
			}
			int currentPage = Integer.parseInt(page);
			int pageLimit = 5;
			int boardLimit = 10;
			
			PageVo pv = new PageVo(listCnt, currentPage, pageLimit, boardLimit);
			
			List<InquiryVo> list = null;
			if(searchType == null || searchType.equals("")) {
				list = is.ServiceList(pv);
			}else {
				list = is.ServiceList(pv,searchType,searchValue);
			}
			
			Map<String,String> map = new HashMap<>();
			map.put("searchValue", searchValue);
			map.put("searchType", searchType);
			
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pv);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/WEB-INF/views/notice/inquiryService.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "FAQ게시판 페이징처리실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	
	}//service
	
}
