package co.edu.uniquindio.poo.panaderia.model;

public class PanaderoIndustrial extends Empleado implements IMetodoProduccion{
    public PanaderoIndustrial(String nombre, Pedido pedido, int minutosDisponibles, String documento, String codigo) {
        super(nombre, pedido, minutosDisponibles, documento, codigo);
    }
}
