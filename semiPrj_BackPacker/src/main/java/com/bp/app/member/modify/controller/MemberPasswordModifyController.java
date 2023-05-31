package com.bp.app.member.modify.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.member.service.MemberService;
import com.bp.app.member.vo.MemberVo;

@WebServlet("/member/modify/password")
public class MemberPasswordModifyController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/modifyPasswordForm.jsp").forward(req, resp);
	}
	
	//비밀번호 변경 기능
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데이터 꺼내기
			String password = req.getParameter("changePassword");
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String memberNo = loginMember.getMemberNo();
			
			MemberService ms = new MemberService();
			MemberVo updatedMember = ms.changePassword(memberNo, password);
			
			if(updatedMember != null) {
				req.getSession().setAttribute("loginMember", updatedMember);
				resp.sendRedirect(req.getContextPath()+"/member/myPage");
			} else {
				throw new Exception("[ERROR] 비밀번호 변경 실패");
			}
		} catch(Exception e) {
			System.out.println("[ERROR] 비밀번호 변경 실패");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "비밀번호 변경 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
}
