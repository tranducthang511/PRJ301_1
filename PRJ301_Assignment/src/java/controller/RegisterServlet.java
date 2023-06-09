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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String subject = request.getParameter("subject");
        session.setAttribute("subject", subject);
        request.getRequestDispatcher("ChooseClass.jsp").forward(request, response);

    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
