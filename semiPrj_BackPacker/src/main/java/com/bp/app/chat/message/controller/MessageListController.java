package com.bp.app.chat.message.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.chat.message.service.MessageService;
import com.bp.app.chat.message.vo.MessageVo;
import com.bp.app.chat.room.service.ChatService;
import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideReplyVo;
import com.google.gson.Gson;
@WebServlet("/chat/room/send/list")
public class MessageListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데꺼
			String chattingRoomNo = req.getParameter("chattingRoomNo");
			
			//서비스
			MessageService ms = new MessageService();
			List<MessageVo>list =ms.selecMessageList(chattingRoomNo);
			
			Gson gson= new Gson();
			String jsonStr = gson.toJson(list);
			System.out.println("줴이슨"+jsonStr);
			//문자열 내보내기
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
		} catch (Exception e) {
			System.out.println("[ERROR] 채팅방 목록조회 error~~");
			e.printStackTrace();
		
			req.setAttribute("errorMsg","채팅방 목록조회");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
	}

}
