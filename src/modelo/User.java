package modelo;

public class User {
    
    private int id_usuario;
    private String nombre;
    private String contrasena;


    public User(){

    }

    public User(int id_usuario, String nombre, String contrasena){

        this.id_usuario=id_usuario;
        this.nombre=nombre;
        this.contrasena=contrasena;

    }

    public int getId(){
        return this.id_usuario;
    }

    public void setId(int id_usuario){
        this.id_usuario=id_usuario;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getContrasena(){
        return this.contrasena;
    }

    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }

}
