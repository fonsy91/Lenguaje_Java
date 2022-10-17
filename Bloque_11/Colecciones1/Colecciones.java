package Java.CursoJava.Bloque_11.Colecciones1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Colecciones {
    public static void main(String[] args) {
        
        /*
         * Colleciones: son almacenes de objetos dinamicos la diferencia con los arrays 
         * es que es dinamico es decir que puede crecer o menguar tras la ejecucion de un
         * programa, pueden ir previstas de ordenamiento y se pueden insertar(no primitivos) 
         * o eliminar elementos
         * 
         * Collection: Set->SortedSet, List, Queue, Map,->SortedMap
         * 1. Set: Permite almacenar una coleccion de elementos no repetidos y sin ordenar 
         * 2. List: Coleccion de elementos que pueden estar repetidos e indexados con valores numericos 
         * 3. Colas: solo se pueden acceder a elementos que esten a la cola o al final 
         * 4. Map: colelcion de elemntos repetibles indexados por clave unica arbitraria se identifica por clave
         * 
         * 
         * 2. Listas (List): ArrayList, LinkedList, Vector, CopyOnWriteArrayList
         *    -Ventajas: acceso aleatorio, estan ordenadas, añadir/eliminar
         * 
         * 1. Set: HashSet, LinkedHasSet, TreeSet, EnumSet, CopyOnWriteArraySet, ConcurrentSkipListSet
         *    -Ventajas: no permite elementos duplicados, uso sencillode metodo add.
         * 
         * 
         * Ejemplo de Banco con clientes: 
         * 1.Clase que construya clientes (Nombre,Nº de cuenta, saldo)
         * 2.Crear collecion para almacenar clientes 
         * 3.Recorrer coleccion 
         * 
         * Metodos vitales para trabajar con colecciones equals() y hashCode(): con ellos puedes comparar objetos 
         * y recibir o saber el numero de hasCode que tiene cada objeto, este numero es equivalente al numero 
         * de bastidor de un coche el cual lo hace unico 
         * 
         */

        Cliente cl1 = new Cliente("Juan", "00001", 5000);
        Cliente cl2 = new Cliente("Julia", "00002", 7000);
        Cliente cl3 = new Cliente("Raul", "00003", 9000);
        Cliente cl4 = new Cliente("Susana", "00004", 1200);

        //Coleccion Set debido a que los usuarios no deben repetirse, la clase HashSet no permite ordenamientos  
        Set <Cliente> clientesBanco = new HashSet<Cliente>();
        //Agregamos los clientes 
        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);
        //Recorremos la collecion 
        for (Cliente cliente : clientesBanco) {
            System.out.println(cliente.getNombre()+" "+cliente.getN_cuenta()+" "+cliente.getSaldo()); 
        }
        
        //Comparamos objetos de tipo cliente con los metodos equasl y hashCode 
        if (cl1.equals(cl2)) {
            System.out.println("Es el mismo libro");
            //Obtenemos su hascode 
            System.out.println(cl1.hashCode());
            System.out.println(cl2.hashCode());
        }
        else{
            System.out.println("No el mismo libro");
            //Obtenemos su hascode 
            System.out.println(cl1.hashCode());
            System.out.println(cl2.hashCode());
        }

        /*
         * Iteradores: hace uso de la interfaz iterator<E> construye un objeto 
         * iterador proporciona tres metodos: next(), hasnext(), remove()
         * Vamos a recorrer en vez de con foreach sino con iterator es mas sencillo hacerlo con foreach 
         */

        //Creamos un iterador 
         Iterator <Cliente> it = clientesBanco.iterator();
        //Mientras haya objetos recorremos 
        while (it.hasNext()) {
            //Almacenamos el nombre del cliente 
            String nombre_cliente = it.next().getNombre();
            System.out.println(nombre_cliente);
            //Eliminamos el cliente 
            if (nombre_cliente.equals("Susana")) {
                it.remove();
            }

        }


    }
}


class Cliente{
    private String nombre; 
    private String n_cuenta;
    private double saldo;

    public Cliente(String nombre, String n_cuenta, double saldo){
        this.nombre=nombre;
        this.n_cuenta=n_cuenta;
        this.saldo=saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getN_cuenta() {
        return n_cuenta;
    }

    public void setN_cuenta(String n_cuenta) {
        this.n_cuenta = n_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Generacion de metodos 

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((n_cuenta == null) ? 0 : n_cuenta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (n_cuenta == null) {
            if (other.n_cuenta != null)
                return false;
        } else if (!n_cuenta.equals(other.n_cuenta))
            return false;
        return true;
    }


}
