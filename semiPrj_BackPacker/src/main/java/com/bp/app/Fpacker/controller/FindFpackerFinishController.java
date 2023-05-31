package com.bp.app.Fpacker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.gboard.service.GuideBoardService;

@WebServlet ("/findFpacker/finish")
public class FindFpackerFinishController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String boardNo = req.getParameter("no");
			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			int result = gbs.finish(boardNo);
			
			if(result==1) {
				resp.sendRedirect(req.getContextPath()+"/findFpacker/list?page=1");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "마감하기 중 에러발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			
		}
	}
}
