package com.bp.app.chat.message.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.chat.message.service.MessageService;
import com.bp.app.member.vo.MemberVo;
import com.google.gson.Gson;
@WebServlet("/chat/cnt/")
public class CountTotalNewMessage extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");

			String receiverNo = null;
			if(loginMember!=null) {
				
				receiverNo = loginMember.getMemberNo();
			}
			MessageService ms = new MessageService();
			int cnt = ms.newMessageCnt(receiverNo);
			String no = null;
			no = req.getParameter("loginMemberNo");
			if (no !=null) {
				
				Gson gson= new Gson();
				String  cnt1= gson.toJson(cnt);
				resp.setCharacterEncoding("UTF-8");
				PrintWriter out = resp.getWriter();
				out.write(cnt1);
			}
		} catch (Exception e) {
			System.out.println("[ERROR] 여행지 목록 조회에러");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "여행지 목록 조회에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
