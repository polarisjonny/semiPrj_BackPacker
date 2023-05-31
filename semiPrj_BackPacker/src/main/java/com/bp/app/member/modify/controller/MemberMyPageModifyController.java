package com.bp.app.member.modify.controller;

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
@WebServlet("/member/modify/myPage")
public class MemberMyPageModifyController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/myPageModifyForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//파일 처리
			Part f = req.getPart("profileImage");
			String path = req.getServletContext().getRealPath("/static/img/member/profile/");
			AttachmentVo attachmentVo = null;
			
			if(f != null && f.getSize() > 0) {
				attachmentVo = FileUploader.saveFile(path, f);
			}	
			
			
			//데이터 꺼내기
			String phoneNumber = req.getParameter("phoneNumber");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			String age = req.getParameter("age");
			String introMessage = req.getParameter("introMessage");
			
			System.out.println(phoneNumber);
			System.out.println(email);
			System.out.println(address);
			System.out.println(age);
			System.out.println(introMessage);
			
			
			
			//데이터 뭉치기
			MemberVo vo = new MemberVo();
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			String memberNo = loginMember.getMemberNo();
			String profileImage = loginMember.getProfileImage();
			
			vo.setMemberNo(memberNo);
			vo.setPhoneNumber(phoneNumber);
			vo.setEmail(email);
			vo.setAddress(address);
			vo.setAge(age);
			vo.setIntroMessage(introMessage);
			if (attachmentVo != null) {
                vo.setProfileImage(attachmentVo.getChangeName());
            }
			else if(attachmentVo == null) {
				vo.setProfileImage(profileImage);
			}
			
			MemberService ms = new MemberService();
			MemberVo updatedMember = ms.editMemberInfo(vo);
			
			if(updatedMember != null) {
				req.getSession().setAttribute("loginMember", updatedMember);
				resp.sendRedirect(req.getContextPath()+"/member/myPage");
			} else {
				throw new Exception("[ERROR] 마이페이지 회원 정보 수정 중 에러 발생");
			}
		} catch(Exception e) {
			System.out.println("[ERROR] 마이페이지 회원 정보 수정 중 에러 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원 정보 수정 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
