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

	public int selectCnt(Connection conn, String searchType, String searchValue) throws Exception {

		//sql
		String sql ="SELECT COUNT(*) FROM INFO_BOARD WHERE DELETE_YN = 'N' AND INFO_CATEGORY_NO = 1 AND TITLE LIKE '%'||?||'%'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
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

	//여행후기 작성
	public int write(Connection conn, TravelReviewVo trvo) throws Exception {
		
		String sql="INSERT INTO INFO_BOARD( INFO_NO ,INFO_CATEGORY_NO ,WRITER_NO ,TITLE ,CONTENT,MAIN_IMG ) VALUES (SEQ_INFO_BOARD_NO.NEXTVAL , 1 , ? , ? , ?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, trvo.getWriterNo());
		pstmt.setString(2, trvo.getTitle());
		pstmt.setString(3, trvo.getContent());
		pstmt.setString(4, trvo.getMainImg());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
		
	}
	
	//여행후기 조회
	public List<TravelReviewVo> selectReviewList(Connection conn, PageVo pv) throws Exception {
		
		String sql="SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG FROM INFO_BOARD I JOIN MEMBER M ON M.MEMBER_NO = I.WRITER_NO WHERE DELETE_YN ='N' AND INFO_CATEGORY_NO = 1 ORDER BY INFO_NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
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
//			String writerId = rs.getString("ID");
//			String writerNick = rs.getString("NICK");
			String mainImg = rs.getString("MAIN_IMG");
			
			
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
//			vo.setWriterId(writerId);
//			vo.setWriterNick(writerNick);
			vo.setMainImg(mainImg);
			
			trList.add(vo);
		}
		
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		
			return trList;
		
	}
	
	//검색해서 조회
	public List<TravelReviewVo> selectReviewList(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {

		String sql = "";
		if(searchType.equals("title")) {
			//제목 검색
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG ,C.INFO_CATEGORY_NAME , M.NICK FROM INFO_BOARD I JOIN INFO_BOARD_CATEGORY C ON (I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO) JOIN MEMBER M ON (I.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND I.TITLE LIKE '%'||?||'%' AND I.INFO_CATEGORY_NO = 1 ORDER BY INFO_NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		}else if(searchType.equals("writer")){
			//작성자 검색
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG ,C.INFO_CATEGORY_NAME , M.NICK FROM INFO_BOARD I JOIN INFO_BOARD_CATEGORY C ON I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO JOIN MEMBER M ON (I.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND M.NICK LIKE '%'||?||'%' AND I.INFO_CATEGORY_NO = 1 ORDER BY INFO_NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		}else {
			return selectReviewList(conn,pv);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setString(3, String.valueOf(pv.getLastRow()));
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
			String writerNick = rs.getString("NICK");
			String mainImg = rs.getString("MAIN_IMG");
			String infoCategoryName = rs.getString("INFO_CATEGORY_NAME");
			
			
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
			vo.setWriterNick(writerNick);
			vo.setMainImg(mainImg);
			vo.setInfoCategoryName(infoCategoryName);
			
			trList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return trList;
	
	}


	//여행 후기 이미지 업로드
	public int insertReviewImg(Connection conn) throws Exception {

		String sql="INSERT INTO INFO_BOARD_IMG_LIST( IMG_LIST_NO ,INFO_NO ,ORIGIN_NAME ,CHANGE_NAME ) VALUES ( SEQ_IMG_LIST_NO.NEXTVAL , SEQ_INFO_BOARD_NO.CURRVAL,?, ? )";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, attvo.getOriginName());
//		pstmt.setString(2, attvo.getChangeName());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//상세조회
	public TravelReviewVo selectOneByNo(Connection conn, String infoNo) throws Exception {

		String sql = "SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT ,I.MAIN_IMG ,M.PROFILE_IMAGE , M.NICK , M.ID FROM INFO_BOARD I JOIN MEMBER M ON I.WRITER_NO = M.MEMBER_NO WHERE I.INFO_NO= ? AND I.INFO_CATEGORY_NO = 1 AND DELETE_YN='N'";
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
			String writerId = rs.getString("ID");
			String mainImg = rs.getString("MAIN_IMG");
			
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
			vo.setWriterNick(writerNick);
			vo.setWriterId(writerId);
			vo.setChangeName(mainImg);
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

	//게시글 수정
	public int edit(Connection conn, TravelReviewVo vo) throws Exception {

		String sql ="UPDATE INFO_BOARD SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE INFO_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getInfoNo());
		int result = pstmt.executeUpdate();
		System.out.println(vo);
		
		JDBCTemplate.close(pstmt);
		
		return result;
	
	}

	//게시글 신고수 증가
	public int increaseReportCnt(Connection conn, TravelReviewVo vo) throws Exception {

		String sql = "UPDATE INFO_BOARD SET REPORT_CNT = REPORT_CNT+1 WHERE INFO_NO = ? AND DELETE_YN ='N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getInfoNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;

	}

	//게시글 신고내용 인서트
	public int insertReport(Connection conn, TravelReviewVo vo) throws Exception {
		
		String sql ="INSERT INTO INFO_BOARD_REPORT (REPORT_NO , MEMBER_NO , INFO_BOARD_NO , REPORT_CONTENT) VALUES (SEQ_INFO_REPORT_NO.NEXTVAL , ? , ? , ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getWriterNo());
		pstmt.setString(2, vo.getInfoNo());
		pstmt.setString(3, vo.getContent());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int replyWrite(Connection conn, TravelReviewVo replyVo) throws Exception {

		String sql="INSERT INTO INFO_BOARD_REPLY (REPLY_NO , INFO_NO , WRITER_NO , CONTENT) VALUES (SEQ_BOARD_REPLY_NO.NEXTVAL , ? , ? , ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, replyVo.getInfoNo());
		pstmt.setString(2, replyVo.getWriterNo());
		pstmt.setString(3, replyVo.getContent());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//댓글 조회
	public List<TravelReviewVo> selectReplyList(Connection conn, String infoNo) throws Exception {

		String sql = "SELECT I.REPLY_NO ,I.INFO_NO ,I.WRITER_NO ,I.CONTENT ,I.ENROLL_DATE ,I.DELETE_YN ,M.PROFILE_IMAGE ,M.NICK FROM INFO_BOARD_REPLY I JOIN MEMBER M ON(I.WRITER_NO = M.MEMBER_NO) WHERE INFO_NO = ? AND DELETE_YN ='N' ORDER BY REPLY_NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, infoNo);
		ResultSet rs = pstmt.executeQuery();
		
		List<TravelReviewVo> replyList = new ArrayList<>();
		while(rs.next()) {
			String replyNo = rs.getString("REPLY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String deleteYn = rs.getString("DELETE_YN");
			String profileImg = rs.getString("PROFILE_IMAGE");
			String nick = rs.getString("NICK");
			
			TravelReviewVo replyVo = new TravelReviewVo();
			replyVo.setReplyNo(replyNo);
			replyVo.setWriterNo(writerNo);		
			replyVo.setContent(content);
			replyVo.setEnrollDate(enrollDate);
			replyVo.setDeleteYn(deleteYn);
			replyVo.setProfileImage(profileImg);
			replyVo.setWriterNick(nick);
			
			replyList.add(replyVo);		
		}
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		
			return replyList;
	}//

	//댓글 삭제
	public int deleteReply(Connection conn, String replyNo) throws Exception {

		String sql ="UPDATE INFO_BOARD_REPLY SET DELETE_YN = 'Y' WHERE REPLY_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, replyNo);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public List<TravelReviewVo> TopHit(Connection conn, PageVo pv) throws Exception {
		
		String sql="SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG FROM INFO_BOARD I JOIN MEMBER M ON M.MEMBER_NO = I.WRITER_NO WHERE DELETE_YN ='N' AND INFO_CATEGORY_NO = 1 ORDER BY HIT DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pv.getBeginRow());
		pstmt.setInt(2,  pv.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<TravelReviewVo> list = new ArrayList<>();
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
//			String writerId = rs.getString("ID");
//			String writerNick = rs.getString("NICK");
			String mainImg = rs.getString("MAIN_IMG");
			
			
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
//			vo.setWriterId(writerId);
//			vo.setWriterNick(writerNick);
			vo.setMainImg(mainImg);
			
			list.add(vo);
		}
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return list;
	
	}

	public List<TravelReviewVo> TopHit(Connection conn, PageVo pv, String searchType, String searchValue) throws Exception {
		String sql = "";
		if(searchType.equals("title")) {
			//제목 검색
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG ,C.INFO_CATEGORY_NAME , M.NICK FROM INFO_BOARD I JOIN INFO_BOARD_CATEGORY C ON (I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO) JOIN MEMBER M ON (I.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND I.TITLE LIKE '%'||?||'%' AND I.INFO_CATEGORY_NO = 1 ORDER BY HIT DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		}else if(searchType.equals("writer")){
			//작성자 검색
			sql = "SELECT * FROM ( SELECT ROWNUM RNUM,T.* FROM (SELECT I.INFO_NO ,I.INFO_CATEGORY_NO ,I.WRITER_NO ,I.TITLE ,I.CONTENT ,I.ENROLL_DATE ,I.MODIFY_DATE ,I.HIT ,I.DELETE_YN ,I.REPORT_CNT, I.MAIN_IMG ,C.INFO_CATEGORY_NAME , M.NICK FROM INFO_BOARD I JOIN INFO_BOARD_CATEGORY C ON I.INFO_CATEGORY_NO = C.INFO_CATEGORY_NO JOIN MEMBER M ON (I.WRITER_NO = M.MEMBER_NO) WHERE DELETE_YN ='N' AND M.NICK LIKE '%'||?||'%' AND I.INFO_CATEGORY_NO = 1 ORDER BY HIT DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		}else {
			return TopHit(conn,pv);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		pstmt.setInt(2, pv.getBeginRow());
		pstmt.setString(3, String.valueOf(pv.getLastRow()));
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
			String writerNick = rs.getString("NICK");
			String mainImg = rs.getString("MAIN_IMG");
			String infoCategoryName = rs.getString("INFO_CATEGORY_NAME");
			
			
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
			vo.setWriterNick(writerNick);
			vo.setMainImg(mainImg);
			vo.setInfoCategoryName(infoCategoryName);
			
			trList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return trList;
	}

	

}//class














