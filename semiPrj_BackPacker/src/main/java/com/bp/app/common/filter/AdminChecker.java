package com.bp.app.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bp.app.member.vo.MemberVo;

@WebFilter("/admin/*")
public class AdminChecker implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember ==null || !"ADMIN".equals(loginMember.getId())){
			req.setAttribute("errorMsg", "관리자만 가능");
			req.getRequestDispatcher("/WEB-INF/views/common/error-page.jsp").forward(request, response);
			throw new IllegalStateException("관리자만 가능");
		}
		
		chain.doFilter(req, response);
	}

}