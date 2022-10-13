package Java.CursoJava.Bloque_8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivosDirectorios {
    public static void main(String[] args) {
        
        /*
        * 
        */

        File archivo = new File("C:/Users/alfon/Desktop/Programacion/Java/CursoJava/Bloque_8/ejemplo_archivo");
        File ruta = new File("C:/Users/alfon/Desktop/Programacion/Java/CursoJava/Bloque_4");
        //Imprimimos la ruta absoluta del archivo que vamos a crear 
        System.out.println(archivo.getAbsolutePath());
        //Comprobamos si el fichero existe 
        System.out.println(archivo.exists());
        //Mostramos todos los archivos contenidos en un directorio 
        String[] nombres_archivos = ruta.list();
        //Recorremos el array y mostramos 
        for (int i = 0; i < nombres_archivos.length; i++) {
            System.out.println(nombres_archivos[i]);
            //Utilizamos otro constructor para saber si en el directorio hay mas directorios y mostrarlos tambien 
            File hijos = new File(ruta.getAbsolutePath(), nombres_archivos[i]);
            if (hijos.isDirectory()) {
                String[] archivos_subcarpeta = hijos.list();
                for (int j = 0; j < archivos_subcarpeta.length; j++) {
                    System.out.println(archivos_subcarpeta[j]);
                }
            }
        }

        //Creacion, escritura y manipulacion
        File ruta2 = new File("C:/Users/alfon/Desktop/Programacion/Java/CursoJava/Bloque_8/prueba_texto.txt");
        String archivo_destino = ruta2.getAbsolutePath();
        try {
            ruta2.createNewFile();
        } catch (IOException e) {
            System.out.println("No se ha podido crear el archivo");
        }

        Escribiendo accede_es = new Escribiendo();
        accede_es.escribir(archivo_destino);

        //Para eliminar un archivo indicamos la ruta del archivo y un delete
        ruta2.delete();

    }
}

//Clase que escribe en la ruta que se le pasa como parametro
class Escribiendo{
    public void escribir(String ruta_archivo){
        String frase = "Escribiendo en un archivo";
        try {
            FileWriter escritura = new FileWriter(ruta_archivo);
            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }
            escritura.close();
        } catch (Exception e) {
            System.out.println("No se puede escribir en el archivo");
        }
    }
}