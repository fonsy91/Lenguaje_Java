package Java.CursoJava.Bloque_2.POO3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {

    /*
     * En este Bloque se ven algunos conceptos clave para la herencia en java como 
     * heredar de una clase a otra gracias a esto las clases hijas pueden eredar variables 
     * y metodos de la clase padre, tambien vemos la palabra reservada super que se usa 
     * para poder heredar constructores mas delante se veran y por ultimo la sobreescritura 
     * de metodos en java que tambien se vera mas adelante tiene el nombre de polimorfismo 
     * de exclusion permite a las clases secundarias hacer una implementacion de un metodo que 
     * ha sido dado por una clase principal, si se crea un objeto de la clase principal y se 
     * invoca el método, se va a ejecutar el código que tiene este en esa clase, pero si se crea 
     * un objeto de la subclase y se invoca el método, se ejecuta la versión del método en esta 
     * subclase con @Override. 
     */

    //Array de motos y camiones para la simulacion de un concesionario usando la clase padre 
    public static ArrayList<Vehiculo> concesionario = new ArrayList<>();
    

    public static void main(String[] args) {
        

        Camion iveco = new Camion(4, 2000, "Limones");
        Moto ktm = new Moto(250, true);

        //Agregamos al array los vehiculos que queramos 
        concesionario.add(iveco);
        concesionario.add(ktm);

        //Para poder coger valores por teclado
        Scanner entradaTeclado = new Scanner(System.in);
        //Para recorrer un arrayList 
        Iterator<Vehiculo> iterador = concesionario.iterator();
        

        System.out.println("************** CONCESIONARIO **************");
        System.out.println("*******************************************");
        int opcion; 
        do {
            System.out.println("Introduzca una opcion: ");
            opcion = entradaTeclado.nextInt();
            System.out.println("1. Ver Vehiculos: ");
            System.out.println("2. Probar descarga de camion: ");
            System.out.println("3. Probar cajon de moto: ");
            System.out.println("4. Salir: ");

            switch (opcion) {
                case 1:
                    System.out.println("\nLos Vehiculos de nuestro concesionario son: \n");
                    while (iterador.hasNext()) {
                        Vehiculo elemento = iterador.next();
                        System.out.println(elemento.toString());
                    }
                    break;
                case 2:
                    iveco.descargar(true);
                    break;
                case 3:
                    ktm.abrirCajon(true);
                    break;
            
                default:
                System.out.println("Esta opcion no es valida");
                    break;
            }

        } while (opcion == 4);

        entradaTeclado.close();
        

    }
}
