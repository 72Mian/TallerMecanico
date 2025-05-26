package org.iesalandalus.programacion.tallermecanico.vista.grafica.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.utilidades.Controlador;

public class InsertarTrabajo extends Controlador {
    @FXML
    private ComboBox<String> cbOpciones;

    @FXML
    void cerrar() {
        getEscenario().close();
    }
    @FXML
    void initialize() {
        cbOpciones.getItems().addAll("Revisión", "Mecánico");
    }






}
