package modelo.persistencia.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistencia {
    private static String loggin = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost/facturacion";
    private static Connection conn = null;
    
    public static Connection createConnection(){
        if(conn==null){
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn=DriverManager.getConnection(url, loggin, password);
            } catch (SQLException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return conn;
    }
    
    public static void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
                conn= null;
            } catch (SQLException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
