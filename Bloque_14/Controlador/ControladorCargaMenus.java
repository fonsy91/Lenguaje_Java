package Java.CursoJava.Bloque_14.Controlador;

import java.awt.event.*;

import Java.CursoJava.Bloque_14.Modelo.CargaMenus;
import Java.CursoJava.Bloque_14.Vista.Marco_Aplicacion;

public class ControladorCargaMenus extends WindowAdapter{
    CargaMenus obj = new CargaMenus();
    private Marco_Aplicacion elmarco; 

    public ControladorCargaMenus(Marco_Aplicacion elmarco){
        this.elmarco=elmarco;
    }

    //Metodos
   public void windowOpened(WindowEvent e){
        obj.ejecutaConsultas();
        try {
            while (obj.rs.next()) {
                elmarco.secciones.addItem(obj.rs.getString(1));
            }
            while (obj.rs2.next()) {
                elmarco.paises.addItem(obj.rs2.getString(1));
            }
        } catch (Exception e2) {System.out.println(e2.getMessage());}
   }
    
}
