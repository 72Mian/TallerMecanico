package org.iesalandalus.programacion.tallermecanico.vista.texto;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.*;
import org.iesalandalus.programacion.tallermecanico.vista.eventos.Evento;
import org.iesalandalus.programacion.tallermecanico.vista.eventos.GestorEventos;
import org.iesalandalus.programacion.utilidades.Entrada;

import static  org.iesalandalus.programacion.tallermecanico.vista.texto.Consola.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class VistaTexto implements org.iesalandalus.programacion.tallermecanico.vista.Vista {
    private final GestorEventos gestorEventos = new GestorEventos(Evento.values());

    @Override
    public GestorEventos getGestorEventos() {
        return gestorEventos;
    }

    @Override
    public void comenzar() {
        Evento evento;
        do {
            Consola.mostrarMenu();
            evento = Consola.elegirOpcion();
            ejecutar(evento);
        } while (evento != Evento.SALIR);
    }
    @Override
    public void terminar() {
        System.out.println("Hasta luego");

    }
    private void ejecutar(Evento opcion) {
        Consola.mostrarCabecera(opcion.toString());
        gestorEventos.notificar(opcion);


    }
    @Override
    public Cliente leerCliente() {
        String nombre = leerCadena("Introduce el nombre: ");
        String dni = leerCadena("Introduce el DNI: ");
        String telefono = leerCadena("Introduce el teléfono: ");
        return new Cliente(nombre, dni, telefono);
    }
    @Override
    public Cliente leerClienteDni() {
        return Cliente.get(leerCadena("Introduce el DNI: "));
    }
    @Override
    public String leerNuevoNombre() {
        return leerCadena("Introduce el nuevo nombre: ");
    }
    @Override
    public String leerNuevoTelefono() {
        return leerCadena("Introduce el nuevo teléfono");
    }
    @Override
    public Vehiculo leerVehiculo() {
        String marca = leerCadena("Introduce la marca: ");
        String modelo = leerCadena("Introduce el modelo: ");
        String matricula = leerCadena("Introduce la matrícula: ");
        return new Vehiculo(marca, modelo, matricula);
    }
    @Override
    public Vehiculo leerVehiculoMatricula() {
        System.out.print("Introduce la matrícula: ");
        return new Vehiculo("Seat", "Mo", Entrada.cadena());

    }
    @Override
    public Trabajo leerRevision() {
        Cliente cliente = leerClienteDni();
        Vehiculo vehiculo = leerVehiculoMatricula();
        LocalDate fechaInicio = leerFecha("Introduce la fecha de inicio");
        return new Revision(cliente, vehiculo, fechaInicio);
    }
    @Override
    public Trabajo leerMecanico() {
        Cliente cliente = leerClienteDni();
        Vehiculo vehiculo = leerVehiculoMatricula();
        LocalDate fechaInicio = leerFecha("Introduce la fecha de inicio");
        return new Mecanico(cliente, vehiculo, fechaInicio);
    }
    @Override
    public Trabajo leerTrabajoVehiculo() {
        Vehiculo vehiculo = leerVehiculoMatricula();
        return Trabajo.get(vehiculo);
    }
    @Override
    public int leerHoras() {
        return leerEntero("Intoduce las horas a añadir: ");
    }
    @Override
    public float leerPrecioMaterial() {
        return leerReal("Introduce el precio del material a añadir: ");

    }
    @Override
    public LocalDate leerFechaCierre() {
        return leerFecha("Introduce la fecha de cierre: ");
    }

    @Override
    public LocalDate leerMes() {
        return leerFecha("Introduce el mes: ");
    }

    @Override
    public void notificarResultado(Evento evento, String texto, boolean exito) {
        if (exito) {
            System.out.println(texto);
        } else {
            System.out.printf("Error %s", texto);
        }

    }
    @Override
    public void mostrarCliente(Cliente cliente) {
        System.out.println(cliente);
    }
    @Override
    public void mostrarVehiculo(Vehiculo vehiculo) {
        System.out.println(vehiculo);
    }
    @Override
    public void mostrarTrabajo(Trabajo trabajo) {
        System.out.println((trabajo != null) ? trabajo : "No existe ningún trabajo para ese cliente, vehiculo y fecha.");
    }
    @Override
    public void mostrarClientes(List<Cliente> clientes) {
        if (!clientes.isEmpty()) {
            clientes.sort(Comparator.comparing(Cliente::getNombre).thenComparing(Cliente::getDni));
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } else {
            System.out.println("No hay clientes que mostrar.");
        }
    }
    @Override
    public void mostrarVehiculos(List<Vehiculo> vehiculos) {
        if (!vehiculos.isEmpty()) {
            vehiculos.sort(Comparator.comparing(Vehiculo::marca).thenComparing(Vehiculo::modelo).thenComparing(Vehiculo::matricula));
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }
        } else {
            System.out.println("No hay vehículos que mostrar.");
        }


    }
    @Override
    public void mostrarTrabajos(List<Trabajo> trabajos) {
        if (!trabajos.isEmpty()) {
            Comparator<Cliente> comparadorCliente = Comparator.comparing(Cliente::getNombre).thenComparing(Cliente::getDni);
            trabajos.sort(Comparator.comparing(Trabajo::getFechaInicio).thenComparing(Trabajo::getCliente, comparadorCliente));
            for (Trabajo trabajo : trabajos) {
                System.out.println(trabajo);
            }
        } else {
            System.out.println("No hay trabajos que mostrar");
        }
    }
    @Override
    public void mostrarEstadisticasMensuales(Map<TipoTrabajo, Integer> estadisticas) {
        System.out.printf("Tipos de trabajos realizados este mes: %s%n", estadisticas);
    }


}

