package co.edu.uniquindio.poo.panaderia.model;

public class Cajero extends Empleado{

    private String cajaAsignada;


    public Cajero(String nombre, Pedido pedido, int minutosDisponibles, String documento, String codigo, String cajaAsignada) {
        super(nombre, pedido, minutosDisponibles, documento, codigo);
        this.cajaAsignada=cajaAsignada;
    }

    public String getCajaAsignada() {
        return cajaAsignada;
    }

    public void setCajaAsignada(String cajaAsignada) {
        this.cajaAsignada = cajaAsignada;
    }
}
