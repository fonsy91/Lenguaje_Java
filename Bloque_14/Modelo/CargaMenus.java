package Java.CursoJava.Bloque_14.Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CargaMenus {
    Conexion miconexion; 
    public ResultSet rs; 
    public ResultSet rs2; 
    public CargaMenus(){
        miconexion=new Conexion();
    }

    //Metodos
    public String ejecutaConsultas(){
        Productos miProducto = null;
        Connection accesoBBDD = miconexion.dameConexion();
        try {
            Statement secciones = accesoBBDD.createStatement();
            Statement paises = accesoBBDD.createStatement();
            rs = secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
            rs2 = paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
            miProducto = new Productos();
            miProducto.setSeccion(rs.getString(1));
            miProducto.setpOrigen(rs.getString(1));
            rs.close();
            rs2.close();
            accesoBBDD.close();

        } catch (Exception e) {System.out.println(e.getMessage());}

        return miProducto.getSeccion();
    }
}
