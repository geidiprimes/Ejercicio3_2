module main.ejercicio3_2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens main.ejercicio3_2 to javafx.fxml;
    exports main.ejercicio3_2;
}
