package Java.CursoJava.Bloque_10.Hilos1;

import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/*
* Haremos un programa grafico que creara una pelota al pulsar sobre dale y esta empezara a rebotar por las paredes 
* de la ventana cuando le demos al boton de salir se saldra de la aplicacion. 
*/

public class Hilos {
    public static void main(String[] args) {
        
        /*
        * Hasta ahora solo hemos visto programas monotarea solo se hace una tarea a la vez 
        * la multitarea permite hacer varias tareas a la vez con los hilos. Los pasos para crear 
        * hilos de ejecucion son los siguientes: 
        * 
        * 1. Crear clase que implemente a la interfaz runable(metodo run)
        * 2. Escribir el codigo de la tarea dentro del metodo run 
        * 3. Instanciar la clase creada y almacenar la instancia en variable de tipo runnable 
        * 4. Crear instancia de la clase Thread pasando como parametro al constructir de Thread el objeto Runnable anterior 
        * 5. Poner en marcha el hilo de ejecucion con el metodo start() de la clase Thread 
        */

        //Creamos el marco con Genearal
        JFrame marco=new MarcoRebote();
		//Para cerrar la aplciacion 
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Hacer que el marco sea visible 
		marco.setVisible(true);

		/*
		 * Tras la ejecucion de este programa vemos que al darle a dale! sale la pelota y rebota tantas 
		 * veces como le indica el for de la funcion comienza_el_juego cuando acaba lo vuelve ha hacer 
		 * una vez que la pelota esta rebotando no es posible salir de la aplicacion ni de sacar otra pelota a 
		 * rebotar debido a que es un programa monotarea, si fuese multitarea seria capaz de salir de la aplicacion 
		 * o de sacar mas de una pelota a rebotar
		 */

    }
}

//Clase que transfroma la aplicacion en Multitarea 
class PelotaHilos implements Runnable{
	private Pelota pelota;
	private Component componente;
	//Constructor 
	public PelotaHilos(Pelota unaPelota, Component unComponente){
		pelota=unaPelota;
		componente=unComponente;
	}
	//implementamos el metodo de la interfaz 
	//En este metodo implementamos todo el codigo que va a ser simultaneo a la tarea 
	public void run(){
		System.out.println("Estado del hilo al comenzar esta detenido?: "+Thread.currentThread().isInterrupted());
		//Este codigo la hara uno, dos o tres hilos cada uno por separado
		/* Con esto la pelota rebotaba 3000 veces antes e acabarse el hilo
		for (int i=1; i<=3000; i++){
            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());
            
            try {
                //Usamos sleep para poder ver con nuestros ojos como rebota 
                Thread.sleep(4);
            } catch (Exception e) {
                System.out.println("No se puede hacer sleep");
            }
        }
		*/

		//Con esto podemos hacer que la pelota rebote siempre 
		//En la condicion puede haber: !Thread.currentThread().isInterrupted() o !Thread.interrupted()
		while (!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());
			try {
                //Usamos sleep para poder ver con nuestros ojos como rebota 
                Thread.sleep(4);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
		}
		System.out.println("Estado del hilo al terminar esta detenido?: "+Thread.currentThread().isInterrupted());
	}
}


//Clase Pelota y su movimiento 
class Pelota{

	private static final int TAMX=15;
	private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
	
	//Sin constructor 
    //Mueve la pelota invirtiendo posicion si choca con limites
	public void mueve_pelota(Rectangle2D limites){
		x+=dx;
		y+=dy;
		
		if(x<limites.getMinX()){
			x=limites.getMinX();
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			x=limites.getMaxX() - TAMX;
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			y=limites.getMinY();
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			y=limites.getMaxY()-TAMY;
			dy=-dy;
		}
		
	}
	
	//Forma de la pelota en su posicion inicial
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}	

}//Final de la clase Pelota 


//Clase LaminaPelota que dibuja las pelotas 
class LaminaPelota extends JPanel{
    //ArrayList donde se almacenan las pelotas 
    private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();

    //Añadimos pelota a la lamina 
    public void add(Pelota b){
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
	}

 }//Final clase LaminaPelota 

//Clase MarcoRebote donde esta la lamina y botones 
class MarcoRebote extends JFrame{
    private LaminaPelota lamina;
	Thread t1,t2,t3;
	JButton arranca1,arranca2,arranca3,detener1,detener2,detener3;
    //Constructor que alberga la grafica 
    public MarcoRebote(){
		//Dimensiones de la ventana
		setBounds(600,300,600,350);
        //Titulo de ventana
		setTitle ("Rebotes");
        //Objeto de tipo lamina 
		lamina=new LaminaPelota();
        //Agregamos lamina a la ventana 
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones=new JPanel();

		//Inicializamos los diferentes botones para los hilos,sus detencciones y funcionalidades  
		arranca1 = new JButton("Hilo1");
		arranca1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca1);

		arranca2 = new JButton("Hilo2");
		arranca2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca2);

		arranca3 = new JButton("Hilo3");
		arranca3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca3);

		detener1 = new JButton("Detener1");
		detener1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				detener(evento);
			}
		});
		laminaBotones.add(detener1);

		detener2 = new JButton("Detener2");
		detener2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				detener(evento);
			}
		});
		laminaBotones.add(detener2);
       
		detener3 = new JButton("Detener3");
		detener3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				detener(evento);
			}
		});
		laminaBotones.add(detener3);

		//Agrega la lamina de botones a la ventana parte inferior 
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//Ponemos botones
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
		JButton boton=new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}
	
	//Agreaga pelota y la bota 1000 veces
	
	public void comienza_el_juego(ActionEvent e){
		
		//Crea una pelota 
		Pelota pelota=new Pelota();
        //Agrega pelota a la lamina->ventana
		lamina.add(pelota);
		/* 
        for (int i=1; i<=3000; i++){
            pelota.mueve_pelota(lamina.getBounds());
            lamina.paint(lamina.getGraphics());
            
            try {
                //Usamos sleep para poder ver con nuestros ojos como rebota 
                Thread.sleep(4);
            } catch (Exception e) {
                System.out.println("No se puede hacer sleep");
            }
        }
		*/

		//Creamos instancia de la clase de la interfaz runnable 
		Runnable r = new PelotaHilos(pelota, lamina);
		//Thread t = new Thread(r); declarado fuera para que sea visible 
		//t = new Thread(r);
		//El metodo start() llama inmediatamente al metodo run()
		//t.start();

		//Para mas de un hilo
		if (e.getSource().equals(arranca1)) {
			t1= new Thread(r);
			t1.start();
		}
		else if(e.getSource().equals(arranca2)){
			t2 =  new Thread(r);
			t2.start();
		}
		else if(e.getSource().equals(arranca3)){
			t3 = new Thread(r);
			t3.start();
		}

	}

	//Metodo que detiene un hilo 
	public void detener(ActionEvent e){
		//t.stop(); metodo obsoleto
		if (e.getSource().equals(detener1)) {
			t1.interrupt();
		}
		else if(e.getSource().equals(detener2)){
			t2.interrupt();
		}
		else if(e.getSource().equals(detener3)){
			t3.interrupt();
		}
	}

}//Final clase MarcoRebote























