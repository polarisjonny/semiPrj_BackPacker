package com.bp.app.travelReview.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.member.vo.MemberVo;
import com.bp.app.travelReview.service.TravelReviewService;
import com.bp.app.travelReview.vo.TravelReviewVo;

@WebServlet("/notice/report")
public class TravelReviewReportController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/notice/travelReviewReport.jsp").forward(req, resp);
	
	}//doget
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
			String infoNo = req.getParameter("infoNo");
			String content = req.getParameter("content");
			String memberNo = loginMember.getMemberNo();
			
			TravelReviewVo vo = new TravelReviewVo();
			vo.setInfoNo(infoNo);
			vo.setWriterNo(memberNo);
			vo.setContent(content);
			
			TravelReviewService trs = new TravelReviewService();
			int result = trs.report(vo);
			
			PrintWriter out = resp.getWriter();
			if(result == 1) {
				out.write("ok");
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 신고 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
	}//dopost
	
}
