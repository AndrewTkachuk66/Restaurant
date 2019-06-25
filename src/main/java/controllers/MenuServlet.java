package controllers;

import dao.menu.MenuDaoImpl;
import dao.menu.MenuDao;
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
import java.sql.*;

/**class is responsible for the logic of extracting the menu list from the database.**/

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(String.valueOf (MenuServlet.class));

   /** the method makes a request through the DAO layer to the database, extracts the menu list
    * and and passes as an attribute to menu.jsp**/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MenuDao menu = new MenuDaoImpl();
        try {
            request.setAttribute("list", menu.getMenu());
        } catch (SQLException | NamingException e){
        log.error(e);
        }
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        request.setAttribute("user", user);
        request.getRequestDispatcher("menu/menu.jsp").forward(request, response);
    }
}




