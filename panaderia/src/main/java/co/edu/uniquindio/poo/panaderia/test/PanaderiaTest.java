package main.java.co.edu.uniquindio.poo.panaderia.test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;
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

    @Test
    void registrar_pedidoValido_quedaPendienteYConservaCantidad() {
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
}

