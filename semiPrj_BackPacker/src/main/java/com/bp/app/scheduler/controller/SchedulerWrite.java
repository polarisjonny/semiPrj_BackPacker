package com.bp.app.scheduler.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.PlaceVo;
import com.bp.app.scheduler.vo.SchedulerVo;
import com.bp.app.scheduler.vo.TimetableVo;
import com.bp.app.util.file.AttachmentVo;
import com.bp.app.util.file.FileUploader;
@MultipartConfig(
		maxFileSize = 1024*1024*50,
		maxRequestSize = 1024*1024*50*10
		)
@WebServlet("/schedulerwrite")
public class SchedulerWrite extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			SchedulerService ss = new SchedulerService();
			List<TimetableVo>timetableVo = ss.totalTimetable(req);
			
			System.out.println(timetableVo);
			req.setAttribute("timetableVo", timetableVo);
			
			req.getRequestDispatcher("/WEB-INF/views/scheduler/writeScheduler.jsp").forward(req, resp);
			
		} catch (Exception e) {
			req.setAttribute("errorMsg", "동행 게시판 timtable 가져오다가 작성중 오류");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	
	}//get
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			GuideBoardVo bgVo = new GuideBoardVo();
			//데이터 꺼내기
			String writerNo = loginMember.getMemberNo();
			String category = req.getParameter("category");
			String schedulerNo = req.getParameter("schedulerNo");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String expense = req.getParameter("expense");
			
			//사진저장
			String path=null;
			//경로 변경
			
			
			Part f = req.getPart("f");
			if(f.getSubmittedFileName()!=null&&f.getSubmittedFileName()!="") {
				
				if("3".equals(category)) {
					path = req.getServletContext().getRealPath("/static/img/accompany/");
					AttachmentVo attachmentVo = FileUploader.saveFile(path,f);	
					bgVo.setMainImg(attachmentVo.getChangeName());
				}else {
					path = req.getServletContext().getRealPath("/static/img/Fpacker/");
					AttachmentVo attachmentVo = FileUploader.saveFile(path,f);	
					bgVo.setMainImg(attachmentVo.getChangeName());
				}
				
			}else {
				if("3".equals(category)) {
					String changeName = "accom_basic.jpg";
					bgVo.setMainImg(changeName);
				}else {
					String changeName = "fpacker_basic.jpg";
					bgVo.setMainImg(changeName);
				}
			}
			
			
			
			//데이터 뭉치기
			//로그인멤버 셋팅
			bgVo.setWriterNo(writerNo);
			bgVo.setSchedulerNo(schedulerNo);
			bgVo.setGuideBoardCategoryNo(category);
			bgVo.setTitle(title);
			bgVo.setContent(content);
			bgVo.setTravelExpense(expense);
            
            
			
			//서비스
			SchedulerService ss = new SchedulerService();
			int result = ss.gbWrite(bgVo);
			
			//화면
			if(result==1) {
				if("3".equals(category)) {
					resp.sendRedirect("/semi/accompany/list?page=1");
					
				}

				if("2".equals(category)) {
					resp.sendRedirect("/semi/findFpacker/list?page=1");
					
				}
				if("1".equals(category)) {
					resp.sendRedirect("/semi/doFpacker/list?page=1");

					
				}
			}else {
				throw new IllegalStateException("작성결과 1아님");
			}
			
		} catch (Exception e) {

			req.setAttribute("errorMsg", "동행 게시판 작성중 오류");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		
		}
		
	
	}//post
	

	
}
