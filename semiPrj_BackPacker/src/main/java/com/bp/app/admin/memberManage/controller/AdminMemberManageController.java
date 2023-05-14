package com.bp.app.admin.memberManage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.admin.boardManage.service.BoardManageService;
import com.bp.app.admin.boardManage.vo.GuideBoardVo;
import com.bp.app.admin.memberManage.service.AdminMemberService;
import com.bp.app.common.page.PageVo;
import com.bp.app.member.vo.MemberVo;
@WebServlet("/admin/member")
public class AdminMemberManageController extends HttpServlet {
   
   
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   try {
		   
		   String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			

			 AdminMemberService ams = new AdminMemberService();
			 //서비스
			 int listCount = ams.selectCnt(searchType, searchValue );
             String page = req.getParameter("page");
             if(page == null) page = "1";
             int currentPage = Integer.parseInt(page);
             int pageLimit = 5;
             int boardLimit= 10;
             PageVo pv = new PageVo(listCount, currentPage, pageLimit, boardLimit);
             
			List<MemberVo> adminMemberVoList = null;
			 
			if(searchType == null || searchType.equals("")) {
				
				adminMemberVoList = ams.getMemberList(pv);
			}else {
				
				adminMemberVoList = ams.getMemberList(pv,searchType, searchValue);
			}
			
			Map<String, String> map = new HashMap<>();
			map.put("searchType",searchType);
			map.put("searchValue",searchValue);
			//화면
			req.setAttribute("pv", pv);
			req.setAttribute("adminMemberVoList", adminMemberVoList);
			req.setAttribute("searchVo", map);
            req.getRequestDispatcher("/WEB-INF/views/admin/member/member-list.jsp").forward(req, resp);
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } 
      
   }

//   @Override
//   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      try {
//         
//    	  
//         List<MemberVo> adminMemberVoList = null;
//         
//         AdminMemberService ams = new AdminMemberService();
//         String searchType = req.getParameter("searchType");
//         String searchValue = req.getParameter("searchValue");
//         int cnt = ams.getMemberListCnt(searchType , searchValue);
//         int page = Integer.parseInt(req.getParameter("page"));
//         PageVo pv = new PageVo(cnt, page, 5, 10);
//         if(searchType == null || searchType.equals("")) {
//            adminMemberVoList = ams.getMemberList(pv);
//         }else {
//            adminMemberVoList = ams.getMemberList(pv, searchType, searchValue);
//         }
//         Map<String, String> map = new HashMap<>();
//         map.put("searchType", searchType);
//         map.put("searchValue", searchValue);
//         //화면
//         req.setAttribute("searchVo", map);
//         req.setAttribute("pv", pv);
//         req.setAttribute("adminMemberVoList", adminMemberVoList);
//      
//      }catch(Exception e) {
//         System.out.println("[ERROR] 게시글 목록 조회 에러 ...");
//         e.printStackTrace();
//         
//         req.setAttribute("errorMsg" , "목록 조회 실패 ..");
//         req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
//         return;
//         
//      }
//      req.getRequestDispatcher("/WEB-INF/views/admin/member-list.jsp").forward(req, resp);
//      
//   
//   }
}