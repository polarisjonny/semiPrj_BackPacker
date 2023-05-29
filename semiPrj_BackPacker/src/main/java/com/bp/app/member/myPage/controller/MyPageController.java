package com.bp.app.member.myPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.member.myPage.matchingMemberService.MyPageMatchingMemberService;
import com.bp.app.member.myPage.service.MyPageBoardService;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/member/myPage")
public class MyPageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			if(loginMember == null) {
				throw new IllegalStateException("로그인 하고 오세요");
			}
			
			//내가 작성한 글 보기 
			String memberNo = loginMember.getMemberNo();
			MyPageBoardService mpbs = new MyPageBoardService();
			List<GuideBoardVo> gbList = mpbs.selectGuideBoardList(memberNo);
			
			
			//매칭 완료된 회원 목록 가져오기
			MyPageMatchingMemberService mpms = new MyPageMatchingMemberService();
			List<MemberVo> matchingList = mpms.selectMatchingMemberList(memberNo);
			MemberVo vo = matchingList.get(0);
			System.out.println(vo.getProfileImage());
			
			
			System.out.println(gbList);
			if(gbList != null && matchingList != null) {
				req.setAttribute("gbList", gbList);
				req.setAttribute("matchingList", matchingList);
				req.getRequestDispatcher("/WEB-INF/views/member/myPageForm.jsp").forward(req, resp);
			} else {
				throw new Exception("[ERROR] 마이 페이지 작성한 글 목록 불러오기 중 오류 발생...");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] 내가 작성한 글 목록 오류");
			req.setAttribute("errorMsg", "작성한 글 목록 불러오는 중 오류 발생함, 다시 이용해주세요...");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
