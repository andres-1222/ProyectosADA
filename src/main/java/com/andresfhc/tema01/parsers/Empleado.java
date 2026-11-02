package com.andresfhc.tema01.parsers;

import java.time.LocalDate;
public class Empleado {
    private final String id, nombre, departamento, moneda;
    private final double salario;
    private final LocalDate fechaAlta;
    public Empleado(String id, String nombre, String departamento, String moneda, double salario, LocalDate fechaAlta) {
        this.id=id; this.nombre=nombre; this.departamento=departamento;
        this.moneda=moneda; this.salario=salario; this.fechaAlta=fechaAlta;
    }
    public String getId(){return id;}
    public String getNombre(){return nombre;}
    public String getDepartamento(){return departamento;}
    public String getMoneda(){return moneda;}
    public double getSalario(){return salario;}
    public LocalDate getFechaAlta(){return fechaAlta;}
    @Override public String toString(){return id+" | "+nombre+" | "+salario+" "+moneda;}
}