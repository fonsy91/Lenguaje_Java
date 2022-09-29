package Java.CursoJava.Bloque_1;


public class Arrays{
    public static void main(String[] args) {
        
        int vector[] = new int[5];
        //vector inicializado
        //int vector2[] = {10,120,20,40,50};

        vector[0] = 5;
        vector[1] = 10;
        vector[2] = 15;
        vector[3] = 20;
        vector[4] = 25;

        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }

        //Bucle for-each puedes recorrer una lista sin necesidad de usar una variable contador 
        String paises[] = new String[5];

        paises[0] = "España";
        paises[1] = "Colombia";
        paises[2] = "Venezuela";
        paises[3] = "Peru";
        paises[4] = "Chile";

        for (String elemento : paises) {
            System.out.println(elemento);
        }

        //Matriz de numeros aleatorios 
        int aleatorios[] = new int[5];
        //Rellenamos 
        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i]=(int)Math.round(Math.random()*100);
        }
        //Recorremos y mostramos 
        for (int elem : aleatorios) {
            System.out.println(elem);
        }


    }
}
