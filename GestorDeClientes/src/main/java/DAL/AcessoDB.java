package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AcessoDB {
    public static Connection conectar(String DB) throws Exception {
        String url = "jdbc:mysql://localhost:3306/"+DB;
        String user = "root"; 
        String password = "0106";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
    
    public static void desconectar(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Exceção, causa:" + e.getClass());
            e.printStackTrace();
        }
    }
 
    public static void desconectar(Connection conn, PreparedStatement pstm) {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            } 
        } catch (Exception e) {
            System.out.println("Exceção, causa:" + e.getClass());
            e.printStackTrace();
        }
    }
 
    public static void desconectar(Connection conn, PreparedStatement pstm, ResultSet rs) {
        try { 
            if (rs != null) {
                rs.close();
            } 
            if (pstm != null) {
                pstm.close();
            } 
            if (conn != null) {
                conn.close();
            } 
        } catch (Exception e) {
            System.out.println("Exceção, causa:" + e.getClass());
            e.printStackTrace(); 
        }
    }
}




