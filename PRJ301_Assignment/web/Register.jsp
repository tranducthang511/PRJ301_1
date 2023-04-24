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
                    <select class="form-select" aria-label="Default select example">
                        <option selected>Choose course  </option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                    <p><p><p><button type="submit" class="btn btn-primary">Register</button>
                </form>
            </div>
        </div>
    </body>
</html>