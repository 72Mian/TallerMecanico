package org.iesalandalus.programacion.tallermecanico.modelo.negocio.memoria;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Trabajo;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trabajos {
    private List<Trabajo> coleccionTrabajos;
    public Trabajos() {
        coleccionTrabajos = new ArrayList<>();
    }
    public List<Trabajo> get() {
        return coleccionTrabajos;
    }
    public List<Trabajo> get(Cliente cliente) {
        List<Trabajo> resultado = new ArrayList<>();
        for (Trabajo trabajo : coleccionTrabajos) {
            if (trabajo.getCliente().equals(cliente)) {
                resultado.add(trabajo);
            }
        }
        return resultado;
    }
    public List<Trabajo> get(Vehiculo vehiculo) {
        List<Trabajo> resultado = new ArrayList<>();
        for (Trabajo trabajo : coleccionTrabajos) {
            if (trabajo.getVehiculo().equals(vehiculo)) {
                resultado.add(trabajo);
            }
        }
        return resultado;
    }

    public void insertar(Trabajo trabajo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(trabajo, "No se puede insertar una revisión nula.");
        comprobarTrabajo(trabajo.getCliente(), trabajo.getVehiculo(), trabajo.getFechaInicio());
        coleccionTrabajos.add(trabajo);
    }
    private void comprobarTrabajo(Cliente cliente, Vehiculo vehiculo, LocalDate fechaRevision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo.");
        Objects.requireNonNull(vehiculo, "El vehiculo no puede ser nulo.");
        Objects.requireNonNull(fechaRevision, "La fecha de revisión no puede ser nula.");
        for (Trabajo trabajo : coleccionTrabajos) {
            if (!trabajo.estaCerrado()) {
                if (trabajo.getCliente().equals(cliente)) {
                    throw new TallerMecanicoExcepcion("El cliente tiene otra revisión en curso.");
                }
                if (trabajo.getVehiculo().equals(vehiculo)) {
                    throw new TallerMecanicoExcepcion("El vehículo está actualmente en revisión.");
                }
            } else if (!fechaRevision.isAfter(trabajo.getFechaFin())) {
                if (trabajo.getCliente().equals(cliente)) {
                    throw new TallerMecanicoExcepcion("El cliente tiene una revisión posterior.");
                }
                if (trabajo.getVehiculo().equals(vehiculo)) {
                    throw new TallerMecanicoExcepcion("El vehículo tiene una revisión posterior.");
                }
            }
        }

    }
    public Trabajo anadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
        getTrabajoAbierto(revision).anadirHoras(horas);
        return getTrabajoAbierto(revision);

    }
    private Trabajo getTrabajoAbierto(Trabajo trabajo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(trabajo, "No puedo operar sobre una revisión nula.");
        if (!coleccionTrabajos.contains(trabajo)) {
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        return trabajo;
    }
    public Trabajo anadirPrecioMaterial(Trabajo trabajo, float precioMaterial) throws TallerMecanicoExcepcion {
        getTrabajoAbierto(trabajo).anadirPrecioMaterial(precioMaterial);
        return getTrabajoAbierto(trabajo);
    }
    public Trabajo cerrar(Trabajo trabajo, LocalDate fechaFin) throws TallerMecanicoExcepcion {
        getTrabajoAbierto(trabajo).cerrar(fechaFin);
        return getTrabajoAbierto(trabajo);
    }
    public Trabajo buscar(Trabajo trabajo)  {
        Objects.requireNonNull(trabajo, "No se puede buscar una revisión nula.");
        if (!coleccionTrabajos.contains(trabajo)) {
            trabajo = null;
        }
        return trabajo;
    }
    public void borrar(Trabajo trabajo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(trabajo, "No se puede borrar una revisión nula.");
        if (!coleccionTrabajos.contains(trabajo)) {
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        coleccionTrabajos.remove(trabajo);

    }
}
