package utilidades; //

import interfaces.ArreglosInterface;

public class ManejadorLista<T> implements ArreglosInterface<T> { //

    @Override
    public T[] regresarReversa(T[] arreglo)
            throws IllegalArgumentException {

        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }

        int n = arreglo.length;

        T[] reverso = (T[]) new Object[n];

        for (int i = 0; i < n; i++) {
            reverso[i] = arreglo[n - 1 - i];
        }

        return reverso;
    }

    @Override
    public T[] agregarElemento(T[] arreglo, T elemento)
            throws IllegalArgumentException {

        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento a agregar no puede ser nulo.");
        }

        int n = arreglo.length;


        T[] nuevoArreglo = (T[]) new Object[n + 1];

        for (int i = 0; i < n; i++) {
            nuevoArreglo[i] = arreglo[i];
        }

        nuevoArreglo[n] = elemento;

        return nuevoArreglo;
    }

    @Override
    public T buscarElemento(T[] arreglo, int posicion)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }

        if (posicion < 0 || posicion >= arreglo.length) {
            throw new IndexOutOfBoundsException("Posición fuera de rango. Se pidió " + posicion +
                    " pero el tamaño es " + arreglo.length);
        }


        return arreglo[posicion];
    }

    @Override
    public T[] eliminarElemento(T[] arreglo, int posicion)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }

        if (posicion < 0 || posicion >= arreglo.length) {
            throw new IndexOutOfBoundsException("Posición fuera de rango. Se pidió " + posicion +
                    " pero el tamaño es " + arreglo.length);
        }

        int n = arreglo.length;


        T[] nuevoArreglo = (T[]) new Object[n - 1];


        for (int i = 0; i < posicion; i++) {
            nuevoArreglo[i] = arreglo[i];
        }

        for (int i = posicion + 1; i < n; i++) {
            nuevoArreglo[i - 1] = arreglo[i];
        }

        return nuevoArreglo;
    }
}
