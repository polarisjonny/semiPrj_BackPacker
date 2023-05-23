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

@WebServlet("/notice/replyWrite")
public class TravelReviewReplyWriteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			String writerNo = loginMember.getMemberNo();
			String content = req.getParameter("content");
			String infoNo = req.getParameter("infoNo");
			
			TravelReviewVo replyVo = new TravelReviewVo();
			replyVo.setWriterNo(writerNo);
			replyVo.setContent(content);
			replyVo.setInfoNo(infoNo);
			
			TravelReviewService trs = new TravelReviewService();
			int result = trs.replyWrite(replyVo);
			
			PrintWriter out = resp.getWriter();
			if(result == 1) {
				out.write("ok");
			}else {
				throw new Exception("댓글작성 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "댓글 작성 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
		
		
		
	}//service
	
}
