package tp4MancusoAugusto.src.main.java.com.programacion2.dto;

import tp4MancusoAugusto.src.main.java.com.programacion2.exceptions.StockInsuficienteException;
import tp4MancusoAugusto.src.main.java.com.programacion2.exceptions.VidaUtilInsuficienteException;

import java.util.List;

public class Receta implements Cocinable {

    int tiempoCoccion;
    List<Ingrediente> ingredientes;
    List<Utensillo> utensilios;
    String preparacion;

    public Receta() {
    }

    public Receta(
            int tiempoCoccion,
            List<Ingrediente> ingredientes,
            String preparacion,
            List<Utensillo> utensilios) {

        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
        this.preparacion = preparacion;
    }

    @Override
    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    @Override
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public List<Utensillo> getUtensillos() {
        return utensilios;
    }

    public void setUtensilios(List<Utensillo> utensilios) {
        this.utensilios = utensilios;
    }

    @Override
    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public Boolean sePuedeCocinar(Despensa despensa) throws VidaUtilInsuficienteException, StockInsuficienteException {
        for (Ingrediente ingrediente : getIngredientes()) {
            if (despensa.getDespensaMap().get(ingrediente) != null) {
                if (ingrediente.getCantidad() > despensa.getDespensaMap().get(ingrediente).obtenerCanitdad()) {
                    throw new StockInsuficienteException("Cantidad insuficiente de ".concat(ingrediente.getNombre()));
                }
            }
        }
        for (Utensillo utensillo : getUtensillos()) {
            if (despensa.getDespensaMap().get(utensillo) != null) {
                if (utensillo.getVidaUtil() > despensa.getDespensaMap().get(utensillo).obtenerCanitdad()) {
                    throw new VidaUtilInsuficienteException("Vida insuficiente de ".concat(utensillo.getNombre()));
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "tiempoCoccion=" + tiempoCoccion +
                ", ingredientes=" + ingredientes +
                ", utensilios=" + utensilios +
                ", preparacion='" + preparacion + '\'' +
                '}';
    }

}
