package Java.CursoJava.Bloque_1;

import java.util.Scanner;   //paquete de util para poder coger valores por la entrada de teclado 

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

    }
}
