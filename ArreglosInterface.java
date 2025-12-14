package interfaces;

public interface ArreglosInterface<T> {


    T[] regresarReversa(T[] arreglo)
            throws IllegalArgumentException, IllegalStateException;


    T[] agregarElemento(T[] arreglo, T elemento)
            throws IllegalArgumentException;


    T buscarElemento(T[] arreglo, int posicion)
            throws IllegalArgumentException, IndexOutOfBoundsException;


    T[] eliminarElemento(T[] arreglo, int posicion)
            throws IllegalArgumentException, IndexOutOfBoundsException;
}