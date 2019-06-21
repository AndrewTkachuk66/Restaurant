package filtres;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/** common filter checks the correctness of the entered data **/
public class LoginFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String login =  request.getParameter("login");
        String password = request.getParameter("password");
        if(login=="" || password == ""){
            response.sendRedirect("errors/error_login.jsp");
        }
        else  filterChain.doFilter (servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }


}
