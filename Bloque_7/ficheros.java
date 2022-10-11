package Java.CursoJava.Bloque_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ficheros {
    public static void main(String[] args) {
        
        /*
        * Reader: secuencia de entrada para la lectura de ficheros 
        * Writer: secuencia de salida para la escritura de ficheros 
        */

        //LeerFichero accediendo =  new LeerFichero();
        //accediendo.lee();

        //EscribirFichero escritura = new EscribirFichero();
        //escritura.escribir();

        //LeerBuffer accediendo2 = new LeerBuffer();
        //accediendo2.lee();

        //EscribirBuffer escritura2 = new EscribirBuffer();
        //escritura2.escribir();

        /*
        * Stream byte java tambien puede manejar cualquier tipo de archivos para enviar y recibir 
        * cualquier tipo de archivo (pdf, excel, VLC...) con:
        * FileInputStream y FileOutputStream como ejemplo leeremos una imagen   
        */

        //Para contar cuantos bytes recorre
        int contador = 0; 
        //Array para almacenar todos los bytes del archivo 
        int datos_entrada[] = new int[17830];
        try {
            FileInputStream archivo_lectura = new FileInputStream("C:/Users/alfon/Desktop/Imagenes/fondo1.jpg");
            boolean final_ar = false;
            while (!final_ar) {
                //Lo que hace es leer byte a byte el archivo 
                int byte_entrada =archivo_lectura.read();
                //Almacenamos en el array los bytes, -1 es porque ha terminado de leer el archivo
                if (byte_entrada != -1) {
                    datos_entrada[contador] = byte_entrada;
                }
                else{
                    final_ar = true;
                }
                
                //muestra los bytes de la imagen
                System.out.println(datos_entrada[contador]);
                contador++;
            }
            archivo_lectura.close();
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo");
        }

        System.out.println("El numero de bytes es: "+contador);

        //Llamamos al metodo creaFichero para la creacion de la copia de la imagen 
        creaFichero(datos_entrada);

    }// Final del main ***********************

    //Metod para la salida del archivo stream para poder conseguir una copia de la imagen 
    static void creaFichero(int datos_nuevo_fichero[]){
        try {
            //Crea un nuevo fichero en la ruta indicada 
            FileOutputStream fichero_nuevo = new FileOutputStream("C:/Users/alfon/Desktop/Imagenes/fondo1_copia.jpg");
            for (int i = 0; i < datos_nuevo_fichero.length; i++) {
                fichero_nuevo.write(datos_nuevo_fichero[i]);
            }
            fichero_nuevo.close();
        } catch (IOException e) {
            System.out.println("El fichero no se ha podido crear");
        }
    }
}

//CLASES PARA LEER FICHEROS Y BUFFERS 
class LeerFichero{
    //Funcion que lee un fichero 
    public void lee(){
        try {
            //Estamos haciendo un stream de datos con el fichero y nos advierte con un warning para acabar con esto se debe cerrar el fichero 
            FileReader entrada = new FileReader("C:/Users/alfon/Desktop/Programacion/Java/CursoJava/Bloque_7/fichero.txt");
            int c = 0;
            while (c != -1) {
                c=entrada.read();
                //Aparecerqa en pantalla los numeros pertenecientes a los caracteres UNICODE por ello hay que castear
                char letra = (char) c; 
                System.out.print(letra);
                
            }
            entrada.close();

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}


class EscribirFichero{
    public void escribir(){
        String frase = "Esto es una prueba de escritura2";
        try {
            //Esto crea un fichero y escribe 
            //FileWriter escritura = new FileWriter("C:/Users/alfon/Desktop/Programacion/Java/CursoJava/Bloque_7/fichero.txt");
            //Esto escribe sobre un fichero existente
            FileWriter escritura = new FileWriter("C:/Users/alfon/Desktop/Programacion/Java/CursoJava/Bloque_7/fichero.txt",true);
            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (IOException e) {
            System.out.println("No se puede escribir en el fichero");
        }
    }
}

/*
* Buffers para transfererir o leer muchos caracteres para ello hacemos la creacion de buffers 
* Para leer un Buffer: BufferedReader
*/

class LeerBuffer{
    //Funcion que lee un fichero usando buffer 
    public void lee(){
        try {
            //Estamos haciendo un stream de datos con el fichero y nos advierte con un warning para acabar con esto se debe cerrar el fichero 
            FileReader entrada = new FileReader("C:/Users/alfon/Desktop/Programacion/Java/CursoJava/Bloque_7/fichero.txt");
            BufferedReader miBuffer = new BufferedReader(entrada);
            String linea = "";
            while (linea != null) {
                linea = miBuffer.readLine();
                if (linea != null) {
                    System.out.println(linea);
                }

            }
            entrada.close();

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}

//Falta que funcione este apartado
class EscribirBuffer{
    public void escribir(){
        
        try {
            FileWriter escritura = new FileWriter("C:/Users/alfon/Desktop/Programacion/Java/CursoJava/Bloque_7/fichero.txt");
            BufferedWriter miBuffer = new BufferedWriter(escritura);
            String frase = "Esto es una prueba de escritura";
            
            for (int i = 0; i < 2; i++) {
                miBuffer.flush();
                miBuffer.write(frase);
            }
            escritura.close();

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}


