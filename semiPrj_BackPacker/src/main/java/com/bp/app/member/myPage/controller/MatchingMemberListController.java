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
import com.bp.app.member.myPage.matchingMemberService.MyPageMatchingMemberService;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/member/myPage/matchingMemberList")
public class MatchingMemberListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session  = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String memberNo = loginMember.getMemberNo();

			MyPageMatchingMemberService mpms = new MyPageMatchingMemberService();
			int listCount = mpms.selectMatchingMemberCount(memberNo);
			String page = req.getParameter("page");
			if(page == null) page = "1";
			
			int currentPage = Integer.parseInt(req.getParameter("page"));
			int pageLimit = 5;
			int boardLimit = 8;
			PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
			List<MemberVo> matchingList = mpms.selectMatchingMemberListForPage(pv, memberNo);
			
			if(matchingList != null) {
				req.setAttribute("pv", pv);
				req.setAttribute("matchingList", matchingList);
				req.getRequestDispatcher("/WEB-INF/views/member/matchingMemberListForm.jsp").forward(req, resp);
			} else {
				req.setAttribute("alertMsg", "매칭 완료된 회원이 없습니다.");
				req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			}
		} catch(Exception e) {
			System.out.println("[ERROR] 매칭 완료된 회원 목록 조회 실패");
			e.printStackTrace();
			req.setAttribute("alertMsg", "매칭 완료된 회원 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
