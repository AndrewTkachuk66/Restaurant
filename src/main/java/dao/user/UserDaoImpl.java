package dao.user;

import dao.sql_connection.SQLConnectionPool;
import models.User;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    public void addUser ( models.User user ) throws SQLException, NamingException {
        String name = user.getName ();
        String login = user.getLogin ();
        String password = user.getPassword ();
        String email = user.getEmail ();
        String status = user.getStatus ();
        String query = "INSERT INTO users (name,login,password,email,status) Values ('" + name + "','" + login + "','" + password + "','" + email + "','" + status + "')";
        SQLConnectionPool.executeUpdate(query);
    }

    public boolean checkIfLoginIsAlreadyUsed(models.User user)  throws SQLException, NamingException{
        String query = "SELECT * FROM users";
        String login = user.getLogin();
        ResultSet   resultSet = SQLConnectionPool.executeQuery(query);
        boolean loginFree = true;
            while (resultSet.next()) {
                String loginFromDataBase = resultSet.getString("login");
                if (login.equals(loginFromDataBase)){
                    loginFree = false;
                    break;
                }
        }return loginFree;
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) throws SQLException, NamingException {
        User user = null;
        String query = "SELECT * FROM users WHERE login='" + login + "'AND PASSWORD='" + password + "'";
         ResultSet resultSet = SQLConnectionPool.executeQuery(query);
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setStatus(resultSet.getString("status"));
            }
        return user;
    }
}
