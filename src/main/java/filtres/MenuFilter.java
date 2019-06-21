package filtres;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/** common filter checks if the user is login. Menu can be shown only login users**/

public class MenuFilter implements javax.servlet.Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession ();
        String sessionStatus = (String) session.getAttribute("status");
        if(sessionStatus == null || sessionStatus.equalsIgnoreCase("logout")){
            response.getWriter().println("Login please");
        }
        if (sessionStatus.equalsIgnoreCase("registered")){
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
