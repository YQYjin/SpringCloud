package com.example.distributedhomework2.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 在这里可以自定义处理登录失败的逻辑，例如记录日志或者返回自定义的错误消息
        // 设置自定义错误消息
        setDefaultFailureUrl("/loginpage?error=true"); // 这里设置了一个错误参数来标识登录失败
        super.onAuthenticationFailure(request, response, exception);
    }
}
