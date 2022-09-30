package Java.CursoJava.Bloque_2.POO2;

import java.util.Date;
import java.util.GregorianCalendar;

public class Empleados {
    public static void main(String[] args) {
     
        /*
        Sobrecarga de constructores: es cuando en una clase hay mas de un constructor 
        esto se hace para construir objetos de diferentes maneras 
        */   
        Empleado misEmpleados[] = new Empleado[3];

        //Inserccion, instanciaccion e creacion de objetos de tipo empleado con constructor 1
        misEmpleados[0] = new Empleado("Juan", 18000, 1991, 3, 12);
        misEmpleados[1] = new Empleado("Julia", 18000, 1992, 4, 13);
        misEmpleados[2] = new Empleado("Paco", 18000, 1993, 4, 14);

        //Recorremos el array y aplicamos funcion sube sueldo 
        for (Empleado e : misEmpleados) {
            e.subeSueldo(5);
        }

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
