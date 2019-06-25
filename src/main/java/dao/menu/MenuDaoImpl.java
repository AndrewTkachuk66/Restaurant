package dao.menu;

import dao.sql_connection.SQLConnectionPool;
import models.Dish;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {

    /**method for getting menu list from database**/

    public List<Dish> getMenu () throws SQLException, NamingException {
        List<Dish> list = new ArrayList<Dish>();
        String query = "Select * from dishes INNER JOIN menu ON (dishes.id = menu.dishId);";
        ResultSet rs = SQLConnectionPool.executeQuery(query);
        while (rs.next ()) {
            Dish dish = new Dish();
            dish.setId(rs.getInt("id"));
            dish.setName(rs.getString("name"));
            dish.setPrice(rs.getInt("price"));
            list.add(dish);
        }return list;
    }
}
