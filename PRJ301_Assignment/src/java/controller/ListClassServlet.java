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
@WebServlet(name = "ListClassServlet", urlPatterns = {"/listclass"})
public class ListClassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pr = response.getWriter();
        if(session.getAttribute("role")!="admin")request.getRequestDispatcher("login.jsp").forward(request, response);
        ClassDAO u = new ClassDAO();
        ArrayList<model.Class> lst = new ArrayList();
        lst = u.getClasses();
        request.setAttribute("ListClass", lst);
        session.setAttribute("isEditable", "no");
        request.getRequestDispatcher("ListClass.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter pr = response.getWriter();
        if(session.getAttribute("role")!="admin")request.getRequestDispatcher("login.jsp").forward(request, response);
        ClassDAO u = new ClassDAO();
        ArrayList<model.Class> lst = new ArrayList();
        lst = u.getClasses();
        request.setAttribute("ListClass", lst);
        session.setAttribute("isEditable", "no");
        session.setAttribute("isAddable", "no");
        request.getRequestDispatcher("ListClass.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
