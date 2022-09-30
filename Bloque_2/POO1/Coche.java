package Java.CursoJava.Bloque_2.POO1;

public class Coche {
    //Constantes de la clase 
    final String matricula = "";
    //atributos de la clase
    private int ruedas;
    private int largo;
    private int ancho;
    private String color; 
    //variable estatica 
    private static int nBastidor=0; 
 
    //constructor de la clase 
    public Coche(int ruedas, int largo, int ancho, String color){
        this.ruedas=ruedas;
        this.largo=largo;
        this.ancho=ancho;
        this.color=color;
        
    }

    //Gtters and Setter *****************
    public int getRuedas(){
        return ruedas;
    }

    public void setRuedas(int ruedas){
        this.ruedas=ruedas;
    }

    public int getLargo(){
        return largo;
    }

    public void setLargo(int largo){
        this.largo=largo;
    }

    public int getAncho(){
        return ancho;
    }

    public void setAncho(int ancho){
        this.ancho=ancho;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color=color;
    }

    //Funciones y metodos de la clase******** 
    public void muestra(){
        System.out.println("** Coche ** \nRuedas: "+ruedas+" \nLargo: "+largo+" \nAncho: "+ancho+" \nColor: "+color);
    }

    //Metodo static 
    public static int dameBastidor(){
        return nBastidor++;
    }

}

/*
 * Encapsulacion: proteger los datos de una clase para que no sean alterables 
 * desde otras para ello se privatizan los atributos con la palabra private, con 
 * esto los valores de las variables solo podran ser cambiados desde la propia clase.
 * 
 * Solo podras acceder a los valores de estos atributos atraves de los metodos getter and setter 
 * 
 * Las variables finales (final) se usan para declarar constantes y es decir para valores que no cambian en todo el programa 
 * 
 * Las variables y métodos estáticos en Java sirven para que puedan ser accedidos desde cualquier parte del código 
 * (inclusive desde otras clases) sin tener que crear un objeto. Un ejemplo muy común en donde se puede utilizar 
 * variables estáticas es cuando se necesita definir una configuración global en un proyecto
 * 
 */