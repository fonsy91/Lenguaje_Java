package Java.CursoJava.Bloque_1;

import java.util.Scanner;
import javax.swing.*;

public class CondicionalesBucles {
    public static void main(String[] args) {
        /* 
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Introduce tu edad: ");
            int edad = entrada.nextInt();

            if (edad<18) {
                System.out.println("Eres un adolescente");
            }
            else if(edad<40){
                System.out.println("Eres medio viejo");
            }
            else if(edad<66){
                System.out.println("Eres un jubileta");
            }
            else{
                System.out.println("Estas jodido");
            }
        }
        */
        //Mas sobre condicionales
        try ( Scanner opcion = new Scanner(System.in)) {
            System.out.println("Introduce una opcion: \n1: Cuadrado \n2: Rectangulo \n3: Triangulo \n4: Circulo");
            int figura = opcion.nextInt();
            switch (figura) {
                case 1:
                    int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado: "));
                    System.out.println("El Area del cuadrado es: "+Math.pow(lado, 2));
                    break;
                case 2: 
                    int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
                    int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
                    System.out.println("El Area del rectangulo es: "+base*altura);
                    break;     
                case 3: 
                    base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
                    altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura: "));
                    System.out.println("El Area del triangulo es: "+(base*altura)/2);
                    break;
                case 4: 
                    int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio: "));
                    System.out.println("El Area del Circulo es: ");
                    System.out.printf("%1.2f",Math.PI*(Math.pow(radio, 2)));
                    break;
                default:
                    System.out.println("La opcion no es correcta");
                    break;
            }
        } 

    }
}
