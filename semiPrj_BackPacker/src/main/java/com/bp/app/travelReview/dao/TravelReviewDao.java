package com.bp.app.travelReview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.travelReview.vo.TravelReviewVo;
import com.bp.app.util.file.AttachmentVo;

public class TravelReviewDao {

	public int selectCnt(Connection conn) throws Exception {

		//sql
		String sql ="SELECT COUNT(*) FROM INFO_BOARD WHERE DELETE_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//tx | rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
		

		
	}

	//여행후기 조회
	public List<TravelReviewVo> selectReviewList(Connection conn, PageVo pv) throws Exception {
		
		String sql="SELECT * FROM INFO_BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<TravelReviewVo> trList = new ArrayList<>(); 
		while(rs.next()) {
			
			String infoNo = rs.getString("INFO_NO");
			String infoCategoryNo = rs.getString("INFO_CATEGORY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String deleteYn = rs.getString("DELETE_YN");
			
			TravelReviewVo vo = new TravelReviewVo();
			vo.setInfoNo(infoNo);
			vo.setInfoCategoryNo(infoCategoryNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDeleteYn(deleteYn);
			
			trList.add(vo);
		}
		
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		
			return trList;
		
	}

	//여행후기 작성
	public int write(Connection conn, TravelReviewVo trvo) throws Exception {

		String sql="INSERT INTO INFO_BOARD( INFO_NO ,INFO_CATEGORY_NO ,WRITER_NO ,TITLE ,CONTENT ) VALUES (SEQ_INFO_BOARD_NO.NEXTVAL , 1 , ? , ? , ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, trvo.getWriterNo());
		pstmt.setString(2, trvo.getTitle());
		pstmt.setString(3, trvo.getContent());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
		
	}

	//여행 후기 이미지 업로드
	public int insertReviewImg(Connection conn, AttachmentVo attvo) throws Exception {

		String sql="INSERT INTO INFO_BOARD_IMG_LIST( IMG_LIST_NO ,INFO_NO ,ORIGIN_NAME ,CHANGE_NAME ) VALUES ( SEQ_IMG_LIST_NO.NEXTVAL , SEQ_INFO_BOARD_NO.CURRVAL,?, ? )";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, attvo.getOriginName());
		pstmt.setString(2, attvo.getChangeName());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}//class














