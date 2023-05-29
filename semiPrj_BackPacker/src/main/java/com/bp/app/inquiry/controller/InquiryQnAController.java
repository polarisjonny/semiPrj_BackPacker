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

@WebServlet("/notice/inquiryQnA")
public class InquiryQnAController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			String searchValue = req.getParameter("searchValue");
			String searchType = req.getParameter("searchType");
			
			
			InquiryService is = new InquiryService();
			int cnt =  is.qnaCnt(searchValue);
			int page=1;
			
			if(req.getParameter("page")!= null) {
				page = Integer.parseInt(req.getParameter("page"));
			}else {
				page=1;
			}
			PageVo pv = new PageVo(cnt,page,5,10);
			
			List<InquiryVo> list = null;
			if(searchType == null || searchType.equals("")) {
				list = is.qnaList(pv);
			}else {
				list = is.qnaList(pv,searchType,searchValue);
			}
			
			Map<String,String> map = new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pv);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/WEB-INF/views/notice/inquiryQnA.jsp").forward(req, resp);
			
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("QNA목록 에러");
		
		}
		
		
	}//service
	
}
