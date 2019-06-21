package dao.dish;

import models.Dish;

import javax.naming.NamingException;
import java.sql.SQLException;

/**public interface for Dish DAO layer contract**/

public interface DishDao  {
   Dish getDishById(int id)  throws SQLException, NamingException;
}
