package com.bp.app.Fpacker.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideBoardVo;

@WebServlet ("/doFpacker/modify")
public class DoFpackerModifyController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/FpackerBoard/doFpackerModify.jsp").forward(req, resp);
	}
	
	//UPDATE GUIDE_BOARD SET TITLE =? , SET CONTENT = ? , MODIFY_DATE = SYSDATE WHERE GUIDE_BOARD_NO = ? 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데꺼
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String no = req.getParameter("no");
			
			System.out.println(title);
			System.out.println(content);
			System.out.println(no);
			
			//데뭉
			GuideBoardVo vo = new GuideBoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setGuideBoardNo(no);
			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			int result = gbs.modify(vo);
			
			PrintWriter out =resp.getWriter();
			if(result==1) {
				out.write("ok");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
		
	
}
