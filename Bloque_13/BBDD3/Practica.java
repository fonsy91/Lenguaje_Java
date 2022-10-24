package Java.CursoJava.Bloque_13.BBDD3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Practica {
    public static void main(String[] args) {
        
        JFrame mimarco=new Marco_Aplicacion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

    }
}


class Marco_Aplicacion extends JFrame{

	private Connection miConexion;
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;
	//Variable para almacenar la consulta parametrizada 
	private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
	//private JComboBox secciones;
	//private JComboBox paises;
	private JComboBox<String> secciones;
	private JComboBox<String> paises;
	private JTextArea resultado;	

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
		//Hacemos que nuestro boton ejecute la funcion ejecutaConsulta al pulsarlo
		botonConsulta.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutaConsulta();
				
			}
			
		});

		//Se añade el boton justo debajo de la ventana 
		add(botonConsulta, BorderLayout.SOUTH);
		

        //----------------------CONEXION BBDD--------------------------
        try {
            //Creamos la conexion con la base de datos, se hara uso de la clase DriverManager 
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "Am618294215");
            //Creamos un objeto Statement 
            Statement sentencia = miConexion.createStatement();
            //-----------CARGA JCOMBOX SECCIONES-----------------------------
            String consulta = "SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
            ResultSet rs = sentencia.executeQuery(consulta);
            while (rs.next()) {
                secciones.addItem(rs.getString(1));
            }
            rs.close();

            //-----------CARGA JCOMBOX SECCIONES-----------------------------
            consulta = "SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
            rs = sentencia.executeQuery(consulta);
            while (rs.next()) {
                paises.addItem(rs.getString(1));
            }
            rs.close();

        } catch (Exception e) {
            System.out.println("No se ha podido realizar la conexion"+e.getMessage());
        }

	}//Fin del constructor 
		
	//Metodo que realizara el evento al apretar el boton 
	private void ejecutaConsulta(){
		ResultSet rs = null;
		try {
			resultado.setText("");
			String seccion = (String)secciones.getSelectedItem();
			String pais = (String)paises.getSelectedItem();
			//Si selecciona una seccion y ningun pais 
			if (!seccion.equals("Todos") && pais.equals("Todos")) {
				enviaConsultaSeccion=miConexion.prepareStatement(consultaSeccion);
				//Solo hay una ? y a esa interrogacion le pasamos seccion
				enviaConsultaSeccion.setString(1, seccion);
				rs=enviaConsultaSeccion.executeQuery();
			}
			else if(seccion.equals("Todos") && !pais.equals("Todos")){
				enviaConsultaPais=miConexion.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1, pais);
				rs=enviaConsultaPais.executeQuery();
			}
			else if(!seccion.equals("Todos") && !pais.equals("Todos")){
				enviaConsultaTodos=miConexion.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs=enviaConsultaTodos.executeQuery();
			}
			
			//Recorremos lo que nos devuelve 
			while (rs.next()) {
				resultado.append(rs.getString(1));
				resultado.append(", ");
				//resultado que corresponde a la seccion 
				resultado.append(rs.getString(2));
				resultado.append(", ");
				resultado.append(rs.getString(3));
				resultado.append(", ");
				resultado.append(rs.getString(4));
				resultado.append("\n");
			}

		} catch (Exception e) {
			System.out.println("No se puede realizar la consulta "+e.getMessage());
		}
		
	}

}