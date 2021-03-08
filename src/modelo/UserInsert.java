package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserInsert {

    static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    static final String URL_BASEDATOS = "jdbc:mysql://localhost:3306/constancia";

    private static final Connection resultado = null;
    private java.sql.PreparedStatement pst;
    private ResultSet rs;

    public boolean addUser(User user) {

        boolean state = false;
        Connection conexion = null;

        try {

            // Connection conexion=null;//maneja la conexión

            Class.forName(CONTROLADOR);// carga la clase controlador
            conexion = DriverManager.getConnection(URL_BASEDATOS, "root", "root");// establece la conexión a la bd

            if (conexion != null) {

                String sql = "INSERT INTO usuario (id_usuario, nombre, contraseña) VALUES (?,?,?)";

                pst = conexion.prepareStatement(sql);

                pst.setInt(1, user.getId());
                pst.setString(2, user.getNombre());
                pst.setString(3, user.getContrasena());

                int resultado = pst.executeUpdate();

                state = resultado > 0;

            } else {
                System.out.println("NO PUEDE CONECTARSE");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            try {
                // resultado.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return state;
    }

    public ArrayList<User> selectUser(String filter, ArrayList<String> data) {

        ArrayList<User> list = new ArrayList<>();
        User user;

        Connection conexion = null;

        try {

            // Connection conexion=null;//maneja la conexión

            Class.forName(CONTROLADOR);// carga la clase controlador
            conexion = DriverManager.getConnection(URL_BASEDATOS, "root", "root");// establece la conexión a la bd

            if (conexion != null) {

                String sql = "";

                switch (filter) {
                case "Nombre":
                    sql = "SELECT * FROM usuario WHERE nombre REGEXP ?";
                    pst = conexion.prepareStatement(sql);
                    pst.setString(1, data.get(0));
                    break;

                case "ID":
                    sql = "SELECT * FROM usuario WHERE id_usuario=?";
                    pst = conexion.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(data.get(0)));
                    break;

                default:
                    sql = "SELECT * FROM usuario WHERE 0";
                    pst = conexion.prepareStatement(sql);
                    break;
                }

                rs = pst.executeQuery();

                while (rs.next()) {

                    user = new User();
                    user.setId(rs.getInt("id_usuario"));
                    user.setNombre(rs.getString("nombre"));
                    user.setContrasena(rs.getString("contraseña"));

                    list.add(user);
                }

            } else {
                System.out.println("NO PUEDE CONECTARSE");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            try {
                // resultado.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return list;

        // return state;

    }

    // dime si
    public boolean modificarUser(User user) {

        boolean state = false;
        Connection conexion = null;// maneja la conexión

        try {

            Class.forName(CONTROLADOR);// carga la clase controlador
            conexion = DriverManager.getConnection(URL_BASEDATOS, "root", "root");// establece la conexión a la bd

            if (conexion != null) {

                String sql = "UPDATE usuario SET nombre=?, contraseña=? WHERE id_usuario=?";

                pst = conexion.prepareStatement(sql);// crea una consulta que seleccina todas las entradas en la bd

                // establecer parámetros, después ejecuta la consulta
                // pst.setInt(1, user.getId());
                pst.setString(1, user.getNombre());
                pst.setString(2, user.getContrasena());
                pst.setInt(3, user.getId());

                int resultado = pst.executeUpdate();// modifica la nueva entrada; devuelve el # de filas actualizadas
                // si resultado es mayor a 0 devuelve true y se actualiza de lo contrario
                // recibirá un error
                state = resultado > 0;

            } else {
                System.out.println("NO PUEDE CONECTARSE");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            try {
                // resultado.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return state;
    }

    public boolean eliminarUser(int id_usuario) {

        boolean state = false;
        Connection conexion = null;// maneja la conexión

        try {

            Class.forName(CONTROLADOR);// carga la clase controlador
            conexion = DriverManager.getConnection(URL_BASEDATOS, "root", "root");// establece la conexión a la bd

            if (conexion != null) {

                String sql = "DELETE FROM usuario WHERE id_usuario=?";

                pst = conexion.prepareStatement(sql);// crea una consulta que seleccina todas las entradas en la bd

                // establecer parámetros, después ejecuta la consulta
                pst.setInt(1, id_usuario);

                int resultado = pst.executeUpdate();// modifica la nueva entrada; devuelve el # de filas actualizadas

                // si resultado es mayor a 0 devuelve true y se eliminan los datos, de lo
                // contrario recibirá un error
                state = resultado > 0;

            } else {
                System.out.println("NO PUEDE CONECTARSE");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {

            try {
                // resultado.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return state;

    }

}
