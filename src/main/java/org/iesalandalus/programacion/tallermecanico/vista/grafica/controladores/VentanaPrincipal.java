package org.iesalandalus.programacion.tallermecanico.vista.grafica.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.WindowEvent;
import org.iesalandalus.programacion.tallermecanico.vista.eventos.Evento;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.utilidades.Controladores;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.utilidades.Dialogos;

public class VentanaPrincipal extends Controlador {


    private void crearInsertarVehiculo() {
        InsertarVehiculo insertarVehiculo = (InsertarVehiculo) Controladores.get("/vistas/InsertarVehiculo.fxml", "Insertar Vehiculo", getEscenario());
        insertarVehiculo.getEscenario().show();
        }
    private void crearBuscarVehiculo() {
        BuscarVehiculo buscarVehiculo = (BuscarVehiculo) Controladores.get("/vistas/BuscarVehiculo.fxml", "Buscar Vehiculo", getEscenario());
        buscarVehiculo.getEscenario().show();
    }
    private void crearBorrarVehiculo() {
        BorrarVehiculo borrarVehiculo = (BorrarVehiculo) Controladores.get("/vistas/BorrarVehiculo.fxml", "Borrar Vehiculo", getEscenario());
        borrarVehiculo.getEscenario().show();
    }
    private void crearInsertarCliente() {
        InsertarCliente insertarCliente = (InsertarCliente) Controladores.get("/vistas/InsertarCliente.fxml", "Insertar Cliente", getEscenario());
        insertarCliente.getEscenario().show();
    }
    private void crearBuscarCliente() {
        BuscarCliente buscarCliente = (BuscarCliente) Controladores.get("/vistas/BuscarCliente.fxml", "Buscar Cliente", getEscenario());
        buscarCliente.getEscenario().show();
    }
    private void crearBorrarCliente() {
        BorrarCliente borrarCliente = (BorrarCliente) Controladores.get("/vistas/BorrarCliente.fxml", "Borrar Cliente", getEscenario());
        borrarCliente.getEscenario().show();
    }
    private void crearAcercaDe() {
        AcercaDe acercaDe = (AcercaDe) Controladores.get("/vistas/AcercaDe.fxml", "Acerca de", getEscenario());
        acercaDe.getEscenario().show();
    }
    private void crearInsertarTrabajo() {
        InsertarTrabajo insertarTrabajo = (InsertarTrabajo) Controladores.get("/vistas/InsertarTrabajo.fxml", "Insertar Trabajo", getEscenario());
        insertarTrabajo.getEscenario().show();
    }
    private void crearBuscarTrabajo() {
        BuscarTrabajo buscarTrabajo = (BuscarTrabajo) Controladores.get("/vistas/BuscarTrabajo.fxml", "Buscar Trabajo", getEscenario());
        buscarTrabajo.getEscenario().show();
    }
    private void crearBorrarTrabajo() {
        BorrarTrabajo borrarTrabajo = (BorrarTrabajo) Controladores.get("/vistas/BorrarTrabajo.fxml", "Borrar Trabajo", getEscenario());
        borrarTrabajo.getEscenario().show();
    }


    @FXML
    private Button btInsertarVehiculo;
    @FXML
    private Button btBuscarVehiculo;

    @FXML
    private Button btBorrarVehiculo;

    @FXML
    private MenuItem btCerrar;




    @FXML
    void insertarVehiculo(ActionEvent event)  {
        crearInsertarVehiculo();

    }
    @FXML
    void buscarVehiculo(ActionEvent event) {
        crearBuscarVehiculo();
    }
    @FXML
    void borrarVehiculo(ActionEvent event) {
        crearBorrarVehiculo();
    }
    @FXML
    void insertarCliente(ActionEvent event)  {
        crearInsertarCliente();

    }
    @FXML
    void buscarCliente(ActionEvent event) {
        crearBuscarCliente();
    }
    @FXML
    void borrarCliente(ActionEvent event) {
        crearBorrarCliente();
    }
    @FXML
    void acercaDe(ActionEvent event) {
        crearAcercaDe();
    }
    @FXML
    void insertarTrabajo(ActionEvent event) {
        crearInsertarTrabajo();
    }
    @FXML
    void buscarTrabajo(ActionEvent event) {
        crearBuscarTrabajo();
    }
    @FXML
    void borrarTrabajo(ActionEvent event) {
        crearBorrarTrabajo();
    }




    @FXML
    void initialize() {
    }

    @FXML
    void salir() {
        boolean confirmacion = Dialogos.mostrarDialogoConfirmacion("Cerrar", "Estas seguro de que quieres cerrar?", getEscenario());
        if (confirmacion) {
            getEscenario().close();
            VistaGrafica.getInstancia().getGestorEventos().notificar(Evento.SALIR);
        }
    }


}

