package co.edu.uniquindio.poo.panaderia.model;

public class PanaderoIndustrial extends Empleado implements IMetodoProduccion {
    public PanaderoIndustrial(String nombre, Pedido pedido, int minutosDisponibles, String documento, String codigo) {
        super(nombre, pedido, minutosDisponibles, documento, codigo);
    }

    @Override
    public int panTradicional(int cantidad) {
        byte bandejas = (byte) Math.ceil((double) cantidad / 30);
        return bandejas * 25+20;
    }

    @Override
    public int panIntegral(int cantidad) {
        byte bandejas = (byte) Math.ceil((double) cantidad / 30);
        return bandejas * 35+20;
    }
}
