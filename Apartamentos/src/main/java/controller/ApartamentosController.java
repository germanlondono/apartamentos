
package controller;
 import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import beans.Ingresos;
import connection.DBConnection;

public class ApartamentosController implements IApartamentosController {

    @Override
    public String listar(boolean ordenar, String orden) {
        
        Gson gson = new Gson ();
        
        DBConnection con = new DBConnection();
        String sql = "Select * from ingresos";
        if (ordenar == true) {
            sql += "order by genero" + orden;
        }
        List<String> Ingresos = new ArrayList<>();
        
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                int id = rs.getInt("id");
                String novedad = rs.getString("novedad");
                String genero = rs.getString("genero");
                String nombre = rs.getString("nombre");
                String cedulas = rs.getString("cedulas");
                String personas = rs.getString("personas");
                String objetos = rs.getString("objetos");
                
                   Ingresos ingresos = new Ingresos(id, novedad, genero, nombre, cedulas, personas, objetos);
                
                ingresos.add(gson.toJson(ingresos));
            }  
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            con.desconectar();
        }
        return gson.toJson(Ingresos);
    }
       
    
    
    
}
