package main.ejercicio3_2;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Liebre extends Corredor {

    private static final long PAUSA_RAPIDA_MS = 50;
    private static final long SIESTA_MS = 11500;

    private boolean yaDurmio = false;

    public Liebre(ProgressBar barra, Label etiqueta, EscuchaCarrera escucha) {
        super("La Liebre", barra, etiqueta, PAUSA_RAPIDA_MS, escucha);
    }

    @Override
    protected String estadoCorriendo() {
        return "¡Está corriendo!";
    }

    @Override
    protected void antesDeAvanzar(double avance) throws InterruptedException {
        if (!yaDurmio && avance >= 0.5) {
            yaDurmio = true;
            mostrarEstado("¡Se durmió!");
            dormir(SIESTA_MS);
            mostrarEstado("¡Despertó y corre de nuevo!");
        }
    }
}

