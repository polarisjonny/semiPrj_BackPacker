package com.bp.app.accompany.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.SchedulerVo;
import com.bp.app.scheduler.vo.TimetableVo;

@WebServlet ("/accompany/detail")
public class AccompanyDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데꺼
			String boardNo = req.getParameter("no");
			String writerNo = req.getParameter("writerNo");
			MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
			
			
	
			//데뭉
			GuideBoardVo bvo = new GuideBoardVo();
			bvo.setGuideBoardNo(boardNo);
			bvo.setWriterNo(writerNo);
			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			SchedulerService ss = new SchedulerService();
			
			//매칭상태를업데이트 서비스
			//채팅룸의 값을select 해서 값이둘다Y이면 매칭스테이터스 y로 수정하는 구문... 
			
			
			MemberVo writerMember = gbs.selectMemberByNo(bvo);
			//조회수 버그 고치기 위한.. 
			GuideBoardVo gbvo =null;
			if(loginMember==null||loginMember.equals("")) {
				gbvo =  gbs.selectOneByNo(bvo,"아무거나");
				if(gbvo.getMatchingState().equals("N")) {
					int result = gbs.setMatchingStatus(boardNo);
					gbvo =  gbs.selectOneByNo(bvo,"아무거나");
				}
			}else {
				String lmNo = loginMember.getMemberNo();
				gbvo =  gbs.selectOneByNo(bvo,lmNo);
				if(gbvo.getMatchingState().equals("N")){
					int result = gbs.setMatchingStatus(boardNo);
					gbvo =  gbs.selectOneByNo(bvo,lmNo);
				}	
			}
			List<TimetableVo>timetableVo = ss.totalTimetable(req);
			
			
			
			
			//화면
			if(writerMember!=null&&gbvo!=null) {
				if(timetableVo==null||timetableVo.equals("")) {
					req.getSession().setAttribute("gbvo", gbvo);
					req.setAttribute("writerMember", writerMember);
					req.getRequestDispatcher("/WEB-INF/views/accompanyBoard/accompanyBoardDetail.jsp").forward(req, resp);								
				}else {
					req.getSession().setAttribute("gbvo", gbvo);
					req.setAttribute("writerMember", writerMember);
					req.setAttribute("timetableVo", timetableVo);
					req.getRequestDispatcher("/WEB-INF/views/accompanyBoard/accompanyBoardDetail.jsp").forward(req, resp);
				}
			}else {
				throw new Exception();
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("디테일 조회중 에러발생");
			
			req.setAttribute("errorMsg", "디테일조회중 에러남");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			
		}
	}

}
