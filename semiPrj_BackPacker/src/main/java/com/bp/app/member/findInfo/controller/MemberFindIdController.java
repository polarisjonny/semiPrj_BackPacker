package com.bp.app.member.findInfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.member.service.MemberService;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/member/find/id")
public class MemberFindIdController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/findIdForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데이터 꺼내기
			String name = req.getParameter("name");
			String phoneNumber = req.getParameter("phoneNumber");
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String no = loginMember.getMemberNo();
			String loginName = loginMember.getName();
			String loginPhoneNumber = loginMember.getPhoneNumber();
			
			
			if(!name.equals(loginName) || !phoneNumber.equals(loginPhoneNumber)) {
				req.getSession().setAttribute("errorMsg", "아이디 찾기 실패");
				req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
				
				return;
			}
			
			
		} catch(Exception e) {
			
		}
		
	}
}
