/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 * 
 * Interfaz que define un método para ordenar un arreglo genérico.
 *
 * @param <T> el tipo de elementos en el arreglo que deben ser comparables entre sí.
 */
public interface IGenericSort<T> {

    /**
     * Ordena el arreglo dado.
     *
     * @param arr el arreglo a ser ordenado.
     * @return el arreglo ordenado.
     */
    public T[] sort(T[] arr);
}