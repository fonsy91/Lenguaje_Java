package Java.CursoJava.Bloque_4.Temporizador;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class Temporizador {
    public static void main(String[] args) {
        
        DameLaHora oyente = new DameLaHora();
        Timer miTemporizador = new Timer(5000, oyente);
        miTemporizador.start();
        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
        System.exit(0);

    }
}

class DameLaHora implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Date ahora = new Date();
        System.out.println("Pongo la hora cada 5 segundos: "+ahora);
        
    }
}