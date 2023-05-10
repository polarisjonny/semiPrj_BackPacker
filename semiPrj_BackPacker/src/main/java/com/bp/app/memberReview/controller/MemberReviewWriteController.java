package com.bp.app.memberReview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.chat.room.vo.ChattingRoomVo;
import com.bp.app.memberReview.service.MemberReviewService;
import com.bp.app.memberReview.vo.MemberReviewVo;
@WebServlet("/click/profile/review")
public class MemberReviewWriteController extends HttpServlet{
   
   
   MemberReviewService mrs = new MemberReviewService();
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      //로그인 멤버랑 선택됨 멤버가 채팅룸이 있고 결제확인이 y 인 경우에면 넘어간다
      try {
         //데꺼
         String loginMemberNo = req.getParameter("loginMemberNo");
         String selectMemberNo = req.getParameter("selectMemberNo");
         //데뭉
         if (loginMemberNo.equals(selectMemberNo)) {
        	 req.setAttribute("errorMsg", "자기 자신에게는 후기를 작성할 수 없습니다.");
             String root = req.getContextPath();
             req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
             return;
         }
         //서비스
         ChattingRoomVo crv = null;
         crv = mrs.checkCanWriteReview(loginMemberNo,selectMemberNo);
         if(crv != null) {
            req.setAttribute("loginMemberNo", loginMemberNo);
            req.setAttribute("selectMemberNo", selectMemberNo);
            req.setAttribute("crv", crv);
            req.getRequestDispatcher("/WEB-INF/views/profile/write-review.jsp").forward(req, resp);
         }else {
            req.setAttribute("errorMsg", "같이 여행한 적이 없어요");
            String root = req.getContextPath();
            req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
         }
      }catch(Exception e) {
         System.out.println("[ERROR] go prfile errr....");
         e.printStackTrace();
         
         req.setAttribute("errorMsg", "같이 여행한 적이 없어요");
         
      }
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      try {
         
         MemberReviewVo mrv = new MemberReviewVo();
         String giverNo = req.getParameter("loginMemberNo");
         String memberNo = req.getParameter("selectMemberNo");
         String chattingRoomNo = req.getParameter("chattingRoomNo");
         String content = req.getParameter("reviewContent");
         String score = req.getParameter("rating");
         mrv.setGiverNo(giverNo);
         mrv.setMemberNo(memberNo);
         mrv.setChattingRoomNo(chattingRoomNo);
         mrv.setContent(content);
         mrv.setScore(score);
         
         MemberReviewService mrs = new MemberReviewService();
         int result = mrs.writeReview(mrv);
         
         if(result == 1) {
            
            String root = req.getContextPath();
            resp.sendRedirect(root+"/click/profile?selectMemberNo="+memberNo);
         }else {
            throw new Exception("[ERROR] 후기 작성 에러");
         }
         
      }catch(Exception e){
         
         e.printStackTrace();
      
         req.setAttribute("errorMsg", "후기 작성 실패");
      
      }
      
      
   }
}