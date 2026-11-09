package co.edu.uniquindio.poo.panaderia.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.panaderia.app.Aplicaccion;
import co.edu.uniquindio.poo.panaderia.controller.AsignarPedidoController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class AsignarPedidoViewController {

    private Aplicaccion aplicaccion;
    private AsignarPedidoController asignarPedidoController;

    public void setApp(Aplicaccion aplicaccion){
        this.aplicaccion=aplicaccion;
        asignarPedidoController = new AsignarPedidoController(aplicaccion.panaderia);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAsignar;

    @FXML
    private TextField txtCodigo;

    @FXML
    void asignarPedidoEvent(ActionEvent event) {
        asignarPedidoAction();

    }

    private void asignarPedidoAction() {
        String codigo= txtCodigo.getText();
        boolean asignado=asignarPedidoController.asignarPedido(codigo);
        if (asignado!=true){
            mostrarMensaje("Informacion","No se logro asignar el pedido", Alert.AlertType.WARNING);
        }else{
            mostrarMensaje("Informacion","El pedido fue asignado con exito", Alert.AlertType.WARNING);}
    }

    public void mostrarMensaje(String titulo, String mensaje, Alert.AlertType alertType){
        Alert alerta = new Alert(alertType);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void initialize() {
        assert btnAsignar != null : "fx:id=\"btnAsignar\" was not injected: check your FXML file 'AsignarPedido.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'AsignarPedido.fxml'.";

    }
}

