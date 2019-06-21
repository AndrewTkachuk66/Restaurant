package dao.sql_connection;

import controllers.BasketServlet;
import org.apache.log4j.Logger;

import java.sql.*;

/**class is used for encapsulation transactions whit basic SQL query.
 Connections to the base is through a JDBC driver **/

public class SQLTransaction {
    private static final Logger log = Logger.getLogger(String.valueOf(BasketServlet.class));
    Connection dbConnection = null;
    Statement statementUpdateMoney = null;
    Statement statementUpdateOrder = null;
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String UserName = "root";
    private static final String password = "1111";

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, UserName, password);
        return connection;
    }

    public void doTransaction(double newMoney, int userId) throws ClassNotFoundException {
        try {
            String updateOrder = "INSERT INTO ORDERS (UserId) VALUES(" + userId + ")";
            String updateMoney = "update users_bank_balance set money =  " + newMoney + "where" + " userId = " + userId;
            dbConnection = getConnection();
            dbConnection.setAutoCommit(false);
            statementUpdateMoney = dbConnection.createStatement();
            statementUpdateOrder = dbConnection.createStatement();
            statementUpdateMoney.executeUpdate(updateMoney);
            statementUpdateOrder.executeUpdate(updateOrder);
            dbConnection.commit();
        } catch (SQLException e) {
            try {
                dbConnection.rollback();
                log.error(e);
            } catch (SQLException e2) {
                log.error(e2);
            }
        } finally {
            connClose(dbConnection, statementUpdateMoney, statementUpdateOrder);
        }
    }

    private static void connClose(Connection dbConnection, Statement statementUpdateMoney, Statement statementUpdateOrder) {
        try {
            if (dbConnection != null) {
                dbConnection.close();
                statementUpdateMoney.close();
                statementUpdateOrder.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

