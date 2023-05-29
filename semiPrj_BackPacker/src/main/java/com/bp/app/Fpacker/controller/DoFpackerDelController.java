package com.bp.app.Fpacker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.gboard.service.GuideBoardService;

@WebServlet ("/doFpacker/del")
public class DoFpackerDelController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String no = req.getParameter("no");
			
			GuideBoardService gbs = new GuideBoardService();
			int result = gbs.delete(no);
			
			if(result==1){
				resp.sendRedirect(req.getContextPath()+"/doFpacker/list?page=1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "게시글 삭제중에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
