package dao.dish;


import dao.sql_connection.SQLConnectionPool;
import models.Dish;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDaoImpl implements DishDao {

    /**method for getting dish by id from database**/

    @Override
    public Dish getDishById(int id) throws SQLException, NamingException {
        String query = "Select * from dishes where id = " + id;
        Dish dish = null;
        ResultSet  rs = SQLConnectionPool.executeQuery(query);
        while (rs.next()) {
            dish = new Dish();
            dish.setName(rs.getString("name"));
            dish.setPrice(rs.getInt("price"));
        }
        return dish;
    }
}
