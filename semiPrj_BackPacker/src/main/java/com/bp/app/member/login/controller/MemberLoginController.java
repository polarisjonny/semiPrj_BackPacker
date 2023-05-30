package com.bp.app.member.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bp.app.member.service.MemberService;
import com.bp.app.member.vo.MemberVo;
import com.google.gson.Gson;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try (PrintWriter out = resp.getWriter()) {
            try {
                // Get the data from the request
                String id = req.getParameter("id");
                String password = req.getParameter("password");

                // Create a MemberVo object
                MemberVo vo = new MemberVo();
                vo.setId(id);
                vo.setPassword(password);

                // Invoke the MemberService to perform login
                MemberService ms = new MemberService();
                MemberVo loginMember = ms.login(vo);

                if (loginMember != null) {
                    if (loginMember.getProfileImage() == null) {
                        loginMember.setProfileImage("profile_default.jpg");
                    }

                    // Set the loginMember in session
                    req.getSession().setAttribute("loginMember", loginMember);

                    // Create a success response JSON
                    Gson gson = new Gson();
                    String successResponse = gson.toJson("success");
                    out.println(successResponse);
                } else {
                    // Create a failure response JSON
                    Gson gson = new Gson();
                    String failureResponse = gson.toJson("fail");
                    out.println(failureResponse);
                }
            } catch (Exception e) {
                // Create an error response JSON
                Gson gson = new Gson();
                String errorResponse = gson.toJson("error");
                out.println(errorResponse);
            }
        }
    }
}

