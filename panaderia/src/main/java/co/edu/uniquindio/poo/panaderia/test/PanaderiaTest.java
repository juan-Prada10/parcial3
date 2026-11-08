package main.java.co.edu.uniquindio.poo.panaderia.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PanaderiaTest {
/**
 * Clase para probar las funcionalidades del programa
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

private Panaderia panaderia;

    @BeforeEach
    void setUp() {
        panaderia = new Panaderia("El Trigal", "900123456-7");
    }
   // funcionalidad 1. Registrar pedido
    @Test
    void registrarPedidoValido() {
        PanaderoArtesanal ana = new PanaderoArtesanal("Ana", null, 100, "12345", "E01");
        panaderia.crearPanaderoArtesanal(ana);
        Pedido pedido = new Pedido(TipoPan.TRADICIONAL, 25, "P01", "Cliente Ejemplo",
                EstadoPedido.PENDIENTE, 0, null);

        assertTrue(panaderia.registrarPedido(pedido));

        Pedido guardado = panaderia.buscarPedido("P01").get();
        assertEquals(EstadoPedido.PENDIENTE, guardado.getEstadoPedido());
        assertEquals(25, guardado.getCantidad());
        assertEquals(100, ana.getMinutosDisponibles());
    }

    @Test
    void testRegistrarPedidoCodigoDuplicadoDespuesDeCancelar() {
        Pedido pedido1 = new Pedido("P01", "Cliente 1", TipoPan.TRADICIONAL, 25);
        panaderia.registrarPedido(pedido1);
        panaderia.cancelarPedido("P01");

        Pedido pedidoDuplicado = new Pedido("P01", "Cliente 2", TipoPan.INTEGRAL, 10);


        assertThrows(IllegalArgumentException.class, () -> {
            panaderia.registrarPedido(pedidoDuplicado);
        });

        assertEquals(1, panaderia.getHistorialPedidos().size());
        assertEquals(EstadoPedido.CANCELADO, panaderia.buscarPedido("P01").get().getEstadoPedido());
    }

    @Test
    void registrarCantidadCero() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Pedido(TipoPan.TRADICIONAL, 0, "P01", "Cliente Ejemplo", EstadoPedido.PENDIENTE, 0, null);
        });

        assertTrue(panaderia.getListaPedidos().isEmpty());
    }

    //funcionalidad 2. Asignar

    @Test
    void asignarPanaderoQueTardaMenos() {

        PanaderoArtesanal ana = new PanaderoArtesanal("Ana", null, 100, "111", "E01");
        PanaderoIndustrial carlos = new PanaderoIndustrial("Carlos", null, 45, "222", "E02");
        panaderia.registrarEmpleado(ana);
        panaderia.registrarEmpleado(carlos);

        Pedido pedido = new Pedido(TipoPan.TRADICIONAL, 25, "P01", "Cliente 1", EstadoPedido.PENDIENTE, 0, null);
        panaderia.registrarPedido(pedido);

        panaderia.asignarPedido("P01");


        assertEquals(carlos, pedido.getEmpleado());
        assertEquals(45, pedido.getMinutosReservados());
        assertEquals(0, carlos.getMinutosDisponibles());
        assertEquals(100, ana.getMinutosDisponibles());
        assertEquals(EstadoPedido.ASIGNADO, pedido.getEstadoPedido());
    }

    @Test
    void asignarEmpateTiempo() {

        PanaderoArtesanal ana = new PanaderoArtesanal("Ana", null, 80, "111", "E01");
        PanaderoArtesanal diana = new PanaderoArtesanal("Diana", null, 80, "222", "E02");
        PanaderoIndustrial carlos = new PanaderoIndustrial("Carlos", null, 54, "333", "E03");

        panaderia.registrarEmpleado(ana);
        panaderia.registrarEmpleado(diana);
        panaderia.registrarEmpleado(carlos);

        Pedido pedido = new Pedido(TipoPan.INTEGRAL, 13, "P01", "Cliente 1", EstadoPedido.PENDIENTE, 0, null);
        panaderia.registrarPedido(pedido);

        panaderia.asignarPedido("P01");


        assertEquals(ana, pedido.getEmpleado());
        assertEquals(0, ana.getMinutosDisponibles());
        assertEquals(80, diana.getMinutosDisponibles());
        assertEquals(54, carlos.getMinutosDisponibles());
    }

    @Test
    void asignaSinTiempoSuficiente() {

        PanaderoIndustrial carlos = new PanaderoIndustrial("Carlos", null, 44, "111", "E01");
        Cajero lucia = new Cajero("Lucía", null, 120, "222", "E02", "Caja 1");

        panaderia.registrarEmpleado(carlos);
        panaderia.registrarEmpleado(lucia);

        Pedido pedido = new Pedido(TipoPan.TRADICIONAL, 25, "P01", "Cliente 1", EstadoPedido.PENDIENTE, 0, null);
        panaderia.registrarPedido(pedido);

        assertThrows(IllegalStateException.class, () -> {
            panaderia.asignarPedido("P01");
        });

        assertEquals(EstadoPedido.PENDIENTE, pedido.getEstadoPedido());
        assertEquals(44, carlos.getMinutosDisponibles());
        assertEquals(120, lucia.getMinutosDisponibles());
    }
}

