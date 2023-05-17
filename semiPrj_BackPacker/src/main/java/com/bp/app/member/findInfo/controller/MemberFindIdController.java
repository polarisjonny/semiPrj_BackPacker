package com.bp.app.member.findInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
			
			MemberService ms = new MemberService();
			MemberVo tempMember = ms.findId(name, phoneNumber);
			System.out.println(tempMember.getId());
			System.out.println(tempMember.getNick());
			
			if(tempMember != null) {
				req.getSession().setAttribute("tempMember", tempMember);
				req.getRequestDispatcher("/WEB-INF/views/member/findIdResult.jsp").forward(req, resp);
			}
		} catch(Exception e) {
			System.out.println("[ERROR] 아이디 찾기 실패");
			e.printStackTrace();
			
			req.getRequestDispatcher("/WEB-INF/views/member/findIdResult.jsp").forward(req, resp);
		
		}
	}
}
