package main.ejercicio3_2;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public abstract class Corredor implements Runnable {

    private static final double PASO = 0.01;

    private final String nombre;
    private final ProgressBar barra;
    private final Label etiqueta;
    private final long pausaMs;
    private final EscuchaCarrera escucha;

    protected Corredor(String nombre, ProgressBar barra, Label etiqueta,
                       long pausaMs, EscuchaCarrera escucha) {
        this.nombre = nombre;
        this.barra = barra;
        this.etiqueta = etiqueta;
        this.pausaMs = pausaMs;
        this.escucha = escucha;
    }

    public String getNombre() {
        return nombre;
    }

    protected abstract String estadoCorriendo();

    protected void antesDeAvanzar(double avance) throws InterruptedException {
    }

    protected void mostrarEstado(String estado) {
        Platform.runLater(() -> etiqueta.setText(nombre + ": " + estado));
    }

    protected void dormir(long ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    @Override
    public void run() {
        double avance = 0;
        mostrarEstado(estadoCorriendo());
        try {
            while (avance < 1.0) {
                antesDeAvanzar(avance);
                avance = Math.min(1.0, avance + PASO);
                final double valor = avance;
                Platform.runLater(() -> barra.setProgress(valor));
                dormir(pausaMs);
            }
            escucha.corredorLlego(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}