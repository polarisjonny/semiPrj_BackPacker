package com.bp.app.member.profile.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.common.page.PageVo;
import com.bp.app.member.profile.service.GoProfileService;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.memberReview.vo.MemberReviewVo;
@WebServlet("/click/profile")
public class GoProfileController extends HttpServlet{

   private final GoProfileService gps = new GoProfileService();
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getSession().removeAttribute("selectMember");
      req.getSession().removeAttribute("selectMemberReviewlist");
   
      MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
      String loginMemberId = loginMember.getId();
      String selectMemberNo= "";
      
      MemberVo selectMember= null;
      try {
         //데꺼
         selectMemberNo = req.getParameter("selectMemberNo");
         //데뭉
         //서비스
         
         
         selectMember = gps.selectMemberToProfile(selectMemberNo);
         

         //서비스
         List<MemberReviewVo> selectMemberReviewlist = gps.selectMemberReadReview(selectMemberNo);
         //화면
//         MemberReviewVo selevtMemberReview = gps.selectMemberReadReview(selectMemberNo);
         //화면
         if(selectMember != null) {
            // && (selectMemberNo.equals(selectMember.getMemberNo())) 
            req.getSession().setAttribute("selectMember", selectMember);
            req.setAttribute("loginMember", loginMember);
            req.setAttribute("selectMemberReviewlist", selectMemberReviewlist);
//            req.setAttribute("pv" , pv);
            req.getRequestDispatcher("/WEB-INF/views/profile/profile.jsp").forward(req, resp);
         }else {
            System.out.println("else");
            throw new Exception();
         }
      }catch(Exception e) {
         System.out.println("catch");
         System.out.println("[ERROR] go prfile errr....");
         e.printStackTrace();
         
         req.setAttribute("errorMsg", "프로필조회실패");
         
      }
      
      
      
      
   }

}