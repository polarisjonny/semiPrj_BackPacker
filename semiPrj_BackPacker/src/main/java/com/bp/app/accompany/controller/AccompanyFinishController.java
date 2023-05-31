package com.bp.app.accompany.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.member.vo.MemberVo;

@WebServlet ("/accompany/finish")
public class AccompanyFinishController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String boardNo = req.getParameter("no");
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			int result = gbs.finish(boardNo,loginMember);
			
			if(result==1) {
				resp.sendRedirect(req.getContextPath()+"/accompany/list?page=1");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "마감하기 중 에러발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			
		}
	}
}
