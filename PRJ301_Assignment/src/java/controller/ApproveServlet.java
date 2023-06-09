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
@WebServlet(name = "ApproveServlet", urlPatterns = {"approve"})
public class ApproveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != "admin") {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        PrintWriter pr = response.getWriter();
        OpenClassRequestDAO u = new OpenClassRequestDAO();
        String subject = request.getParameter("subject");
        String typeaction = request.getParameter("typeaction");
        if (typeaction.equals("decline")) {
            ArrayList<String> listuser = u.getRequestUserId(subject);
            for (String m : listuser) {
            SubjectsStatusDAO o = new SubjectsStatusDAO();
            o.updateToNotPassed(subject, m);
        }
            u.delete(subject);
            request.getRequestDispatcher("listrequest").forward(request, response);
        }
        else {
        ClassDAO q = new ClassDAO();
        q.newClass(subject);
        Class_StudentDAO p = new Class_StudentDAO();
        ArrayList<String> listuser = u.getRequestUserId(subject);
        for (String m : listuser) {
            p.insert(q.getLatestClassIdBySubject(subject), m);
            SubjectsStatusDAO o = new SubjectsStatusDAO();
            o.update(subject, m);
        }
        u.delete(subject);
        request.getRequestDispatcher("listclass").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
