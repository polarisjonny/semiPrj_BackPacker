package com.bp.app.admin.placeManage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bp.app.admin.placeManage.service.PlaceManageService;
import com.bp.app.scheduler.vo.PlaceVo;
import com.bp.app.util.file.AttachmentVo;
import com.bp.app.util.file.FileUploader;
@WebServlet("/admin/place/add")
public class PlaceAddController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/admin/place/place-add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			Part f = req.getPart("placeImage");
			String path = req.getServletContext().getRealPath("/static/img/place/");
			AttachmentVo attachmentVo = FileUploader.saveFile(path , f);
			
			//데꺼
			String placeCategoryNo = req.getParameter("placeCategoryNo");
			String countryNo = req.getParameter("countryNo");
			String locationNo = req.getParameter("locationNo");
			String placeIntroduce = req.getParameter("placeIntroduce");
			String placeTime = req.getParameter("placeTime");
			String placeExpense = req.getParameter("placeExpense");
			String placeLat = req.getParameter("placeLat");
			String placeLng = req.getParameter("placeLng");
			String placeName = req.getParameter("placeName");
		
			
			PlaceVo vo = new PlaceVo();
			vo.setPlaceCategory(placeCategoryNo);
			vo.setPlaceImage(attachmentVo.getChangeName());
			vo.setCountryNo(countryNo);
			vo.setLocationNo(locationNo);
			vo.setPlaceIntroduce(placeIntroduce);
			vo.setPlaceTime(placeTime);
			vo.setPlaceExpense(placeExpense);
			vo.setPlaceLat(placeLat);
			vo.setPlaceLng(placeLng);
			vo.setPlaceName(placeName);
			
			PlaceManageService pms = new PlaceManageService();
			int result = pms.addPlace(vo);
			
			//화면
			if(result == 1) {
				String root = req.getContextPath();
				req.getSession().setAttribute("alertMsg", "여행지 추가 성공!");
				resp.sendRedirect(root + "/admin/place/list");
			}else {
				throw new Exception("[ERROR] 여행지 추가 에러.");
			}
			
			
			
		}catch(Exception e ) {
			System.out.println("[ERROR] add fail ...");
			e.printStackTrace();
			
			req.setAttribute("errorMsg", "여행지추가 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(req, resp);
		}

		
		
		
	}

	
}
