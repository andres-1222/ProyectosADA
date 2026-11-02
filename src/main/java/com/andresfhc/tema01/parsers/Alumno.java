package com.andresfhc.tema01.parsers;

public class Alumno {
    private final String nombre, fechaNacimiento; private final Nota[] notas;
    public Alumno(String nombre,String fechaNacimiento,Nota[] notas){this.nombre=nombre;this.fechaNacimiento=fechaNacimiento;this.notas=notas;}
    public String getNombre(){return nombre;}
    public String getFechaNacimiento(){return fechaNacimiento;}
    public Nota[] getNotas(){return notas;}
}