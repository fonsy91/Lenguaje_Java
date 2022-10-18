package Java.CursoJava.Bloque_12.Socket1;

import javax.swing.*;
import java.awt.event.*;
//import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        
        /*
         * Los Sockets se usan para hacer programas cliente-servidor
         * para transmitir informacion desde un ordenador cliente a un ordenador 
         * servidor para ello es necesario tener una aplicacion cliente y otra servidor.
         * Es necesario saber la direccion del servidor(ip, dominio) y un puerto de recepcion  
         * Tambien es necesario un OutputStream(cliente) y un InputStream(servidor)
         * 
         * Para este chat es necesario antes de terminar crear un JAR ejecutable tanto de 
         * cliente como de servidor mi ordenador personal hara de servidor y dos maquinas 
         * virtuales diferentes haran de clientes para ello se crean dos JAR ejecutables y 
         * se ejecutan en las maquinas clientes
         */

        MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

    }
}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		setBounds(600,300,280,350);		
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		add(milamina);
		setVisible(true);
	}	
}


class LaminaMarcoCliente extends JPanel implements Runnable{

    private JTextField campo1,nick,ip;
	private JButton miboton;
    private JTextArea campochat;

	public LaminaMarcoCliente(){
        nick=new JTextField(7);
        add(nick);
		JLabel texto=new JLabel("-CHAT-");
		add(texto);
        ip=new JTextField(8);
        add(ip);
        campochat = new JTextArea(12,20);
        add(campochat);
		campo1=new JTextField(20);
		add(campo1);		
		miboton=new JButton("Enviar");
        //Agregamos el evento del boton 
        EnviaTexto mievento = new EnviaTexto();
        miboton.addActionListener(mievento);
		add(miboton);	
        //Hilo
        Thread miHilo = new Thread(this);
        miHilo.start();
	}

    //Clase interna 
    private class EnviaTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("Hola funciona");
            //System.out.println(campo1.getText());
            campochat.append("\n"+campo1.getText());

            try {
                try (
                    //Creacion del Socket 
                    Socket misocket = new Socket("ip_ordenador_cliente", 9999)) {
                    //Se crea un flujo de datos de salida que circula o fluye por el socket creado
                    //Estas instrucciones no serviran al ir mejorando el chat 
                    //DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                    //Obtenemos el valor del campo de texto y escribimos por el flujo 
                    //flujo_salida.writeUTF(campo1.getText());
                    //Cerramos el flujo de salida 
                    //flujo_salida.close();

                    PaqueteEnvio datos = new PaqueteEnvio();    
                    datos.setNick(nick.getText());
                    datos.setIp(ip.getText());
                    datos.setMensaje(campo1.getText());
                    //Como ahora vamos a enviar un objeto usaremos ObjetOutPutStrem 
                    ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
                    paquete_datos.writeObject(datos);
                    misocket.close();
                }

            } catch (UnknownHostException e1) {e1.printStackTrace();
            } catch (IOException e1) {System.out.println(e1.getMessage());}
            
        }

    }

    @Override
    public void run() {
        try {
            try (ServerSocket servidor_cliente = new ServerSocket(9090)) {
                Socket cliente; 
                PaqueteEnvio paqueteRecibido;
                while (true) {
                    cliente=servidor_cliente.accept();
                    ObjectInputStream flujoEntarada = new ObjectInputStream(cliente.getInputStream());
                    paqueteRecibido=(PaqueteEnvio) flujoEntarada.readObject(); 
                    campochat.append("\n"+paqueteRecibido.getNick()+": "+paqueteRecibido.getMensaje());               
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

}

//Clase que envia el conjunto de datos necesarios al servidor 
//para recibirlo un cliente.Serializaremos esta clase para que pueda 
//ser convertida en bytes y poder enviarse 
class PaqueteEnvio implements Serializable{
    private String nick,ip,mensaje;



    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}