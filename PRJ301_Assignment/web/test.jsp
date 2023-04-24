<%-- 
    Document   : test
    Created on : Apr 24, 2023, 6:24:50 PM
    Author     : admin
--%>
<%@page import="model.AdminDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    AdminDAO ad = new AdminDAO();
    String xusername = "thangtdhe160619@fpt.edu.vn";
        String checkPassword = ad.getAdminByUsername(xusername).getPassword();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%=checkPassword%>
    </body>
</html>
