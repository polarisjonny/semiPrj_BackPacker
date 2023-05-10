package com.bp.app.scheduler.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.scheduler.vo.PlaceVo;

public class SchedulerService {

	public List<PlaceVo> selectPlace() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		String sql = "SELECT * FROM PLACE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		//tx
		List<PlaceVo>list = new ArrayList<>();
		while(rs.next()) {
			String placeNo = rs.getString("PLACE_NO");
			String placeCategoryNo = rs.getString("PLACE_CATEGORY_NO");
			String countryNo = rs.getString("COUNTRY_NO");
			String locationNo = rs.getString("LOCATION_NO");
			String placeName = rs.getString("PLACE_NAME");
			String placeIntroduce = rs.getString("PLACE_INTRODUCE");
			String placeImage = rs.getString("PLACE_IMAGE");
			String placeLat = rs.getString("PLACE_LAT");
			String placeLng = rs.getString("PLACE_LNG");
			String placeTime = rs.getString("PLACE_TIME");
			String placeExpense = rs.getString("PLACE_EXPENSE");
			
			PlaceVo vo = new PlaceVo();
			vo.setPlaceNo(placeNo);
			vo.setPlaceCategoryNo(placeCategoryNo);
			vo.setCountryNo(countryNo);
			vo.setLocationNo(locationNo);
			vo.setPlaceName(placeName);
			vo.setPlaceIntroduce(placeIntroduce);
			vo.setPlaceImage(placeImage);
			vo.setPlaceLat(placeLat);
			vo.setPlaceLng(placeLng);
			vo.setPlaceTime(placeTime);
			vo.setPlaceExpense(placeExpense);
			
			list.add(vo);
			
			
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		JDBCTemplate.close(conn);
		
		
		return list;
	}

}
