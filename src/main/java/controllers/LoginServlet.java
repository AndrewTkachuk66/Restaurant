package controllers;

import dao.user.UserDao;
import dao.user.UserImpl;
import models.User;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**class is responsible for login or logout users.**/

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(String.valueOf(LoginServlet.class));
    UserDao userDao = new UserImpl();
    User user = new User();

    /**
     * method is responsible for logout the user. It make invalidate() for session and redirect the user to index.jsp
     **/

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        if (user != null) {
            log.info(user.getLogin() + " " + user.getName() + " do logout");
            session.invalidate();
            HttpSession sessionNEW = request.getSession();
            sessionNEW.setAttribute("status", "logout");
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().println("Login or register please ");
        }
    }

    /**
     * method is responsible for login the user. It redirect the user to indexAdmin.jsp or to indexUser.jsp according to user status.
     * In the other case an error message is displayed
     **/

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            user = userDao.getUserByLoginAndPassword(login, password);
        } catch (SQLException | NamingException e) {
            log.error(e);
        }
        if (user != null) {
            httpSession.setAttribute("user", user);
            httpSession.setAttribute("status","registered");
            log.info(user.getName() + " " + user.getPassword() + " is login in");
            if (user.getStatus().equalsIgnoreCase("admin")) {
                response.sendRedirect("indexes/indexAdmin.jsp");
            }
            if (user.getStatus().equalsIgnoreCase("client")) {
                response.sendRedirect("indexes/indexUser.jsp");
            }
        }else {
            response.sendRedirect("errors/error_login.jsp");
        }
    }
}

