package Java.CursoJava.Bloque_12.Socket1;

import javax.swing.*;
import java.awt.*;
//import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        
        MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //En el servidor hacemos que se ponga a la escucha y abra el puerto 
        //correspondiente eso equivale a dos tareas por ello usaremos hilos 

    }
}

class MarcoServidor extends JFrame implements Runnable{
	
    private	JTextArea areatexto;

	public MarcoServidor(){
		setBounds(1200,300,280,350);							
		JPanel milamina= new JPanel();		
		milamina.setLayout(new BorderLayout());	
		areatexto=new JTextArea();		
		milamina.add(areatexto,BorderLayout.CENTER);		
		add(milamina);		
		setVisible(true);		
        //Creacion del hilo que estara a la escucha 
        Thread miHilo = new Thread(this);
        miHilo.start();
	}	
	
    @Override
    public void run(){
        //System.out.println("Estoy a la escucha");
        try {
            try (//Ponemos el servidor a la escucha 
            ServerSocket servidor = new ServerSocket(9999)) {
                //Variables para almacenar lo que envia el cliente por la red 
                String nick,ip,mensaje;
                //Variable de tipo objeto serializado clase creada en cliente 
                PaqueteEnvio paquete_recibido;
                while (true) {
                    //Le decimos que acepte cualquier conexion que venga del exterior 
                    Socket miSocket = servidor.accept();
                    ObjectInputStream paquete_Datos = new ObjectInputStream(miSocket.getInputStream());
                    //casteamos el objeto paquete_Datos a paquete recibido serializado enviado por el flujo 
                    paquete_recibido = (PaqueteEnvio) paquete_Datos.readObject();
                    nick=paquete_recibido.getNick();
                    ip=paquete_recibido.getIp();
                    mensaje=paquete_recibido.getMensaje();
                    //Agreagamos los datos 
                    areatexto.append("\n"+nick+": "+mensaje+" para "+ip); 

                    //Creacion de socket y envio de informacion a otro cliente 
                    Socket enviaDestinatario = new Socket(ip,9090);
                    ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                    paqueteReenvio.writeObject(paquete_recibido);
                    paqueteReenvio.close();
                    enviaDestinatario.close();
                    miSocket.close();
                    
                    //Creamos un flujo de entrada de datos 
                    //DataInputStream flujo_entrada = new DataInputStream(miSocket.getInputStream());
                    //String mensaje_texto = flujo_entrada.readUTF();
                    //Colocamos el mensaje recibido en el textArea
                    //areatexto.append("\n"+mensaje_texto);
                    //cerramos la conexion 
                    //miSocket.close();
                }
            } catch (ClassNotFoundException e) {e.printStackTrace();}
        } catch (IOException  e) {e.printStackTrace();}


    }
}