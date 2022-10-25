package Java.CursoJava.Bloque_14.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //Controlador del patron de software 
    Connection miConexion=null;
    public Conexion(){

    }

    //Metodo 
    public Connection dameConexion(){
        try {
            //Creamos la conexion con la base de datos, se hara uso de la clase DriverManager 
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "tucontraseñaBBDD");
        }catch(Exception e){}

        return miConexion;
    }
}
