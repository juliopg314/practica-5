/*
 * ESTE ARCHIVO REEMPLAZA AL DE LA PRÁCTICA 4: Proyecto/src/Main.java
 */

// Importamos los paquetes que creamos
import modulos.*;
import utilidades.ManejadorLista; // La nueva clase genérica
import BD.ManejadorArchivos;    // La nueva clase de BD

/**
 * Clase principal para la Práctica 05.
 * Este programa lee 10 nombres de la terminal, los procesa,
 * los guarda en archivos, añade nuevos usuarios y lee los
 * resultados finales.
 */
public class Main {

    // Definimos la ubicación de nuestros archivos de "Base de Datos"
    // como constantes para fácil acceso [cite: 142-145].
    private static final String FILE_EMPLEADOS = "BD/Empleados.txt";
    private static final String FILE_ADMINS = "BD/Administradores.txt";

    public static void main(String[] args) {

        // --- 1. ENTRADA POR TERMINAL --- [cite: 215]
        // Verificamos que se recibieron exactamente 10 nombres
        if (args.length != 10) {
            System.err.println("Error: Se esperaban 10 nombres como argumentos.");
            System.err.println("Ejemplo de uso:");
            System.err.println("java -cp out Main \"Juan\" \"Maria\" \"Carlos\" \"Ana\" \"Luis\" \"Laura\" \"Pedro\" \"Sofia\" \"Miguel\" \"Elena\"");
            return; // Termina el programa si no hay 10 nombres
        }

        // Imprimimos la entrada recibida, como en el ejemplo
        System.out.println("ENTRADA RECIBIDA (10 nombres) [cite: 238]");
        for (int i = 0; i < args.length; i++) {
            System.out.println((i + 1) + ". " + args[i]);
        }
        System.out.println("PROCESANDO DATOS ===");

        // Instanciamos nuestras clases de utilidades
        ManejadorArchivos manejadorBD = new ManejadorArchivos();

        // Creamos instancias de nuestro ManejadorLista genérico
        // Una para manejar Empleados, otra para Administradores
        ManejadorLista<Empleado> listaEmpleados = new ManejadorLista<>();
        ManejadorLista<Administrador> listaAdmins = new ManejadorLista<>();

        // --- 2. PROCESAMIENTO ---
        // Usamos un try-catch porque la creación de Usuarios
        // (Empleado/Administrador) puede lanzar una IllegalArgumentException
        try {
            int N = args.length; // 10
            Empleado[] empleados = new Empleado[N];
            Administrador[] admins = new Administrador[N];

            // 2.1 Crear arreglos de Empleado y Administrador [cite: 218-220]
            for (int i = 0; i < N; i++) {
                String nombre = args[i];
                // Creamos un correo genérico como pide el PDF [cite: 219-220]
                String email = nombre.toLowerCase() + "@empresa.com";

                // (Recuerda que esto puede fallar si el nombre es < 5 chars)
                empleados[i] = new Empleado(nombre, email);
                admins[i] = new Administrador(nombre, email);
            }
            System.out.println("Usuarios creados automáticamente.");

            // 2.2 Revertir el orden de ambos arreglos [cite: 221]
            Empleado[] empleadosReverso = listaEmpleados.regresarReversa(empleados);
            Administrador[] adminsReverso = listaAdmins.regresarReversa(admins);
            System.out.println("✔ Listas revertidas correctamente.");

            // 2.3 Convertir arreglos de Objetos a arreglos de Strings
            // (Usando el método toString() que definimos en Usuario.java)
            String[] stringsEmpleados = convertirAStrings(empleadosReverso);
            String[] stringsAdmins = convertirAStrings(adminsReverso);

            // 2.4 Guardar la lista revertida en archivos (sobrescribiendo) [cite: 222-224]
            manejadorBD.escribirArregloAArchivo(stringsEmpleados, FILE_EMPLEADOS);
            manejadorBD.escribirArregloAArchivo(stringsAdmins, FILE_ADMINS);
            System.out.println("✔ Archivos creados con 10 usuarios.");

            // 2.5 Crear y añadir el nuevo usuario (el #11) [cite: 225-226]
            // El ejemplo usa "Roberto" [cite: 258, 280]
            Empleado nuevoEmpleado = new Empleado("Roberto", "roberto@empresa.com");
            Administrador nuevoAdmin = new Administrador("Roberto", "roberto@empresa.com");

            // 2.6 Añadir los nuevos usuarios al FINAL del archivo (append) [cite: 227-228]
            manejadorBD.escribirLineaAlFinal(nuevoEmpleado.toString(), FILE_EMPLEADOS);
            manejadorBD.escribirLineaAlFinal(nuevoAdmin.toString(), FILE_ADMINS);
            System.out.println("✔ Nuevos usuarios añadidos al archivo.");

            // --- 3. SALIDA ESTÁNDAR ---
            // 3.1 Leer los archivos COMPLETOS (con 11 líneas) [cite: 229]
            String[] lineasAdmins = manejadorBD.leerArchivoComoArreglo(FILE_ADMINS);
            String[] lineasEmpleados = manejadorBD.leerArchivoComoArreglo(FILE_EMPLEADOS);

            // 3.2 Mostrar lista de 11 Administradores [cite: 231-234]
            System.out.println("\n=== RESULTADO FINAL (11 administradores) ===");
            imprimirLineas(lineasAdmins);

            // 3.3 Mostrar lista de 11 Empleados [cite: 232-234]
            System.out.println("\n=== RESULTADO FINAL (11 empleados) ===");
            imprimirLineas(lineasEmpleados);

        } catch (IllegalArgumentException e) {
            // Captura cualquier error de validación (ej. nombre corto)
            System.err.println("Error al procesar los usuarios: " + e.getMessage());
        } catch (Exception e) {
            // Captura cualquier otro error (ej. de archivos)
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método auxiliar genérico para convertir un arreglo de cualquier tipo
     * a un arreglo de Strings, usando el método .toString() de cada objeto.
     * @param <T> El tipo genérico del arreglo.
     * @param arreglo El arreglo de objetos (Ej. Empleado[] o Administrador[]).
     * @return Un arreglo de String[].
     */
    private static <T> String[] convertirAStrings(T[] arreglo) {
        String[] strings = new String[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            strings[i] = arreglo[i].toString();
        }
        return strings;
    }

    /**
     * Método auxiliar para imprimir un arreglo de líneas de texto
     * con numeración (1., 2., 3., etc.).
     * @param lineas El arreglo de String[] leído del archivo.
     */
    private static void imprimirLineas(String[] lineas) {
        if (lineas == null || lineas.length == 0) {
            System.out.println("Archivo vacío o no encontrado.");
            return;
        }
        for (int i = 0; i < lineas.length; i++) {
            // Se imprime con formato: " 1. Elena, elena@empresa.com,Administrador"
            System.out.println(" " + (i + 1) + ". " + lineas[i]);
        }
    }
}