package com.bp.app.accompany.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.service.GuideBoardService;
import com.bp.app.gboard.vo.GuideBoardVo;

@WebServlet ("/accompany/list")
public class AccompanyListController extends HttpServlet{
	//디비에서 셀렉트해서 가져온걸 보여주는 화면으로 가야함
	//BoardVo생성하고 Vo를 저장한 리스트를 화면측에 넘겨야함
	//어느Board인지 구분가능하게 작명하여 vo를 작성 GuideBoardVo
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//데뭉
		try {
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			
			//서비스
			//가이드vo형식의 리스트를 담아서 모든 정보를 가지고 와서 session에 담아 전달...? session에 담아야할까?
			GuideBoardService gbs = new GuideBoardService();
			String currentPage_ = req.getParameter("page");
			int currentPage = Integer.parseInt(currentPage_);
			int cnt = gbs.countCnt(3);
			
			PageVo pvo = new PageVo(cnt, currentPage, 5, 8);
			
			
			List<GuideBoardVo> bvoList = null;
			if(searchType ==null || searchType.equals("")) {
				bvoList = gbs.getList(3, pvo);
			}else {
				bvoList = gbs.getAccomList(pvo, searchType, searchValue);		
			}
			
			Map<String,String> map= new HashMap<>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			
			//화면
			req.setAttribute("searchVo", map);
			req.setAttribute("pv", pvo);
			req.setAttribute("gbvoList", bvoList);
			
			
			req.getRequestDispatcher("/WEB-INF/views/accompanyBoard/accompanyBoardList.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("동행게시판 리스트 보여주는 메소드에서 발생");
			e.printStackTrace();
			req.setAttribute("errorMsg", "동행게시판 리스트 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
			
		}
	}
}