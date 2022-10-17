package Java.CursoJava.Bloque_11.Colecciones4;

import java.util.HashMap;
import java.util.Map;

public class Mapas {
    public static void main(String[] args) {
        
        //Estructuras de clave-valor 
        HashMap<String,Empleado> personal = new HashMap<String,Empleado>();
        personal.put("145", new Empleado("Juan"));
        personal.put("146", new Empleado("Julia"));
        personal.put("147", new Empleado("Raul"));
        personal.put("148", new Empleado("Santi"));

        System.out.println(personal);
        //Eliminamos a partir de la clave 
        personal.remove("147");
        //EntrySet nos devuelve un set lista con lo que contiene el hasMap 
        System.out.println(personal.entrySet());
        //Va guardando en entrada la pareja de clave valor que da entrySet
        for(Map.Entry<String,Empleado> entrada: personal.entrySet()) {
            String clave= entrada.getKey();
            Empleado valor = entrada.getValue();
            System.out.println("Clave= "+clave+", Valor= "+valor);
        }

    }
}


class Empleado{
    private String nombre;
    private double sueldo; 

    public Empleado(String n){
        nombre=n;
        sueldo=2000; 
    }

    public String toString(){
        return "[Nombre="+nombre+", sueldo="+sueldo+"]";
    }
}