package main.java.co.edu.uniquindio.poo.panaderia.model;

import java.util.ArrayList;
import java.util.Optional;

public class Panaderia {

    private String nombre;
    private String NIT;

    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private ArrayList<Pedidos> listaPedidos = new ArrayList<>();

    public Panaderia(String nombre, String NIT) {
        this.nombre = nombre;
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Optional<Empleado> buscarEmpleado(String codigo){
        return listaEmpleados.stream().filter(empleados ->empleados.getCodigo().equals(codigo) ).findFirst();
    }

    public boolean crearPanaderoIndustrial(Empleado empleado){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(empleado.getCodigo());
        if (!empleadoEncontrado.isPresent() && empleado instanceof PanaderoIndustrial){
            listaEmpleados.add(empleado);
            return true;
        }return false;
    }

    public boolean eliminarPanaderoIndustrial(String codigo){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(codigo);
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof PanaderoIndustrial){
            listaEmpleados.remove(empleadoEncontrado.get());
            return true;
        }return false;
    }

    public boolean actualizarEmpleado(Empleado empleadoNuevo){
        Optional<Empleado> empleadoEncontrado = buscarEmpleado(empleadoNuevo.getCodigo());
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof PanaderoIndustrial){
            empleadoEncontrado.get().setDocumento(empleadoNuevo.getDocumento());
            empleadoEncontrado.get().setMinutosDisponibles(empleadoNuevo.getMinutosDisponibles());
            empleadoEncontrado.get().setNombre(empleadoNuevo.getNombre());
            empleadoEncontrado.get().setPedido(empleadoNuevo.getPedido());
            return true;
        }return false;
    }

    public boolean crearPanaderoArtesanal(Empleado empleado){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(empleado.getCodigo());
        if (!empleadoEncontrado.isPresent() && empleado instanceof PanaderoArtesanal){
            listaEmpleados.add(empleado);
            return true;
        }return false;
    }

    public boolean eliminarPanaderoArtesanal(String codigo){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(codigo);
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof PanaderoArtesanal){
            listaEmpleados.remove(empleadoEncontrado.get());
            return true;
        }return false;
    }

    public boolean actualizarPanaderoArtesanal(Empleado empleadoNuevo){
        Optional<Empleado> empleadoEncontrado = buscarEmpleado(empleadoNuevo.getCodigo());
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof PanaderoArtesanal){
            empleadoEncontrado.get().setDocumento(empleadoNuevo.getDocumento());
            empleadoEncontrado.get().setMinutosDisponibles(empleadoNuevo.getMinutosDisponibles());
            empleadoEncontrado.get().setNombre(empleadoNuevo.getNombre());
            empleadoEncontrado.get().setPedido(empleadoNuevo.getPedido());
            return true;
        }return false;
    }

    public boolean crearCajero(Empleado empleado){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(empleado.getCodigo());
        if (!empleadoEncontrado.isPresent() && empleado instanceof Cajero){
            listaEmpleados.add(empleado);
            return true;
        }return false;
    }

    public boolean eliminarCajero(String codigo){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(codigo);
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof Cajero){
            listaEmpleados.remove(empleadoEncontrado.get());
            return true;
        }return false;
    }

    public boolean actualizarCajero(Empleado empleadoNuevo, String cajeroNuevo){
        Optional<Empleado> empleadoEncontrado = buscarEmpleado(empleadoNuevo.getCodigo());
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof Cajero){
            empleadoEncontrado.get().setDocumento(empleadoNuevo.getDocumento());
            empleadoEncontrado.get().setMinutosDisponibles(empleadoNuevo.getMinutosDisponibles());
            empleadoEncontrado.get().setNombre(empleadoNuevo.getNombre());
            empleadoEncontrado.get().setPedido(empleadoNuevo.getPedido());
            ((Cajero) empleadoEncontrado.get()).setCajaAsignada(cajeroNuevo);
            return true;
        }return false;
    }


}
