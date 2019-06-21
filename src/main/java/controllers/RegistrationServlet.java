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

/**class is responsible for registering new users and checking if login is not user.**/

@WebServlet( "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(String.valueOf (RegistrationServlet.class));

/**method is responsible for checking user's login. If login is already used, it redirect request to loginIsUsed.jsp.
 * If login is free,the user successfully added to Database and the user is redirected to login.jsp **/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserImpl();
        String login = request.getParameter ("login");
        String name = request.getParameter ("name");
        String password = request.getParameter ("password");
        String email = request.getParameter ("email");
        User user = new User();
        user.setLogin(login);
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setStatus("client");
        boolean loginFree;
        try {
            loginFree = userDao.checkIfLoginIsAlreadyUsed(user);
            if(loginFree == false){
                request.getRequestDispatcher("errors/loginIsUsed.jsp").forward(request, response);
                return;
            }
            else{
                userDao.addUser(user);
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("status", "registered");
                log.info("User " + user.getName() + " login - " + user.getLogin() + "  registered");
                request.getRequestDispatcher("logging&registration/login.jsp").forward(request, response);
            }
        } catch (SQLException | NamingException e ){
            log.error(e);
        }
    }
}
