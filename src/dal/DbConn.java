package dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConn {
    final static String url = "jdbc:sqlserver://localhost;databaseName=pizzamario;";
    private static String user = "pizzaman";
    private static String pass = "pizzaman";

    private static ConnectionString prefConnection;

    public DbConn() {}

    public static Connection connection() {
        Connection con = null;
        try {
            if (prefConnection != null) {
                con = DriverManager.getConnection(prefConnection.getUrl(),
                        prefConnection.getUser(),
                        prefConnection.getPassword());
            } else {
                throw new SQLException("failed to open connect for given user info");
            }
        }catch(SQLException e){
            System.out.println("Failed to open connection");
        }
        return con;
    }

    public static Connection connect(){
        Connection con = null;
        try {
//            con = DriverManager.getConnection("jdbc.odbc:login_DNS");
            con = DriverManager.getConnection(url, user, pass);
//            con = DriverManager.getConnection(url);
            System.out.println("successful connection!");
        } catch (SQLException e) {
            System.out.println("Failed to open connection");
        }
        return con;
    }

    public void setPrefConnection(String url, String user, String password){
        prefConnection = new ConnectionString(url, user, password);
    }
}