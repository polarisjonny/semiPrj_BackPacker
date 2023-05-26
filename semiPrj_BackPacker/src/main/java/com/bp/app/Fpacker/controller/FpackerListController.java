package com.bp.app.Fpacker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.service.GuideBoardService;

@WebServlet ("/Fpacker/list")
public class FpackerListController extends HttpServlet{
	
	//SELECT * FROM GUIDE_BOOARD ...
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 뭉치기
		
		//데이터꺼내기
		//클라로부터 게시판카테고리를 받아와야함.

		
		//서비스
		GuideBoardService gbs = new GuideBoardService();
		
		String currentPage_ = req.getParameter("page");
		int currentPage = Integer.parseInt(currentPage_);
		int cnt = gbs.countCnt(0);
		
		//페이징
		new PageVo(cnt, currentPage, 5, 10);
		
		gbs.getList(0, null);
		
		//화면
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/FpackerBoard/FpackerList.jsp").forward(req, resp);
	}
	
}
