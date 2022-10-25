package Java.CursoJava.Bloque_14.Controlador;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import Java.CursoJava.Bloque_14.Modelo.EjecutaConsultas;
import Java.CursoJava.Bloque_14.Vista.Marco_Aplicacion;

public class ControladorBotonEjecuta implements ActionListener{
    private Marco_Aplicacion elmarco; 
    private ResultSet resultadoConsulta;
    EjecutaConsultas obj = new EjecutaConsultas();
    public ControladorBotonEjecuta(Marco_Aplicacion elmarco){
        this.elmarco=elmarco;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String seleccionSeccion=(String)elmarco.secciones.getSelectedItem();
        String seleccionPais=(String)elmarco.paises.getSelectedItem();
        resultadoConsulta =  obj.filtraBBDD(seleccionSeccion, seleccionPais);
        try {
            //Para que se borren los resultados que habia y se agregen los nuevos 
            elmarco.resultado.setText("");
            while (resultadoConsulta.next()) {
                elmarco.resultado.append(resultadoConsulta.getString(1));
                elmarco.resultado.append(", ");
                elmarco.resultado.append(resultadoConsulta.getString(2));
                elmarco.resultado.append(", ");
                 elmarco.resultado.append(resultadoConsulta.getString(3));
                elmarco.resultado.append(", ");
                elmarco.resultado.append(resultadoConsulta.getString(4));
                elmarco.resultado.append("\n");
            }
        } catch (SQLException e1) {e1.printStackTrace();}

    }

    

}
