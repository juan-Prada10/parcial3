package co.edu.uniquindio.poo.panaderia.test;
import co.edu.uniquindio.poo.panaderia.model.Cajero;
import co.edu.uniquindio.poo.panaderia.model.EstadoPedido;
import co.edu.uniquindio.poo.panaderia.model.Panaderia;
import co.edu.uniquindio.poo.panaderia.model.PanaderoArtesanal;
import co.edu.uniquindio.poo.panaderia.model.PanaderoIndustrial;
import co.edu.uniquindio.poo.panaderia.model.Pedido;
import co.edu.uniquindio.poo.panaderia.model.TipoPan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
   void registraPedidoPendienteSinReservarTiempo() {
       PanaderoArtesanal ana = artesanal("Ana", 100, "E01");
       panaderia.crearPanaderoArtesanal(ana);
       Pedido pedido = pedido("P01", TipoPan.TRADICIONAL, 25);

       assertTrue(panaderia.registrarPedido(pedido));

       assertEquals(EstadoPedido.PENDIENTE, pedido.getEstadoPedido());
       assertEquals(25, pedido.getCantidad());
       assertEquals(1, panaderia.getListaPedidos().size());
       assertEquals(100, ana.getMinutosDisponibles());
       assertNull(pedido.getEmpleado());
       assertEquals(0, pedido.getMinutosReservados());
   }

    @Test
    void rechazaCodigoReutilizadoAunqueElPedidoEsteCancelado() {
        Pedido original = pedido("P01", TipoPan.TRADICIONAL, 25);
        panaderia.registrarPedido(original);
        panaderia.cancelarPedido("P01");

        assertThrows(IllegalArgumentException.class,
                () -> panaderia.registrarPedido(pedido("P01", TipoPan.INTEGRAL, 10)));

        assertEquals(1, panaderia.getListaPedidos().size());
        assertEquals(EstadoPedido.CANCELADO, original.getEstadoPedido());
    }


    @Test
    void rechazaCantidadCeroYDejaVacioElHistorial() {
        assertThrows(IllegalArgumentException.class,
                () -> panaderia.registrarPedido(pedido("P01", TipoPan.TRADICIONAL, 0)));

        assertTrue(panaderia.getListaPedidos().isEmpty());
    }

    //funcionalidad 2. Asignar

    @Test
    void asignaAlPanaderoElegibleQueTardaMenos() {
        PanaderoArtesanal ana = artesanal("Ana", 100, "E01");
        PanaderoIndustrial carlos = industrial("Carlos", 45, "E02");
        panaderia.crearPanaderoArtesanal(ana);
        panaderia.crearPanaderoIndustrial(carlos);
        Pedido pedido = pedido("P01", TipoPan.TRADICIONAL, 25);
        panaderia.registrarPedido(pedido);

        assertTrue(panaderia.asignarPedido("P01"));

        assertEquals(carlos, pedido.getEmpleado());
        assertEquals(45, pedido.getMinutosReservados());
        assertEquals(EstadoPedido.ASIGNADO, pedido.getEstadoPedido());
        assertEquals(0, carlos.getMinutosDisponibles());
        assertEquals(100, ana.getMinutosDisponibles());
    }

    @Test
    void anteEmpateAsignaAlPanaderoPrimeroEnLaLista() {
        PanaderoArtesanal ana = artesanal("Ana", 80, "E01");
        PanaderoArtesanal diana = artesanal("Diana", 80, "E02");
        PanaderoIndustrial carlos = industrial("Carlos", 54, "E03");
        panaderia.crearPanaderoArtesanal(ana);
        panaderia.crearPanaderoArtesanal(diana);
        panaderia.crearPanaderoIndustrial(carlos);
        Pedido pedido = pedido("P01", TipoPan.INTEGRAL, 13);
        panaderia.registrarPedido(pedido);

        panaderia.asignarPedido("P01");

        assertEquals(ana, pedido.getEmpleado());
        assertEquals(80, pedido.getMinutosReservados());
        assertEquals(EstadoPedido.ASIGNADO, pedido.getEstadoPedido());
        assertEquals(0, ana.getMinutosDisponibles());
        assertEquals(80, diana.getMinutosDisponibles());
        assertEquals(54, carlos.getMinutosDisponibles());
    }
    @Test
    void noAsignaSiNadieTieneTiempoSuficienteNiAlCajero() {
        PanaderoIndustrial carlos = industrial("Carlos", 44, "E01");
        Cajero lucia = new Cajero("Lucía", null, 120, "222", "E02", "Caja 1");
        panaderia.crearPanaderoIndustrial(carlos);
        panaderia.crearCajero(lucia);
        Pedido pedido = pedido("P01", TipoPan.TRADICIONAL, 25);
        panaderia.registrarPedido(pedido);

        assertThrows(IllegalStateException.class, () -> panaderia.asignarPedido("P01"));

        assertEquals(EstadoPedido.PENDIENTE, pedido.getEstadoPedido());
        assertNull(pedido.getEmpleado());
        assertEquals(0, pedido.getMinutosReservados());
        assertEquals(44, carlos.getMinutosDisponibles());
        assertEquals(120, lucia.getMinutosDisponibles());
    }

    // funcionalidad 3. Cancelar
    @Test
    void cancelarPedidoAsignadoDevuelveSoloSusMinutosReservados() {
        PanaderoIndustrial carlos = industrial("Carlos", 120, "E01");
        panaderia.crearPanaderoIndustrial(carlos);
        Pedido primero = pedido("P01", TipoPan.TRADICIONAL, 25);
        Pedido segundo = pedido("P02", TipoPan.TRADICIONAL, 25);
        panaderia.registrarPedido(primero);
        panaderia.registrarPedido(segundo);
        panaderia.asignarPedido("P01");
        panaderia.asignarPedido("P02");

        assertEquals(30, carlos.getMinutosDisponibles());
        panaderia.cancelarPedido("P01");

        assertEquals(75, carlos.getMinutosDisponibles());
        assertEquals(EstadoPedido.CANCELADO, primero.getEstadoPedido());
        assertEquals(EstadoPedido.ASIGNADO, segundo.getEstadoPedido());
    }

    @Test
    void cancelarPedidoPendienteLoConservaEnHistorialSinCambiarDisponibilidad() {
        PanaderoArtesanal ana = artesanal("Ana", 100, "E01");
        panaderia.crearPanaderoArtesanal(ana);
        Pedido pedido = pedido("P01", TipoPan.TRADICIONAL, 10);
        panaderia.registrarPedido(pedido);

        panaderia.cancelarPedido("P01");

        assertEquals(EstadoPedido.CANCELADO, pedido.getEstadoPedido());
        assertEquals(1, panaderia.getListaPedidos().size());
        assertEquals(100, ana.getMinutosDisponibles());
    }
    @Test
    void segundoIntentoDeCancelarNoDevuelveDeNuevoElTiempo() {
        PanaderoIndustrial carlos = industrial("Carlos", 120, "E01");
        panaderia.crearPanaderoIndustrial(carlos);
        Pedido pedido = pedido("P01", TipoPan.TRADICIONAL, 25);
        panaderia.registrarPedido(pedido);
        panaderia.asignarPedido("P01");
        panaderia.cancelarPedido("P01");

        assertEquals(120, carlos.getMinutosDisponibles());
        assertThrows(IllegalStateException.class, () -> panaderia.cancelarPedido("P01"));

        assertEquals(120, carlos.getMinutosDisponibles());
        assertEquals(EstadoPedido.CANCELADO, pedido.getEstadoPedido());
    }

    private Pedido pedido(String codigo, TipoPan tipoPan, int cantidad) {
        return new Pedido(tipoPan, cantidad, codigo, "Cliente", EstadoPedido.PENDIENTE, 0, null);
    }

    private PanaderoArtesanal artesanal(String nombre, int minutos, String codigo) {
        return new PanaderoArtesanal(nombre, null, minutos, codigo, codigo);
    }

    private PanaderoIndustrial industrial(String nombre, int minutos, String codigo) {
        return new PanaderoIndustrial(nombre, null, minutos, codigo, codigo);
    }
}

