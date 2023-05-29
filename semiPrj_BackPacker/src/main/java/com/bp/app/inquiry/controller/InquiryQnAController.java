package com.bp.app.inquiry.controller;

import java.io.IOException;
import java.util.List;

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
			String QnaCategoryNo=req.getParameter("QnaCategoryNo");
			
			InquiryService is = new InquiryService();
			int cnt =  is.qnaCnt(QnaCategoryNo);
			int page=1;
			
			if(req.getParameter("page")!= null) {
				page = Integer.parseInt(req.getParameter("page"));
			}else {
				page=1;
			}
			PageVo pv = new PageVo(cnt,page,5,10);
			
			List<InquiryVo>list = is.qnaList(pv,QnaCategoryNo);
			
			
			req.setAttribute("pv", pv);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/WEB-INF/views/notice/inquiryQnA.jsp").forward(req, resp);
			
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("QNA목록 에러");
		
		}
		
		
	}//service
	
}
