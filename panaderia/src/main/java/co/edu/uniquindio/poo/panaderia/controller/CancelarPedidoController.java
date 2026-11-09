package co.edu.uniquindio.poo.panaderia.controller;

import co.edu.uniquindio.poo.panaderia.model.Panaderia;

public class CancelarPedidoController {

    private Panaderia panaderia;

    public CancelarPedidoController(Panaderia panaderia){
        this.panaderia=panaderia;
    }

    public boolean cancelarPedido(String codigo){
        return panaderia.cancelarPedido(codigo);
    }
}
