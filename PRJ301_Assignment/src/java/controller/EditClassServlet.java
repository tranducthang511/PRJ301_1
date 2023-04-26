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
@WebServlet(name = "EditClassServlet", urlPatterns = {"/edit"})
public class EditClassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pr = response.getWriter();
        if(session.getAttribute("role")!="admin")request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        session.setAttribute("isEditable", "yes");
        request.getRequestDispatcher("ClassDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pr = response.getWriter();
        if(session.getAttribute("role")!="admin")request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        session.setAttribute("isEditable", "no");
        String time = request.getParameter("time");
        String class_id = session.getAttribute("class_id").toString();
        ClassDAO u = new ClassDAO();
        u.updateTime(class_id, time);
        request.getRequestDispatcher("ClassDetails.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
