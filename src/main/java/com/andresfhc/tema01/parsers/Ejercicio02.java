package com.andresfhc.tema01.parsers;

import java.util.*;
public class Ejercicio02 {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> cantidades = new TreeMap<>();
        Map<String, Double> totales = new TreeMap<>();
        for (Empleado e:Ejercicio01.parsearEmpleados("datos/empleados.xml")) {
            cantidades.merge(e.getDepartamento(),1,Integer::sum);
            totales.merge(e.getDepartamento(),e.getSalario(),Double::sum);
        }
        System.out.println("Departamento | Nº empleados | Salario medio");
        for (String dep:cantidades.keySet())
            System.out.printf("%s | %d | %.2f%n",dep,cantidades.get(dep),totales.get(dep)/cantidades.get(dep));
    }
}