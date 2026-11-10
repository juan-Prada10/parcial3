package co.edu.uniquindio.poo.panaderia.app;
import co.edu.uniquindio.poo.panaderia.controller.AsignarPedidoController;
import co.edu.uniquindio.poo.panaderia.model.*;
import co.edu.uniquindio.poo.panaderia.viewController.AsignarPedidoViewController;
import co.edu.uniquindio.poo.panaderia.viewController.CancelarPedidoViewController;
import co.edu.uniquindio.poo.panaderia.viewController.MenuViewController;
import co.edu.uniquindio.poo.panaderia.viewController.RegistrarPedidoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


public class Aplicaccion extends Application {

    private Stage primaryStage;
    public static Panaderia panaderia = new Panaderia("El trigal", "525832");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Panaderia el trigal");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicaccion.class.getResource("/co/edu/uniquindio/poo/panaderia/Menu.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            MenuViewController menuViewController= loader.getController();
            menuViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch();
    }

    public void asignarPedido() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicaccion.class.getResource("/co/edu/uniquindio/poo/panaderia/AsignarPedido.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            AsignarPedidoViewController asignarPedidoViewController= loader.getController();
            asignarPedidoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void registrarPedido() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicaccion.class.getResource("/co/edu/uniquindio/poo/panaderia/RegistrarPedido.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            RegistrarPedidoViewController registrarPedidoViewController= loader.getController();
            registrarPedidoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cancelarPedido() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicaccion.class.getResource("/co/edu/uniquindio/poo/panaderia/CancelarPedido.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            CancelarPedidoViewController cancelarPedidoViewController= loader.getController();
            cancelarPedidoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void inicializarData() {

        Pedido pedido1= new Pedido(TipoPan.TRADICIONAL,50,"12345","La quinta", EstadoPedido.PENDIENTE,0, null);
        Pedido pedido2= new Pedido(TipoPan.INTEGRAL,100,"12346","Pan de bono", EstadoPedido.PENDIENTE,0, null);
        Pedido pedido3= new Pedido(TipoPan.TRADICIONAL,200,"12347","La sexta", EstadoPedido.PENDIENTE,0, null);

        Empleado empleado1= new PanaderoArtesanal("Juan",null,400,"1094671","2345");
        Empleado empleado2= new PanaderoIndustrial("Jairo",null,400,"1094672","2346");
        Empleado empleado3= new PanaderoArtesanal("Diego",null,400,"1094673","2347");
        Empleado empleado4= new Cajero("Sophia",null,400,"1094674","2348","caja1");

        panaderia.crearPedido(pedido1);
        panaderia.crearPedido(pedido2);
        panaderia.crearPedido(pedido3);
        panaderia.crearPanaderoArtesanal(empleado1);
        panaderia.crearPanaderoArtesanal(empleado3);
        panaderia.crearPanaderoIndustrial(empleado2);
        panaderia.crearCajero(empleado4);


    }

}

