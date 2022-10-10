
package controller;

import java.util.Map;

public interface IUsuarioController {
    
    public String login(String username,String contrasena);
    
    public String register(String username,String contrasena,
             String numero_de_apartamento,String nombre, String apellidos, String genero, String email);
    
    
    public String pedir (String username);
    
}