package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Clientes;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Revisiones;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Vehiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Modelo {
    private Clientes clientes;
    private Revisiones revisiones;
    private Vehiculos vehiculos;

    public Modelo() {

    }
    public void comenzar() {
        clientes = new Clientes();
        revisiones = new Revisiones();
        vehiculos = new Vehiculos();
    }
    public void terminar() {
        System.out.println("El modelo ha terminado.");
    }
    public void insertar(Cliente cliente) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo.");
        clientes.insertar(new Cliente(cliente));
    }
    public void insertar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(vehiculo, "El vehiculo no puede ser nulo.");
        vehiculos.insertar(vehiculo);
    }
    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "La revisión no puede ser nula.");
        Cliente cliente = clientes.buscar(revision.getCliente());
        Vehiculo vehiculo = vehiculos.buscar(revision.getVehiculo());
        revisiones.insertar(new Revision(cliente, vehiculo, revision.getFechaInicio()));
    }
    public Cliente buscar(Cliente cliente) {
        Cliente buscao = null;
        if (clientes.buscar(cliente) != null) {
            buscao = new Cliente(cliente);
        }
        return buscao;
    }
    public Vehiculo buscar(Vehiculo vehiculo) {
        Vehiculo buscao = null;
        if (vehiculos.buscar(vehiculo) != null) {
            buscao = new Vehiculo(vehiculo.marca(), vehiculo.modelo(), vehiculo.matricula());
        }
        return buscao;
    }
    public Revision buscar(Revision revision) {
        Revision buscao = null;
        if (revisiones.buscar(revision) != null) {
            buscao = new Revision(revision);
        }
        return buscao;
    }
    public Cliente modificar(Cliente cliente, String nombre, String telefono) throws TallerMecanicoExcepcion {
        return clientes.modificar(cliente, nombre, telefono);
    }
    public Revision anadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
        return revisiones.anadirHoras(revision, horas);
    }
    public Revision anadirPrecioMaterial(Revision revision, float precioMaterial) throws TallerMecanicoExcepcion {
        return revisiones.anadirPrecioMaterial(revision, precioMaterial);
    }
    public Revision cerrar(Revision revision, LocalDate fechaFin) throws TallerMecanicoExcepcion {
        return revisiones.cerrar(revision, fechaFin);
    }
    public void borrar(Cliente cliente) throws TallerMecanicoExcepcion {
        List<Revision> revisionesCliente = revisiones.get(cliente);
        for (Revision revision : revisionesCliente) {
            revisiones.borrar(revision);
        }
        clientes.borrar(cliente);

    }

    public void borrar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        List<Revision> revisionesVehiculo = revisiones.get(vehiculo);
        for (Revision revision : revisionesVehiculo) {
            revisiones.borrar(revision);
        }
        vehiculos.borrar(vehiculo);

    }
    public void borrar(Revision revision) throws TallerMecanicoExcepcion {
        revisiones.borrar(revision);

    }
    public List<Cliente> getClientes() {
        List<Cliente> copiaClientes = new ArrayList<>();
        for (Cliente cliente : clientes.get()) {
            copiaClientes.add(new Cliente(cliente));
        }
    return copiaClientes;
    }
    public List<Vehiculo> getVehiculos() {
        List<Vehiculo> copiaVehiculos = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos.get()) {
            copiaVehiculos.add(vehiculo);
        }
        return copiaVehiculos;
    }
    public List<Revision> getRevisiones() {
        List<Revision> copiaRevisiones = new ArrayList<>();
        for (Revision revision : revisiones.get()) {
            copiaRevisiones.add(new Revision(revision));
        }
        return copiaRevisiones;
    }
    public List<Revision> getRevisiones(Cliente cliente) {
        List<Revision> copiaRevisionCliente = new ArrayList<>();
        for (Revision revision : revisiones.get(cliente)) {
            if (revision.getCliente().equals(cliente)) {
                copiaRevisionCliente.add(new Revision(revision));
            }
        }
        return copiaRevisionCliente;
    }
    public List<Revision> getRevisiones(Vehiculo vehiculo) {
        List<Revision> copiaRevisionVehiculo = new ArrayList<>();
        for (Revision revision : revisiones.get(vehiculo)) {
            if (revision.getVehiculo().equals(vehiculo)) {
                copiaRevisionVehiculo.add(new Revision(revision));
            }
        }
        return copiaRevisionVehiculo;
    }




}
