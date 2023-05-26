package com.bp.app.scheduler.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.member.vo.MemberVo;
import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.SchedulerVo;

@WebServlet("/schedulermake/setScheduler")
public class SetScheduler extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//데이터 꺼내기 
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String memberNo = loginMember.getMemberNo(); 
			
			//세션에서 로그인 멤버 가져오기
			
			//데이터 뭉치기
			SchedulerVo sVo = new SchedulerVo();
			sVo.setMemberNo(memberNo);
			sVo.setStartDate(startDate);
			sVo.setEndDate(endDate);
			
			//서비스 
			SchedulerService ss = new SchedulerService();
			int result = ss.setScheduler(sVo);
			
			
			
			
			//req.getSession().setAttribute("sVo", sVo);
			//화면
			
		} catch (Exception e) {
			System.out.println("error setScheduler 에러");
			e.printStackTrace();
		
		}
		
		
	
	
	}
}
