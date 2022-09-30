package Java.CursoJava.Bloque_2.POO1;

public class Principal {
    public static void main(String[] args) {
         
        //Instanciamos de la clase Coche 
        Coche Renault = new Coche(4,200,100,"Rojo");
        Renault.muestra();
        //LLamamos al metodo estatico desde la clase sin necesidad de instanciar ningun objeto 
        for (int i = 0; i < 3; i++) {
            System.out.println("El numero de bastidor es: "+Coche.dameBastidor());
        }
       
        


    }
}
