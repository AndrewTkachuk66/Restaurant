package dao.order;

import dao.sql_connection.SQLConnectionPool;
import dao.sql_connection.SQLTransaction;
import controllers.BasketServlet;
import models.Basket;
import models.Order;
import models.User;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderImpl implements OrderDao {

    /**method for making orders. If user has enough money on his bank account - transaction happens**/

    @Override
    public boolean makeOrder (User user ) throws SQLException, NamingException, NullPointerException, ClassNotFoundException {
        boolean orderSuccess = true;
        Order order = new Order ();
        order.setUser (user);
        int userId = order.getUser().getId ();
        Double userMoney = 0d;
        double priceOfOrder = Basket.getPriceOfOrder(BasketServlet.orderList);
        String paymentQuery = "SElECT * from users_bank_balance where userId = " + userId;
        ResultSet resultSet = SQLConnectionPool.executeQuery(paymentQuery);
        while (resultSet.next ()) {
         userMoney = resultSet.getDouble("money");
        }
        double newMoney = userMoney - priceOfOrder;
        if(newMoney >= 0){
                SQLTransaction sqlTransaction = new SQLTransaction();
                sqlTransaction.doTransaction(newMoney, userId);
        }else {
            orderSuccess = false;
        }
       return orderSuccess;
    }
}
