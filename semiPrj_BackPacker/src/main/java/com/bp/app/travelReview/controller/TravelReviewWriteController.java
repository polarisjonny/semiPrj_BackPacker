package com.bp.app.travelReview.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.travelReview.service.TravelReviewService;
import com.bp.app.travelReview.vo.TravelReviewVo;
import com.bp.app.util.file.AttachmentVo;
import com.bp.app.util.file.FileUploader;

import oracle.net.aso.f;

@MultipartConfig(
			maxFileSize = 1024 * 1024 * 100,
			maxRequestSize = 1024 * 1024 * 1000
		)
@WebServlet("/notice/travelReviewWrite")
public class TravelReviewWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/notice/travelReviewWrite.jsp").forward(req, resp);
	
	}//doget
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			if(loginMember == null) {
				throw new IllegalStateException();
			}
			
			//파일 업로드
			TravelReviewVo trvo = new TravelReviewVo();
			Part f = req.getPart("fileName");

			AttachmentVo attvo = null;
			if(f.getSubmittedFileName()!=null && f.getSubmittedFileName()!="") {
				String path = req.getServletContext().getRealPath("/static/img/travelReview/");
				attvo = FileUploader.saveFile(path, f);
				trvo.setMainImg(attvo.getChangeName());
			}else {
				String changeName = "travelReviewMain.jpg";
				trvo.setMainImg(changeName);
			}

			//데이터 꺼내기
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writerNo = loginMember.getMemberNo();
			
			//데이터 뭉치기
			trvo.setTitle(title);
			trvo.setContent(content);
			trvo.setWriterNo(writerNo);
		
			
			TravelReviewService trs = new TravelReviewService();
			int result = trs.write(trvo);
			
			//화면
			if(result == 1) {
				resp.sendRedirect(req.getContextPath()+"/notice/travelReview?page=1");
			}
			else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR] 여행 후기 작성 중 예외 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "후기 작성 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
		
		
	}//dopost
	
}
