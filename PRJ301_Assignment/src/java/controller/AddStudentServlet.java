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
@WebServlet(name = "AddStudentServlet", urlPatterns = {"/add"})
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pr = response.getWriter();
        if (session.getAttribute("role") != "admin") {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        session.setAttribute("isAddable", "yes");
        request.getRequestDispatcher("ClassDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pr = response.getWriter();
        if (session.getAttribute("role") != "admin") {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        session.setAttribute("isAddable", "no");
        String add_student_id = request.getParameter("add_student_id");
        String class_id = session.getAttribute("class_id").toString();
        SubjectsStatusDAO c = new SubjectsStatusDAO();
        String check = c.checkStatus(class_id, add_student_id);
        if (check.equals("not passed")) {
            Class_StudentDAO u = new Class_StudentDAO();
            ClassDAO p = new ClassDAO();
            model.Class y = p.getClassesById(class_id);
            String subject = y.getSubject();
            u.insert(class_id, add_student_id);
            c.update(subject, add_student_id);
        } 
        request.getRequestDispatcher("ClassDetails.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
