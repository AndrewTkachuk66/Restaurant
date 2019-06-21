package controllers;

import dao.admin.AdminDao;
import dao.admin.AdminImpl;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**class is responsible for the logic of extracting  list of clients and list of orders from the database.**/

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(String.valueOf(BasketServlet.class));
    AdminDao adminDao = new AdminImpl();

    /** the method makes a request through the DAO layer to the database, extracts the clients list
     * and passes it as an attribute to admin.jsp**/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("clientList", adminDao.getAllClients());
            log.info("The admin looked at the restaurant's customers ");
        } catch (SQLException | NamingException e) {
            log.error(e);
        }
        request.getRequestDispatcher("admins/admin.jsp").forward(request, response);
    }

    /** the method makes a request through the DAO layer to the database, extracts the orders list
     * and passes it as an attribute to admin.jsp**/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("orderList", adminDao.getOrders());
        } catch (SQLException | NamingException e) {
            log.error(e);
        }
        request.getRequestDispatcher("admins/admin.jsp").forward(request, response);
    }
}
