/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author aleyelre
 */
public class ConexionSingleton {

    private static ConexionSingleton instancia = null;
    private java.sql.Connection conexion = null;

    public static String driver = "";
    public static String urlBaseDatos = "";
    public static String usuario = "";
    public static String password = "";

    private ConexionSingleton() {
    }

    public static ConexionSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConexionSingleton();
        }
        return instancia;
    }

    /* devuelve true si se ha creado correctamente */

    @SuppressWarnings("UseSpecificCatch")
    public boolean crearConexion() {
        try {

            ConexionSingleton.urlBaseDatos = "jdbc:mysql://localhost:3303/bdsicate";
            ConexionSingleton.usuario = "root";
            ConexionSingleton.password = "Temporal345";
            ConexionSingleton.driver = "com.mysql.jdbc.Driver";

            Class.forName(
                    driver
            );

            System.out.println("Creando la conexion con los datos urlBaseDatos " + urlBaseDatos
                    + "usuario " + usuario + " password " + password);

            conexion = DriverManager.getConnection(
                    urlBaseDatos,
                     usuario,
                     password
            );
        } catch (Exception e) {
            System.out.println("Error creando conexion " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public java.sql.Connection getConexion() {
        if (conexion == null) {
            crearConexion();
        }
        return conexion;
    }
}
