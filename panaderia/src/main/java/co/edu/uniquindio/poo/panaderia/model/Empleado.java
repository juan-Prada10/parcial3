package co.edu.uniquindio.poo.panaderia.model;

import main.java.co.edu.uniquindio.poo.panaderia.model.Pedido;

public abstract class Empleado {

    private String nombre;
    private String documento;
    private String codigo;
    private int minutosDisponibles;

    private Pedido pedido;

    public Empleado(String nombre, Pedido pedido, int minutosDisponibles, String documento, String codigo) {
        this.nombre = nombre;
        this.pedido = pedido;
        this.minutosDisponibles = minutosDisponibles;
        this.documento = documento;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMinutosDisponibles() {
        return minutosDisponibles;
    }

    public void setMinutosDisponibles(int minutosDisponibles) {
        this.minutosDisponibles = minutosDisponibles;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}

