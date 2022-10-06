package Java.CursoJava.Bloque_3;

public class Clases_Metodos_Abstract {
    public static void main(String[] args) {
        
        /*
        * La principal diferencia entre una clases convencional y una clase abstracta es que la 
        * clase abstracta debe poseer por lo menos un método abstracto. Ok, pero ahora, 
        * ¿ Qué es un método abstracto? Verás, un método abstracto no es más que un método vacío, 
        * un método el cual no posee cuerpo, por ende no puede realizar ninguna acción. Esto 
        * referencia mucho a los patrones de diseño este metodo vacio debe ser implementado en cada 
        * una de las subclases que heredan de esta.
        */

        Cuadrado c1 = new Cuadrado(4, 2);
        System.out.println("El area del cuadrado es: "+c1.area());

        /*
         * MODIFICADORES DE ACCESO 
         * Ejem: public es visible desde la propia clase, propio paquete subclase que hereda y includo 
         * desde otro paquete en otra clase
         * 
         *              CLASE   PACKAGE    SUCLASE    TODOS  
         * public:       si       si          si        si
         * protected:    si       si          si        no
         * private:      si       no          no        no     
         * por defecto:  si       si          no        no    
         */

    }   
}

//Clase Padre y abstracta
abstract class Figura{
    private int nLados; 

    public Figura(int nLados){
        this.nLados=nLados;
    }

    //Get y Set
    public int getnLados(){
        return nLados;
    }

    public void setNLados(int nLados){
        this.nLados=nLados;
    }

    /*
    * Dentro de la clase encontramos el método área, método que se encuentra pensado para obtener 
    * el área de cualquier figura, sin embargo cómo sabemos todas las figuras poseen su propia fórmula 
    * matemática para calcular su área. Si yo comienzo a heredar de la clase Figura todas las clases hijas 
    * tendrían que sobre escribir el método área e implementar su propia formula para así poder calcular su área. 
    * En estos casos, en los casos la clase hija siempre deba que sobreescribir el método lo que podemos hacer 
    * es convertir al método convencional en un método abstracto.
    */

    //Metodo abstracto el cual deberan implementar todos las clases quye hereden de esta clase 
    //Puede a ver uno o tantos como se quiera eso si se deberan implemntar en todas las clases
    public abstract float area();

}


class Cuadrado extends Figura{
    private int lado;       
    public Cuadrado(int nLados, int lado){
        super(nLados);
        this.lado=lado;
    }

    //Get and set

    //Implementacion de la clase abstracta declarada en la clase padre 
    public float area(){
        return lado*lado; 
    }

}

class Triangulo extends Figura{
    private int base; 
    private int altura;
    public Triangulo(int nLados, int base, int altura){
        super(nLados);
        this.base=base;
        this.altura=altura;
    }

    //Get and set

    //Implementacion de la clase abstracta declarada en la clase padre 
    public float area(){
        return (base*altura)/2; 
    }

}