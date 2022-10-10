package Java.CursoJava.Bloque_6;

//import javax.swing.*;

public class Excepciones {
    public static void main(String[] args) {

        /*
        * Java tiene toda una clase que sirve para manejar este tipo de situaciones, se trata Throwable, 
        * que a su vez tiene las subclases exception y error.
        * Java cuenta con excepciones predefinidas (IOException) que muestran a quien está programando que 
        * hay operaciones que no se están llevando a cabo de una manera correcta. Por otro lado, también se 
        * pueden crear excepciones para que el código se ejecute aún en caso de presentarse ciertos fallos.
        * 
        * Una excepción no verificada es una incidencia que se produce durante la ejecución del programa (runtime) 
        * que interrumpe el flujo de las instrucciones. Este tipo de excepciones pueden ser capturadas y manejadas 
        * para que el código se ejecute hasta el final. 
        * 
        */

        //Ejemplo de EXCEPCION no verificada 
        dividir(4, 0);

        
        
    }

    //Funcion de division entre cero (causa un error aritmetico) 
    public static int dividir(int A, int B){
        int resultado = 0; 
        try {
            resultado=A/B;
            System.out.println("El resultado es: "+resultado);
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre cero.");
        }
        return resultado;
    }

    /*
     * Otra manera es usando para ello la sentencia throws que señala la posibilidad de 
     * que se presenten una o varias excepciones y gestiona su manejo. 
     */

}
