package co.edu.uniquindio.poo.panaderia.controller;

import co.edu.uniquindio.poo.panaderia.model.Panaderia;

public class AsignarPedidoController {

    private Panaderia panaderia;

    public AsignarPedidoController(Panaderia panaderia){
        this.panaderia=panaderia;
    }

    public boolean asignarPedido(String codigo){
        return panaderia.asignarPedido(codigo);
    }
}
