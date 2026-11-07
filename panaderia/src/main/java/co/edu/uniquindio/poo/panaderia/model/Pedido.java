package main.java.co.edu.uniquindio.poo.panaderia.model;

public class Pedido {

    private String codigo;
    private String nombreCliente;
    private final TipoPan tipoPan;
    private final int cantidad;
    private EstadoPedido estadoPedido;
    private int minutosReservados;
    private Empleado empleado;

    public Pedido(TipoPan tipoPan, int cantidad, String codigo, String nombreCliente, EstadoPedido estadoPedido, int minutosReservados, Empleado empleado) {
        this.tipoPan = tipoPan;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.nombreCliente = nombreCliente;
        this.estadoPedido = estadoPedido;
        this.minutosReservados = minutosReservados;
        this.empleado = empleado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public TipoPan getTipoPan() {
        return tipoPan;
    }

    public int getCantidad() {
        return cantidad;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public int getMinutosReservados() {
        return minutosReservados;
    }

    public void setMinutosReservados(int minutosReservados) {
        this.minutosReservados = minutosReservados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
