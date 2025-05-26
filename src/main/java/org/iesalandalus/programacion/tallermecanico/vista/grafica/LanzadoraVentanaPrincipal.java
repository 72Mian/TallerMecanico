package org.iesalandalus.programacion.tallermecanico.vista.grafica;


import javafx.application.Application;
import javafx.stage.Stage;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.controladores.VentanaPrincipal;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.utilidades.Controladores;

public class LanzadoraVentanaPrincipal extends Application {

    @Override
    public void start(Stage stage) {
        VistaGrafica.getInstancia().inicializar();
        VentanaPrincipal ventanaPrincipal = (VentanaPrincipal) Controladores.get("/vistas/VentanaPrincipal.fxml", "Taller Mecánico", null);
        //ventanaPrincipal.inicializar();//
        ventanaPrincipal.getEscenario().show();
        ventanaPrincipal.centrar();
    }
    public static void comenzar() {
        launch();
    }
}