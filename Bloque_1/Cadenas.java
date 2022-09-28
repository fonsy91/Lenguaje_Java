package Java.CursoJava.Bloque_1;

/*
 * CURSO DE JAVA 
 * LINK DEL CURSO: https://www.youtube.com/watch?v=YMyJLs22uY4&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=13&ab_channel=pildorasinformaticas
 * 
 * Compilacion: javac Cadenas.java
 * Ejecucion: java Cadenas.java 
 * 
 * Estamos usando un paquete por defecto que es el de CursoJava pero existen muchos paquetes predefinidos que en el caso de 
 * usar algunas de sus funciones sera necesario importarlos para poder usar sus clases y metodos
 * 
 */

public class Cadenas {
    public static void main(String[] args) {

        String nombre="Juan";
        String alumno1="Fernando";
        String alumno2="fernando";
        System.out.println("Mi nombre es: "+nombre);
        System.out.println("Mi nombre tiene: "+nombre.length()+" letras");
        //Devolvemos la letra segun el indice que se le indica 
        System.out.println("La primera letra de mi nombre es: "+nombre.charAt(0));
        System.out.println("La ultima letra de mi nombre es: "+nombre.substring(nombre.length() - 1));
        //Comparacion de cadenas equals distinge entre mayusculas y minusculas alumno1 y alumno2 sera false 
        System.out.println(alumno1.equals(alumno2));

        
        
    }
}

