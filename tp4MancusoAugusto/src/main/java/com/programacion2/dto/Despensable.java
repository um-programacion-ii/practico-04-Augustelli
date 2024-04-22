package tp4MancusoAugusto.src.main.java.com.programacion2.dto;

import tp4MancusoAugusto.src.main.java.com.programacion2.exceptions.StockInsuficienteException;
import tp4MancusoAugusto.src.main.java.com.programacion2.exceptions.VidaUtilInsuficienteException;

public interface Despensable {

    Despensable sacar(int cantidad) throws VidaUtilInsuficienteException, StockInsuficienteException;

    int obtenerCanitdad();

    String obtenerNombre();

}
