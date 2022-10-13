package Java.CursoJava.Bloque_9;

import java.util.*;

public class ArrayListIntro {
    public static void main(String[] args) {

        /*
        * El uso de array en java es un poco incomodo ya que es muy extricto con los tipos de datos
        * es decir si creas un aray de tipo empleados solo podras añadir empleados y a la hora de definir 
        * una array estamos obligados a expecificar el numero de elementos que va a tener. Por ello es mejor 
        * usar la clase ArrayList que permite crear listas dinamicas sin especificar la cantidad de elementos
        */
        
        /* 
        //Uso de array en java 
        Empleado listaEmpleados[] = new Empleado[3];
        listaEmpleados[0] = new Empleado("Ana", 45, 1800);
        listaEmpleados[1] = new Empleado("Juan", 46, 1700);
        listaEmpleados[2] = new Empleado("Pedro", 47, 2800);
        */

        ArrayList <Empleado> listaEmpleados = new ArrayList<Empleado>();
        listaEmpleados.add(new Empleado("Ana", 45, 1800));
        listaEmpleados.add(new Empleado("Juan", 46, 1700));

        //ArrayList con el constructor por defecto puede albergar hasta un maximo de 10 elementos 
        //aunque puedas meter todos los que quieras ya que al llegar al 11 hace una copia de los mismos 
        //por lo que se consumen muchos recursos se puede usar ensure capacity para evitar esto pasandole como 
        //parametro el numero de elementos que vaya ha haber 
        listaEmpleados.ensureCapacity(5);

        //Para borrar el exceso de memoria 
        listaEmpleados.trimToSize();

        //Metodo para insertar o reemplazar un elemeto set y obtener un elemento con get 
        listaEmpleados.set(1, new Empleado("Julieta", 45, 1800));
        System.out.println(listaEmpleados.get(0).dameDatos());
        
        //No podemos usar un foreach para recorrer un arrayList por que no tiene indices
        //for (Empleado e : listaEmpleados) {
        //    System.out.println(e.dameDatos());
        //}

        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado e = listaEmpleados.get(i);
            System.out.println(e.dameDatos());
        }

        //Iteradores funcion Iterator() nos permite acceder a los elementos de una colecion 
        Iterator <Empleado> mi_iterador = listaEmpleados.iterator();
        while (mi_iterador.hasNext()) {
            System.out.println(mi_iterador.next().dameDatos());
        }
    }
}

class Empleado{
    private String nombre;
    private int edad; 
    private double salario; 

    public Empleado(String nombre, int edad, double salario){
        this.nombre=nombre;
        this.edad=edad;
        this.salario=salario;
    }

    public String dameDatos(){
        return "El empleado se llama "+nombre+". Tiene "+edad+" años. "+"Y un salario de "+salario;
    }
}
