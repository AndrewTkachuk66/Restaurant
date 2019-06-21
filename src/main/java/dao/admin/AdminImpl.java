package dao.admin;

import dao.sql_connection.SQLConnectionPool;
import models.Order;
import models.User;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminImpl implements AdminDao  {

/**method for getting all orders from database**/

    @Override
    public List<Order> getOrders() throws SQLException, NamingException {
        List<Order> orderList = new ArrayList<>();
        String quary = "SELECT * from orders";
        ResultSet resultSet= SQLConnectionPool.executeQuery(quary);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUserID(resultSet.getInt("userId"));
                orderList.add(order);
            }
        return orderList;
    }

    /**method for getting all clients from database**/

    public List<User> getAllClients() throws SQLException, NamingException{
        String quary = "SELECT * from users where status = 'client'";
        ResultSet resultSet = SQLConnectionPool.executeQuery(quary);
        List<User> userList = new ArrayList<>();
            while (resultSet.next ()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setStatus(resultSet.getString("status"));
                userList.add(user);
            }
        return userList;
    }
}
