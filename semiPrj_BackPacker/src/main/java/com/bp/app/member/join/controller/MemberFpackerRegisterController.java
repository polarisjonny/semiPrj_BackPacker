package com.bp.app.member.join.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bp.app.member.service.MemberService;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.util.file.AttachmentVo;
import com.bp.app.util.file.FileUploader;

@MultipartConfig(
			maxFileSize = 1024 * 1024 * 50,
			maxRequestSize = 1024 * 1024 * 50 * 2
		)
@WebServlet("/member/join/fpacker")
public class MemberFpackerRegisterController extends HttpServlet {
	//프패커 등록 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/fpackerRegisterForm.jsp").forward(req, resp);
	}
	
	//프패커 등록 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//파일 처리
			Part f = req.getPart("idCard");
			String path = req.getServletContext().getRealPath("/static/img/member/idCard/");
			AttachmentVo attachmentVo = FileUploader.saveFile(path, f);
			
			//신분증사진 이름 바꾸기
			String idChangeName = attachmentVo.getChangeName();
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
			String memberNo = loginMember.getMemberNo();
			System.out.println(memberNo);
			
			
			MemberService ms = new MemberService();
			MemberVo updatedMember = ms.registerFpacker(idChangeName, memberNo);
			
			if(updatedMember != null) {
				req.getSession().setAttribute("loginMember", updatedMember);
				String root = req.getContextPath();
				resp.sendRedirect(root+"/home");
			} else {
				throw new Exception("[ERROR] 프패커 등록 실패....");
			}
		} catch(Exception e) {
			System.out.println("[ERROR] 프패커 등록 실패");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "프패커 등록 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
