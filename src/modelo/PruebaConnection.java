package modelo;

//Establecer conexión con MySQL

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebaConnection {

    static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    static final String URL_BASEDATOS = "jdbc:mysql://localhost:3306/constancia";

    public static Connection pruebaConnection() {

        // public static void main(String[] args) {

        Connection conexion = null;// maneja la conexión

        // Conectarse a la base de datos constancia
        try {
            Class.forName(CONTROLADOR);// carga la clase controlador
            conexion = DriverManager.getConnection(URL_BASEDATOS, "root", "root");// establece la conexión a la bd

            System.out.println("CONEXIÓN EXITOSA A LA BASE DE DATOS\n");

        } // fin del try
        catch (Exception excepcion) {
            System.out.println("NO PUEDE CONECTARSE\n" + excepcion);
        } // fin de catch
        return conexion;
    }// fin de main
}// fin de la clase PruebaConnection
