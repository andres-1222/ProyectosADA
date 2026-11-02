package com.andresfhc.tema01.parsers;

import org.w3c.dom.*;
import java.util.*;
public class Ejercicio04 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.print("ID del pedido: "); String buscado=sc.nextLine();
        NodeList pedidos=Util.xml("datos/pedidos.xml").getElementsByTagName("pedido");
        boolean encontrado=false;
        for(int i=0;i<pedidos.getLength();i++) {
            Element pedido=(Element)pedidos.item(i);
            if(!pedido.getAttribute("id").equals(buscado)) continue;
            encontrado=true;
            NodeList items=pedido.getElementsByTagName("item");
            double total=0;
            for(int j=0;j<items.getLength();j++) {
                Element item=(Element)items.item(j);
                int cantidad=Integer.parseInt(Util.texto(item,"cantidad"));
                double precio=Double.parseDouble(Util.texto(item,"precioUnitario"));
                double subtotal=cantidad*precio; total+=subtotal;
                System.out.printf("Item %d: %d x %.2f = %.2f%n",j+1,cantidad,precio,subtotal);
            }
            double declarado=Double.parseDouble(Util.texto(pedido,"total"));
            System.out.printf("Calculado %.2f | XML %.2f | Coincide: %b%n",total,declarado,Math.abs(total-declarado)<0.001);
        }
        if(!encontrado) System.out.println("Pedido no encontrado");
    }
}