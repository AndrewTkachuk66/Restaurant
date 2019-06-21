package dao.admin;

import models.Order;
import models.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;
/**public interface for Adnim DAO layer contract**/

public interface AdminDao {
   List<Order> getOrders() throws SQLException, NamingException;
   List<User> getAllClients() throws SQLException, NamingException;
}
