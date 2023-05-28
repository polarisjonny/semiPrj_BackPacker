package com.bp.app.Fpacker.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.gboard.service.GuideBoardService;

@WebServlet ("/findFpacker/reply/delete")
public class FindFpackerReplyDelController extends HttpServlet {
	//UPDATE GUIDE_REPLY SET DELETE_YN = 'Y' WHERE GUIDE_REPLY_NO=?;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//데꺼
			String replyNo = req.getParameter("replyNo");
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			int result=0;
			try {
				result = gbs.deleteReply(replyNo);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("댓글삭제중 에러발생");
			}
			

			//화면
			PrintWriter out = resp.getWriter();
			if(result==1) {
				out.write("ok");
			}
		
	}
}
