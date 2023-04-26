package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author thangtdhe160619
 */
@WebServlet(name = "DeleteStudentFromClassServlet", urlPatterns = {"/delete"})
public class DeleteStudentFromClassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pr = response.getWriter();
        if (session.getAttribute("role") != "admin") {
            request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        }
        String delete_id = request.getParameter("delete_id");
        Class_StudentDAO u = new Class_StudentDAO();
        u.delete(session.getAttribute("class_id").toString(), delete_id);
        ClassDAO p = new ClassDAO();
        model.Class y = p.getClassesById(session.getAttribute("class_id").toString());
        String subject = y.getSubject();
        SubjectsStatusDAO q = new SubjectsStatusDAO();
        q.updateToNotPassed(subject, delete_id);
        request.getRequestDispatcher("ClassDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pr = response.getWriter();
        if (session.getAttribute("role") != "admin") {
            request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        }
        request.getRequestDispatcher("ClassDetails.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
