package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;

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
        PrintWriter pr = response.getWriter();
        pr.println("welcome");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
