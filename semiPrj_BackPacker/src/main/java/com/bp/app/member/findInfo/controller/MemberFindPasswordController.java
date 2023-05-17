package com.bp.app.member.findInfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.member.service.MemberService;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/member/find/password")
public class MemberFindPasswordController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/findPasswordForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			String phoneNumber = req.getParameter("phoneNumber");
			String email = req.getParameter("email");
			System.out.println(id);
			System.out.println(phoneNumber);
			System.out.println(email);
			
			MemberService ms = new MemberService();
			MemberVo tempMember = ms.findPassword(id, phoneNumber, email);
			System.out.println(tempMember.getPassword());
			System.out.println(tempMember.getNick());
			
			if(tempMember != null) {
				req.getSession().setAttribute("tempMember", tempMember);
				req.getRequestDispatcher("/WEB-INF/views/member/findPasswordResult.jsp").forward(req, resp);
			}
		} catch(Exception e) {
			System.out.println("[ERROR] 비밀번호 찾기 실패");
			e.printStackTrace();
			
			req.getRequestDispatcher("/WEB-INF/views/member/findPasswordResult.jsp").forward(req, resp);
		}
	}
}
