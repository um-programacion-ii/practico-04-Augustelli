package dto;

import exceptions.StockInsuficienteException;
import exceptions.VidaUtilInsuficienteException;

public interface Despensable {

    Despensable sacar(int cantidad) throws VidaUtilInsuficienteException, StockInsuficienteException;

    int obtenerCanitdad();

    String obtenerNombre();

}
