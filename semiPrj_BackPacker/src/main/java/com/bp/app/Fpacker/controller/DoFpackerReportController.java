package com.bp.app.Fpacker.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.admin.boardManage.service.BoardManageService;
import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.report.vo.ReportVo;

@WebServlet ("/doFpacker/report")
public class DoFpackerReportController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/FpackerBoard/doFpackerReport.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데꺼
			String content = req.getParameter("content");
			String no = req.getParameter("no");
			MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
			
			//데뭉
			ReportVo vo = new ReportVo();
			vo.setReportContent(content);
			vo.setGuideBoardNo(no);
			vo.setMemberNo(loginMember.getMemberNo());
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			int result = gbs.report(vo);
			
			//화면
			PrintWriter out = resp.getWriter();
			if(result==1) {
				out.write("ok");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
