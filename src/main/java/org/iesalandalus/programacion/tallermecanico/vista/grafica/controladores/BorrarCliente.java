package org.iesalandalus.programacion.tallermecanico.vista.grafica.controladores;

import javafx.fxml.FXML;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.utilidades.Controlador;

public class BorrarCliente extends Controlador {
    @FXML
    void cerrar() {
        getEscenario().close();
    }
}
