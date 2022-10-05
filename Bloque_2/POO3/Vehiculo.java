package Java.CursoJava.Bloque_2.POO3;

public class Vehiculo {
    //Atributos comunes a todos los vehiculos 
    private int ruedas; 
    private int motor;
    private String matricula; 
    private int peso; 
    private int nPuertas;

    public Vehiculo(int ruedas, int motor, String matricula, int peso, int nPuertas){
        this.ruedas=ruedas;
        this.motor=motor;
        this.matricula=matricula;
        this.peso=peso; 
        this.nPuertas=nPuertas; 
    }

    //Constructor de super calse
    public Vehiculo(){

    }
    
    //Get y Set
    public int getRuedas(){
        return ruedas;
    }

    public void setRuedas(int ruedas){
        this.ruedas=ruedas;
    }

    public int getMotor(){
        return motor;
    }

    public void setMotor(int motor){
        this.motor=motor;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public int getPeso(){
        return peso;
    }

    public void setPeso(int peso){
        this.peso=peso;
    }

    public int getNPuertas(){
        return nPuertas;
    }

    public void setNpuertas(int nPuertas){
        this.nPuertas=nPuertas;
    }

    //Funciones y metodos de clase 
    public void repostar(){
        try {
            System.out.println("Repostando...");
            Thread.sleep(3*1000);
            System.out.println("Repostaje finalizado vuelva cuando quiera.");
        } catch (Exception e) {System.out.println(e);}
    }

    @Override
    public String toString(){
        return ruedas+" "+motor+" "+matricula+" "+peso+" "+nPuertas;
    }

}
