package com.bp.app.member.join.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.member.service.MemberService;
import com.google.gson.Gson;

@WebServlet("/member/join/checkNick")
public class NickCheckController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String nick = req.getParameter("nick");
			System.out.println(nick);
			MemberService ms = new MemberService();
			boolean result = ms.checkNick(nick);
			System.out.println(result);
			
			Gson gson = new Gson();
			
			
			if(result == true) {
				String str = gson.toJson(result);
				resp.setContentType("application/x-json; charset=utf-8");
				resp.getWriter().print(str); 
			} else {
				String str = gson.toJson(result);
				resp.setContentType("application/x-json; charset=utf-8");
				resp.getWriter().print(str); 
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("아이디 중복체크 실패");
			req.setAttribute("errorMsg", "아이디 중복 확인 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	
	}
}
