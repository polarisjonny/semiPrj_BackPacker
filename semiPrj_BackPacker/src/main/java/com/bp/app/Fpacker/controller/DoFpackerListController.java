package com.bp.app.Fpacker.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideBoardVo;

@WebServlet ("/doFpacker/list")
public class DoFpackerListController extends HttpServlet{
	
	//SELECT * FROM GUIDE_BOOARD ...
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데이터 뭉치기
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			//데이터꺼내기
			//클라로부터 게시판카테고리를 받아와야함.

			
			//서비스
			GuideBoardService gbs = new GuideBoardService();
			
			String currentPage_ = req.getParameter("page");
			int currentPage = Integer.parseInt(currentPage_);
			int cnt = gbs.countCnt(1,searchType,searchValue); //게시글 수 얻어오기
			
			//페이징
			PageVo pvo = new PageVo(cnt, currentPage, 5, 10);
			
			List<GuideBoardVo> bvoList = null;
			if(searchType ==null || searchType.equals("")) {
				bvoList = gbs.getList(1, pvo);
				
			}else {
				bvoList = gbs.getList(1 ,pvo, searchType, searchValue);		
			}
			
			//화면
			Map<String,String> map= new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			
			//화면
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pvo);
			req.setAttribute("gbvoList", bvoList);
			

			req.getRequestDispatcher("/WEB-INF/views/FpackerBoard/doFpackerList.jsp").forward(req, resp); 
		} catch (Exception e) {
			System.out.println("프패커합니다 리스트 보여주는 메소드에서 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "프패커합니다 리스트 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
		
	}
	
}
