package Java.CursoJava.Bloque_3;

public class Casting_Y_MetodoFinal {
    public static void main(String[] args) {
        
        /*
         * Si quieres castear un objeto a otro, para poder tener los metodos de la 
         * otra clase 
         */

        //Casteamos un objeto de tipo Perro a tipo Animal
        Animal num1 = new Animal("Pajarraco", 1);
        Perro pol = new Perro("Pol", 7);
        //convertimos a pol que es un perro a tipo Animal
        pol = (Perro) num1;
        pol.calculaEdad(pol.getEdad());
        
        /*
         * Cuando declaramos una clase como final (la clase perro) estamos 
         * consiguiendo que ninguna clase mas pueda heredar de ella seria la 
         * ultima clase que hay es decir el final de la herencia.
         * 
         * Para los metodos final es parecido, las sublcases no podran usar ese nombre 
         * para ninguno de sus metodos 
         */

    }
}

//Clase padre 
class Animal{

    private String nombre; 
    private int edad;
    
    public Animal(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    //Get y Set
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }

    public int calculaEdad(int edad){
        return edad+7; 
    }
}

//Clase hija
final class Perro extends Animal{

    private String raza;

    public Perro(String nombre, int edad){
        super(nombre, edad);
    }

    public String getRaza(){
        return raza;
    }

    public void setRaza(String raza){
        this.raza=raza;
    }
}
