package Java.CursoJava.Bloque_14.Vista;

import javax.swing.*;

import Java.CursoJava.Bloque_14.Controlador.ControladorBotonEjecuta;
import Java.CursoJava.Bloque_14.Controlador.ControladorCargaMenus;

import java.awt.*;

public class Marco_Aplicacion extends JFrame{
    //Vista del patron de software 
    public JComboBox<String> secciones;
	public JComboBox<String> paises;
	public JTextArea resultado;	

    public Marco_Aplicacion(){
		setTitle ("Consulta BBDD");
		setBounds(500,300,400,400);
		setLayout(new BorderLayout());
		JPanel menus=new JPanel();
		menus.setLayout(new FlowLayout());
		//secciones=new JComboBox();
		secciones=new JComboBox<>();
		secciones.setEditable(false);
		secciones.addItem("Todos");
		paises=new JComboBox<>();
		paises.setEditable(false);
		paises.addItem("Todos");
		resultado= new JTextArea(4,50);
		resultado.setEditable(false);
		add(resultado);
		menus.add(secciones);
		menus.add(paises);	
		add(menus, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		JButton botonConsulta=new JButton("Consulta");	
        add(botonConsulta, BorderLayout.SOUTH);
		botonConsulta.addActionListener(new ControladorBotonEjecuta(this));
        //Para que este escuchando eventos en la ventana
        addWindowListener(new ControladorCargaMenus(this));
    }
}
