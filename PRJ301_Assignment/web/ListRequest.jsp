<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String[] subject = new String[]{"MAE101","PRF192","MAD101","PRO192","JPD113","LAB211","MAS291","JPD123","PRJ301","JPD316","PRM392"};
        OpenClassRequestDAO u = new OpenClassRequestDAO();
        ArrayList<String> lst = u.getRequestSubject();
        int[] count = new int[11];
        for(String n:lst)
        {
            if(n.equals("MAE101")) count[0]++;
            if(n.equals("PRF192")) count[1]++;
            if(n.equals("MAD101")) count[2]++;
            if(n.equals("PRO192")) count[3]++;
            if(n.equals("JPD113")) count[4]++;
            if(n.equals("LAB211")) count[5]++;
            if(n.equals("MAS291")) count[6]++;
            if(n.equals("JPD123")) count[7]++;
            if(n.equals("PRJ301")) count[8]++;
            if(n.equals("JPD316")) count[9]++;
            if(n.equals("PRM392")) count[10]++;
            
        }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Class</title>
        <link href="myStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link rel="shortcut icon" href="../favicon.ico"/>
    </head>
    <body>
        <div class="container">
            <div class="container-form">
                <h1>List Request </h1>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="listclass">Classes</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="listrequest">Requests<span class="sr-only">(current)</span></a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <hr>
                <ul class="list-group">
                    <%for(int i=0;i<11;i++){ if(count[i]!=0){%>
                    <form action="approve" method="POST">
                        <li class="list-group-item"><%=subject[i]%> amount: <%=count[i]%>
                            <input type="hidden" name="subject" value="<%=subject[i]%>">
                            <button type="submit" value="approve" name="typeaction" class="btn btn-info">Approve</button>
                            <button type="submit" value="decline" name="typeaction" class="btn btn-reject">Decline</button>
                        </li>
                    </form>
                    <%}}%>
                </ul>
            </div>
        </div>
    </body>
</html>
