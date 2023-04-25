<%-- 
    Document   : ChooseClass
    Created on : Apr 25, 2023, 1:30:47 PM
    Author     : admin
--%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ClassDAO u = new ClassDAO();
    ArrayList<String> lst = new ArrayList();
    lst=u.getClassesBySubject(session.getAttribute("subject").toString());
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="myStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="shortcut icon" href="favicon.ico"/>
        <title>Register</title>
    </head>
    <body>
        <div class="container-login">
                <h1>Register repeat a course</h1>
                <form action="joinclass" method="POST">
                    <select name="class">
                        <option selected>Choose class  </option>
                        <%
                            for(String c:lst){
                        %>
                        <option value="<%=c%>"> <%=c%>  </option>
                        <%}%>
                    </select>
                    <p><p><p><button type="submit" class="btn btn-primary">Register</button>
                </form>
            </div>
    </body>
</html>
