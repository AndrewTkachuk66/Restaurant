package dao.order;

import models.User;

import javax.naming.NamingException;
import java.sql.SQLException;

/**public interface for Order DAO layer contract**/

public interface OrderDao {
    boolean makeOrder(User user) throws SQLException, NamingException, ClassNotFoundException;
}
