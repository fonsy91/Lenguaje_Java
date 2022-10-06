package Java.CursoJava.Bloque_2.POO3;

public class Moto extends Vehiculo{
    //atributos solo de motos 
    private int cilindrada; 
    private boolean cajon; 

    //Sirve para llamar al constructor de la clase padre 


    public Moto(int cilindrada, boolean cajon){
        this.cilindrada=cilindrada;
        this.cajon=cajon;
    }

    //Get y Set
    public int getCilindrada(){
        return cilindrada;
    }

    public void setCilindrada(int cilindrada){
        this.cilindrada=cilindrada;
    }

    public boolean getCajon(){
        return cajon;
    }

    public void setCajon(Boolean cajon){
        this.cajon=cajon;
    }

    //Funciones y metodos de clase *************************
    public void abrirCajon(boolean boton){
        if (boton == true) {
            System.out.println("Abriendo cajon");
        }
    }

    @Override
    public String toString(){
        return "Moto: "+cilindrada+" "+cajon;
    }


}
