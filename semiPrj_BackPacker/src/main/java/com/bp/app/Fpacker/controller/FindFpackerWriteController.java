package com.bp.app.Fpacker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.util.file.AttachmentVo;
import com.bp.app.util.file.FileUploader;
@MultipartConfig(
		maxFileSize = 1024*1024*50,
		maxRequestSize = 1024*1024*50*5
		)
@WebServlet ("/findFpacker/write")
public class FindFpackerWriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			req.getRequestDispatcher("/WEB-INF/views/FpackerBoard/findWriteForm.jsp").forward(req, resp);			
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			GuideBoardVo vo = new GuideBoardVo();

			Part f = req.getPart("boardListThumbnail");

			if(f.getSubmittedFileName()!=null&&f.getSubmittedFileName()!="") {
				String path = req.getServletContext().getRealPath("/static/img/Fpacker/");
				AttachmentVo attachmentVo = FileUploader.saveFile(path,f);	
				vo.setMainImg(attachmentVo.getChangeName());
			}else {
				String changeName = "fpacker_basic.jpg";
				vo.setMainImg(changeName);
			}
			
			
			
			
			//로그인 멤버 얻기
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			
			
			//데이터뭉치기
			vo.setGuideBoardCategoryNo("2");
			vo.setTitle(title);
			vo.setContent(content);
			vo.setStartDate(startDate);
			vo.setEndDate(endDate);
			
			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			int result = gbs.write(vo, loginMember);
			
			//화면
			if(result==1) {
				resp.sendRedirect(req.getContextPath()+"/findFpacker/list?page=1");
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "프패커게시판 게시글 작성 중 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
