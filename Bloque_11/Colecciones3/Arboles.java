package Java.CursoJava.Bloque_11.Colecciones3;

import java.util.Comparator;
import java.util.TreeSet;

public class Arboles {
    public static void main(String[] args) {
        
        TreeSet<String> ordenaPersonas = new TreeSet<String>();
        ordenaPersonas.add("Sandra");
        ordenaPersonas.add("Juan");
        ordenaPersonas.add("Susana");

        for (String s : ordenaPersonas) {
            System.out.println(s);
        }

        /*
         * Ahora le estamos pasando String pero permite objetos los 
         * los cuales pueden ser ordenados 
         */

        Articulo primero = new Articulo(1, "Primer articulo");
        Articulo segundo = new Articulo(2, "Segundo articulo");
        Articulo tercero = new Articulo(3, "Tercer articulo");

        TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(primero);
        ordenaArticulos.add(segundo);

        //Los articulos salen ordenados segun el metodo CompareTo ya que 
        //la clase implementa la interfaz Comparable
        for (Articulo articulo : ordenaArticulos) {
            System.out.println(articulo.getDescripcion());
        }

        //Comparacion de articulos por orden alfabetico 
        Articulo comparadorArticulos = new Articulo();
        TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparadorArticulos);
        ordenaArticulos2.add(primero);
        ordenaArticulos2.add(segundo);
        ordenaArticulos2.add(tercero);

        for (Articulo art : ordenaArticulos2) {
            System.out.println(art.getDescripcion());
        }

        //Para que la clase no necesite implementar la interfaz Comparator se puede 
        //hacer una clase interna 

    }
}


class Articulo implements Comparable<Articulo>, Comparator<Articulo>{

    private int numero_articulo;
    private String descripcion;

    //constructor1
    public Articulo(){

    }

    //constructor2 numero de articulo y desripcion
    public Articulo(int num, String desc){
        numero_articulo=num;
        descripcion=desc;
    }

    public String getDescripcion(){
        return descripcion;
    }

    //El metodo generado comprateTo comparara por numero de articulo
    @Override
    public int compareTo(Articulo o) {
        return numero_articulo - o.numero_articulo;
    }
    //Metodo generado Comparator compara por orden alfabetico
    @Override
    public int compare(Articulo o1, Articulo o2) {
        String descripcionA = o1.getDescripcion();
        String descripcionB = o2.getDescripcion();
        return descripcionA.compareTo(descripcionB);
    }

}