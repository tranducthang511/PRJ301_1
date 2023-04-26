<%-- 
    Document   : test
    Created on : Apr 24, 2023, 6:24:50 PM
    Author     : admin
--%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String id = (String)request.getAttribute("id");
    ClassDAO u = new ClassDAO();
    model.Class x = u.getClassesById(id);
    Class_StudentDAO q= new Class_StudentDAO();
    ArrayList<String> liststudentid = q.FindStudentInClass(id);
    StudentDAO p = new StudentDAO();
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
        <a href="logout">Log out</a>
        <div class="container-form">           
            <div class="details-in">
                <h1>Class Name: <%=id%></h1>
                <p>Subject: <%=x.getSubject()%>
                <p>Time:  <%=x.getTime()%> 
                (
                <%if(x.getTime().equals("Slot1")){%>
                7h30-9h tu thu 2 den thu 6
                <%}%>
                <%if(x.getTime().equals("Slot2")){%>
                9h10-10h40 tu thu 2 den thu 6
                <%}%>
                <%if(x.getTime().equals("Slot3")){%>
                10h50-12h20 tu thu 2 den thu 6
                <%}%>
                <%if(x.getTime().equals("Slot4")){%>
                12h50-14h20 tu thu 2 den thu 6
                <%}%>
                <%if(x.getTime().equals("Slot5")){%>
                14h30-16h tu thu 2 den thu 6
                <%}%>
                <%if(x.getTime().equals("Slot6")){%>
                16h10-17h40 tu thu 2 den thu 6
                <%}%>
                <%if(x.getTime().equals("Slot7")){%>
                18h-19h30 tu thu 2 den thu 6
                <%}%>
                )
                <p> List students:
                <p>
                    <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">name</th>
                        <th scope="col">dob</th>
                        <th scope="col">gender</th>
                        <th scope="col">email</th>
                    </tr>
                </thead>
                <tbody>
                    <%for(String student_id : liststudentid){Student y=p.getStudentById(student_id);%>
                    <tr>
                        <th scope="row"><%=y.getId()%></th>
                        <td><%=y.getName()%></td>
                        <td><%=y.getDOB()%></td>
                        <td><%=y.isGender()%></td>
                        <td><%=y.getEmail()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <p><p><button onclick='window.history.go(-1);'>Back to previous page</button>
            </div>
        </div>
    </body>
</html>
