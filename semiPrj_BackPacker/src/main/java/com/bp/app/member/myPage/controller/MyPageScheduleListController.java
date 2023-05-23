package com.bp.app.member.myPage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.member.myPage.scheduler.service.MyPageSchedulerService;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.scheduler.vo.SchedulerVo;

@WebServlet("/member/myPage/schedule/scheduleList")
public class MyPageScheduleListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			if(loginMember == null) {
				throw new IllegalStateException("로그인 하고 오세요");
			}
			
			String memberNo = loginMember.getMemberNo();
			
			MyPageSchedulerService mps = new MyPageSchedulerService();
			Map<Integer, SchedulerVo> scheduleMap = mps.selectScheduleList(memberNo);
			System.out.println(scheduleMap);
			if(scheduleMap != null) {
				req.setAttribute("scheduleMap", scheduleMap);
				req.getRequestDispatcher("/WEB-INF/views/member/scheduleListForm.jsp").forward(req, resp);
			} else {
				throw new Exception("[ERROR] 스케줄 조회 실패");
			}
			
		} catch(Exception e) {
			System.out.println("[ERROR] 스케줄 조회 실패");
			e.printStackTrace();
			req.setAttribute("errorMsg", "스케줄 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
		
		
	}
}
