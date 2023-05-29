package com.bp.app.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.inquiry.service.InquiryService;
import com.bp.app.inquiry.vo.InquiryVo;
import com.google.gson.Gson;

@WebServlet("/notice/inquiryServiceAnswer")
public class InquiryServiceAnswerController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/notice/inquiryServiceAnswer.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String answer = req.getParameter("answer");
			String qnaNo = req.getParameter("qnaNo");
			
			InquiryVo vo = new InquiryVo();
			vo.setAnswer(answer);
			vo.setQnaNo(qnaNo);
			
			InquiryService is = new InquiryService();
			int result = is.answer(vo);
			
			
			if(result != 1) {
				throw new IllegalStateException();
			}
			
			resp.getWriter().write("ok");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "답변 달기 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
	}
}
