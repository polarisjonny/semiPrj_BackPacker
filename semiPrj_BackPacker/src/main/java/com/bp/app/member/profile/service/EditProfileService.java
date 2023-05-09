package com.bp.app.member.profile.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.member.profile.dao.EditProfileDao;
import com.bp.app.member.vo.MemberVo;

public class EditProfileService {
   private final EditProfileDao dao;
   
   public EditProfileService() {
      dao = new EditProfileDao();
   }
   public MemberVo editImg(MemberVo vo) throws Exception {
      Connection conn = JDBCTemplate.getConnection();
      
      MemberVo updatedMember = null;
      try {
         //SQL
         int result = dao.editImg(conn , vo);
         
         //tx || rs
         if(result == 1) {
            updatedMember = dao.selectOneByNo(conn , vo.getMemberNo());
            if(updatedMember == null) {
               throw new Exception();
            }
            JDBCTemplate.commit(conn);
         }else {
            JDBCTemplate.rollback(conn);
         }
         
      }finally {
         //close
         JDBCTemplate.close(conn);
      }
      
      return updatedMember;
      
      
   }
   public MemberVo editIntMsg(MemberVo vo) throws Exception {
      Connection conn = JDBCTemplate.getConnection();
      
      MemberVo updatedMember = null;
      try {
         //SQL
         int result = dao.editIntMsg(conn , vo);
         
         //tx || rs
         if(result == 1) {
            updatedMember = dao.selectOneByNo(conn , vo.getMemberNo());
            if(updatedMember == null) {
               throw new Exception();
            }
            JDBCTemplate.commit(conn);
         }else {
            JDBCTemplate.rollback(conn);
         }
         
      }finally {
         //close
         JDBCTemplate.close(conn);
      }
      
      return updatedMember;
   }

}