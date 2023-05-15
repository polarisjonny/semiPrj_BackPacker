package com.bp.app.member.quit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.member.service.MemberService;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/member/quit")
public class MemberQuitController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			
			MemberService ms = new MemberService();
			int result = ms.quit(vo);
			
			if(result == 1) {
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath()+"/home");
			} else {
				throw new Exception("[ERROR] 회원탈퇴 실패");
			}
		} catch(Exception e) {
			System.out.println("[ERROR] 회원탈퇴 실패");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원탈퇴 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
