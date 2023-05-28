package com.bp.app.Fpacker.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideReplyVo;
import com.bp.app.member.vo.MemberVo;

@WebServlet ("/findFpacker/reply/write")
public class FindFpackerReplyWriterController extends HttpServlet{
	//INSERT INTO GUIDE_REPLY(GUIDE_REPLY_NO, WRITER_NO, GUIDE_BOARD_NO,CONTENT) VALUES(SEQ_GUIDE_REPLY_NO.NEXTVAL, ? ,?,?,?);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String writerNo = loginMember.getMemberNo();
			
			
			//데꺼
			String GuideBoardNo = req.getParameter("findFpackerNo");
			String comment =  req.getParameter("content");
			
			//데뭉
			GuideReplyVo rvo = new GuideReplyVo();
			rvo.setContent(comment);
			rvo.setWriterNo(writerNo);
			rvo.setGuideBoardNo(GuideBoardNo);
			
			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			int result = gbs.replyWrite(rvo);
			
			//화면
			PrintWriter out = resp.getWriter();
			if(result==1) {
				out.write("ok");
			}
		} catch (Exception e) {
			System.out.println("[ERROR] notice reply error");
			e.printStackTrace();
			
		}
		
	}
}
