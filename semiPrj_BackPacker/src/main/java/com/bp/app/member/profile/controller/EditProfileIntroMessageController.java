package com.bp.app.member.profile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bp.app.member.profile.service.EditProfileService;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.util.file.AttachmentVo;
import com.bp.app.util.file.FileUploader;
@WebServlet("/click/profile/edit/intMsg")
public class EditProfileIntroMessageController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
      if(loginMember != null) {
         req.getRequestDispatcher("/WEB-INF/views/profile/edit-profile-intMsg.jsp").forward(req, resp);
      }else {
         req.getSession().setAttribute("alertMsg", "로그인을 먼저 해주세요");
         resp.sendRedirect(req.getContextPath() + "/home");
      }
      
      
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
      try {
         String introMessage = req.getParameter("introMessage");
         
         MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
         String loginMemberNo = loginMember.getMemberNo();
         
         MemberVo vo = new MemberVo();
         vo.setMemberNo(loginMemberNo);
         vo.setIntroMessage(introMessage);
//         
         EditProfileService eps = new EditProfileService();
         MemberVo updatedMember = eps.editIntMsg(vo);
         
         if(updatedMember != null) {
            
            req.getSession().setAttribute("loginMember", updatedMember);
            resp.sendRedirect(req.getContextPath() + "/home");
         }else {
            throw new Exception();
         }
      }catch(Exception e) {
         
      }
   }
}