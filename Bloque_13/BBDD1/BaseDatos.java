package Java.CursoJava.Bloque_13.BBDD1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDatos {
    public static void main(String[] args) {
        
        /*
         * JDBC(Java Data Base Connectivity): es como un driver que conecta una aplicacion 
         * java con una base de datos, para ello hay que manejar dos paquetes java: Java.sql 
         * y Javax.sql. 
         * 
         * Lo primero que hay que hacer es instalar mysql, el driver jdbc mysql 
         *   
         */


        try {
            //Creamos la conexion con la base de datos, se hara uso de la clase DriverManager 
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "contraseñaBBDD");
            //Creamos un objeto Statement 
            Statement miStatement = miConexion.createStatement();
            //Ejecutar SQL, ResultSet es lo que recibe de la consulta SQL  
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
            //Recorremos el ResultSet 
            while (miResultSet.next()) {
                System.out.println(miResultSet.getString("NOMBREARTÍCULO")+" "+miResultSet.getString("CÓDIGOARTÍCULO")+" "+miResultSet.getString("PRECIO"));
                //System.out.println(miResultSet.getString(3)+" "+miResultSet.getString(1)+" "+miResultSet.getString(4));
            }


        } catch (Exception e) {
            System.out.println("No se ha podido realizar la conexion"+e.getMessage());
        }


    }
}
