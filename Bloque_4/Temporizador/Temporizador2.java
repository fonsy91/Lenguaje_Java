package Java.CursoJava.Bloque_4.Temporizador;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;


public class Temporizador2 {
    public static void main(String[] args) {
        
        /*
         * Porque tener una clase dentro de otra: 
         * 1:Para acceder a los campos privados de una clase dentro de otra 
         * 2:Para ocultar una clase de otra pertenecientes al mismo paquete 
         * 3:Para crear clases internas, muyutiles para gestionar eventos y retrollamadas 
         * 4: 
         */

        Reloj miReloj = new Reloj(3000, true);
        miReloj.enMarcha();
        JOptionPane.showMessageDialog(null, "Pulse aceptar para terminar");
        System.exit(0);

    }
}


class Reloj{
    private int intervalo;
    private boolean sonido; 

    public Reloj(int intervalo, boolean sonido){
        this.intervalo=intervalo;
        this.sonido=sonido;
    }

    public void enMarcha(){
        ActionListener oyente = new DameLaHora2();
        Timer miTemporizador = new Timer(intervalo, oyente);
        miTemporizador.start();
    }

    //Implementamos una clase dentro de otra 
    private class DameLaHora2 implements ActionListener{
        //Desarrollamos el metodo de la interface 
        public void actionPerformed(ActionEvent evento){
            Date ahora = new Date();
            System.out.println("Te pongo la hora cada 3 segundos"+ahora);
            if (sonido) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

}