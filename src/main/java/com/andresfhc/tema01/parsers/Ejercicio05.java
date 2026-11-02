package com.andresfhc.tema01.parsers;

import org.json.*;
public class Ejercicio05 {
    public static void main(String[] args) throws Exception {
        JSONArray alumnos=Util.lista(Util.json("datos/alumnos.json"),"alumnos");
        for(int i=0;i<alumnos.length();i++) {
            JSONObject a=alumnos.getJSONObject(i);
            System.out.println(a.getString("nombre")+" | "+a.getString("fechaNacimiento"));
        }
    }
}