package com.damon.common;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 功能：
 *
 * Created by ZhouJW on 2015/6/3 16:28.
 */
public class UserFilter implements Filter{

        public void doFilter(ServletRequest request, ServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpReq = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String path = httpReq.getRequestURI();
            System.out.println(path);
            //验证码图片和js放行
            if(path.endsWith("/login.jsp")||path.endsWith("/register.jsp")){
                chain.doFilter(request, response);
                return;
            }

            HttpSession session = httpReq.getSession();
            //获取用户登录session
            String loginUser= (String) session.getAttribute("userName");
            System.out.println("============filter======" + loginUser);
            //验证session和单点登录的用户ID
            if (loginUser == null) {
                httpResponse.sendRedirect("login.jsp");
                return;
            }

            chain.doFilter(request, response);
        }

        public void destroy() {}
        public void init(FilterConfig filterConfig) throws ServletException {}
    }
