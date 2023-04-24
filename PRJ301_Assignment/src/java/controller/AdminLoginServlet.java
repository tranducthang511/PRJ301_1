package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author thangtdhe160619
 */
@WebServlet(name = "AdminLoginServlet", urlPatterns = {"adminlogin"})
public class AdminLoginServlet extends HttpServlet {
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AcademicStaffDAO acdDao = new AcademicStaffDAO();
        String checkPassword = acdDao.getPassword(username);
        if (password.equals(checkPassword) || session.getAttribute("username") != null) {
            session.setAttribute("username", username);

           response.sendRedirect("ShowListStudentRegisterServlet");
        } else {
            request.setAttribute("errorLogin", "Wrong username or password!!!");
            request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
