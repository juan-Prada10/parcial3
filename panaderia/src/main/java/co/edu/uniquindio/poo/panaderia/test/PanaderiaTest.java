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


@Test
void testRegistrarPedido() {
    PanaderoArtesanal ana = new PanaderoArtesanal("Ana", null, 100, "12345", "E01");
    panaderia.crearPanaderoArtesanal(ana);

    Pedido pedido = new Pedido(TipoPan.TRADICIONAL, 25, "P01", "Cliente Ejemplo",
            EstadoPedido.PENDIENTE, 0, null);

    assertTrue(panaderia.registrarPedido(pedido));

    assertEquals(EstadoPedido.PENDIENTE, pedido.getEstadoPedido());
    assertEquals(25, pedido.getCantidad());
    assertEquals(100, ana.getMinutosDisponibles());
}
}
