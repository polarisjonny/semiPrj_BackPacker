package com.bp.app.member.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.member.service.MemberService;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데이터 꺼내기
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			//데이터 뭉치기
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPassword(password);
			
			//서비스
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			
			if(loginMember != null) {
				req.getSession().setAttribute("loginMember", loginMember);
				String root = req.getContextPath();
				resp.sendRedirect(root+"/home");
			} else {
				throw new Exception("로그인 실패");
			}
		} catch(Exception e) {
			System.out.println("[ERROR] 로그인 실패");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "로그인 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
