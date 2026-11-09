module co.edu.uniquindio.poo.panaderia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.poo.panaderia to javafx.fxml;
    exports co.edu.uniquindio.poo.panaderia.model;
    exports co.edu.uniquindio.poo.panaderia.app;
    exports co.edu.uniquindio.poo.panaderia.viewController;

    opens co.edu.uniquindio.poo.panaderia.viewController to javafx.fxml;

}