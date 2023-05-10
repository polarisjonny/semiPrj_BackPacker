package com.bp.app.admin.memberManage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.admin.memberManage.service.AdminMemberService;
import com.bp.app.member.vo.MemberVo;
@WebServlet("/admin/member/edit/status")
public class AdminMemberEditStatusController extends HttpServlet {

   
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      try {
      //데꺼member
      String status = req.getParameter("status");
      String memberNo = req.getParameter("memberNo");
      //데뭉
      MemberVo vo = new MemberVo();
      vo.setMemberStatus(status);;
      vo.setMemberNo(memberNo);
      System.out.println("edit 에서 vo");
      //서비스
      AdminMemberService ams = new AdminMemberService();
      int result = ams.editStatus(vo);
      
      System.out.println("상태변경 1이면 성고 :: : " + result);
      
      //화면 == 문자열 내보내기
      PrintWriter out = resp.getWriter();
      if(result == 1) {
         out.write("ok");
      }
      
      }catch (Exception e) {
      System.out.println("[ERROR] notice reply errr~~~");
      e.printStackTrace();
      
      //view ~~~
   }
         
   }      
   
}