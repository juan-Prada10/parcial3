module co.edu.uniquindio.poo.panaderia {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.panaderia to javafx.fxml;
    exports co.edu.uniquindio.poo.panaderia;
}