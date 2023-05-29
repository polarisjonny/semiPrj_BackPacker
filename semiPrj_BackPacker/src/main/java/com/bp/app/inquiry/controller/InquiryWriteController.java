package com.bp.app.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.inquiry.service.InquiryService;
import com.bp.app.inquiry.vo.InquiryVo;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/notice/inquiryWrite")
public class InquiryWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/notice/inquiryWrite.jsp").forward(req, resp);
		
	}//doget
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			String categoryType = req.getParameter("categoryType");
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writerNo = loginMember.getMemberNo();
			
			
			InquiryVo vo = new InquiryVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			
			InquiryService is = new InquiryService();
			
			int result = is.write(vo , categoryType);
				
			
			if(result != 1) {
				throw new IllegalStateException("문의사항 작성 실패");
			}
			
			resp.sendRedirect(req.getContextPath()+"/notice/inquiry");
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "문의사항 작성실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	
	}//service
	
}
