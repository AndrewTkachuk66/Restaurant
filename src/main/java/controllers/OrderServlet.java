package controllers;

import dao.order.OrderDao;
import dao.order.OrderDaoImpl;
import models.Basket;
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

/** class is responsible for the logic of adding order to database**/

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(String.valueOf (LoginServlet.class));
    OrderDao orderDao = new OrderDaoImpl();

    /**he method checks the presence of dishes in the list. If there is at least one dish, an order will be formed.
     * Otherwise, a message will be displayed**/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean orderSuccess;
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        Basket basket = new Basket();
        try {
            orderSuccess = orderDao.makeOrder(user);
            if(basket.getOrder().isEmpty()){
                response.getWriter().println("Your basket is empty");
                return;
            }
           else if (orderSuccess){
                response.getWriter().println(user.getName() + " you have made an order. Our manager will contact with you");
                log.info(user.getLogin() + " " + user.getName() + " made order");
            } else {
                response.getWriter().println("\n" +
                        "Problems with a transaction or insufficient money in the account");
                return;
            }
            } catch (SQLException | NamingException  | ClassNotFoundException e) {
            log.error(e);
            response.getWriter().println("\n" +
                    "Login or register please ");
            }finally {
            basket.getOrder().clear();
        }
    }
}
