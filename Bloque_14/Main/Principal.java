package Java.CursoJava.Bloque_14.Main;

import javax.swing.JFrame;
import Java.CursoJava.Bloque_14.Vista.Marco_Aplicacion;

public class Principal {
    public static void main(String[] args) {
        
        /*
         * Modelo Vista Controlador: Es un patron de software que separa la logica del programa 
         * Modelo (datos,BBDD), de la interfaz de usuario Vista(graficas,ventanas, front), y las 
         * comunicaciones Controlador(eventos,conexion,canales de comunicacion).
         * 
         * Esto tiene las ventajas de modularizar el programa(dividirlo en partes), reutilziar 
         * codigo, mayor facilidad en el desarrollo y mejor mantenimiento 
         */

        //Creamos un objeto de tipo Marco_Aplicacion (Interfaz grafica)
        Marco_Aplicacion mimarco = new Marco_Aplicacion();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);


    }
}
