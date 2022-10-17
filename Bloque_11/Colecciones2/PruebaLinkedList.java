package Java.CursoJava.Bloque_11.Colecciones2;

import java.util.*;

public class PruebaLinkedList {
    public static void main(String[] args) {
        
        /*
         * LinkedList: como arrayList pero cada elemento o nodo esta 
         * unido por enlaces
         */

        LinkedList <String> personas = new LinkedList<String>();
        //Creamos un Iterador para LinkedList 
        ListIterator<String> it = personas.listIterator();
        //Agregamos personas 
        personas.add("Sandra");
        personas.add("Pepe");
        personas.add("Juan");
        System.out.println(personas.size());
        for (String persona : personas) {
            System.out.println(persona);
            System.out.println(it.hashCode()); 
        }

        //Ejmplo de capitales y paises 
        LinkedList<String> paises = new LinkedList<String>();
        paises.add("España");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Peru");
        LinkedList<String> capitales = new LinkedList<String>();
        capitales.add("Madrid");
        capitales.add("Bogota");
        capitales.add("DF");
        capitales.add("Lima");

        System.out.println(paises);
        System.out.println(capitales);

        //Agreagamos la linkedList de capitales a la de paises con un total de 8 elementos 
        ListIterator<String> iterA = paises.listIterator();
        ListIterator<String> iterB = capitales.listIterator();

        while (iterB.hasNext()) {
            if (iterA.hasNext()) {
                iterA.next();
            }
            iterA.add(iterB.next());
        }

        System.out.println(paises);

        //Eliminamos las posiciones pares 
        iterB=capitales.listIterator(); 
        while (iterB.hasNext()) {
            iterB.next();
            if (iterB.hasNext()) {
                iterB.next();
                iterB.remove();
            }
        }
    }
}
