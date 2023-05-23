package com.bp.app.member.myPage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.member.myPage.scheduler.service.MyPageSchedulerService;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.scheduler.vo.TimetableVo;

@WebServlet("/member/myPage/schedule/detail")
public class MyPageScheduleDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String schedulerNo = req.getParameter("schedulerNo");
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String memberNo = loginMember.getMemberNo();
			
			if(loginMember == null) {
				throw new IllegalStateException("로그인 하고 오세요~");
			}
			
			MyPageSchedulerService mps = new MyPageSchedulerService();
			
			List<TimetableVo> timetableVo = mps.getScheduleDetailPage(schedulerNo, memberNo);
			
			System.out.println(timetableVo);
			
			if(timetableVo == null) {
				throw new Exception("타임 테이블을 불러올 수 없습니다.");
			}
			
			req.setAttribute("timetableVo", timetableVo);
			req.getRequestDispatcher("/WEB-INF/views/member/myPageScheduleDetailForm.jsp").forward(req, resp);
		} catch(Exception e) {
			System.out.println("[ERROR] 타임 테이블 불러오기 오류");
			e.printStackTrace();
			req.setAttribute("errorMsg", "타임 테이블 불러오기 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
		
		
	}
}
