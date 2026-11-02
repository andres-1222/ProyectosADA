package com.andresfhc.tema01.parsers;

import org.w3c.dom.*;
import java.time.LocalDate;
public class Ejercicio01 {
    public static Empleado[] parsearEmpleados(String ruta) throws Exception {
        NodeList nodos = Util.xml(ruta).getElementsByTagName("empleado");
        Empleado[] empleados = new Empleado[nodos.getLength()];
        for (int i=0; i<nodos.getLength(); i++) {
            Element e=(Element)nodos.item(i);
            Element salario=(Element)e.getElementsByTagName("salario").item(0);
            empleados[i]=new Empleado(e.getAttribute("id"), Util.texto(e,"nombre"),
                Util.texto(e,"departamento"), salario.getAttribute("moneda"),
                Double.parseDouble(salario.getTextContent().trim()),LocalDate.parse(Util.texto(e,"fechaAlta")));
        }
        return empleados;
    }
    public static void main(String[] args) throws Exception {
        for (Empleado e:parsearEmpleados("datos/empleados.xml"))
            System.out.println(e.getId()+" | "+e.getNombre()+" | "+e.getSalario());
    }
}