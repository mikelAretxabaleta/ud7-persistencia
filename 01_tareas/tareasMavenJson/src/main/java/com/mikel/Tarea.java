package com.mikel;

public class Tarea {


    private String titulo;
    private boolean completada;

    public Tarea(String titulo, boolean completada) {
        this.titulo = titulo;
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", completada=" + completada +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isCompletada() {
        return completada;
    }
}
