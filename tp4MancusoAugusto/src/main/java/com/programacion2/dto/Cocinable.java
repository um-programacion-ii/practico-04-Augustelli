package tp4MancusoAugusto.src.main.java.com.programacion2.dto;

import tp4MancusoAugusto.src.main.java.com.programacion2.exceptions.StockInsuficienteException;
import tp4MancusoAugusto.src.main.java.com.programacion2.exceptions.VidaUtilInsuficienteException;

import java.util.List;

public interface Cocinable {
    Boolean sePuedeCocinar(Despensa despensa) throws VidaUtilInsuficienteException, StockInsuficienteException;
    String getPreparacion();
    List<Ingrediente> getIngredientes();
    List<Utensillo> getUtensillos();
    int getTiempoCoccion();


}
