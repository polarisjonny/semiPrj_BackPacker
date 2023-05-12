package com.bp.app.gboard.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.gboard.vo.GuideBoardVo;

public class GuideBoardService {

	public List<GuideBoardVo> getBoardList() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//sql
		//모든 정보를 join해서든 가지고 와야함
		//guide_board의 모든 정보 가져오기
		String sql = "SELECT GB.*, M.ID, M.NICK, M.AGE, M.PROFILE_IMAGE, M.GENDER, L.CHANGE_NAME FROM GUIDE_BOARD GB JOIN MEMBER M ON (GB.WRITER_NO = M.MEMBER_NO) JOIN GUIDE_BOARD_IMG_LIST L ON (L.GUIDE_BOARD_NO= GB.GUIDE_BOARD_NO)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<GuideBoardVo> bvoList = new ArrayList<>();
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat formatter2 = new SimpleDateFormat("M월d일");
		while(rs.next()) {
			String guideBoardNo =rs.getString("GUIDE_BOARD_NO");
			String writerNo =rs.getString("WRITER_NO");
			String guideBoardCategoryNo =rs.getString("GUIDE_BOARD_CATEGORY_NO");
			String title =rs.getString("TITLE");
			String content =rs.getString("CONTENT");
			String enrollDate =rs.getString("ENROLL_DATE");
			String modifyDate =rs.getString("MODIFY_DATE");
			String hit =rs.getString("HIT");
			String matchingState =rs.getString("MATCHING_STATE");
			String travelExpense =rs.getString("TRAVEL_EXPENSE");
			String deleteYn =rs.getString("DELETE_YN");
			String startDate =rs.getString("START_DATE");
			String endDate =rs.getString("END_DATE");
			
		
			
			//startDate 와 endDate를 날짜로 변환시키기
			Date startDate_ = formatter1.parse(startDate);
			Date endDate_ =formatter1.parse(endDate);
			//변환된 date를 원하는 형식에 알맞게 수정하여 set하기
			String formatStartDate = formatter2.format(startDate_);
			String formatEndDate = formatter2.format(endDate_);
	
			
			String changeName =rs.getString("CHANGE_NAME");
			
			String nickName =rs.getString("NICK");
			String id =rs.getString("ID");
			String age =rs.getString("AGE");
			String profile =rs.getString("PROFILE_IMAGE");
			String gender =rs.getString("GENDER");
			switch(gender) {
			case "M" : gender="남성"; break;
			case "F" : gender ="여성"; break;
			}
			
			GuideBoardVo bvo = new GuideBoardVo();
			bvo.setGuideBoardNo(guideBoardNo);
			bvo.setWriterNo(writerNo);
			bvo.setGuideBoardCategoryNo(guideBoardCategoryNo);
			bvo.setTitle(title);
			bvo.setContent(content);
			bvo.setEnrollDate(enrollDate);
			bvo.setModifyDate(modifyDate);
			bvo.setHit(hit);
			bvo.setMatchingState(matchingState);
			bvo.setTravelExpense(travelExpense);
			bvo.setDeleteYn(deleteYn);
			
			bvo.setStartDate(formatStartDate);
			bvo.setEndDate(formatEndDate);
			
			bvo.setChangeName(changeName);
			
			bvo.setNickName(nickName);
			bvo.setId(id);
			bvo.setAge(age);
			bvo.setProfile(profile);
			bvo.setGender(gender);
			
			bvoList.add(bvo);
			
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return bvoList;
		
		
	}

}
