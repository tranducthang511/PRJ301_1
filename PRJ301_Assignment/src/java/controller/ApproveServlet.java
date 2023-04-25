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
        String subject = request.getParameter("subject");
        PrintWriter pr = response.getWriter();
        OpenClassRequestDAO u = new OpenClassRequestDAO();
        ClassDAO q = new ClassDAO();
        q.newClass(subject);
        Class_StudentDAO p = new Class_StudentDAO();
        ArrayList<String> listuser = u.getRequestUserId(subject);
        for (String m : listuser) {
            p.insert(q.getLatestClassIdBySubject(subject), m);
        }
        u.delete(subject);
        SubjectsStatusDAO o = new SubjectsStatusDAO();
        o.update(subject, session.getAttribute("user_id").toString());
        request.getRequestDispatcher("listclass").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
