package com.bp.app.member.myPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.common.page.PageVo;
import com.bp.app.member.myPage.service.MyPageBoardService;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.travelReview.vo.TravelReviewVo;

@WebServlet("/member/myPage/myReviewList")
public class MemberMyReviewListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			if(loginMember == null) {
				throw new IllegalStateException("로그인 하고 오세요");
			}
			
			String memberNo = loginMember.getMemberNo();
			String page = req.getParameter("page");
			if(page == null) page = "1";
			int currentPage = Integer.parseInt(req.getParameter("page"));
			int pageLimit = 5;
			int boardLimit = 8;
			MyPageBoardService mpbs = new MyPageBoardService();
			int listCount = mpbs.selectMyReviewCount(memberNo);
			PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
			
			List<TravelReviewVo> tList = mpbs.selectMyTravelReviewList(pv, memberNo);

			
			if(tList != null) {
				req.setAttribute("pv", pv);
				req.setAttribute("tList", tList);
				req.getRequestDispatcher("/WEB-INF/views/member/myReviewListForm.jsp").forward(req, resp);
			} else {
				throw new Exception("[ERROR] 여행 후기 게시판 조회 오류");
			}
		} catch(Exception e) {
			System.out.println("[ERROR] 여행 후기 게시판 조회 오류");
			e.printStackTrace();
			req.setAttribute("errorMsg", "여행 후기 게시판 조회 오류");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
}
