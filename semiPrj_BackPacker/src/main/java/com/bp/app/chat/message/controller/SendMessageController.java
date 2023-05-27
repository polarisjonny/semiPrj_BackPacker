package com.bp.app.chat.message.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.chat.message.service.MessageService;
import com.bp.app.chat.message.vo.MessageVo;
import com.bp.app.chat.room.service.ChatService;
import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideReplyVo;
import com.bp.app.member.vo.MemberVo;
@WebServlet("/chat/room/send")
public class SendMessageController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String writerNo = loginMember.getMemberNo();
			
			
			//데꺼
//			String guideBoardNo = req.getParameter("guideBoardNo");
			String chattingRoomNo = req.getParameter("chattingRoomNo");
			String chattingUserNo = req.getParameter("chattingUserNo");
			String chattingUser2No = req.getParameter("chattingUser2No");
			String content =  req.getParameter("content");
			String senderNo =  req.getParameter("writerNo");
			System.out.println(content);
			System.out.println(chattingRoomNo);
			//데뭉
			MessageVo vo = new MessageVo();
			if(writerNo.equals(chattingUserNo)) {
				vo.setReceiverNo(chattingUser2No);
				vo.setSenderNo(chattingUserNo);
			}else {
				vo.setReceiverNo(chattingUserNo);
				vo.setSenderNo(chattingUser2No);
			}
			
			vo.setContent(content);
			vo.setChattingRoomNo(chattingRoomNo);
			
			
			//서비스
			MessageService ms = new MessageService();
			int result = ms.sendMessage(vo);
			
			//화면
			PrintWriter out = resp.getWriter();
			if(result==1) {
				out.write("ok");
			}
		} catch (Exception e) {
			
			
		}
		
	}
}
