package co.edu.uniquindio.poo.panaderia.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.panaderia.app.Aplicaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarPedido;

    @FXML
    private Button btnAsignarPedido;

    @FXML
    private Button btnCancelarPedido;
    private Aplicaccion aplicacion;

    @FXML
    void registrarPedidoEvent(ActionEvent event) {
            aplicacion.registrarPedido();

    }

    @FXML
    void asignarPedidoEvent(ActionEvent event) {
        aplicacion.asignarPedido();

    }

    @FXML
    void cancelarPedidoEvent(ActionEvent event) {

    }

    public void setApp(Aplicaccion aplicaccion) {
        this.aplicacion= aplicaccion;
    }

    @FXML
    void initialize() {
        assert btnRegistrarPedido != null : "fx:id=\"btnRegistrarPedido\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnAsignarPedido != null : "fx:id=\"btnAsignarPedido\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnCancelarPedido != null : "fx:id=\"btnCancelarPedido\" was not injected: check your FXML file 'Menu.fxml'.";

    }
}
