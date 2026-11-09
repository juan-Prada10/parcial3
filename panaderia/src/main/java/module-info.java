module co.edu.uniquindio.poo.panaderia {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens co.edu.uniquindio.poo.panaderia to javafx.fxml;
    exports co.edu.uniquindio.poo.panaderia;
}