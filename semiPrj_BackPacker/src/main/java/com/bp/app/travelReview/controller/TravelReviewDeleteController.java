package com.bp.app.travelReview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.member.vo.MemberVo;
import com.bp.app.travelReview.service.TravelReviewService;
import com.bp.app.travelReview.vo.TravelReviewVo;

@WebServlet("/notice/reviewDelete")
public class TravelReviewDeleteController extends HttpServlet{

	//여행후기 게시판 삭제하기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			if(loginMember == null) {
				throw new IllegalStateException("로그인을 먼저 해주세요");
			}
			
			//데이터 꺼내기
			String infoNo = req.getParameter("infoNo");
			String writerId = loginMember.getId();
			
			TravelReviewVo vo = new TravelReviewVo();
			vo.setInfoNo(infoNo);
			vo.setWriterId(writerId);
			
			//서비스
			TravelReviewService trs = new TravelReviewService();
			int result = trs.delete(vo);
			
			//화면
			if(result == 1) {
				resp.sendRedirect(req.getContextPath()+"/notice/travelReview");
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("후기 게식글 삭제 에러");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "여행후기 게시글 삭제 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	
	}
	
}
