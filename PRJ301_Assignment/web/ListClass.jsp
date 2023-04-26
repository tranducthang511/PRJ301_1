<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <a href="logout">Log out</a>
        <div class="container">
            <div class="container-form">
                <h1>List Class </h1>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active">
                                <a class="nav-link" href="listclass">Classes<span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="listrequest">Requests</a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <hr>
                <ul class="list-group">
                    <c:forEach var="c" items="${ListClass}">
                        <form action="classdetails" method="POST">
                            <li class="list-group-item">${c.id}
                                <input type="hidden" value="${c.id}" name="ClassId" />
                                <button type="submit" class="btn btn-info">Details</button>
                            </li>
                        </form>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </body>
</html>
