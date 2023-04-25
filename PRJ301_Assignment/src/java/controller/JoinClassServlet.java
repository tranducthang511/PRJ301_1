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
@WebServlet(name = "JoinClassServlet", urlPatterns = {"/joinclass"})
public class JoinClassServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String cl = request.getParameter("class");
        if (cl.equals("newclass")) {
            OpenClassRequestDAO o = new OpenClassRequestDAO();
            o.insert(session.getAttribute("subject").toString(), session.getAttribute("user_id").toString());
            response.getWriter().println("request successfully");
            response.getWriter().println("<p><a href=\"Register.jsp\"> Back to home </a>");
        } else {
            Class_StudentDAO u = new Class_StudentDAO();
            u.insert(cl, session.getAttribute("user_id").toString());
            SubjectsStatusDAO s = new SubjectsStatusDAO();
            s.update(session.getAttribute("subject").toString(), session.getAttribute("user_id").toString());
            response.getWriter().println("register successfully");
            response.getWriter().println("<p><a href=\"Register.jsp\"> Back to home </a>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
