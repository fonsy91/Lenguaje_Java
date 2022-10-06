package Java.CursoJava.Bloque_3;

public class TiposEnumerados {
    //Declaracion de tipo enumerado 
    enum Talla {MINI,MEDIANA,GRANDE,MUY_GRANDE};

    public static void main(String[] args) {
        
        /*
        * Es como un array de variables  
        * con esto puedes declarar y definir tus propios tipos de datos.
        * 
        * Algunos metodos importantes son: values(), ordinal(), valueOf()
        * values(): devuelve todos los valores presentes dentro de un enum
        * ordinal(): se encuentra cada indice de la constante enum
        * valueOf(): devuelve la constante enum del valor de cadena especificado
        */

        //Talla s = Talla.MINI;
        //Talla m = Talla.MEDIANA;
        //Talla l = Talla.GRANDE;
        //Talla xl = Talla.MUY_GRANDE;

        //Almacenamos todos los valores
        Talla arr[] = Talla.values();

        //Recorremos 
        for (Talla talla : arr) {
            System.out.println(talla+" en el indice "+talla.ordinal());
        }
        //Nos devuelve el nombre con el que hayamos buscado si existe 
        System.out.println(Talla.valueOf("MINI"));

    }
}
