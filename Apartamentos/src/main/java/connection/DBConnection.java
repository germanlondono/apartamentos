package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    Connection connection;
    static String bd = "railway";
    static String port = "7964";
    static String login = "root";
    static String password = "xmcm5lhEGCke8iJIBIWt";
    static String ip = "containers-us-west-95.railway.app";

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + this.ip + ":" + this.port + "/" + this.bd;
            connection = DriverManager.getConnection(url, this.login, this.password);
            System.out.println("conexion");

        } catch (Exception ex) {
            System.out.println("Error");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {

        connection = null;

    }
}
