package com.bp.app.accompany.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.gboard.vo.GuideReplyVo;
import com.bp.app.member.vo.MemberVo;

@WebServlet ("/accompany/reply/write")
public class AccompanyReplyWriterController extends HttpServlet{
	//INSERT INTO GUIDE_REPLY(GUIDE_REPLY_NO, WRITER_NO, GUIDE_BOARD_NO,CONTENT) VALUES(SEQ_GUIDE_REPLY_NO.NEXTVAL, ? ,?,?,?);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String writerNo = loginMember.getMemberNo();
			
			
			//데꺼
			String guideBoardNo = req.getParameter("accomNo");
			String comment =  req.getParameter("content");
			
			
			
			
			//데뭉
			GuideReplyVo rvo = new GuideReplyVo();
			rvo.setContent(comment);
			rvo.setWriterNo(writerNo);
			rvo.setGuideBoardNo(guideBoardNo);
			
			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			
			//매칭 스테이터스불러오Y이면...실패하기로 하기...
			
			
			//코멘트가 널이거나 빈문자열이면 out으로 오류메세지 내보내기
			PrintWriter out = resp.getWriter();
			if(comment==null||comment.equals("")) {
				out.write("empty");
			}else {
				
				String status = gbs.getStatus(guideBoardNo);
				if(!status.equals("Y")) {
					int result = gbs.replyWrite(rvo);
					if(result==1) {
						out.write("ok");
					}
				}else if(status.equals("Y")) {
					out.write("no");
				}
			} 
		}catch (Exception e) {
			System.out.println("[ERROR] notice reply error");
			e.printStackTrace();
			
		}
		
	}
}
