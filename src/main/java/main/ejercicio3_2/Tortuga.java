/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.ejercicio3_2;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Tortuga extends Corredor {

    private static final long PAUSA_LENTA_MS = 150;

    public Tortuga(ProgressBar barra, Label etiqueta, EscuchaCarrera escucha) {
        super("La Tortuga", barra, etiqueta, PAUSA_LENTA_MS, escucha);
    }

    @Override
    protected String estadoCorriendo() {
        return "¡Está corriendo!";
    }
}
