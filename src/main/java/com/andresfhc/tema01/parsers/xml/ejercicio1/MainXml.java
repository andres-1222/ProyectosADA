package com.andresfhc.tema01.parsers.xml.ejercicio1;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MainXml {
    static void main() {
        try {
            Empleado[] empleados = Ejercicio01.parsearEmpleados(
                    "src/main/java/com/andresfhc/tema01/parsers/xml/ejercicio1/empleados.xml"
            );
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el fichero de empleados");
        } catch (ParserConfigurationException e) {
            System.err.println("Error al leer interpretar el fichero de empleados");//
        } catch (SAXException e) {
            System.err.println("Error al construir el DOM jerárquico de empleados");
        }
    }
}
