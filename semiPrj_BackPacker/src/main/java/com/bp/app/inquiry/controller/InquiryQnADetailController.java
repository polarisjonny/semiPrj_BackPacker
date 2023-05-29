package com.bp.app.inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.inquiry.service.InquiryService;
import com.bp.app.inquiry.vo.InquiryVo;

@WebServlet("/notice/inquiryQnADetail")
public class InquiryQnADetailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String qnaNo = req.getParameter("QnANo");
			
			InquiryService is = new InquiryService();
			
			InquiryVo vo = is.detail(qnaNo);
			
			if(vo !=null) {
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/WEB-INF/views/notice/inquiryQnADetail.jsp").forward(req, resp);
			}else {
				throw new IllegalStateException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "1:1문의 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
	
}
