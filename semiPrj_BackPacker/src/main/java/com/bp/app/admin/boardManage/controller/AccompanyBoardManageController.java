package com.bp.app.admin.boardManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin/acb")
public class AccompanyBoardManageController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		req.getRequestDispatcher("/WEB-INF/views/admin/report/acb-report-list.jsp").forward(req, resp);
		
	}
}