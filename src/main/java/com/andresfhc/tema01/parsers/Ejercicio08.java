package com.andresfhc.tema01.parsers;

import org.json.*;
import java.util.*;

public class Ejercicio08 {
    public static void main(String[] args) throws Exception {
        JSONArray peliculas = Util.lista(Util.json("datos/peliculas.json"), "peliculas");
        List<JSONObject> lista = new ArrayList<>();
        Set<String> generos = new TreeSet<>();
        for (int i = 0; i < peliculas.length(); i++) {
            JSONObject pelicula = peliculas.getJSONObject(i);
            JSONObject puntuaciones = pelicula.getJSONObject("puntuaciones");
            double media = (puntuaciones.getDouble("rt") / 10.0 + puntuaciones.getDouble("imdb")) / 2.0;
            pelicula.put("mediaCalculada", media);
            lista.add(pelicula);
            JSONArray gs = pelicula.getJSONArray("generos");
            for (int j = 0; j < gs.length(); j++) generos.add(gs.getString(j));
        }
        lista.sort((a, b) -> Double.compare(b.getDouble("mediaCalculada"), a.getDouble("mediaCalculada")));
        System.out.println("Películas ordenadas por puntuación media:");
        for (JSONObject pelicula : lista) {
            System.out.printf("%s | %.2f%n", pelicula.getString("titulo"), pelicula.getDouble("mediaCalculada"));
        }
        System.out.println("Géneros sin repetir (orden alfabético):");
        generos.forEach(System.out::println);
    }
}
