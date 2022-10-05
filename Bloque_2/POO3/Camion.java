package Java.CursoJava.Bloque_2.POO3;

public class Camion extends Vehiculo{
    //atributos solo de camiones 
    private int nEjes; 
    private int pesoTransporte;
    private String tipoCarga; 

    //Sirve para llamar al constuctor de la clase padre 
    
    public Camion(int nEjes, int pesoTransporte, String tipoCarga){
        this.nEjes=nEjes;
        this.pesoTransporte=pesoTransporte;
        this.tipoCarga=tipoCarga;
    }



    //Get y Set
    public int getNEjes(){
        return nEjes;
    }

    public void setNEjes(int nEjes){
        this.nEjes=nEjes;
    }

    public int getPesoTransporte(){
        return pesoTransporte;
    }

    public void setPesoTransporte(int pesoTransporte){
        this.pesoTransporte=pesoTransporte;
    }

    public String getTipoCarga(){
        return tipoCarga;
    }

    public void setTipoCarga(String tipoCarga){
        this.tipoCarga=tipoCarga;
    }

    //Funciones y metodos de clase *************************
    public void descargar(boolean boton){
        if (boton == true) {
            System.out.println("Descargando carga");    
        }
        
    }

    public void mostrar(){
        System.out.println("Datos: \n"+" NEjes: "+nEjes+"\n Peso: "+pesoTransporte+" \n TCaraga: "+tipoCarga);
    }

    @Override
    public String toString(){
        return "Camion: "+nEjes+" "+pesoTransporte+" "+tipoCarga;
    }

}
