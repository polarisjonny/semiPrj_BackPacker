package com.bp.app.chat.room.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.chat.room.service.ChatService;
import com.bp.app.chat.room.vo.ChattingRoomVo;
import com.bp.app.member.vo.MemberVo;
@WebServlet("/chat/room/out")
public class OutChatRoomController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			
			//데꺼
			String chattingRoomNo = req.getParameter("chattingRoomNo");
			String chattingStatus =  req.getParameter("chattingStatus");
			String chattingUserNo =  req.getParameter("chattingUserNo");
			String chattingUser2No =  req.getParameter("chattingUser2No");
			System.out.println(chattingRoomNo);
			System.out.println(chattingStatus);
			System.out.println("user"+chattingUserNo);
			System.out.println(chattingUser2No);
			//데뭉
			ChattingRoomVo vo = new ChattingRoomVo();
			
			vo.setChattingRoomNo(chattingRoomNo);
			vo.setChattingStatus(chattingStatus);;
			vo.setChattingUserNo(chattingUserNo);
			vo.setChattingUser2No(chattingUser2No);
			System.out.println("login"+loginMember.getMemberNo());
			
			//서비스
			ChatService cs = new ChatService();
			int result = 0 ;
			//내가 게시판 작성자인셩우
			if(chattingUserNo.equals(loginMember.getMemberNo())) {
				
				result = cs.outMyBoardChatRoom(vo);
			}else {
				
				result = cs.outChatRoom(vo);
			}
			System.out.println(result);
			
			//화면
			PrintWriter out = resp.getWriter();
			if(result==1) {
				out.write("ok");
			}
		} catch (Exception e) {
			
			
		}
		
	}
}
