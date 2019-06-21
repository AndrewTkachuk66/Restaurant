package dao.sql_connection;

import com.sun.rowset.CachedRowSetImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

/**class is used for encapsulation operations whit basic SQL query.
 Connections to the base is through a connecting pool **/

public class  SQLConnectionPool {
    private  static InitialContext initialContext =null;
    private  static DataSource dataSource = null;
    private static Context context = null;

    public Connection getConnection () throws SQLException, NamingException {
        initialContext = new InitialContext ();
        context= (Context) initialContext.lookup("java:comp/env");
        dataSource = (DataSource) initialContext.lookup ("java:/comp/env/jdbc/restaurant");
        return dataSource.getConnection ();
    }

    public static ResultSet executeQuery (String queryStmt ) throws SQLException, NamingException {

        ResultSet resultSet = null;
        SQLConnectionPool pool = new SQLConnectionPool ();
        CachedRowSetImpl cachedRowSet = null;
        Connection connection = pool.getConnection ();
        if (connection != null) {
            Statement statement = connection.createStatement ();
            if (statement!= null) {
                resultSet = statement.executeQuery (queryStmt);
            }
            cachedRowSet = new CachedRowSetImpl ();
            if (resultSet != null) {
                cachedRowSet.populate (resultSet);
            }
            connClose (connection, statement);
        }
        return cachedRowSet;
    }

    public static void executeUpdate ( String updStmt ) throws SQLException, NamingException {
        Statement statement = null;
        SQLConnectionPool pool = new SQLConnectionPool();
        Connection connection = pool.getConnection();
        if (connection != null) {
            statement = connection.createStatement();
            if (statement != null) {
                statement.executeUpdate(updStmt);
            }
        }
        connClose(connection, statement);
    }

        private static void connClose(Connection connection, Statement statement ) {
            try {
                if (connection != null) {
                    statement.close ();
                    connection.close ();
                }
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
}
