package co.edu.uniquindio.poo.panaderia.model;

import co.edu.uniquindio.poo.panaderia.model.Cajero;
import co.edu.uniquindio.poo.panaderia.model.PanaderoArtesanal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Panaderia {

    private String nombre;
    private String NIT;

    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();



    public Panaderia(String nombre, String NIT) {
        this.nombre = nombre;
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Optional<Empleado> buscarEmpleado(String codigo){
        return listaEmpleados.stream().filter(empleados ->empleados.getCodigo().equals(codigo) ).findFirst();
    }

    public boolean crearPanaderoIndustrial(Empleado empleado){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(empleado.getCodigo());
        if (!empleadoEncontrado.isPresent() && empleado instanceof PanaderoIndustrial){
            listaEmpleados.add(empleado);
            return true;
        }return false;
    }

    public boolean eliminarPanaderoIndustrial(String codigo){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(codigo);
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof PanaderoIndustrial){
            listaEmpleados.remove(empleadoEncontrado.get());
            return true;
        }return false;
    }

    public boolean actualizarEmpleado(Empleado empleadoNuevo){
        Optional<Empleado> empleadoEncontrado = buscarEmpleado(empleadoNuevo.getCodigo());
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof PanaderoIndustrial){
            empleadoEncontrado.get().setDocumento(empleadoNuevo.getDocumento());
            empleadoEncontrado.get().setMinutosDisponibles(empleadoNuevo.getMinutosDisponibles());
            empleadoEncontrado.get().setNombre(empleadoNuevo.getNombre());
            empleadoEncontrado.get().setPedido(empleadoNuevo.getPedido());
            return true;
        }return false;
    }

    public boolean crearPanaderoArtesanal(Empleado empleado){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(empleado.getCodigo());
        if (!empleadoEncontrado.isPresent() && empleado instanceof PanaderoArtesanal){
            listaEmpleados.add(empleado);
            return true;
        }return false;
    }

    public boolean eliminarPanaderoArtesanal(String codigo){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(codigo);
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof PanaderoArtesanal){
            listaEmpleados.remove(empleadoEncontrado.get());
            return true;
        }return false;
    }

    public boolean actualizarPanaderoArtesanal(Empleado empleadoNuevo){
        Optional<Empleado> empleadoEncontrado = buscarEmpleado(empleadoNuevo.getCodigo());
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof PanaderoArtesanal){
            empleadoEncontrado.get().setDocumento(empleadoNuevo.getDocumento());
            empleadoEncontrado.get().setMinutosDisponibles(empleadoNuevo.getMinutosDisponibles());
            empleadoEncontrado.get().setNombre(empleadoNuevo.getNombre());
            empleadoEncontrado.get().setPedido(empleadoNuevo.getPedido());
            return true;
        }return false;
    }

    public boolean crearCajero(Empleado empleado){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(empleado.getCodigo());
        if (!empleadoEncontrado.isPresent() && empleado instanceof Cajero){
            listaEmpleados.add(empleado);
            return true;
        }return false;
    }

    public boolean eliminarCajero(String codigo){
        Optional<Empleado> empleadoEncontrado= buscarEmpleado(codigo);
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof Cajero){
            listaEmpleados.remove(empleadoEncontrado.get());
            return true;
        }return false;
    }

    public boolean actualizarCajero(Empleado empleadoNuevo, String cajeroNuevo){
        Optional<Empleado> empleadoEncontrado = buscarEmpleado(empleadoNuevo.getCodigo());
        if (empleadoEncontrado.isPresent() && empleadoEncontrado.get() instanceof Cajero){
            empleadoEncontrado.get().setDocumento(empleadoNuevo.getDocumento());
            empleadoEncontrado.get().setMinutosDisponibles(empleadoNuevo.getMinutosDisponibles());
            empleadoEncontrado.get().setNombre(empleadoNuevo.getNombre());
            empleadoEncontrado.get().setPedido(empleadoNuevo.getPedido());
            ((Cajero) empleadoEncontrado.get()).setCajaAsignada(cajeroNuevo);
            return true;
        }return false;
    }

    public Optional<Pedido> buscarPedido(String codigo) {
        return listaPedidos.stream().filter(pedido -> pedido.getCodigo().equals(codigo)).findFirst();
    }

    public boolean crearPedido(Pedido pedido) {
        Optional<Pedido> CrearPedido = buscarPedido(pedido.getCodigo());
        if (CrearPedido.isPresent()) {
            throw new IllegalArgumentException("El codigo de pedido ya existe");
        } else {
            listaPedidos.add(pedido);
            return true;
        }
    }

    public boolean eliminarPedido(String codigo) {
        Optional<Pedido> PedidoEncontrado = buscarPedido(codigo);
        if (PedidoEncontrado.isPresent()) {
            listaPedidos.remove(PedidoEncontrado.get());
            return true;
        }
        return false;
    }

    public boolean actualizarPedido(String codigo, Pedido pedidoActualizado) {
        Optional<Pedido> pedidoEncontrado = buscarPedido(codigo);
        if (pedidoEncontrado.isPresent()) {
            pedidoEncontrado.get().setCodigo(pedidoActualizado.getCodigo());
            pedidoEncontrado.get().setNombreCliente(pedidoActualizado.getNombreCliente());
            pedidoEncontrado.get().setTipoPan(pedidoActualizado.getTipoPan());
            pedidoEncontrado.get().setCantidad(pedidoActualizado.getCantidad());
            pedidoEncontrado.get().setEstadoPedido(pedidoActualizado.getEstadoPedido());
            pedidoEncontrado.get().setMinutosReservados(pedidoActualizado.getMinutosReservados());
            pedidoEncontrado.get().setEmpleado(pedidoActualizado.getEmpleado());
            return true;
        }
        return false;
    }

    //1.Registrar pedido
    public boolean registrarPedido(Pedido pedido){
        if(crearPedido(pedido)) {
            return true;
        }return false;
    }

    //2.Asignar pedido
    public boolean asignarPedido(String codigoPedido){
        Optional<Pedido> pedidoEncontrado = buscarPedido(codigoPedido);
        int mejorTiempo = 0;
        Empleado asignado= null;
        try {if (pedidoEncontrado.isEmpty()){
            throw new IllegalArgumentException("El pedido no existe");
        }
        if (pedidoEncontrado.get().getEstadoPedido()==EstadoPedido.PENDIENTE){
            List<Empleado> panaderosDisponibles =listaEmpleados.stream().filter(empleado -> empleado.getMinutosDisponibles()>0).collect(Collectors.toList());
            for (Empleado empleado: panaderosDisponibles){
                int tiempo=0;
                if (empleado instanceof IMetodoProduccion metodoProduccion ){
                    if(pedidoEncontrado.get().getTipoPan()==TipoPan.TRADICIONAL){
                        tiempo = metodoProduccion.panTradicional(pedidoEncontrado.get().getCantidad());
                    }else{tiempo= metodoProduccion.panIntegral(pedidoEncontrado.get().getCantidad());}

                    if (empleado.getMinutosDisponibles()> tiempo && (asignado==null || tiempo<mejorTiempo)){
                        asignado = empleado;
                        mejorTiempo= tiempo;
                    }
                }
            }
            if (asignado==null){
                throw new IllegalArgumentException("No hay panaderos disponibles");
            }
        }else {throw new IllegalArgumentException("El pedido ya fue asignado");}}catch (IllegalArgumentException i){
            System.out.println(i.getMessage());
        }
        asignado.setMinutosDisponibles(asignado.getMinutosDisponibles() - mejorTiempo);
        pedidoEncontrado.get().setEmpleado(asignado);
        pedidoEncontrado.get().setMinutosReservados(mejorTiempo);
        pedidoEncontrado.get().setEstadoPedido(EstadoPedido.ASIGNADO);
        return true;

    }


    //3. Cancelar un pedido
    public void cancelarPedido(String codigoPedido) {
        Pedido pedido = buscarPedido(codigoPedido)
                .orElseThrow(() -> new IllegalArgumentException("El pedido con código " + codigoPedido + " no existe."));

        if (pedido.getEstadoPedido() == EstadoPedido.CANCELADO) {
            throw new IllegalStateException("El pedido ya se encuentra cancelado.");
        }

        if (pedido.getEstadoPedido() == EstadoPedido.ASIGNADO) {
            Empleado empleado = pedido.getEmpleado();
            empleado.setMinutosDisponibles(empleado.getMinutosDisponibles() - pedido.getMinutosReservados());
        }

        pedido.setEstadoPedido(EstadoPedido.CANCELADO);
    }
}
