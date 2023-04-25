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
    SubjectsStatusDAO u= new SubjectsStatusDAO();
    StudentDAO s= new StudentDAO();
    SubjectsStatus x = u.getSubjectsStatusById(s.getStudentByEmail(session.getAttribute("username").toString()).getId());
    ArrayList<String> lst = new ArrayList();
    lst = u.getNotPassedSubjects(x.getId());
    Class_StudentDAO cs = new Class_StudentDAO();
    ArrayList<String> clst = cs.FindStudyingClass(session.getAttribute("user_id").toString());
    ArrayList<model.Class> lst2 = new ArrayList();
    ClassDAO p = new ClassDAO();
    for(String n:clst){ lst2.add(p.getClassesById(n));}
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
        <div class="container">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">MAE101</th>
                        <th scope="col">PRF192</th>
                        <th scope="col">MAD101</th>
                        <th scope="col">PRO192</th>
                        <th scope="col">JPD113</th>
                        <th scope="col">LAB211</th>
                        <th scope="col">MAS291</th>
                        <th scope="col">JPD123</th>
                        <th scope="col">PRJ301</th>
                        <th scope="col">JPD316</th>
                        <th scope="col">PRM392</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row"><%=x.getId()%></th>
                        <td><%=x.getMAE101()%></td>
                        <td><%=x.getPRF192()%></td>
                        <td><%=x.getMAD101()%></td>
                        <td><%=x.getPRO192()%></td>
                        <td><%=x.getJPD123()%></td>
                        <td><%=x.getLAB211()%></td>
                        <td><%=x.getMAS291()%></td>
                        <td><%=x.getJPD123()%></td>
                        <td><%=x.getPRJ301()%></td>
                        <td><%=x.getJPD316()%></td>
                        <td><%=x.getPRM392()%></td>
                    </tr>
                </tbody>
            </table>
            <div class="container-login">
                <h1>Register repeat a course</h1>
                <form action="register" method="POST">
                    <select name="subject">
                        <option selected>Choose course  </option>
                        <%
                            for(String sub:lst){
                        %>
                        <option value="<%=sub%>"> <%=sub%>  </option>
                        <%}%>
                    </select>
                    <p><p><p><button type="submit" class="btn btn-primary">Register</button>
                </form>
                    =================================================
                    <p>Studying Class: <%
                    for(model.Class d:lst2){
            %>

            <%=d.getId()%> - time:  <%=d.getTime()%> 
            (
            <%if(d.getTime().equals("Slot1")){%>
            7h30-9h tu thu 2 den thu 6
            <%}%>
            <%if(d.getTime().equals("Slot2")){%>
            9h10-10h40 tu thu 2 den thu 6
            <%}%>
            <%if(d.getTime().equals("Slot3")){%>
            10h50-12h20 tu thu 2 den thu 6
            <%}%>
            <%if(d.getTime().equals("Slot4")){%>
            12h50-14h20 tu thu 2 den thu 6
            <%}%>
            <%if(d.getTime().equals("Slot5")){%>
            14h30-16h tu thu 2 den thu 6
            <%}%>
            <%if(d.getTime().equals("Slot6")){%>
            16h10-17h40 tu thu 2 den thu 6
            <%}%>
            <%if(d.getTime().equals("Slot7")){%>
            18h-19h30 tu thu 2 den thu 6
            <%}%>
            )
            <%}%>
            </div>
        </div>
    </body>
</html>
