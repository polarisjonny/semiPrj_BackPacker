package com.bp.app.accompany.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideReplyVo;
import com.google.gson.Gson;

@WebServlet ("/accompany/reply/list")
public class AccompanyReplyListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데꺼
			String accomNo = req.getParameter("accomNo");
			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			List<GuideReplyVo>list =gbs.selectReplyList(accomNo);
			
			Gson gson= new Gson();
			String jsonStr = gson.toJson(list);
			
			//문자열 내보내기
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
		} catch (Exception e) {
			System.out.println("[ERROR] notice reply error~~");
			e.printStackTrace();
		}
		
		
	}
}
