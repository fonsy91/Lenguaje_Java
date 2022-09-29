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

        //Bucles *********************
        /* 
        String clave="Juan";
        String pass="";
        //No saldra del bucle while hasta que no se introduzca la contraseña correcta 
        while (clave.equals(pass) == false) {
            pass=JOptionPane.showInputDialog("Introduce la contraseña porfavor");
            if (clave.equals(pass) == false) {
                System.out.println("Contraseña incorrecta");
            }
        }
        */
        System.out.println("Contraseña correcta, acceso permitido");

        //Bucles **********************
        //Nos devuelve un numero aleatorio entre 1 y 100 en decimal 
        int aleatorio=(int)(Math.random()*100);
        System.out.println(aleatorio);

        String genero="";
        do {
            genero=JOptionPane.showInputDialog("Introduce tu genero (H/M)");
        } while (genero.equalsIgnoreCase("H") == false && genero.equalsIgnoreCase("M") == false);

        int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce altura en centimetros"));
        int pesoideal=0;
        if (genero.equalsIgnoreCase("H")) {
            pesoideal=altura-110;
        }
        else if(genero.equalsIgnoreCase("M")){
            pesoideal=altura-120;
        }

        System.out.println("Tu peso ideal es: "+pesoideal);

        //Bucles **********************
        boolean arroba=false;
        String email=JOptionPane.showInputDialog("Introduce tu email");
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                arroba=true;
            }
        }
        if (arroba==true) {
            System.out.println("El email es correcto");
        }else{
            System.out.println("El email es incorrecto");
        }


    }
}
