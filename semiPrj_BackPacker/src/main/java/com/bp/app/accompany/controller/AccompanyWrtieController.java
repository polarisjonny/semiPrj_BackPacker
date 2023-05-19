package com.bp.app.accompany.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.util.file.AttachmentVo;
import com.bp.app.util.file.FileUploader;

@MultipartConfig (
		maxFileSize = 1024*1024*100,
		maxRequestSize = 1024*1024*100*2
		)
@WebServlet ("/accompany/write")
public class AccompanyWrtieController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/accompanyBoard/accompanyBoardWrite.jsp").forward(req, resp);;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//썸네일 사진 서버에 업로드
			Part f = req.getPart("boardListThumbnail");
			String path = req.getServletContext().getRealPath("/static/img/accompany/");
			AttachmentVo attachmentVo = FileUploader.saveFile(path,f);			
			
			//데이터 꺼내기
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			
			//카테고리넘버
			String categoryNo = "3";
			
			//꺼낸 데이터 vo에 set하기  
			GuideBoardVo vo = new GuideBoardVo();
			vo.setMainImg(attachmentVo.getChangeName());
			vo.setTitle(title);
			vo.setContent(content);
			vo.setStartDate(startDate);
			vo.setEndDate(endDate);	
			vo.setGuideBoardCategoryNo(categoryNo);
			
			//세션에서 로그인멤버Vo 가져오기
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			
			//insert문 실행하는 서비스 객체 만들어서 result값 받아오기
			//insert를 총 3번해서 result1,result2, result3이 나오지만 반환값은 result로 받음
			//위의 1,2,3이 모두 1일때에만 result값인 1을 반환.
			GuideBoardService gbs = new GuideBoardService();
			int result = gbs.accomWrite(vo,loginMember);
			
			if(result==1) {
				//위의 insert문 3개가 정상적으로 삽입되면 BoardList로 이동
				resp.sendRedirect(req.getContextPath()+"/accompany/list?page=1");
			}else {
				//하나라도 인서트가 안되면 예외 발생시키기
				throw new Exception();
			}
			
		
		} catch (Exception e) {
			//에러메세지 출력
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "동행구하기게시판 게시글 작성중 에러 발생. 같은 에러가 계속 발생시 관리자에게 문의하세요.");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
	}
}
