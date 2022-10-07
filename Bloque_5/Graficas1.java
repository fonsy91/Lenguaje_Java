package Java.CursoJava.Bloque_5;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.*;

public class Graficas1 {
    public static void main(String[] args) {
        
        //Para Primera clase 
        //miMarco ventana = new miMarco();
        //ventana.setVisible(true);
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Para segunda clase 
        MarcoCentrado ventana2 = new MarcoCentrado();
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana2.setVisible(true);

    }
}

class miMarco extends JFrame{
    //Constructor 
    public miMarco(){
        //setSize(500, 300);
        //Colocamos las coordenadas de donde quieres que salga la ventana y la altura y ancho 
        setBounds(500, 300, 550, 250);
        //Hacemos que se estire o no la ventana 
        setResizable(false);
        //Hacer que ocupe toda la ventana completa, verticalmente 
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        //Ponemos un titulo a la ventana 
        setTitle("Programa");
    }
}

class MarcoCentrado extends JFrame{
    public MarcoCentrado(){
        //Con esto almacenamos en la variable nuestro sistema de ventanas 
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        //Averiguamos la resolucion de la ventana
        Dimension tamanioVentana = miPantalla.getScreenSize();
        System.out.println("El tamaño de mi ventana es pixeles es: "+tamanioVentana);
        int alturaPantalla = tamanioVentana.height;
        int anchoPantalla = tamanioVentana.width;
        setSize(anchoPantalla/2, alturaPantalla/2);
        setLocation(anchoPantalla/4, alturaPantalla/4);
        setTitle("Marco centrado");
        //Agregar un icono en la ventana poniendo el nombre del archivo o la ruta relativa 
        //Image miIcono = miPantalla.getImage("icono.gif");
        //setIconImage(miIcono);

        //Creamos un objeto de tipo Lamina y lo agregamos a la ventana con add 
        Lamina miLamina = new Lamina();
        add(miLamina);
        
    }
}

//Creamos una clase donde poder meter laminas dentro de MarcoCentrado 
class Lamina extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Estamos aprendiendo swing", 100, 100);
        //Con esto creamos figuras geometricas 
        g.drawRect(120, 120, 200, 200);
    }
}