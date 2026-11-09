package co.edu.uniquindio.poo.panaderia.viewController;

import co.edu.uniquindio.poo.panaderia.app.Aplicaccion;
import co.edu.uniquindio.poo.panaderia.controller.CancelarPedidoController;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CancelarPedidoViewController {

    private Aplicaccion aplicaccion;
    private CancelarPedidoController cancelarPedidoController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodigo;

    @FXML
    private Button btnCancelarPedido;

    @FXML
    void cancelarPedidoEvent(ActionEvent event) {
        cancelarPedidoAction();

    }

    public void cancelarPedidoAction() {

        String codigo = txtCodigo.getText();
        boolean cancelado = cancelarPedidoController.cancelarPedido(codigo);
        if (cancelado!=true){
            mostrarMensaje("Informacion", "El pedido no fue posible de cancelar", Alert.AlertType.WARNING);
        }else{mostrarMensaje("Informacion", "El pedidose cancelo con exito", Alert.AlertType.WARNING);}
    }

    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType alertType) {
        Alert alerta= new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }


    public void setApp(Aplicaccion aplicaccion){
        this.aplicaccion=aplicaccion;
        cancelarPedidoController= new CancelarPedidoController(aplicaccion.panaderia);
    }

    @FXML
    void initialize() {
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'CancelarPedido.fxml'.";
        assert btnCancelarPedido != null : "fx:id=\"btnCancelarPedido\" was not injected: check your FXML file 'CancelarPedido.fxml'.";

    }
}

