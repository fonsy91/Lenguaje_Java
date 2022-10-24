package Java.CursoJava.Bloque_13.BBDD2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class ModificaBBDD {
    public static void main(String[] args) {

        //Inserta, actualiza y elimina 

        try {
            //Creamos la conexion con la base de datos, se hara uso de la clase DriverManager 
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "ContraseñaBBDD");
            //Creamos un objeto Statement 
            Statement miStatement = miConexion.createStatement();
            //Intrucciones SQL 
            String InstruccionSQL = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO,NOMBREARTÍCULO,PRECIO) VALUES ('AR77','PANTALON','25.35')";
            String InstruccionSQL2 = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
            String InstruccionSQL3 = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'";
            //Ejecutamos la instruccion 
            miStatement.executeUpdate(InstruccionSQL);
            System.out.println("Datos insertados correctamente");
            miStatement.executeUpdate(InstruccionSQL2);
            System.out.println("Datos modificados correctamente");
            miStatement.executeUpdate(InstruccionSQL3);
            System.out.println("Datos eliminados correctamente");
            System.out.println("");

            /*
             * Consultas preparadas: permite pasar parametros a las sentencias SQL, previene ataques
             * y mejor rendimiento.
             * 
             * Consulta Normal:    SELECT * FROMPRODUCTOS WHERE SECCION='DEPORTES' AND PAISESORIGEN='ESPAÑA'
             * Consulta preprada:  SELECT * FROMPRODUCTOS WHERE SECCION=? AND PAISESORIGEN=?
             */

            PreparedStatement miSentencia = miConexion.prepareStatement("SELECT NOMBREARTÍCULO,SECCIÓN,PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");
            System.out.println("EJECUCION PRIMERA CONSULTA");
            System.out.println("");
            //Establecemos parametros de consulta el 1 equivale a la primera interrogacion 
            miSentencia.setString(1, "deportes");
            miSentencia.setString(2, "USA");
            //Ejecutar y recorrer consulta 
            ResultSet rs = miSentencia.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }   
            rs.close();

            //Es bueno porque podemos reutilizar la consulta y hacerlo tantas veces como quisieramos
            System.out.println("");
            System.out.println("EJECUCION SEGUNDA CONSULTA");
            System.out.println("");
            miSentencia.setString(1, "céramica");
            miSentencia.setString(2, "china");
            rs = miSentencia.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }   
            rs.close();



        } catch (Exception e) {
            System.out.println("No se ha podido realizar la conexion"+e.getMessage());
        }


    }   
}
