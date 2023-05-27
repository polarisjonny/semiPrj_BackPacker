package com.bp.app.admin.placeManage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.scheduler.vo.PlaceVo;

public class PlaceManageDao {

	public int getPlaceListCnt(Connection conn, String searchType, String searchValue) throws Exception {
		String sql ="SELECT COUNT(*) FROM ( SELECT P.PLACE_DELETE_YN, P.PLACE_NO, P.PLACE_CATEGORY_NO, P.COUNTRY_NO, P.LOCATION_NO, P.PLACE_NAME AS NAME, P.PLACE_INTRODUCE, P.PLACE_IMAGE, P.PLACE_LAT, P.PLACE_LNG, P.PLACE_TIME, P.PLACE_EXPENSE, PC.PLACE_NAME AS PLACECATEGORY , LC.LOCATION_NAME AS LOCATIONCATEGORY, CC.COUNTRY_NAME AS COUNTRYCATEGORY FROM PLACE P JOIN PLACE_CATEGORY PC ON P.PLACE_CATEGORY_NO = PC.PLACE_CATEGORY_NO JOIN LOCATION_CATEGORY LC ON P.LOCATION_NO = LC.LOCATION_NO JOIN COUNTRY_CATEGORY CC ON P.COUNTRY_NO = CC.COUNTRY_NO ) WHERE PLACE_DELETE_YN = 'N'";

		if("name".equals(searchType)){
			sql += " AND " +searchType + " LIKE '%" + searchValue + "%'";
		
		}else if("placeCategory".equals(searchType)){
			sql += " AND " +searchType + " LIKE '%" + searchValue + "%'";
					
		}else if("locationCategory".equals(searchType)){
			sql += " AND " +searchType + " LIKE '%" + searchValue + "%'";
			
		}else if("countryCategory".equals(searchType)){
			sql += " AND " +searchType + " LIKE '%" + searchValue + "%'";
		}
		
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//tx||rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	public List<PlaceVo> getPlaceList(Connection conn, PageVo pv) throws Exception {
		String sql = "SELECT *FROM (  SELECT ROWNUM RNUM, T.* FROM (SELECT P.PLACE_DELETE_YN,P.PLACE_NO, P.PLACE_CATEGORY_NO, P.COUNTRY_NO, P.LOCATION_NO, P.PLACE_NAME AS NAME, P.PLACE_INTRODUCE, P.PLACE_IMAGE, P.PLACE_LAT, P.PLACE_LNG, P.PLACE_TIME, P.PLACE_EXPENSE, PC.PLACE_NAME AS PLACECATEGORY , LC.LOCATION_NAME AS LOCATIONCATEGORY, CC.COUNTRY_NAME AS COUNTRYCATEGORY FROM PLACE P JOIN PLACE_CATEGORY PC ON P.PLACE_CATEGORY_NO = PC.PLACE_CATEGORY_NO JOIN LOCATION_CATEGORY LC ON P.LOCATION_NO = LC.LOCATION_NO JOIN COUNTRY_CATEGORY CC ON P.COUNTRY_NO = CC.COUNTRY_NO WHERE PLACE_DELETE_YN = 'N' ORDER BY PLACE_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		
		List<PlaceVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String placeNo = rs.getString("PLACE_NO");
			String placeCategoryNo = rs.getString("PLACE_CATEGORY_NO");
			String countryNo = rs.getString("COUNTRY_NO");
			String locationNo = rs.getString("LOCATION_NO");
			String placeName = rs.getString("NAME");
			String placeIntroduce = rs.getString("PLACE_INTRODUCE");
			String placeImage = rs.getString("PLACE_IMAGE");
			String placeLat = rs.getString("PLACE_LAT");
			String placeLng = rs.getString("PLACE_LNG");
			String placeTime = rs.getString("PLACE_TIME");
			String placeExpense = rs.getString("PLACE_EXPENSE");
			String placeCategory = rs.getString("PLACECATEGORY");
			String locationCategory = rs.getString("LOCATIONCATEGORY");
			String countryCategory =rs.getString("COUNTRYCATEGORY");
			String placeDeleteYn = rs.getString("PLACE_DELETE_YN");
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
			vo.setPlaceCategory(placeCategory);
			vo.setLocationCategory(locationCategory);
			vo.setCountryCategory(countryCategory);
			vo.setPlaceDeleteYn(placeDeleteYn);
			
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	public List<PlaceVo> getPlaceList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {
		String sql = "";
		
		if("name".equals(searchType)) {
			//sql(제목으로검색)
			sql = "SELECT *FROM (  SELECT ROWNUM RNUM, T.* FROM (SELECT P.PLACE_DELETE_YN,P.PLACE_NO, P.PLACE_CATEGORY_NO, P.COUNTRY_NO, P.LOCATION_NO, P.PLACE_NAME AS NAME, P.PLACE_INTRODUCE, P.PLACE_IMAGE, P.PLACE_LAT, P.PLACE_LNG, P.PLACE_TIME, P.PLACE_EXPENSE, PC.PLACE_NAME AS PLACECATEGORY , LC.LOCATION_NAME AS LOCATIONCATEGORY, CC.COUNTRY_NAME AS COUNTRYCATEGORY FROM PLACE P JOIN PLACE_CATEGORY PC ON P.PLACE_CATEGORY_NO = PC.PLACE_CATEGORY_NO JOIN LOCATION_CATEGORY LC ON P.LOCATION_NO = LC.LOCATION_NO JOIN COUNTRY_CATEGORY CC ON P.COUNTRY_NO = CC.COUNTRY_NO WHERE PLACE_DELETE_YN = 'N' AND P.PLACE_NAME LIKE ('%'||?||'%') ORDER BY PLACE_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if("placeCategory".equals(searchType)) {
			//sql(작성자로검색)
			sql = "SELECT *FROM (  SELECT ROWNUM RNUM, T.* FROM (SELECT P.PLACE_DELETE_YN,P.PLACE_NO, P.PLACE_CATEGORY_NO, P.COUNTRY_NO, P.LOCATION_NO, P.PLACE_NAME AS NAME, P.PLACE_INTRODUCE, P.PLACE_IMAGE, P.PLACE_LAT, P.PLACE_LNG, P.PLACE_TIME, P.PLACE_EXPENSE, PC.PLACE_NAME AS PLACECATEGORY , LC.LOCATION_NAME AS LOCATIONCATEGORY, CC.COUNTRY_NAME AS COUNTRYCATEGORY FROM PLACE P JOIN PLACE_CATEGORY PC ON P.PLACE_CATEGORY_NO = PC.PLACE_CATEGORY_NO JOIN LOCATION_CATEGORY LC ON P.LOCATION_NO = LC.LOCATION_NO JOIN COUNTRY_CATEGORY CC ON P.COUNTRY_NO = CC.COUNTRY_NO WHERE PLACE_DELETE_YN = 'N' AND PC.PLACE_NAME LIKE ('%'||?||'%') ORDER BY PLACE_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if ("locationCategory".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT *FROM (  SELECT ROWNUM RNUM, T.* FROM (SELECT P.PLACE_DELETE_YN,P.PLACE_NO, P.PLACE_CATEGORY_NO, P.COUNTRY_NO, P.LOCATION_NO, P.PLACE_NAME AS NAME, P.PLACE_INTRODUCE, P.PLACE_IMAGE, P.PLACE_LAT, P.PLACE_LNG, P.PLACE_TIME, P.PLACE_EXPENSE, PC.PLACE_NAME AS PLACECATEGORY , LC.LOCATION_NAME AS LOCATIONCATEGORY, CC.COUNTRY_NAME AS COUNTRYCATEGORY FROM PLACE P JOIN PLACE_CATEGORY PC ON P.PLACE_CATEGORY_NO = PC.PLACE_CATEGORY_NO JOIN LOCATION_CATEGORY LC ON P.LOCATION_NO = LC.LOCATION_NO JOIN COUNTRY_CATEGORY CC ON P.COUNTRY_NO = CC.COUNTRY_NO WHERE PLACE_DELETE_YN = 'N' AND LC.LOCATION_NAME LIKE ('%'||?||'%') ORDER BY PLACE_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
			
		}else if ("countryCategory".equals(searchType)) {
			//sql(카테고리로검색)
			sql = "SELECT *FROM (  SELECT ROWNUM RNUM, T.* FROM (SELECT P.PLACE_DELETE_YN,P.PLACE_NO, P.PLACE_CATEGORY_NO, P.COUNTRY_NO, P.LOCATION_NO, P.PLACE_NAME AS NAME, P.PLACE_INTRODUCE, P.PLACE_IMAGE, P.PLACE_LAT, P.PLACE_LNG, P.PLACE_TIME, P.PLACE_EXPENSE, PC.PLACE_NAME AS PLACECATEGORY , LC.LOCATION_NAME AS LOCATIONCATEGORY, CC.COUNTRY_NAME AS COUNTRYCATEGORY FROM PLACE P JOIN PLACE_CATEGORY PC ON P.PLACE_CATEGORY_NO = PC.PLACE_CATEGORY_NO JOIN LOCATION_CATEGORY LC ON P.LOCATION_NO = LC.LOCATION_NO JOIN COUNTRY_CATEGORY CC ON P.COUNTRY_NO = CC.COUNTRY_NO WHERE PLACE_DELETE_YN = 'N' AND CC.COUNTRY_NAME LIKE ('%'||?||'%') ORDER BY PLACE_NO DESC ) T )WHERE  RNUM BETWEEN ? AND ?";
		}else {
			getPlaceList(conn, pv);
		}
		

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setInt(3, pv.getLastRow());
		ResultSet rs =  pstmt.executeQuery();
		
		List<PlaceVo> voList = new ArrayList<>();
		while(rs.next()) {
			
			String placeNo = rs.getString("PLACE_NO");
			String placeCategoryNo = rs.getString("PLACE_CATEGORY_NO");
			String countryNo = rs.getString("COUNTRY_NO");
			String locationNo = rs.getString("LOCATION_NO");
			String placeName = rs.getString("NAME");
			String placeIntroduce = rs.getString("PLACE_INTRODUCE");
			String placeImage = rs.getString("PLACE_IMAGE");
			String placeLat = rs.getString("PLACE_LAT");
			String placeLng = rs.getString("PLACE_LNG");
			String placeTime = rs.getString("PLACE_TIME");
			String placeExpense = rs.getString("PLACE_EXPENSE");
			String placeCategory = rs.getString("PLACECATEGORY");
			String locationCategory = rs.getString("LOCATIONCATEGORY");
			String countryCategory =rs.getString("COUNTRYCATEGORY");
			String placeDeleteYn = rs.getString("PLACE_DELETE_YN");
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
			vo.setPlaceCategory(placeCategory);
			vo.setLocationCategory(locationCategory);
			vo.setCountryCategory(countryCategory);
			vo.setPlaceDeleteYn(placeDeleteYn);
			
			voList.add(vo);
			
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return voList;
	}

	public PlaceVo getPlaceOneByNo(Connection conn, String placeNo) throws Exception {
		
		String sql = "SELECT P.PLACE_DELETE_YN,P.PLACE_NO, P.PLACE_CATEGORY_NO, P.COUNTRY_NO, P.LOCATION_NO, P.PLACE_NAME AS NAME, P.PLACE_INTRODUCE, P.PLACE_IMAGE, P.PLACE_LAT, P.PLACE_LNG, P.PLACE_TIME, P.PLACE_EXPENSE, PC.PLACE_NAME AS PLACECATEGORY , LC.LOCATION_NAME AS LOCATIONCATEGORY, CC.COUNTRY_NAME AS COUNTRYCATEGORY FROM PLACE P JOIN PLACE_CATEGORY PC ON P.PLACE_CATEGORY_NO = PC.PLACE_CATEGORY_NO JOIN LOCATION_CATEGORY LC ON P.LOCATION_NO = LC.LOCATION_NO JOIN COUNTRY_CATEGORY CC ON P.COUNTRY_NO = CC.COUNTRY_NO WHERE PLACE_DELETE_YN = 'N' AND PLACE_NO =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, placeNo);
		ResultSet rs = pstmt.executeQuery();
		PlaceVo vo = new PlaceVo();
		while(rs.next()) {
			
			String placeCategoryNo = rs.getString("PLACE_CATEGORY_NO");
			String countryNo = rs.getString("COUNTRY_NO");
			String locationNo = rs.getString("LOCATION_NO");
			String placeName = rs.getString("NAME");
			String placeIntroduce = rs.getString("PLACE_INTRODUCE");
			String placeImage = rs.getString("PLACE_IMAGE");
			String placeLat = rs.getString("PLACE_LAT");
			String placeLng = rs.getString("PLACE_LNG");
			String placeTime = rs.getString("PLACE_TIME");
			String placeExpense = rs.getString("PLACE_EXPENSE");
			String placeCategory = rs.getString("PLACECATEGORY");
			String locationCategory = rs.getString("LOCATIONCATEGORY");
			String countryCategory =rs.getString("COUNTRYCATEGORY");
			String placeDeleteYn = rs.getString("PLACE_DELETE_YN");
			
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
			vo.setPlaceCategory(placeCategory);
			vo.setLocationCategory(locationCategory);
			vo.setCountryCategory(countryCategory);
			vo.setPlaceDeleteYn(placeDeleteYn);
		}
		return vo;
	}

	public int deletePlace(Connection conn, String placeNo) throws Exception {
		String sql = "UPDATE PLACE SET PLACE_DELETE_YN='Y' WHERE PLACE_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, placeNo);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
	}

	public int addPlace(Connection conn, PlaceVo vo) throws Exception {
		//SQL
		String sql = "INSERT INTO PLACE( PLACE_NO, PLACE_CATEGORY_NO, COUNTRY_NO, LOCATION_NO, PLACE_NAME, PLACE_INTRODUCE, PLACE_IMAGE, PLACE_LAT, PLACE_LNG, PLACE_TIME, PLACE_EXPENSE ) VALUES(SEQ_PLACE_NO.NEXTVAL , ?, ?, ?, ?, ?, ?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,vo.getPlaceCategoryNo());
		pstmt.setString(2, vo.getCountryNo());
		pstmt.setString(3, vo.getLocationNo());
		pstmt.setString(4, vo.getPlaceName());
		pstmt.setString(5, vo.getPlaceIntroduce());
		pstmt.setString(6, vo.getPlaceImage());
		pstmt.setString(7, vo.getPlaceLat());
		pstmt.setString(8, vo.getPlaceLng());
		pstmt.setString(9, vo.getPlaceTime());
		pstmt.setString(10, vo.getPlaceExpense());
		pstmt.setString(10, vo.getPlaceExpense());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
	}

	public int editPlace(Connection conn, PlaceVo vo) throws Exception {
		//SQL
		String sql = "";
		sql = "UPDATE PLACE SET PLACE_CATEGORY_NO =? , COUNTRY_NO = ? , LOCATION_NO = ?, PLACE_NAME = ?, PLACE_INTRODUCE =?,  PLACE_LAT =? , PLACE_LNG=? , PLACE_TIME=? , PLACE_EXPENSE=? WHERE PLACE_NO = ?";
		if(vo.getPlaceImage() != null) {
			sql = "UPDATE PLACE SET PLACE_CATEGORY_NO =? , COUNTRY_NO = ? , LOCATION_NO = ?, PLACE_NAME = ?, PLACE_INTRODUCE =? , PLACE_LAT =? , PLACE_LNG=? , PLACE_TIME=? , PLACE_EXPENSE=? , PLACE_IMAGE=? WHERE PLACE_NO = ?";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPlaceCategoryNo());
		pstmt.setString(2, vo.getCountryNo());
		pstmt.setString(3, vo.getLocationNo());
		pstmt.setString(4, vo.getPlaceName());
		pstmt.setString(5, vo.getPlaceIntroduce());
		pstmt.setString(6, vo.getPlaceLat());
		pstmt.setString(7, vo.getPlaceLng());
		pstmt.setString(8, vo.getPlaceTime());
		pstmt.setString(9, vo.getPlaceExpense());
		if(vo.getPlaceImage() == null) {
			
			pstmt.setString(10, vo.getPlaceNo());
		}else if(vo.getPlaceImage() != null) {
			pstmt.setString(10, vo.getPlaceImage());
			pstmt.setString(11, vo.getPlaceNo());
			
		}
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
	}

}
