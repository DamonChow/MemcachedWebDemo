package com.damon.common;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 功能：用户名过滤器
 *
 * Created by ZhouJW on 2015/6/3 16:28.
 */
public class UserFilter implements Filter{

        public void doFilter(ServletRequest request, ServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpReq = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String path = httpReq.getRequestURI();

            HttpSession session = httpReq.getSession();
            //获取用户登录session
            String userName= (String) session.getAttribute("userName");
            System.out.println("path="+path+",userName=" + userName);

            if(path.endsWith("/login.jsp")){
                if (userName != null) {
                    httpResponse.sendRedirect("success.jsp");
                    return;
                }

                chain.doFilter(request, response);
                return;
            }

            //验证session用户ID
            if (userName == null) {
                httpResponse.sendRedirect("login.jsp");
                return;
            }

            chain.doFilter(request, response);
        }

        public void destroy() {}
        public void init(FilterConfig filterConfig) throws ServletException {}
    }
