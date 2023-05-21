package com.bp.app.member.myPage.matchingMemberService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bp.app.common.db.JDBCTemplate;
import com.bp.app.common.page.PageVo;
import com.bp.app.member.myPage.matchingMemberDao.MyPageMatchingMemberDao;
import com.bp.app.member.vo.MemberVo;

public class MyPageMatchingMemberService {

	//마이페이지 미리보기 매칭완료된 회원 목록 가져오기
	public List<MemberVo> selectMatchingMemberList(String memberNo) throws Exception {
		MyPageMatchingMemberDao dao = new MyPageMatchingMemberDao();
		Connection conn = JDBCTemplate.getConnection();
		List<MemberVo> list = dao.selectMatchingMemberList(conn, memberNo);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	//페이징 처리에 따른 매칭완료된 회원 목록 더보기
	public List<MemberVo> selectMatchingMemberListForPage(PageVo pv, String memberNo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MyPageMatchingMemberDao dao = new MyPageMatchingMemberDao();
		List<MemberVo> list = dao.selectMatchingMemberListForPage(conn, pv, memberNo);
		//sql
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	
	public int selectMatchingMemberCount(String memberNo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT COUNT(*) FROM MEMBER M JOIN CHATTING_ROOM C ON (M.MEMBER_NO = C.CHATTING_USER_NO OR M.MEMBER_NO = C.CHATTING_USER2_NO) WHERE (C.CHATTING_USER_NO = ? OR C.CHATTING_USER2_NO = ?) AND C.MATCHING_CHECK = 'Y' AND C.MATCHING_CHECK2 = 'Y' AND C.CHATTING_STATUS = 1 AND M.MEMBER_NO <> ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2,  memberNo);
		pstmt.setString(3,  memberNo);
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return count;
	}
}
