package controllers;

import dao.dish.DishDao;
import dao.dish.DishDaoImpl;
import models.Basket;
import models.Dish;
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
import java.util.ArrayList;
import java.util.List;

/** class contains list of user's orders. User can delete or insert dishes to this list. The list and
 * price of order pass as attribute in basket.jsp**/
@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(String.valueOf(BasketServlet.class));
    DishDao dishDao = new DishDaoImpl();

    /**the method through the DAO layer takes from database id of the dish that the user wants to add or delete dish from list
     **/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dish dish = null;
        HttpSession httpSession = request.getSession();
        Basket basket = new Basket();
        User user = (User)httpSession.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");
        try {
            dish = dishDao.getDishById(id);
        } catch (SQLException | NamingException e) {
          log.error(e);
        }
        dish.setId(id);
        if (action.equalsIgnoreCase("insert")) {
               basket.addProductToBasket(dish);
                log.info(dish.getName() + " is added to " + user.getName() + " basket");
        }
       else if (action.equalsIgnoreCase("delete")) {
            basket.removeProductFromBasket(dish);
            log.info(dish.getName() + " is removed from " + user.getName() + " basket");
        }
        request.setAttribute("list", basket.getOrder());
        request.setAttribute("price",basket.getPriceOfOrder());
        request.getRequestDispatcher("baskets/basket.jsp").forward(request, response);
    }
}
