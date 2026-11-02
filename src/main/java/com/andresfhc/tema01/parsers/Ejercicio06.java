package com.andresfhc.tema01.parsers;

import org.json.*;
public class Ejercicio06 {
    public static Alumno[] cargar(String ruta) throws Exception {
        JSONArray datos=Util.lista(Util.json(ruta),"alumnos");
        Alumno[] alumnos=new Alumno[datos.length()];
        for(int i=0;i<datos.length();i++) {
            JSONObject a=datos.getJSONObject(i);
            JSONArray listaNotas=a.getJSONArray("notas");
            Nota[] notas=new Nota[listaNotas.length()];
            for(int j=0;j<listaNotas.length();j++) {
                JSONObject n=listaNotas.getJSONObject(j);
                notas[j]=new Nota(n.getString("asignatura"),n.getDouble("nota"));
            }
            alumnos[i]=new Alumno(a.getString("nombre"),a.getString("fechaNacimiento"),notas);
        }
        return alumnos;
    }
    public static void main(String[] args) throws Exception {
        double mejorNota = -1;
        double mejorMedia = -1;
        String mejorAlumnoNota="",mejorAsignatura="",mejorAlumnoMedia="";
        for(Alumno a:cargar("datos/alumnos.json")) {
            double suma=0;
            for(Nota n:a.getNotas()) {
                suma+=n.getCalificacion();
                if(n.getCalificacion()>mejorNota){mejorNota=n.getCalificacion();mejorAlumnoNota=a.getNombre();mejorAsignatura=n.getAsignatura();}
            }
            if(a.getNotas().length==0) continue;
            double media=suma/a.getNotas().length;
            if(media>mejorMedia){mejorMedia=media;mejorAlumnoMedia=a.getNombre();}
        }
        System.out.println("Nota más alta: "+mejorAlumnoNota+" | "+mejorAsignatura+" | "+mejorNota);
        System.out.println("Media más alta: "+mejorAlumnoMedia+" | "+mejorMedia);
    }
}