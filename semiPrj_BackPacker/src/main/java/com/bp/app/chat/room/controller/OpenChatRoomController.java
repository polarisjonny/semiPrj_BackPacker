package com.bp.app.chat.room.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.chat.room.service.ChatService;
import com.bp.app.chat.room.vo.ChattingRoomVo;
import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideReplyVo;
import com.bp.app.member.vo.MemberVo;
@WebServlet("/chat/room/open")
public class OpenChatRoomController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String loginMemberNo = loginMember.getMemberNo();
			String chattingUser2No = null;;
			String chattingUserNo = null;
			if(req.getParameter("chattingUserNo") != null) {
				 chattingUserNo = req.getParameter("chattingUserNo");
			}else {
				 chattingUserNo = loginMember.getMemberNo();
			}
			if(req.getParameter("chattingUser2No") != null) {
				
				chattingUser2No = req.getParameter("chattingUser2No");
			}else {
				
				chattingUser2No = req.getParameter("writerNo");
			}
			System.out.println("loginMember.No"+chattingUserNo);
			System.out.println(chattingUser2No);
			String type = req.getParameter("type");
			if("new".equals(type) && chattingUserNo.equals(chattingUser2No)) {
				req.setAttribute("errorMsg", "이거 니가쓴글이야 정신차려");
				
				throw new Exception("이거 니가쓴 글이다");
			}
			String guideBoardNo = req.getParameter("guideBoardNo");
			String chattingRoomNo = null;
			if(req.getParameter("chattingRoomNo") != null) {
				
				chattingRoomNo = req.getParameter("chattingRoomNo");
			}
			
			ChattingRoomVo crv = new ChattingRoomVo();
			crv.setChattingUserNo(chattingUserNo);
			crv.setChattingUser2No(chattingUser2No);
			crv.setGuideBoardNo(guideBoardNo);
			System.out.println("USER1NO"+chattingUserNo);
			System.out.println("USER2NO"+chattingUser2No);
			System.out.println(loginMemberNo);
			ChatService cs = new ChatService();
			ChattingRoomVo vo = null;
			System.out.println("채팅방번호"+chattingRoomNo);
			if(chattingRoomNo != null) {
				crv.setChattingRoomNo(chattingRoomNo);
				vo = cs.openOldChatRoomByRoomNo(crv,loginMemberNo);
			}else {
				vo = cs.openOldChatRoom(crv,loginMemberNo);
				System.out.println("1");
				if(vo.getChattingRoomNo()==null) {
					System.out.println("2");
					System.out.println("crv"+crv);
					vo = cs.openNewChatRoom(crv,loginMemberNo);
					System.out.println("3");
					
				}
				System.out.println("4");
			}
			System.out.println(vo);
			System.out.println(loginMember);
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/chat/room.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR] chat reply error");
			e.printStackTrace();
	        req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			
		}
	}

	
}

