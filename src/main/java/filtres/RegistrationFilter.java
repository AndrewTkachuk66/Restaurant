package filtres;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** common filter checks if user entered all fields in registration form **/

public class RegistrationFilter implements Filter {

    FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String name =  request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if(login =="" || name =="" || password =="" || email == ""){
            response.sendRedirect("errors/error_registration.jsp");
    } else  filterChain.doFilter (servletRequest, servletResponse);}

    @Override
    public void destroy() {

    }
}
