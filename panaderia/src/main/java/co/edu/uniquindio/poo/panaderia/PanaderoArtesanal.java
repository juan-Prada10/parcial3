package co.edu.uniquindio.poo.panaderia;

public class PanaderoArtesanal extends Empleado implements IMetodoProduccion {
    public PanaderoArtesanal(String nombre, Pedido pedido, int minutosDisponibles, String documento, String codigo) {
        super(nombre, pedido, minutosDisponibles, documento, codigo);
    }
}
