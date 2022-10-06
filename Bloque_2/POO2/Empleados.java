package Java.CursoJava.Bloque_2.POO2;

import java.util.Date;
import java.util.GregorianCalendar;

//Clase principal 
public class Empleados {
    public static void main(String[] args) {
     
        /*
         * Se puede usar un objeto de la subclase cuando el programa espere un objeto 
         * de la subclase es una de las opciones del polimorfismo, en este caso el array 
         * esperaba objetos de la clase Empleado y le hemos agregado un objeto de tipo 
         * Jefatura (jefe_RRHH).
         * 
         * TIPOS DE POLIMORFISMO
         * Sobrecarga: El más conocido y se aplica cuando existen funciones con el mismo nombre en clases que son completamente independientes una de la otra.
         * Paramétrico: Existen funciones con el mismo nombre pero se usan diferentes parámetros (nombre o tipo). Se selecciona el método dependiendo del tipo de datos que se envíe.
         * Inclusión: Es cuando se puede llamar a un método sin tener que conocer su tipo, así no se toma en cuenta los detalles de las clases especializadas, utilizando una interfaz común.  
         */

        Jefatura jefe_RRHH = new Jefatura("Pedro", 2000, 1994, 5, 15);
        jefe_RRHH.estableceIncentivo(1000);

        /*
        Sobrecarga de constructores: es cuando en una clase hay mas de un constructor 
        esto se hace para construir objetos de diferentes maneras 
        */   
        Empleado misEmpleados[] = new Empleado[4];

        //Inserccion, instanciaccion e creacion de objetos de tipo empleado con constructor 1
        misEmpleados[0] = new Empleado("Juan", 18000, 1991, 3, 12);
        misEmpleados[1] = new Empleado("Julia", 18000, 1992, 4, 13);
        misEmpleados[2] = new Empleado("Paco", 18000, 1993, 4, 14);
        misEmpleados[3] = jefe_RRHH; 


        //Recorremos el array y aplicamos funcion sube sueldo 
        for (Empleado e : misEmpleados) {
            e.subeSueldo(5);
        }

        
        /*En este caso se llama al metodo dameSueldo como sabe java a que metodo dameSueldo debe llamar si hay dos metodos 
         * con el mismo nombre en las clases Empleado y Jefatura?? lo sabe con el enlazado dinamico que es capaz de saber 
         * a que metodo tiene que llamar.
         */
        //Mostramos array 
        for (Empleado e : misEmpleados) {
            System.out.println("Nombre: "+e.dameNombre()+" Sueldo: "+e.dameSueldo()+" Fecha Alta: "+e.dameFechaContrato());
        }

        //instanciaccion e creacion de objetos de tipo empleado con constructor 2
        Empleado emple1 = new Empleado("Laura");
        emple1.muestra();



    }
}

//Normalemente las clases y la clase principal deben estar separadas en diferentes archivos 
//pero para este ejemplo lo haremos todo en una 

class Empleado{
    private String nombre;
    private double sueldo;
    private Date altaContrato; 

    //Constructor 1
    public Empleado(String nom, double sue, int agno, int mes, int dia){
        nombre=nom;
        sueldo=sue;
        GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
        altaContrato=calendario.getTime();
    }

    //Constructor 2
    public Empleado(String nom){
        nombre=nom;

    }

    public String dameNombre(){
        return nombre;
    }

    public double dameSueldo(){
        return sueldo;
    }

    public Date dameFechaContrato(){
        return altaContrato;
    }

    public void subeSueldo(double porcentaje){
        double aumento = sueldo*porcentaje/100;
        sueldo+=aumento; 
    }

    public void muestra(){
        System.out.println("El empleado es: "+nombre);
    }
}


class Jefatura extends Empleado{
    private double incentivo; 
    //Constructor
    public Jefatura(String nom, double sue, int agno, int mes, int dia){
        super(nom, sue, agno, mes, dia);
    }

    public void estableceIncentivo(double b){
        incentivo=b;
    }

    public double dameSueldo(){
        double sueldoJefe=super.dameSueldo();
        return sueldoJefe+incentivo;
    }

}