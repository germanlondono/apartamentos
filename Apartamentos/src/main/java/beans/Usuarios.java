package beans;


public class Usuarios {
    
    private String username;
    private String contrasena;
    private String numero_de_apartamento;
    private String nombre;
    private String apellidos;
    private String genero;
    private String email;

    public Usuarios(String username, String contrasena, String numero_de_apartamento, String nombre, String apellidos, String genero, String email) {
        this.username = username;
        this.contrasena = contrasena;
        this.numero_de_apartamento = numero_de_apartamento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumero_de_apartamento() {
        return numero_de_apartamento;
    }

    public void setNumero_de_apartamento(String numero_de_apartamento) {
        this.numero_de_apartamento = numero_de_apartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "username=" + username + ", contrasena=" + contrasena + ", numero_de_apartamento=" + numero_de_apartamento + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero + ", email=" + email + '}';
    }

    
    
  

                            
}
