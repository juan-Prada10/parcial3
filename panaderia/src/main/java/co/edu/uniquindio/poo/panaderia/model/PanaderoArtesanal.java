package co.edu.uniquindio.poo.panaderia.model;

public class PanaderoArtesanal extends Empleado implements IMetodoProduccion {
    public PanaderoArtesanal(String nombre, Pedido pedido, int minutosDisponibles, String documento, String codigo) {
        super(nombre, pedido, minutosDisponibles, documento, codigo);
    }

    @Override
    public int panTradicional(int cantidad) {
        byte bandejas = (byte) Math.ceil((double) cantidad / 12);
        return bandejas * 30;
    }

    @Override
    public int panIntegral(int cantidad) {
        byte bandejas = (byte) Math.ceil((double) cantidad / 12);
        return bandejas * 40;
    }
}
