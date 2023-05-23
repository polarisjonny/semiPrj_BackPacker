package com.bp.app.scheduler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.scheduler.service.SchedulerService;
import com.bp.app.scheduler.vo.PlaceVo;
import com.google.gson.Gson;

@WebServlet("/schedulermake/searchPlace")
public class Search extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			SchedulerService ss = new SchedulerService();
			List<PlaceVo>list = ss.search(req);
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(list);
			
			System.out.println(list);
			//문자열 내보내기
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);
			
		} catch (Exception e) {
			System.out.println("[ERROR] place search가져오다가 에러");
			e.printStackTrace();
		
		}
		
		
		
	
	}

}
