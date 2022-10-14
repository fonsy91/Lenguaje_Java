package Java.CursoJava.Bloque_10.Hilos3;

//Importes Usados para candados
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

public class AplicacionHilos {
    public static void main(String[] args) {
        
        /*
         * Porque es necesario sincronizar hilos en java? habra aplicaciones que no y otras 
         * que si lo vemos con un ejemplo. Creamos una aplicacion java en la que creamos un banco 
         * y vamos a abrir 100 cuentas corrientes y las va a cargar con un saldo inicial de 2000 con 
         * saldo total de cuentas de 200000 euros, tambien se podran hacer transferencias internas 
         * de la cuenta1 a la cuenta3 etc.. y estas transferencias internas las va ha hacer un hilo. El 
         * saldo total siempre seran 200000 euros. Y con un bucle infinito va a dedicarse a hacer transferencias
         * entre las cuentas de forma aleatoria. Nos daremos cuenta que despues de un rato ese saldo total habra 
         * bajado y nos daremos cuenta del error de no simncronizar los hilos    
         */

        Banco b = new Banco();
        //Realizamos las transferencias 
        for (int i = 0; i < 100; i++) {
            EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }

        /*
         * Si Ejecutamos este programa las cuentas no siempre tendran 200000 ya que los hilos se amontonan 
         * y interfieren unos con otros podriamos usar el metodo join para evitar esto pero se compilcaria 
         * mucho por ello existe otra clase que nos permite abordar estas compilaciones la clase ReentranLock
         * tiene los metodos lock y unlock para bloquear y desbloquer una porcion de codigo y solo pueda acceder 
         * un hilo mientras el resto se queda a la espera como en una especie de semaforo, usamos estos 
         * metodos en la parte de codigo de transferencia 
         */

         /*
          * Se puede dar el caso de que una cuenta haya hecho muchas transferencias pero no haya recibido 
          * ninguna aqui aparecen las condiciones de bloqueo, si nos damos cuenta cuando la cantidad es 
          * insuficiente el hilo se pierde. Una condicion en el bloqueo hace que el hilo se ponga a la espera 
          * en el caso de saldo insuficiente en vez de perderse esperara con el metodo await() y libera el codigo 
          * despues entra otro hilo y cuando termina avisa al resto que estaban esperando para ver si se pueden 
          * desbloquear, la diferencia con lo anterior es que todos los hilos tarde o temprano cumplen con su trabajo   
          */

          /*
           * Otra forma de hacer lo mismo que lo anterior de pero de una forma mas sencilla seria con Synchronized 
           * agregando en la declaracion de la funcion la palabra synchoronized y sobran los cierres lock y unlock 
           * tanto como los condicionales si es mejor asi porque existe lo otro? en este caso mas sencillo solo 
           * podemos usar una condicion, pero con los otro podemos agregar varias condiciones es decir mas await()
           * 
           */


    }
}

//Clase Banco crea 100 cuentas y les carga 2000 euros 
class Banco{
    private final double[] cuentas;
    //Creacion de candado para el bloqueo de los hilos y hacer sincronizacion
    //private Lock cierreBnaco = new ReentrantLock();
    //Creacion de una condicion de bloqueo 
    //private Condition saldoSuficiente; 

