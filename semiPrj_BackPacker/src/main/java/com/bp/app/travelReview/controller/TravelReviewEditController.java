package com.bp.app.travelReview.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.member.vo.MemberVo;
import com.bp.app.travelReview.service.TravelReviewService;
import com.bp.app.travelReview.vo.TravelReviewVo;

@WebServlet("/notice/reviewEdit")
public class TravelReviewEditController extends HttpServlet{

	//여행후기 게시판 수정하기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/notice/travelReviewEdit.jsp").forward(req, resp);
	
	}//doget
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			if(loginMember == null) {
				throw new IllegalStateException();
			}
			
			String infoNo = req.getParameter("infoNo");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			System.out.println(infoNo);
			
			TravelReviewVo vo = new TravelReviewVo();
			vo.setInfoNo(infoNo);
			vo.setTitle(title);
			vo.setContent(content);
			
			TravelReviewService trs = new TravelReviewService();
			int result = trs.edit(vo);
			
			PrintWriter out = resp.getWriter();
			if(result == 1) {
				out.write("ok");
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	
	}
	
}//class
