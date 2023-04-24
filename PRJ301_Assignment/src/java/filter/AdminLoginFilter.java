package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.AdminDAO;

/**
 *
 * @author thangtdhe160619
 */
public class AdminLoginFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();
        String xusername = request.getParameter("username");
        String xpassword = request.getParameter("password");
        AdminDAO u = new AdminDAO();
        if (xpassword.equals(u.getAdminByUsername(xusername).getPassword())) {
            session.setAttribute("username", xusername);
            session.setAttribute("password", xpassword);
            chain.doFilter(request, response);
        } else {
            request.setAttribute("errorLogin", "Wrong username or password!!!");
            request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
    }
}
