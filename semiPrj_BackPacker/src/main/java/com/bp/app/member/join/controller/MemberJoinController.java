package com.bp.app.member.join.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bp.app.member.service.MemberService;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.util.file.AttachmentVo;
import com.bp.app.util.file.FileUploader;

@MultipartConfig(
			maxFileSize = 1024 * 1024 * 50,
			maxRequestSize = 1024 * 1024 * 50 * 2
		)
@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	//회원가입 구현 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/joinForm.jsp").forward(req, resp);
	}
	
	//회원가입 기능
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
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			String nick = req.getParameter("nick");
			String name = req.getParameter("name");
			String phoneNumber = req.getParameter("phoneNumber");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			String gender = req.getParameter("gender");
			String age = req.getParameter("age");
			String introMessage = req.getParameter("introMessage");
			
			//데이터 뭉치기
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPassword(password);
			vo.setNick(nick);
			vo.setName(name);
			vo.setPhoneNumber(phoneNumber);
			vo.setEmail(email);
			vo.setAddress(address);
			vo.setGender(gender);
			vo.setAge(age);
			vo.setIntroMessage(introMessage);
			if (attachmentVo != null) {
                vo.setProfileImage(attachmentVo.getChangeName());
            }
			
			MemberService ms = new MemberService();
			int result = ms.join(vo);
			
			
			if(result == 1) {
				String root = req.getContextPath();
				req.getSession().setAttribute("errorMsg", "회원가입 성공");
				resp.sendRedirect(root+"/home");
			} else {
				throw new Exception("[ERROR] 회원 가입 처리 중 에러 발생");
			}
			
			
		} catch(Exception e) {
			System.out.println("[ERROR] 회원 가입 처리 중 에러 발생");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "회원가입 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
