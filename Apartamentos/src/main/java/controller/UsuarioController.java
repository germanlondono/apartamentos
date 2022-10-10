package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuarios;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController{

    @Override    
    public String login(String username,String contrasena){
        
        Gson gson = new Gson();
        
        DBConnection con = new DBConnection();
        String sql = "Select * from usuarios where username = '" + username + "'and contrasena = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String numero_de_apartamento =rs.getString("numero_de_apartamento");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String genero = rs.getString("genero");
                String email  =rs.getString("email");
                
                
            
            Usuarios usuarios =   
                    new Usuarios(username,contrasena, numero_de_apartamento,nombre,apellidos,genero,email);
            return gson.toJson(usuarios);
             
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
        return "false";
    }

    @Override
    public String register(String username, String contrasena, String numero_de_apartamento,
            String nombre, String apellidos, String genero, String email) {
        
        Gson gson = new Gson();
        
        DBConnection con = new DBConnection();
        
        String sql = "insert into usuarios values('"+ username +"','"+ contrasena +"',"+ numero_de_apartamento +",'"+ nombre +"','"+ apellidos +"','"+ genero +"','"+ email +"')";
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            
            Usuarios usuarios = new Usuarios(username, contrasena,numero_de_apartamento, nombre, apellidos, genero, email);
            
            st.close();
            
            return gson.toJson(usuarios);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    } 

    @Override
    public String pedir(String username) {
     
        Gson gson = new Gson ();
        DBConnection con = new DBConnection();
        String sql = "Select * from usuarios where username = '" + username + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
             while (rs.next()) {
                     String contrasena = rs.getString("contrasena");
                     String numero_de_apartamentos = rs.getString("numero_de_apartamento");
                     String nombre = rs.getString("nombre");
                     String apellidos = rs.getString ("apellidos");
                     String genero = rs.getString("genero");
                     String email = rs.getString("email");
                     
                     Usuarios usuario = new Usuarios(username,contrasena,numero_de_apartamentos,nombre,apellidos,genero,email);
                     return gson.toJson(usuario);          
                     }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }
    
    
}
