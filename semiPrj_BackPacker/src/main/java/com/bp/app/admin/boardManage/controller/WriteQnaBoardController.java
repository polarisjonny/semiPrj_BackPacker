package com.bp.app.admin.boardManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.admin.boardManage.service.BoardManageService;
import com.bp.app.admin.boardManage.vo.QnaBoardVo;
import com.bp.app.member.vo.MemberVo;
@WebServlet("/admin/qna/write")
public class WriteQnaBoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/admin/qna/write.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		    MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		    QnaBoardVo qvo = new QnaBoardVo();
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writerNo = loginMember.getMemberNo();
			String qnaCategoryNo = req.getParameter("qnaCategoryNo");
			qvo.setTitle(title);
			qvo.setContent(content);
			qvo.setWriterNo(writerNo);
			qvo.setQnaCategoryNo(qnaCategoryNo);
			BoardManageService bs = new BoardManageService();
			int result = bs.writeQnaBoard(qvo);
					
			if(result == 1) {
				String root = req.getContextPath();
				resp.sendRedirect(root+"/문의게시판 목록으로");
			} else {
				throw new Exception("[ERROR] 문의게시판 작성 중 에러 발생");
			}
		}catch(Exception e){
			System.out.println("[ERROR]문의게시판 작성 중 에러 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "문의게시판 작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	
	}

	
}
