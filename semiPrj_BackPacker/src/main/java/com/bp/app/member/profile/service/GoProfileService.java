package com.bp.app.member.profile.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.chat.room.dao.ChatDao;
import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.member.profile.dao.GoProfileDao;
import com.bp.app.member.vo.MemberVo;
import com.bp.app.memberReview.vo.MemberReviewVo;

public class GoProfileService {
   private final GoProfileDao dao;
	
	public GoProfileService() {
		dao=new GoProfileDao();
	}

   public MemberVo selectMemberToProfile(String selectMemberNo) throws Exception {
      
      MemberVo vo = null;
      //conn
      Connection conn = JDBCTemplate.getConnection();
         //update
         
      vo = dao.selectMemberToProfile(conn , selectMemberNo);
         
      JDBCTemplate.close(conn);
      return vo;
   }

   public List<MemberReviewVo> selectMemberReadReview(String selectMemberNo) throws Exception {
      List<MemberReviewVo> MemberReviewVolist = new ArrayList<>();
      //conn
      Connection conn = JDBCTemplate.getConnection();
         //update
      MemberReviewVolist = dao.selectMemberReadReview(conn , selectMemberNo);
         
      JDBCTemplate.close(conn);
      return MemberReviewVolist;
   }

   public int selectCnt(String selectMemberNo) throws SQLException {
      //conn
      Connection conn = JDBCTemplate.getConnection();
      
      int cnt = dao.selectCnt(conn, selectMemberNo);
      
      JDBCTemplate.close(conn);
      
      return cnt;
   }

   

}
