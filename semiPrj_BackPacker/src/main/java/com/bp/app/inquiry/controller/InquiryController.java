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

@WebServlet("/notice/inquiry")
public class InquiryController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			InquiryService qs = new InquiryService();
			List<InquiryVo>list = qs.getTotalList();
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("/WEB-INF/views/notice/inquiry.jsp").forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("qna리스트에러");
		
		}
		
	}
	
}
