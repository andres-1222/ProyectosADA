package com.andresfhc.tema01.parsers;

import org.w3c.dom.*;
import java.util.*;

public class Ejercicio03 {
    public static void main(String[] args) throws Exception {
        NodeList libros = Util.xml("datos/biblioteca.xml").getElementsByTagName("libro");
        Map<String, Integer> generos = new TreeMap<>();
        for (int i = 0; i < libros.getLength(); i++) {
            Element libro = (Element) libros.item(i);
            System.out.println(libro.getAttribute("isbn") + " | " + Util.texto(libro, "titulo"));
            NodeList listaGeneros = libro.getElementsByTagName("genero");
            for (int j = 0; j < listaGeneros.getLength(); j++) {
                String genero = listaGeneros.item(j).getTextContent().trim();
                generos.merge(genero, 1, Integer::sum);
            }
        }
        System.out.println("Libros por género:");
        generos.forEach((genero, cantidad) -> System.out.println(genero + ": " + cantidad));
    }
}
