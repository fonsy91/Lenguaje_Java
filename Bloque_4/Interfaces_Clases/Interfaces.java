package Java.CursoJava.Bloque_4.Interfaces_Clases;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;

public class Interfaces {
    public static void main(String[] args) {
        
        /*
        * Una interfaz de Java es un mecanismo que tiene este lenguaje de programación para enunciar un 
        * conjunto de especificaciones y comportamiento que otras clases van a implementar.
        * Dentro de cada una de las interfaces de Java puedes encontrar constantes estáticas y métodos 
        * abstractos. Esto quiere decir que si revisas el código de la interfaz solo verás los nombres de los métodos 
        * muy parecido a los .h de C solo contiene constantes y metodos publicos o abstractos Es como una especie de 
        * plantilla que servirá de modelo para las clases que implementen los métodos.
        * Existen las interfaces porque en java no existe la herencia multiple es decir una clase solo puede heredar de 
        * una superclase no de varias con las interfaces en este caso las clases podran heredar metodos de varias interfaces 
        */

        //Haremos un ejemplo de la implementacion de una interfaz en java por defecto la interface Comparable

        Persona p1= new Persona ("pedro",20);
        Persona p2= new Persona ("juan",30);
        Persona p3= new Persona ("maria",40);
        Persona p4= new Persona ("gema",15);
    
        ArrayList<Persona> lista= new ArrayList<Persona>();
    
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
    
        Collections.sort(lista);

        for (Persona p :lista){
            System.out.println("Nombre: "+p.getNombre()+" Edad: "+p.getEdad());
            
        }

        /* 
        Persona personas[] = new Persona[2];
        personas[0] = new Persona("Juan", 20);
        personas[1] = new Persona("Pedro", 12);
        Arrays.sort(personas);
        */

        //Instanciacion de interfaces principio de sustitucion 
        Persona person = new Persona("Alfonso", 31);
        //Comparable ejemplo = new Persona("Julia", 31);
        //Si person pertenece a la clase persona o es una instancia entrara
        if (person instanceof Persona) {
            System.out.println("Es un objeto de tipo Persona");
        }

        //if (ejemplo instanceof Comparable) {
        //    System.out.println("Implementa la interfaz comparable");
        //}

        //CRECION DE NUESTRAS PROPIAS INTERFACES ***************************************
        Empleado empleJefe = new Empleado("Luis", 1700, 31);
        System.out.println(empleJefe.tomarDecision("Subele el sueldo a Alfonso"));


    }
}

class Persona implements Comparable<Persona>{
    private String nombre; 
    private int edad; 

    public Persona(String nombre, int edad){
        super();
        this.nombre = nombre;
        this.edad = edad;
    }

    //GET and SET
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Implementamos el metodo compareTo el cual esta definido en la interface Comparable
    //Descripcion del metodo: https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#compareTo-T-
    public int compareTo(Persona o){
        if (this.getEdad()>o.getEdad()) {
            return 1;
        }else if(this.getEdad()<o.getEdad()) {
            return -1;
        }else {
            return 0;
        }
    }
}

//Implementa la interface Interface que hemos creado 
class Empleado extends Persona implements Interface{
    private String nombre; 
    private float sueldo;

    public Empleado(String nombre, float sueldo, int edad){
        super(nombre, edad);
        this.nombre=nombre;
        this.sueldo=sueldo;
    }

    //GET and SET
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getSueldo() {
        return sueldo;
    }
    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    //Implementamos el metodo de la interface 
    public String tomarDecision(String decision){
        return "Un miembro de la direccion a tomado una decision: "+decision;
    }

}