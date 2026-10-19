package main.ejercicio3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class CarreraController {

    @FXML private Button btnIniciar;
    @FXML private Label lblLiebre;
    @FXML private ProgressBar barraLiebre;
    @FXML private Label lblTortuga;
    @FXML private ProgressBar barraTortuga;

    private final List<Corredor> corredores = new ArrayList<>();
    private final List<Label> etiquetas = new ArrayList<>();

    @FXML
    private void iniciarCarrera() {
        btnIniciar.setDisable(true);
        barraLiebre.setProgress(0);
        barraTortuga.setProgress(0);

        corredores.clear();
        etiquetas.clear();

        AtomicInteger llegadas = new AtomicInteger(0);

        EscuchaCarrera escucha = corredor -> {
            int lugar = llegadas.incrementAndGet();
            Platform.runLater(() -> {
                Label etiqueta = etiquetaDe(corredor);
                if (lugar == 1) {
                    etiqueta.setText(corredor.getNombre() + ": ¡Ganó la carrera!");
                } else {
                    etiqueta.setText(corredor.getNombre() + ": ¡Llegó a la meta!");
                }
                if (lugar == corredores.size()) {
                    btnIniciar.setDisable(false);
                }
            });
        };

        corredores.add(new Liebre(barraLiebre, lblLiebre, escucha));
        etiquetas.add(lblLiebre);
        corredores.add(new Tortuga(barraTortuga, lblTortuga, escucha));
        etiquetas.add(lblTortuga);

        for (Corredor corredor : corredores) {
            Thread hilo = new Thread(corredor);
            hilo.setDaemon(true);
            hilo.start();
        }
    }

    private Label etiquetaDe(Corredor corredor) {
        return etiquetas.get(corredores.indexOf(corredor));
    }
}
