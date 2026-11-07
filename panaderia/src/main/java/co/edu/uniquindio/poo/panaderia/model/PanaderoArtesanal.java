package co.edu.uniquindio.poo.panaderia.model;

import main.java.co.edu.uniquindio.poo.panaderia.model.IMetodoProduccion;
import main.java.co.edu.uniquindio.poo.panaderia.model.Pedido;

public class PanaderoArtesanal extends co.edu.uniquindio.poo.panaderia.model.Empleado implements IMetodoProduccion {
    public PanaderoArtesanal(String nombre, Pedido pedido, int minutosDisponibles, String documento, String codigo) {
        super(nombre, pedido, minutosDisponibles, documento, codigo);
    }
}
