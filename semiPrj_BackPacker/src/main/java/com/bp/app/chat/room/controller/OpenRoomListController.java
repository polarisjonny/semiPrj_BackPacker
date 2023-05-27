package com.bp.app.chat.room.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.chat.message.service.MessageService;
import com.bp.app.chat.room.service.ChatService;
import com.bp.app.chat.room.vo.ChattingRoomVo;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideReplyVo;
import com.bp.app.member.vo.MemberVo;
import com.google.gson.Gson;
@WebServlet("/chat/room/list/open")
public class OpenRoomListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			  
		    String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			ChatService cs = new ChatService();
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
//			String chattingUserNo = loginMember.getMemberNo();
//			String chattingUser2No = loginMember.getMemberNo();
			String no =loginMember.getMemberNo();
			int listCount1 = cs.selectCnt1(searchType, searchValue,no);
			int listCount2 = cs.selectCnt2(searchType, searchValue,no);
			int listCount = listCount1 + listCount2;
            String page = req.getParameter("page");
            if(page == null) page = "1";
            int currentPage = Integer.parseInt(page);
            int pageLimit = 5;
            int boardLimit= 5;
            PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
            
			
			List<ChattingRoomVo> roomList = null;
			ChattingRoomVo crv = new ChattingRoomVo();
			crv.setChattingUserNo(no);
//			crv.setChattingUser2No(chattingUser2No);
			
			if(searchType == null || searchType.equals("")) {
				
				roomList  = cs.openRoomList(pv, crv);
			}else {
				
				roomList = cs.openRoomList(pv,searchType, searchValue, crv);
			}
			
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType",searchType);
			map.put("searchValue",searchValue);
			//화면
			req.setAttribute("pv", pv);
			req.setAttribute("roomList", roomList);
			req.setAttribute("searchVo", map);
			req.getRequestDispatcher("/WEB-INF/views/chat/room-list.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] 채팅방 목록 보기 에러");
			req.setAttribute("errorMsg","채팅방 목록 보기 에러");
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");

			String receiverNo = null;
			
			receiverNo = loginMember.getMemberNo();
			
			MessageService ms = new MessageService();
			String chattingRoomNo = null;
			chattingRoomNo = req.getParameter("chattingRoomNo");
			int cnt = ms.newMessageCnt(receiverNo,chattingRoomNo);
			if (chattingRoomNo !=null) {
				
				Gson gson= new Gson();
				String  cnt1= gson.toJson(cnt);
				resp.setCharacterEncoding("UTF-8");
				PrintWriter out = resp.getWriter();
				out.write(cnt1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] 채팅방 목록 보기 에러");
			req.setAttribute("errorMsg","채팅방 목록 보기 에러");
			 req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
	
}

