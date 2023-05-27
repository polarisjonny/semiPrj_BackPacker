package com.bp.app.admin.memberManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.admin.memberManage.service.AdminMemberService;
import com.bp.app.member.vo.MemberVo;
@WebServlet("/admin/member/edit/status")
public class AdminMemberEditStatusController extends HttpServlet {

   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
      try {
      //데꺼member
      String status = req.getParameter("memberStatus");
      String memberNo = req.getParameter("memberNo");
      //데뭉
      MemberVo vo = new MemberVo();
      vo.setMemberStatus(status);;
      vo.setMemberNo(memberNo);
      //서비스
      AdminMemberService ams = new AdminMemberService();
      int result = ams.editStatus(vo);
      
      
      //화면 == 문자열 내보내기
      if(result == 1) {
    	String root = req.getContextPath();
		resp.sendRedirect(root + "/admin/member");
      }
      
      }catch (Exception e) {
      System.out.println("[ERROR] 회원 상태 변경 실패");
      e.printStackTrace();
  	 req.setAttribute("errorMsg", "회원 상태 변경 실패 발생");
      
      //view ~~~
      }
         
   }      
   
}