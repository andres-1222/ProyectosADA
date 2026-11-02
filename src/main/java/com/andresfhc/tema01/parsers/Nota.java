package com.andresfhc.tema01.parsers;

public class Nota {
    private final String asignatura; private final double calificacion;
    public Nota(String asignatura,double calificacion){this.asignatura=asignatura;this.calificacion=calificacion;}
    public String getAsignatura(){return asignatura;}
    public double getCalificacion(){return calificacion;}
}