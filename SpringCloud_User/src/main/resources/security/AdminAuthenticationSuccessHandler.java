package com.example.distributedhomework2.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        MyUserDetail userDetails = (MyUserDetail) authentication.getPrincipal();

        // 获取用户的userID
        int userID = userDetails.getUserID();

        // 构建重定向URL
        String targetUrl = "/admin/home/" + userID;
        System.out.println("Redirecting to: " + targetUrl);

        // 重定向到目标URL
        response.sendRedirect(targetUrl);
    }
}
