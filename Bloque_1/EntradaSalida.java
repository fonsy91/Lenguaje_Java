package Java.CursoJava.Bloque_1;

import java.util.Scanner;   //paquete de util para poder coger valores por la entrada de teclado 
import javax.swing.JOptionPane;

public class EntradaSalida {
    public static void main(String[] args) {
        
        //Con system indicamos que la entrada sera por teclado 
        
        Scanner entradaTeclado = new Scanner(System.in); 
        System.out.print("Hola ingrese su nombre: ");
        String nombre=entradaTeclado.nextLine();
        System.out.print("Introduce edad: ");
        int edad=entradaTeclado.nextInt();

        System.out.println("Hola "+nombre+" bienvenido tu edad es "+edad);
        entradaTeclado.close();
        
        //Usando una ventana 
        String Nombre_usuario = JOptionPane.showInputDialog("Introduce tu nombre porfavor");
        String edad2 = JOptionPane.showInputDialog("Introduce edad ");

        //parseamos la edad de tipos string a tipo int 
        int edadParseada = Integer.parseInt(edad2);
        System.out.println("El nombre es "+Nombre_usuario+" y la edad "+edadParseada);

        //Usando el formato con printf 
        double x = 100000.0;
        System.out.printf("%1.2f",x/3);

    }
}
