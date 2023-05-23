package com.bp.app.travelReview.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.travelReview.service.TravelReviewService;
import com.bp.app.travelReview.vo.TravelReviewVo;
import com.google.gson.Gson;

@WebServlet("/notice/replyList")
public class TravelReviewReplyListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			
			String infoNo = req.getParameter("infoNo");
			TravelReviewService trs = new TravelReviewService();
			List<TravelReviewVo> replyList = trs.selectReplyList(infoNo);
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(replyList);
			
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "댓글 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
		
	}//service
	
}
