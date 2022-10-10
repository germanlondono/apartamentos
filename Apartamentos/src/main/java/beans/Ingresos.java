
package beans;


public class Ingresos {
     private int id;
     private String novedad;
     private String genero;
     private String nombre;
     private String cedulas;
     private String personas;
     private String objetos;   

    public Ingresos(int id, String novedad, String genero, String nombre, String cedulas, String personas, String objetos) {
        this.id = id;
        this.novedad = novedad;
        this.genero = genero;
        this.nombre = nombre;
        this.cedulas = cedulas;
        this.personas = personas;
        this.objetos = objetos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedulas() {
        return cedulas;
    }

    public void setCedulas(String cedulas) {
        this.cedulas = cedulas;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public String getObjetos() {
        return objetos;
    }

    public void setObjetos(String objetos) {
        this.objetos = objetos;
    }

    @Override
    public String toString() {
        return "Ingresos{" + "id=" + id + ", novedad=" + novedad + ", genero=" + genero + ", nombre=" + nombre + ", cedulas=" + cedulas + ", personas=" + personas + ", objetos=" + objetos + '}';
    }

    public void add(String toJson) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
