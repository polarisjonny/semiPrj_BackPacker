package com.bp.app.member.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.member.service.MemberService;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLogincontroller extends HttpServlet {

	//로그인
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login-form.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			//데꺼
			String id = req.getParameter("memberId");
			String password = req.getParameter("memberPwd");
			
			//데뭉
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPassword(password);
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			HttpSession session = req.getSession();
			session.invalidate();
			//화면
			if(loginMember != null) {
				req.getSession().removeAttribute("selectMember");
				req.getSession().removeAttribute("selectMemberReviewlist");
				req.getSession().setAttribute("loginMember", loginMember);
				String root = req.getContextPath();
				resp.sendRedirect(root + "/home");
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			System.out.println("[ERROR] login fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "로그인 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
	
	
	
}//class