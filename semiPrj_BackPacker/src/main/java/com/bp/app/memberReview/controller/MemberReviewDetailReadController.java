package com.bp.app.memberReview.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.common.page.PageVo;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.memberReview.service.MemberReviewService;
import com.bp.app.memberReview.vo.MemberReviewVo;
@WebServlet("/click/profile/review/detail")
public class MemberReviewDetailReadController extends HttpServlet{
   
   private final MemberReviewService mrs = new MemberReviewService();
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String selectMemberNo = "";
      try {
         //데꺼
         selectMemberNo = req.getParameter("selectMemberNo");
         //서비스
         
         int listCount = mrs.selectCnt(selectMemberNo);
         String page = req.getParameter("page");
         if(page == null) page = "1";
         int currentPage = Integer.parseInt(page);
         int pageLimit = 5;
         int boardLimit= 5;
         PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
         MemberVo selectMemberDetail = mrs.selectMemberToProfile(selectMemberNo);
         
         //서비스
         List<MemberReviewVo> selectMemberReviewlistDetail = mrs.selectMemberReviewDetail(selectMemberNo , pv);
         //화면
//         MemberReviewVo selevtMemberReview = gps.selectMemberReadReview(selectMemberNo);
         //화면
//         if(selectMemberDetail != null ) {
//            req.getSession().setAttribute("selectMemberDetail", selectMemberDetail);
//            req.getSession().setAttribute("selectMemberReviewlistDetail",  (Serializable)selectMemberReviewlistDetail);
            req.setAttribute("selectMemberReviewlistDetail", selectMemberReviewlistDetail);
            req.setAttribute("selectMemberDetail", selectMemberDetail);
//            req.setAttribute("loginMember", loginMember);
            req.setAttribute("pv" , pv);
            req.getRequestDispatcher("/WEB-INF/views/profile/detail-review.jsp").forward(req, resp);
//         }else {
//            throw new Exception();
//         }
      }catch(Exception e) {
         System.out.println("catch");
         System.out.println("[ERROR] go prfile errr....");
         e.printStackTrace();
         
         req.setAttribute("errorMsg", "프로필 조회 실패");
         
      }
      
   }
}
