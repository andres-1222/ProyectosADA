package com.andresfhc.tema01.parsers;

import org.json.*;
import java.util.*;

public class Ejercicio07 {
    public static void main(String[] args) throws Exception {
        JSONObject inventario = (JSONObject) Util.json("datos/inventario.json");
        JSONArray productos = inventario.getJSONArray("productos");
        Scanner sc = new Scanner(System.in);
        System.out.print("ID del producto: ");
        String buscado = sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < productos.length(); i++) {
            JSONObject producto = productos.getJSONObject(i);
            if (producto.getString("id").equalsIgnoreCase(buscado)) {
                JSONObject ubicacion = producto.getJSONObject("ubicacion");
                System.out.println("Producto: " + producto.getString("nombre"));
                System.out.println("Almacén: " + inventario.getString("almacen"));
                System.out.println("Pasillo: " + ubicacion.getInt("pasillo"));
                System.out.println("Estante: " + ubicacion.getString("estante"));
                encontrado = true;
                break;
            }
        }
        if (!encontrado) System.out.println("Producto no encontrado");
    }
}
