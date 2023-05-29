package com.bp.app.gboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.gboard.vo.GuideBoardVo;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.report.vo.ReportVo;

public class GuideBoardDao {
	//스케쥴러인서트
	public int insertScheduler(Connection conn, GuideBoardVo vo, MemberVo loginMember) throws Exception {
		String sql = "INSERT INTO SCHEDULER (SCHEDULER_NO, MEMBER_NO,START_DATE,END_DATE) VALUES (SEQ_SCHEDULER_NO.NEXTVAL,?,TO_DATE('"+vo.getStartDate()+"','YYYY-MM-DD'),TO_DATE('"+vo.getEndDate()+"','YYYY-MM-DD'))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		return result;
	}
	
	//가이드 보드에 인서트
	public int insertGuideBoard(Connection conn, GuideBoardVo vo, MemberVo loginMember) throws Exception {
		String sql = "INSERT INTO GUIDE_BOARD (GUIDE_BOARD_NO,WRITER_NO,GUIDE_BOARD_CATEGORY_NO, SCHEDULER_NO, TITLE,CONTENT,MAIN_IMG) VALUES (SEQ_GUIDE_BOARD_NO.NEXTVAL,?,?,SEQ_SCHEDULER_NO.CURRVAL,?,?,?)";
		//여행 경비값이 있을때 다른 쿼리문 실행
		if(vo.getTravelExpense()!=null) {
			sql = "INSERT INTO GUIDE_BOARD (GUIDE_BOARD_NO,WRITER_NO,GUIDE_BOARD_CATEGORY_NO, SCHEDULER_NO, TITLE,CONTENT,MAIN_IMG,TRAVEL_EXPENSE) VALUES (SEQ_GUIDE_BOARD_NO.NEXTVAL,?,?,SEQ_SCHEDULER_NO.CURRVAL,?,?,?,?)";
	
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getMemberNo());
		pstmt.setString(2, vo.getGuideBoardCategoryNo());
		pstmt.setString(3, vo.getTitle());
		pstmt.setString(4, vo.getContent());
		pstmt.setString(5, vo.getMainImg());
		if(vo.getTravelExpense()!=null) {
			pstmt.setString(6, vo.getTravelExpense());
		}
		
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);

		
		return result;
	}

	
	//작성자 정보 가져오기
	public MemberVo selectMemberByNo(Connection conn, GuideBoardVo bvo) throws Exception {
		//sql
		String sql = "SELECT NICK,ID,PROFILE_IMAGE,INTRO_MESSAGE FROM MEMBER WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bvo.getWriterNo());
		ResultSet rs =  pstmt.executeQuery();
		
		//rs
		MemberVo writerMember = null;
		if(rs.next()) {
			String nick = rs.getString("NICK");
			String id = rs.getString("ID");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String introMessage = rs.getString("INTRO_MESSAGE");
			
			writerMember = new MemberVo();
			writerMember.setMemberNo(bvo.getWriterNo());
			writerMember.setNick(nick);;
			writerMember.setId(id);
			writerMember.setProfileImage(profileImage);
			writerMember.setIntroMessage(introMessage);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return writerMember;
	}
	//게시글한개가져오기
	public GuideBoardVo selectOneByNo(Connection conn, GuideBoardVo bvo) throws Exception {
		//sql
		String sql ="SELECT TITLE,CONTENT,ENROLL_DATE,MODIFY_DATE,HIT,MATCHING_STATE,SCHEDULER_NO, MAIN_IMG FROM GUIDE_BOARD WHERE GUIDE_BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bvo.getGuideBoardNo());
		ResultSet rs = pstmt.executeQuery();
				
		//rs
		GuideBoardVo selectedBvo = null; 
		if(rs.next()) {
			String title =rs.getString("TITLE");
			String content =rs.getString("CONTENT");
			String enrollDate =rs.getString("ENROLL_DATE");
			String modifyDate =rs.getString("MODIFY_DATE");
			String hit =rs.getString("HIT");
			String matchingState =rs.getString("MATCHING_STATE");
			String schedulerNo =rs.getString("SCHEDULER_NO");
			String mainImg = rs.getString("MAIN_IMG");
			
			selectedBvo = new GuideBoardVo();
			selectedBvo.setTitle(title);
			selectedBvo.setContent(content);	
			selectedBvo.setEnrollDate(enrollDate);
			selectedBvo.setModifyDate(modifyDate);
			selectedBvo.setHit(hit);
			selectedBvo.setMatchingState(matchingState);
			selectedBvo.setSchedulerNo(schedulerNo);
			selectedBvo.setGuideBoardNo(bvo.getGuideBoardNo());
			selectedBvo.setMainImg(mainImg);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return selectedBvo;
	}
	
	//신고테이블 인서트
	public int insertReport(Connection conn, ReportVo vo) throws Exception {
		String sql ="INSERT INTO GUIDE_REPORT (REPORT_NO,MEMBER_NO,GUIDE_BOARD_NO,REPORT_CONTENT) VALUES (SEQ_GUIDE_REPORT_NO.NEXTVAL,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberNo());
		pstmt.setString(2, vo.getGuideBoardNo());
		pstmt.setString(3, vo.getReportContent());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//신고수 업데이트하기
	public int reportCnt(Connection conn, ReportVo vo) throws Exception {
		String sql = "UPDATE GUIDE_BOARD SET REPORT_CNT = REPORT_CNT+1 WHERE GUIDE_BOARD_NO =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getGuideBoardNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(conn);
		return result;
	}
	//조회수 올리기
	public int increaseHit(Connection conn, GuideBoardVo bvo) throws Exception {
		String sql = "UPDATE GUIDE_BOARD SET HIT = HIT+1 WHERE GUIDE_BOARD_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bvo.getGuideBoardNo());
		int result =pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}
	//목록 보여주기 리스트 가져와서 담기
	public List<GuideBoardVo> getList(Connection conn, int i, PageVo pvo) throws Exception {
		//sql
		String sql ="SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM( SELECT GB.GUIDE_BOARD_NO ,GB.TITLE , GB.WRITER_NO , GB.SCHEDULER_NO , M.ID , M.NICK , M.AGE , M.PROFILE_IMAGE , M.GENDER ,GB.MAIN_IMG ,TO_CHAR(S.START_DATE,'YYYY-MM-DD')AS START_DATE ,TO_CHAR(S.END_DATE,'YYYY-MM-DD')AS END_DATE ,GB.GUIDE_BOARD_CATEGORY_NO ,GB.CONTENT ,GB.ENROLL_DATE ,GB.MODIFY_DATE ,GB.HIT ,GB.MATCHING_STATE ,TO_CHAR(GB.TRAVEL_EXPENSE,'999,999,999,999') AS TRAVEL_EXPENSE ,GB.DELETE_YN ,GB.REPORT_CNT ,C.CATEGORY_NAME FROM GUIDE_BOARD GB JOIN MEMBER M ON (GB.WRITER_NO = M.MEMBER_NO) JOIN SCHEDULER S ON(S.SCHEDULER_NO=GB.SCHEDULER_NO) JOIN GUIDE_BOARD_CATEGORY C ON(GB.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO) WHERE GUIDE_BOARD_CATEGORY_NO =? AND DELETE_YN = 'N' AND MATCHING_STATE = 'N' ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, i);
		pstmt.setInt(2, pvo.getBeginRow());
		pstmt.setInt(3, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<GuideBoardVo> bvoList = new ArrayList<>(); 
		while(rs.next()) {
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String title = rs.getString("TITLE");
			String id = rs.getString("ID");
			String nick = rs.getString("NICK");
			String age = rs.getString("AGE");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String gender = rs.getString("GENDER");
			String writerNo = rs.getString("WRITER_NO");
			String mainImg = rs.getString("MAIN_IMG");
			String schedulerNo = rs.getString("SCHEDULER_NO");
			
			if(gender=="M") {
				gender="남성";
			}else {
				gender="여성"; 
			}
			
			String startDate_ = rs.getString("START_DATE");
			String endDate_ = rs.getString("END_DATE");
			
			String guideBoardCategoryNo = rs.getString("GUIDE_BOARD_CATEGORY_NO");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String matchingState = rs.getString("MATCHING_STATE");
			String travelExpense = rs.getString("TRAVEL_EXPENSE");
			String deleteYn = rs.getString("DELETE_YN");
			String reportCnt = rs.getString("REPORT_CNT");
			String categoryName = rs.getString("CATEGORY_NAME");
			
			GuideBoardVo bvo = new GuideBoardVo();
			bvo.setGuideBoardCategoryNo(guideBoardCategoryNo);
			bvo.setContent(content);
			bvo.setEnrollDate(enrollDate);
			bvo.setModifyDate(modifyDate);
			bvo.setHit(hit);
			bvo.setMatchingState(matchingState);
			bvo.setTravelExpense(travelExpense);
			bvo.setDeleteYn(deleteYn);
			bvo.setReportCnt(reportCnt);
			bvo.setCategoryName(categoryName);
			
			bvo.setGuideBoardNo(guideBoardNo);
			bvo.setTitle(title);
			bvo.setId(id);
			bvo.setNick(nick);
			bvo.setAge(age);
			bvo.setProfileImage(profileImage);
			bvo.setWriterNo(writerNo);
			
			bvo.setGender(gender);
			bvo.setMainImg(mainImg);
			bvo.setSchedulerNo(schedulerNo);
			//5월11일 이런식으로 데이터를 가공
			if(startDate_==null) {
					
			}else {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date startDate = formatter.parse(startDate_);
				Date endDate =formatter.parse(endDate_);
				SimpleDateFormat format = new SimpleDateFormat("MM월 dd일");
				String startDateStr = format.format(startDate);
				String endDateStr = format.format(endDate);
				
				
				bvo.setStartDate(startDateStr);
				bvo.setEndDate(endDateStr);
			}
			
			
			
			bvoList.add(bvo);
			
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return bvoList;
	}

	public int countCnt(Connection conn, int categoryNo, String searchType, String searchValue) throws Exception {
		//sql
		String sql = "SELECT COUNT(*) as CNT FROM (SELECT GB.GUIDE_BOARD_NO ,GB.TITLE , GB.WRITER_NO , GB.SCHEDULER_NO , M.ID , M.NICK , M.AGE , M.PROFILE_IMAGE , M.GENDER ,GB.MAIN_IMG ,TO_CHAR(S.START_DATE,'YYYY-MM-DD')AS START_DATE ,TO_CHAR(S.END_DATE,'YYYY-MM-DD')AS END_DATE ,GB.GUIDE_BOARD_CATEGORY_NO ,GB.CONTENT ,GB.ENROLL_DATE ,GB.MODIFY_DATE ,GB.HIT ,GB.MATCHING_STATE ,GB.TRAVEL_EXPENSE ,GB.DELETE_YN ,GB.REPORT_CNT ,C.CATEGORY_NAME FROM GUIDE_BOARD GB JOIN MEMBER M ON (GB.WRITER_NO = M.MEMBER_NO) JOIN SCHEDULER S ON(S.SCHEDULER_NO=GB.SCHEDULER_NO) JOIN GUIDE_BOARD_CATEGORY C ON(GB.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO)) WHERE DELETE_YN ='N' and MATCHING_STATE = 'N' AND GUIDE_BOARD_CATEGORY_NO = ? ";
		
		if("title".equals(searchType)) {
			sql += "AND TITLE LIKE '%" + searchValue + "%'";
		}else if("writerId".equals(searchType)) {
			sql += "AND ID LIKE '%" + searchValue + "%'";
		}else if("writerNick".equals(searchType)) {
			sql += "AND NICK LIKE '%" + searchValue + "%'";
		}
		
		
		
		
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setInt(1,categoryNo);
		ResultSet rs = pstmt.executeQuery();
		//rs
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt("CNT");
		}
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	public List<GuideBoardVo> getList(Connection conn, int i, PageVo pvo, String searchType, String searchValue) throws Exception {
		//sql
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM( SELECT GB.GUIDE_BOARD_NO ,GB.SCHEDULER_NO ,GB.TITLE , GB.WRITER_NO , M.ID , M.NICK , M.AGE , M.PROFILE_IMAGE , M.GENDER ,GB.MAIN_IMG , TO_CHAR(S.START_DATE,'YYYY-MM-DD')AS START_DATE ,TO_CHAR(S.END_DATE,'YYYY-MM-DD')AS END_DATE ,GB.GUIDE_BOARD_CATEGORY_NO ,GB.CONTENT ,GB.ENROLL_DATE ,GB.MODIFY_DATE ,GB.HIT ,GB.MATCHING_STATE ,TO_CHAR(GB.TRAVEL_EXPENSE,'999,999,999,999,999') AS TRAVEL_EXPENSE ,GB.DELETE_YN ,GB.REPORT_CNT ,C.CATEGORY_NAME FROM GUIDE_BOARD GB JOIN MEMBER M ON (GB.WRITER_NO = M.MEMBER_NO) JOIN SCHEDULER S ON(S.SCHEDULER_NO=GB.SCHEDULER_NO) JOIN GUIDE_BOARD_CATEGORY C ON(GB.GUIDE_BOARD_CATEGORY_NO = C.CATEGORY_NO) WHERE DELETE_YN = 'N' AND MATCHING_STATE = 'N' AND GUIDE_BOARD_CATEGORY_NO=? AND ";
		if(searchType.equals("title")) {
			sql+="GB.TITLE LIKE '%'||?||'%' ";
		}else if(searchType.equals("writerId")) {
			sql+="M.ID LIKE '%'||?||'%' ";
			
		}else if(searchType.equals("writerNick")) {
			sql+="M.NICK LIKE '%'||?||'%' ";
			
		}else {
			return getList(conn,i,pvo);
		}
		sql+="ORDER BY GUIDE_BOARD_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, i);
		pstmt.setString(2, searchValue);
		
		pstmt.setInt(3, pvo.getBeginRow());
		pstmt.setInt(4, pvo.getLastRow());
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<GuideBoardVo> bvoList = new ArrayList<>(); 
		while(rs.next()) {
			String guideBoardNo = rs.getString("GUIDE_BOARD_NO");
			String title = rs.getString("TITLE");
			String id = rs.getString("ID");
			String nick = rs.getString("NICK");
			String age = rs.getString("AGE");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String gender = rs.getString("GENDER");
			String writerNo = rs.getString("WRITER_NO");
			String mainImg = rs.getString("MAIN_IMG");
			String shedulerNo = rs.getString("SCHEDULER_NO");
			if(gender=="M") {
				gender="남성";
			}else {
				gender="여성"; 
			}
			
			String startDate_ = rs.getString("START_DATE");
			String endDate_ = rs.getString("END_DATE");
			
			String guideBoardCategoryNo = rs.getString("GUIDE_BOARD_CATEGORY_NO");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String hit = rs.getString("HIT");
			String matchingState = rs.getString("MATCHING_STATE");
			String travelExpense = rs.getString("TRAVEL_EXPENSE");
			String deleteYn = rs.getString("DELETE_YN");
			String reportCnt = rs.getString("REPORT_CNT");
			String categoryName = rs.getString("CATEGORY_NAME");
			
			GuideBoardVo bvo = new GuideBoardVo();
			bvo.setGuideBoardCategoryNo(guideBoardCategoryNo);
			bvo.setContent(content);
			bvo.setEnrollDate(enrollDate);
			bvo.setModifyDate(modifyDate);
			bvo.setHit(hit);
			bvo.setMatchingState(matchingState);
			bvo.setTravelExpense(travelExpense);
			bvo.setDeleteYn(deleteYn);
			bvo.setReportCnt(reportCnt);
			bvo.setCategoryName(categoryName);
			
			bvo.setGuideBoardNo(guideBoardNo);
			bvo.setTitle(title);
			bvo.setId(id);
			bvo.setNick(nick);
			bvo.setAge(age);
			bvo.setProfileImage(profileImage);
			bvo.setWriterNo(writerNo);
			bvo.setSchedulerNo(shedulerNo);
			
			bvo.setGender(gender);
			bvo.setMainImg(mainImg);
			
			//5월11일 이런식으로 데이터를 가공
			if(startDate_==null) {
				
			}else {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date startDate = formatter.parse(startDate_);
				Date endDate =formatter.parse(endDate_);
				SimpleDateFormat format = new SimpleDateFormat("MM월 dd일");
				String startDateStr = format.format(startDate);
				String endDateStr = format.format(endDate);
				
				
				bvo.setStartDate(startDateStr);
				bvo.setEndDate(endDateStr);
			}
			
			
			bvoList.add(bvo);
			
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return bvoList;
	}

	public int modify(Connection conn, GuideBoardVo vo) throws Exception {
		//sql
		String sql = "UPDATE GUIDE_BOARD SET TITLE =? ,CONTENT = ? , MODIFY_DATE = SYSDATE WHERE GUIDE_BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getGuideBoardNo());
		
		
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
				
	}

	public int delete(Connection conn, String no) throws Exception {
		//sql
		String sql = "UPDATE GUIDE_BOARD SET DELETE_YN ='Y' WHERE GUIDE_BOARD_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
	}

}
