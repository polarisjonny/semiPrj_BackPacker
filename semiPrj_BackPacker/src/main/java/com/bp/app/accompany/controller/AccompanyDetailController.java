package com.bp.app.accompany.controller;

import java.io.IOException;

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
	
			//데뭉
			GuideBoardVo bvo = new GuideBoardVo();
			bvo.setGuideBoardNo(boardNo);
			bvo.setWriterNo(writerNo);
			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			SchedulerService ss = new SchedulerService();
			
			MemberVo writerMember = gbs.selectMemberByNo(bvo);
			GuideBoardVo gbvo =  gbs.selectOneByNo(bvo);
			TimetableVo tvo = ss.getTimetable(gbvo.getSchedulerNo());
			
			//화면
			if(writerMember!=null&&gbvo!=null) {
				if(tvo==null) {
					req.setAttribute("gbvo", gbvo);
					req.setAttribute("writerMember", writerMember);
					req.getRequestDispatcher("/WEB-INF/views/accompanyBoard/accompanyBoardDetail.jsp").forward(req, resp);								
				}else {
					req.setAttribute("gbvo", gbvo);
					req.setAttribute("WriterMember", writerMember);
					req.setAttribute("tvo", tvo);
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
