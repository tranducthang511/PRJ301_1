package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import model.*;

/**
 *
 * @author thangtdhe160619
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pr = response.getWriter();
        pr.println("welcome " + session.getAttribute("username"));
        SubjectsStatusDAO u = new SubjectsStatusDAO();
        StudentDAO s = new StudentDAO();
        String xEmail = session.getAttribute("username").toString();
        pr.println(xEmail);
        String xId = (String) s.getStudentByEmail(xEmail).getId();
        pr.println(xId);
        SubjectsStatus x = u.getSubjectsStatusById(xId);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
