package modelo;



import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
public class Usuario {

    //static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    //static final String URL_BASEDATOS = "jdbc:mysql://localhost:3306/constancia";
    


    //private static final Connection resultado = null;
    private java.sql.PreparedStatement pst;
    private ResultSet rs;
    
    public boolean addUser(User user){

        boolean state=false;
        //Connection con=null;

        try {
            
            //Connection conexion=null;//maneja la conexión

            
            //Class.forName(CONTROLADOR);//carga la clase controlador

           PruebaConnection conexion=new PruebaConnection();//crea objeto conexion
            //con=PruebaConnection.getInstance.getConnection();//establece la conexión a la bd

            
            if(conexion!=null){

                String sql="INSERT INTO usuario (id_usuario, nombre, contraseña) VALUES (?,?,?)";
                
                pst= conexion.prepareStatement(sql);

                pst.setInt(1, user.getId());
                pst.setString(2, user.getNombre());
                pst.setString(3, user.getContrasena());

                int resultado= pst.executeUpdate();

                state=resultado>0;
                


            }else{
                System.out.println("NO PUEDE CONECTARSE");
            }
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        
        }finally{
            
            try {
               // resultado.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return state;
    }


    public ArrayList<User> selectUser(String filter, ArrayList<String> data){

        ArrayList<User> list=new ArrayList<>();
        User user;


        Connection conexion=null;

        try {
            
            //Connection conexion=null;//maneja la conexión

            
            Class.forName(CONTROLADOR);//carga la clase controlador
            conexion=DriverManager.getConnection(URL_BASEDATOS, "root", "root");//establece la conexión a la bd

            
            if(conexion!=null){

                String sql="";
                
               
                switch (filter) {
                    case "Nombre de Usuario":
                        sql="SELECT * FROM usuario WHERE nombre REGEXP ?";
                        pst= conexion.prepareStatement(sql);
                        pst.setString(1, data.get(0));
                    break;

                    case "ID":
                    sql="SELECT * FROM usuario WHERE id_usuario=?";
                    pst= conexion.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(data.get(1)));
                    break;

                    default:
                    sql="SELECT * FROM usuario WHERE 1";
                    pst= conexion.prepareStatement(sql);
                    break;
                }

                rs=pst.executeQuery();

                while(rs.next()){

                    user=new User();
                    user.setId(rs.getInt("id_usuario"));
                    user.setNombre(rs.getString("nombre"));
                    user.setContrasena(rs.getString("contraseña"));
                    
                    list.add(user);
                }              



            }else{
                System.out.println("NO PUEDE CONECTARSE");
            }
            
            } catch (Exception e) {
            
            System.out.println(e.getMessage());
        
        }finally{
            
            try {
               // resultado.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return list;

       // return state;

    }
}

    
}
