package com.bp.app.travelReview.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.travelReview.service.TravelReviewService;

@WebServlet("/notice/delete")
public class TravelReviewReplyDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String replyNo = req.getParameter("replyNo");
			
			TravelReviewService trs = new TravelReviewService();
			int result = trs.deleteReply(replyNo);
			
			if(result != 1) {
				throw new Exception();
			}
			
			PrintWriter out = resp.getWriter();
			out.write("ok");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "댓글삭제실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	
		
		
	}//service
	
}