    public Banco(){
        cuentas= new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i]=2000;
        }
        //establecemos una condicion en cierreBanco llamada saldoSuficiente 
        //La creamos aqui en el constructor porque ada vez que hacemos un banco ya lleva la condicion 
        //saldoSuficiente=cierreBnaco.newCondition();
    }

    //Metodo para hacer las transferencias 
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
   
        while (cuentas[cuentaOrigen]<cantidad) {
            //saldoSuficiente.await();
            wait();
        }
        //Mostramos que hilo esta realizando la transferencia 
        System.out.println(Thread.currentThread());
        //descontamos la cantidad a la cuenta origen 
        cuentas[cuentaOrigen]-=cantidad;
        //Mostramos por pantalla la cuenta origen con solo dos decimales 
        System.out.printf("%10.2f de cuenta %d a cuenta %d",cantidad,cuentaOrigen,cuentaDestino);
        //Despues incrementamos el saldo de la cuenta destino 
        cuentas[cuentaDestino]+=cantidad;
        //Imprimimos el saldo total de las cuentas 
        System.out.printf(" Saldo total: %10.2f\n",getSaldoTotal());
        //Avisamos al resto de hilos que estan a la espera por el await() para ver si pueden cunmplir con lo que antes 
        //no podian y si es asi realizar su trabajo y sino que sigan a la espera  
        //saldoSuficiente.signalAll();
        notifyAll();


    }

    //Metodo para obtener el saldo total 
    public double getSaldoTotal(){
        double suma_cuentas=0;
        for (double a : cuentas) {
            suma_cuentas+=a;
        }
        return suma_cuentas;
    }

}//Final de la clase Banco 

//Clase que ejecuta las transferencias 
class EjecucionTransferencias implements Runnable{

    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;

    //Constructor Bnaco, cuentaOrigen, cantidad  
    public EjecucionTransferencias(Banco b, int de, double max){
        banco=b;
        deLaCuenta=de;
        cantidadMax=max;
    }

    @Override
    public void run() {
        //Este metodo run lo ejecutara cada hilo lo hara de forma infinita 
        //hasta que lo paremos por consola 
        try {
            while (true) {
                //La cuenta destino sera aleatoria 
                int paraLaCuenta = (int)(100*Math.random());
                //cantidad a transferir aleatoriamente 
                double cantidad=cantidadMax*Math.random();
                //Realizamos la transferencia 
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                //Para verlo de una forma lenta y visual de forma aleatoria 
                Thread.sleep((int)(Math.random()*10));
            }
        } catch (InterruptedException e) {}
        
    }

} 


//CODIGO MAS CLARO PARA LOCK Y UNLOCK ***************************
//Variables --------------------
//private Lock cierreBnaco = new ReentrantLock();
//Creacion de una condicion de bloqueo 
//private Condition saldoSuficiente; 
//En constructor -------------
//saldoSuficiente=cierreBnaco.newCondition();

//Metodo para hacer las transferencias 
// public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
//     //cerramos el candado y ponemos un try dentro del codigo que bloqueamos 
//     cierreBnaco.lock();
//     try {
//         /* 
//         //Para probar antes de las condiciones de bloqueo
//         //Para evitar mandar mas dinero del que tienes 
//         if (cuentas[cuentaOrigen]<cantidad) {
//             //en ese caso no hacemos nada 
//             System.out.println("----------CANTIDAD INSUFICIENTE: "+cuentaOrigen+" .....SALDO: "+cuentas[cuentaOrigen]+" ...."+cantidad);
//             return; 
//         }
//         else{
//             System.out.println("----------CANTIDAD OK: "+cuentaOrigen);
//         }
//         */
//         while (cuentas[cuentaOrigen]<cantidad) {
//             saldoSuficiente.await();
            
//         }
//         //Mostramos que hilo esta realizando la transferencia 
//         System.out.println(Thread.currentThread());
//         //descontamos la cantidad a la cuenta origen 
//         cuentas[cuentaOrigen]-=cantidad;
//         //Mostramos por pantalla la cuenta origen con solo dos decimales 
//         System.out.printf("%10.2f de cuenta %d a cuenta %d",cantidad,cuentaOrigen,cuentaDestino);
//         //Despues incrementamos el saldo de la cuenta destino 
//         cuentas[cuentaDestino]+=cantidad;
//         //Imprimimos el saldo total de las cuentas 
//         System.out.printf(" Saldo total: %10.2f\n",getSaldoTotal());
//         //Avisamos al resto de hilos que estan a la espera por el await() para ver si pueden cunmplir con lo que antes 
//         //no podian y si es asi realizar su trabajo y sino que sigan a la espera  
//         saldoSuficiente.signalAll();
       
//     } finally{
//         cierreBnaco.unlock();
//     }
