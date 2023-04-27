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
        String role = session.getAttribute("role").toString();
        if (role.equals("admin")) {
            session.setAttribute("role", "admin");
        request.getRequestDispatcher("listclass").forward(request, response);
        }
        if (role.equals("student")) {
        SubjectsStatusDAO u = new SubjectsStatusDAO();
        StudentDAO s = new StudentDAO();
        String xEmail = session.getAttribute("username").toString();
        String xId = (String) s.getStudentByEmail(xEmail).getId();
        session.setAttribute("user_id", xId);
        request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
