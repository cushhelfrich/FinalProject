package finalproject;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author charl
 */
public class DBConnector {
    private Connection connection;

        public Connection makeConnection() throws SQLException {
        
        
        Driver driver = new Driver() {
            @Override
            public Connection connect(String url, Properties info) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean acceptsURL(String url) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int getMajorVersion() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int getMinorVersion() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean jdbcCompliant() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        // Local connection info goes here
        connection = DriverManager.getConnection (
                "jdbc:mysql://localhost:3306/mydb",
                "root",
                "!986$@ckbu+"
        );
        
       return connection; 
    }
        
    public ResultSet retrieveSaltedPW(String user) throws SQLException
    {
        boolean b = false;
        Statement stmt;
        ResultSet rs = null;
        
        try 
        {
             stmt = connection.createStatement();
             // Modify these parameters according to group discussion
             rs = stmt.executeQuery("SELECT email, pw_hash, salt FROM test_encryption WHERE email = '" + user + "'");
        }
        catch (SQLException ex)
        {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return rs;
    }
}
