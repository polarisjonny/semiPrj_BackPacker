package com.bp.app.travelReview.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.travelReview.dao.TravelReviewDao;
import com.bp.app.travelReview.vo.TravelReviewVo;
import com.bp.app.util.file.AttachmentVo;

public class TravelReviewService {

	private final TravelReviewDao dao = new TravelReviewDao();

	public int selectCnt() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	
		
	}

	//여행 후기 조회
	public List<TravelReviewVo> selectReviewList(PageVo pv) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		List<TravelReviewVo> trList = dao.selectReviewList(conn,pv);
		
		JDBCTemplate.close(conn);
		
		return trList;
	}

	//여행후기 작성
	public int write(TravelReviewVo trvo, AttachmentVo attvo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.write(conn , trvo);
		int result2 = dao.insertReviewImg(conn,attvo);
		
		if(result == 1 && result2 > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	
	}


}
