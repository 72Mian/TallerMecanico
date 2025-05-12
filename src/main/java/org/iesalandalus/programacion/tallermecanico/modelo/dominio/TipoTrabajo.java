package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.util.Objects;

public enum TipoTrabajo {
    MECANICO("Mecánico"),
    REVISION("Revisión");
    private String nombre;
    private TipoTrabajo(String nombre) {
        this.nombre = nombre;
    }
    public static TipoTrabajo get(Trabajo trabajo) {
        Objects.requireNonNull(trabajo, "El trabajo no puede ser nulo.");
        TipoTrabajo resultado = null;
        if (trabajo instanceof Revision) {
            resultado = REVISION;
        }
        if (trabajo instanceof Mecanico) {
            resultado = MECANICO;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
