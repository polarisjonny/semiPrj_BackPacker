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
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.member.myPage.service.MyPageBoardService;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/member/myPage/myBoardList")
public class MemberMyBoardListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session  = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String writerNo = loginMember.getMemberNo();

			
			MyPageBoardService mpbs = new MyPageBoardService();
			int listCount = mpbs.selectCountAccompanyBoard(writerNo);
			String page = req.getParameter("page");
			if(page == null) page = "1";
			int currentPage = Integer.parseInt(req.getParameter("page"));
			int pageLimit = 5;
			int boardLimit = 8;
			PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
			List<GuideBoardVo> gvList  = mpbs.selectAccompanyBoardList(pv, writerNo);
			
			req.setAttribute("pv", pv);
			req.setAttribute("gvList", gvList);
			req.getRequestDispatcher("/WEB-INF/views/member/myBoardListForm.jsp").forward(req, resp);
			
			
		} catch(Exception e) {
			System.out.println("[ERROR] 게시글 목록 조회 중 에러 발생...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
