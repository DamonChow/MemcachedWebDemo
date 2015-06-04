package com.damon.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能：
 *
 * Created by ZhouJW on 2015/6/3 16:04.
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Map<String, String> accountDB = new HashMap<String, String>();
    static {
        accountDB.put("test", "123456");
        accountDB.put("admin", "999999");
        accountDB.put("dev", "000888");
        accountDB.put("007", "007007");
    }

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println("Raw input:userName=" + userName + ",password=" + password);

        if(userName!=null && password!=null
                && accountDB.containsKey(userName)
                && accountDB.get(userName).equals(password)) {
            System.out.println("Login;status=SUCCESS");
            request.getSession().setAttribute("userName", userName);
            response.sendRedirect("success.jsp");
        } else {
            System.out.println("Login;status=FAIL");
            response.sendRedirect("login.jsp");
        }
    }

}
