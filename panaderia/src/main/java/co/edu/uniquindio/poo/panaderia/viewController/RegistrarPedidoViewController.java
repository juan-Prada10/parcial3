package co.edu.uniquindio.poo.panaderia.viewController;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.panaderia.app.Aplicaccion;
import co.edu.uniquindio.poo.panaderia.controller.RegistrarPedidoController;
import co.edu.uniquindio.poo.panaderia.model.EstadoPedido;
import co.edu.uniquindio.poo.panaderia.model.Pedido;
import co.edu.uniquindio.poo.panaderia.model.TipoPan;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrarPedidoViewController {
    private Aplicaccion aplicacion;
    private RegistrarPedidoController registrarPedidoController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTipoPan;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtIngresarCodigo;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtIngresarCliente;

    @FXML
    void registrarEvent(ActionEvent event) {
        registrarAction();

    }

    private void registrarAction() {
        TipoPan tipoPan = TipoPan.valueOf(txtTipoPan.getText().toUpperCase());
        int cantidad = Integer.valueOf(txtCantidad.getText());
        String codigo = txtIngresarCodigo.getText();
        String cliente= txtIngresarCliente.getText();

        Pedido pedido = new Pedido(tipoPan,cantidad,codigo,cliente, EstadoPedido.PENDIENTE,0,null);
        boolean registrado= registrarPedidoController.registrarPedido(pedido);
        if(registrado!=true){
            mostrarMensaje("Informacion","Ya existe un pedido con dicho codigo", Alert.AlertType.WARNING);

        }else{mostrarMensaje("Informacion","Se registro el pedido con exito", Alert.AlertType.WARNING);

        }
    }

    public void mostrarMensaje(String titulo, String mensaje, Alert.AlertType alertType){
        Alert alerta = new Alert(alertType);
        alerta.setTitle("Informacion");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void setApp(Aplicaccion aplicaccion){
        this.aplicacion= aplicaccion;

        registrarPedidoController = new RegistrarPedidoController(aplicaccion.panaderia);
    }

    @FXML
    void initialize() {
        assert txtTipoPan != null : "fx:id=\"txtTipoPan\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert txtCantidad != null : "fx:id=\"txtCantidad\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert txtIngresarCodigo != null : "fx:id=\"txtIngresarCodigo\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert txtIngresarCliente != null : "fx:id=\"txtIngresarCliente\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";

    }


}

