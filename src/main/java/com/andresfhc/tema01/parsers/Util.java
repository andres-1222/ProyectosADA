package com.andresfhc.tema01.parsers;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.nio.file.*;
import org.json.*;
public class Util {
    private Util() {}
    public static Document xml(String ruta) throws Exception {
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        fabrica.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        Document documento = fabrica.newDocumentBuilder().parse(Path.of(ruta).toFile());
        documento.getDocumentElement().normalize();
        return documento;
    }
    public static String texto(Element e, String etiqueta) {
        return e.getElementsByTagName(etiqueta).item(0).getTextContent().trim();
    }
    public static Object json(String ruta) throws Exception {
        return new JSONTokener(Files.readString(Path.of(ruta))).nextValue();
    }
    public static JSONArray lista(Object raiz, String clave) {
        return raiz instanceof JSONArray ? (JSONArray) raiz : ((JSONObject) raiz).getJSONArray(clave);
    }
}