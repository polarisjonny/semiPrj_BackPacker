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
		
		String sql="SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT ,L.CHANGE_NAME ,M.ID AS ID ,M.NICK AS NICK FROM INFO_BOARD I JOIN INFO_BOARD_IMG_LIST L ON I.INFO_NO = L.INFO_NO JOIN MEMBER M ON M.MEMBER_NO = I.WRITER_NO WHERE DELETE_YN ='N' ORDER BY INFO_NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2, pv.getLastRow());
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
			String changeName = rs.getString("CHANGE_NAME");
			String writerId = rs.getString("ID");
			String writerNick = rs.getString("NICK");
			
			
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
			vo.setChangeName(changeName);
			vo.setwriterId(writerId);
			vo.setwriterNick(writerNick);
			
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

	//상세조회
	public TravelReviewVo selectOneByNo(Connection conn, String infoNo) throws Exception {

		String sql = "SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT ,M.PROFILE_IMAGE ,M.NICK ,M.ID ,L.CHANGE_NAME FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO JOIN INFO_BOARD_IMG_LIST L ON I.INFO_NO = L.INFO_NO WHERE I.INFO_NO=? AND DELETE_YN='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, infoNo);
		ResultSet rs = pstmt.executeQuery();
		
		TravelReviewVo vo = new TravelReviewVo();
		if(rs.next()) {
			String infoCategoryNo = rs.getString("INFO_CATEGORY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String deleteYn = rs.getString("DELETE_YN");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String writerNick = rs.getString("NICK");
			String changeName = rs.getString("CHANGE_NAME");
			String writerId = rs.getString("ID");
			
			vo.setInfoNo(infoNo);
			vo.setInfoCategoryNo(infoCategoryNo);
			vo.setWriterNo(writerNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(modifyDate);
			vo.setHit(hit);
			vo.setDeleteYn(deleteYn);
			vo.setProfileImage(profileImage);
			vo.setwriterNick(writerNick);
			vo.setChangeName(changeName);
			vo.setwriterId(writerId);
		}

			JDBCTemplate.close(pstmt);

			return vo;
	
	}

	//여행후기 조회수 증가
	public int increaseHit(Connection conn, String infoNo) throws Exception {
		
		String sql="UPDATE INFO_BOARD SET HIT = HIT+1 WHERE INFO_NO = ? AND DELETE_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, infoNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

	//여행 후기 삭제
	public int delete(Connection conn, TravelReviewVo vo) throws Exception {

		String sql = "UPDATE INFO_BOARD SET DELETE_YN = 'Y' WHERE INFO_NO= ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getInfoNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}//class














