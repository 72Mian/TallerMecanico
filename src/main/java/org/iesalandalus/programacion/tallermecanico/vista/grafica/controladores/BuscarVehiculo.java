package org.iesalandalus.programacion.tallermecanico.vista.grafica.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.vista.eventos.Evento;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.utilidades.Controlador;

public class BuscarVehiculo extends Controlador {
    @FXML
    private TextField tfMatricula;
    @FXML
    void cerrar() {
        getEscenario().close();
    }
    @FXML
    void aceptar() {
        VistaGrafica.getInstancia().getGestorEventos().notificar(Evento.BUSCAR_VEHICULO);
        getEscenario().close();
    }
    public Vehiculo getVehiculoMatricula() {
        String matricula = tfMatricula.getText();
        return Vehiculo.get(matricula);
    }
}
