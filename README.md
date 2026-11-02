# Boletín 03 - XML y JSON (datasets reales)

Código en `src/main/java/com/andresfhc/tema01/parsers`.

## Configuración
1. Abre la carpeta `Boletin03_XML_JSON_Java` en IntelliJ como proyecto Gradle.
2. Sincroniza Gradle para descargar `org.json`.
3. Ejecuta la clase `Ejercicio01` ... `Ejercicio08` individualmente desde IntelliJ.
4. **Directorio de trabajo**: la raíz del proyecto (`Boletin03_XML_JSON_Java`), porque el código utiliza rutas `datos/*.xml` y `datos/*.json`.

## Ficheros
La carpeta `datos/` incluye los seis datasets que has subido. En `alumnos.json` se han quitado exclusivamente las comas sobrantes antes de `}` y `]`, que impedían que el archivo fuera JSON estrictamente válido. Los campos y los valores se mantienen.

## Estructura
- Ejercicios 01-04: XML DOM estándar (sin dependencias adicionales).
- Ejercicios 05-08: `org.json` (dependencia en `build.gradle.kts`).
- Ejercicio 03 cuenta **todos** los géneros de cada libro.
- Ejercicio 07 lee `productos[].ubicacion`.
- Ejercicio 08 lee `peliculas[].puntuaciones.imdb` y `.rt`.

## Comprobaciones con los datasets
- Ejercicio 02: Desarrollo (2 empleados): 36250.63 EUR; Soporte: 28500.00 EUR; Marketing: 31000.00 EUR.
- Ejercicio 03: Tecnología aparece en los 3 libros.
- Ejercicio 04: P-1001 = 84.48 EUR, P-1002 = 94.85 EUR.
- Ejercicio 06: nota más alta Elena Prieto (Acceso a datos, 9.7); media más alta Elena Prieto (9.2).
- Ejercicio 08: El algoritmo invisible (8.30); Compiladores: El origen (7.25); Overflow (6.50).

**Nota:** se ha adaptado el código a los datasets recibidos. Si el enunciado original exige una forma de presentación concreta, contrástalo con el boletín antes de entregar.
