package Java.CursoJava.Bloque_10.Hilos2;

public class Sincronizacion {
    public static void main(String[] args) {
        
        /*
         * Estados de un Hilo
         * 1. Nuevo: Recien creado no hemos llamado al metodo start()
         * 2. Ejecutable: cuando hemos llamado al start()
         * 3. Bloqueado: cuando se ha detenido como por ejemplo llamar a un sleep()
         * 4. muerto: ha terminado la tarea o cuando hay una excepcion 
         * 
         * Para utilizar hilos hemos implementado una clase de Runnable tambien se puede 
         * hacer al heredar de Thread 
         * 
         * Muchas veces queremos que no empieze un hilo hasta que no haya acabado el otro o los demas 
         * para ello usamos la sincronizacion un metodo seria join() es una manera sencilla de hacerlo y 
         * tienes que especificarlo con codigo y try catch hay maneras mas avanzadas de hacerlo 
         */

        HilosVarios hilo1 = new HilosVarios();
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);

        hilo2.start();
        hilo1.start();

        /*
         *La funcion run() de HilosVarios2 espera a que el hilo1 acabe en este ejemplo 
         el sistem.out de Tareas terminadas seguramente salga el primero ya que el hilo 
         main queda liberado   
         */
        
        System.out.println("Tareas terminadas");
    }
}


class HilosVarios extends Thread{
    public void run(){
        //getName nos dice que hilo es el que esta ejecutando 
        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo"+getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HilosVarios2 extends Thread{

    private Thread hilo; 

    public HilosVarios2(Thread hilo){
        this.hilo=hilo;
    }

    public void run(){
        //Indicamos que esta tarea no empieze hasta que el hilo que le hemos 
        //pasado como parametro al constructor no haya terminado su tarea
        try {
            hilo.join();
        } catch (InterruptedException e1) {e1.printStackTrace();}

        //getName nos dice que hilo es el que esta ejecutando 
        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo"+getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}