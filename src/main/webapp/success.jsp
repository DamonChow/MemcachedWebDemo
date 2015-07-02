<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登录成功页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<form method="post" action="logout">
    <table width="500" height="200" align="center" border="1">
        <tr>
            <td align="center">
                tomcat---------------8080<br/>
                当前登录用户：<%=session.getAttribute("userName") %><br/>
                sessionId：<%=session.getId()%><br/>
                ip：<%=request.getRemoteAddr()%><br/>
                prot：<%=request.getServerPort()%><br/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="退出"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>