<%-- 
    Document   : test
    Created on : Apr 24, 2023, 6:24:50 PM
    Author     : admin
--%>
<%@page import = "model.Student" %>
<%@page import = "model.StudentDAO" %>
<%@page import = "model.SubjectsStatus" %>
<%@page import = "model.SubjectsStatusDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    SubjectsStatusDAO u= new SubjectsStatusDAO();
    StudentDAO s= new StudentDAO();
    SubjectsStatus x = u.getSubjectsStatusById(s.getStudentByEmail("thangtdhe160619@fpt.edu.vn").getId());
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <table border="1">
      <tr>
        <td align="center"> Id </td>
        <td align="center"> MAE101 </td>
        <td align="center"> PRF192 </td>
        <td align="center"> MAD101 </td>
      </tr>
      <tr>
        <td><%= x.getId() %> </td>
        <td><%= x.getMAE101() %> </td>
        <td><%= x.getPRF192() %> </td>
        <td><%= x.getMAD101() %> </td>
      </tr>  
    </table> 
    </body>
</html>
