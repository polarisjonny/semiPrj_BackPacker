package com.bp.app.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.inquiry.service.InquiryService;
import com.bp.app.inquiry.vo.InquiryVo;

@WebServlet("/notice/inquiryQnaAnswer")
public class InquiryQnaAnswerController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/notice/inquiryQnaAnswer.jsp").forward(req, resp);
	
	}//doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String qnaNo = req.getParameter("qnaNo");
			String answer = req.getParameter("answer");
			
			InquiryVo vo = new InquiryVo();
			vo.setQnaNo(qnaNo);
			vo.setAnswer(answer);
			
			InquiryService is = new InquiryService();
			int result = is.qnaAnswer(vo);
			
			if(result != 1) {
				throw new IllegalStateException("1:1문의 답변달기 실패");
			}
			
			resp.getWriter().write("ok");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "1:1문의 답변달기 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
		
	}//dopost
}
