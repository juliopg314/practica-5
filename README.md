# Práctica 5: Persistencia de Datos y Clases Genéricas

## Objetivo
El objetivo de esta práctica es implementar la persistencia de datos básica utilizando archivos de texto (`.txt`) para simular una base de datos. Además, se aplican conceptos de Programación Genérica para manipular listas de diferentes tipos de objetos (Empleados y Administradores) con una sola clase manejadora.

## Descripción
Este programa funciona como un sistema de procesamiento por lotes que recibe datos desde la terminal y los almacena externamente. El flujo de ejecución es el siguiente:

1.  **Entrada de Datos:** Recibe exactamente 10 nombres de usuarios a través de los argumentos de la línea de comandos (CLI).
2.  **Procesamiento Genérico:**
    - Crea objetos de tipo `Empleado` y `Administrador` usando los nombres recibidos.
    - Utiliza una clase genérica (`ManejadorLista<T>`) para invertir el orden de los registros en memoria.
3.  **Persistencia (Base de Datos):**
    - Escribe la lista invertida en archivos de texto dentro de una carpeta `BD` (`Empleados.txt` y `Administradores.txt`).
    - Realiza una operación de "Append" (añadir al final) para insertar un usuario extra ("Roberto") directamente en el archivo, sin borrar los datos anteriores.
4.  **Lectura:** Finalmente, lee los archivos completos (ahora con 11 registros) y los muestra en consola.

## Tecnologías utilizadas
- **Java (JDK):** Lenguaje principal.
- **Java I/O:** Clases `File`, `FileWriter`, `BufferedReader` para manejo de archivos.
- **Genéricos:** Uso de `<T>` para reutilización de código.
- **Argumentos de Main:** Manejo de `String[] args`.
- **Git & GitHub:** Control de versiones.

## Evidencias
![Ejecución con 10 argumentos y lectura de archivos](ruta_de_tu_captura.png)

*(La imagen debe mostrar la "ENTRADA RECIBIDA", el mensaje de "Archivos creados" y el "RESULTADO FINAL" con 11 usuarios)*

## Instrucciones de ejecución
**Importante:** Este programa requiere recibir argumentos al momento de ejecutarse.

1. **Clonar el repositorio:**
   ```bash
   git clone [URL-DEL-REPOSITORIO]
   javac -d out src/Main.java src/modulos/*.java src/utilidades/*.java src/BD/*.java
   java -cp out Main "Juan" "Maria" "Carlos" "Ana" "Luis" "Laura" "Pedro" "Sofia" "Miguel" "Elena"
