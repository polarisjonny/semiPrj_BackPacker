package com.bp.app.admin.placeManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.admin.placeManage.service.PlaceManageService;
import com.bp.app.scheduler.vo.PlaceVo;
@WebServlet("/admin/place/delete")
public class PlaceDeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String placeNo = req.getParameter("placeNo");
			
			PlaceManageService pms = new PlaceManageService();
			
			int result = pms.deletePlace(placeNo);
			if(result ==1) {
				String root = req.getContextPath();
				resp.sendRedirect(root + "/admin/place/list");
			}else {
				throw new Exception("[ERROR] 여행지 삭제 중 에러 발생");
			}
		}catch(Exception e) {
			System.out.println("[ERROR] 여행지 삭제 에러");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "여행지 삭제 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}
			
	}
}
