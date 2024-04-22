package dto;

import exceptions.StockInsuficienteException;
import exceptions.VidaUtilInsuficienteException;

import java.util.List;

public interface Cocinable {
    Boolean sePuedeCocinar(Despensa despensa) throws VidaUtilInsuficienteException, StockInsuficienteException;
    String getPreparacion();
    List<Ingrediente> getIngredientes();
    List<Utensillo> getUtensillos();
    int getTiempoCoccion();


}
