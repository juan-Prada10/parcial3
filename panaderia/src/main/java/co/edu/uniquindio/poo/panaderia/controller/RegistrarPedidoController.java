package co.edu.uniquindio.poo.panaderia.controller;

import co.edu.uniquindio.poo.panaderia.model.Panaderia;
import co.edu.uniquindio.poo.panaderia.model.Pedido;

public class RegistrarPedidoController {

    private Panaderia panaderia;

    public RegistrarPedidoController(Panaderia panaderia){
        this.panaderia=panaderia;
    }

    public boolean registrarPedido(Pedido pedido){
        return panaderia.registrarPedido(pedido);
    }
}
