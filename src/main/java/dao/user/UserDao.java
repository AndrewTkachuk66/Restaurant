package dao.user;


import models.User;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface UserDao {
    void addUser ( User user ) throws SQLException, NamingException;

    User getUserByLoginAndPassword (String login, String password) throws SQLException, NamingException;

    boolean checkIfLoginIsAlreadyUsed(User user) throws SQLException, NamingException ;
}
