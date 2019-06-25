package dao.menu;

import models.Dish;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

/**public interface for MenuDaoImpl DAO layer contract**/

public interface MenuDao {
    /** getting list of product objects which are listed in the menu */
    List<Dish> getMenu() throws SQLException, NamingException;
}
