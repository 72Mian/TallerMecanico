package org.iesalandalus.programacion.tallermecanico.vista.grafica.controladores;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.ficheros.Vehiculos;
import org.iesalandalus.programacion.tallermecanico.vista.eventos.Evento;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.utilidades.Controles;

public class InsertarVehiculo extends Controlador {
    @FXML
    private Button btCerrar;
    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfMatricula;

    @FXML
    private TextField tfModelo;
    @FXML
    void cerrar() {
        getEscenario().close();
    }
    @FXML
    void aceptar() {
        VistaGrafica.getInstancia().getGestorEventos().notificar(Evento.INSERTAR_VEHICULO);
        getEscenario().close();
        limpiar();
    }
    public Vehiculo getVehiculo() {
        String marca = tfMarca.getText();
        String modelo = tfModelo.getText();
        String matricula = tfMatricula.getText();
        return new Vehiculo(marca, modelo, matricula);
    }

    public void limpiar() {
        Controles.limpiarCamposTexto(tfMarca, tfModelo, tfMatricula);
    }

}
