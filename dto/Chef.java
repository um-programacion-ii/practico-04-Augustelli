package dto;

import exceptions.StockInsuficienteException;
import exceptions.VidaUtilInsuficienteException;

import java.util.List;
import java.util.concurrent.Callable;

public class Chef implements Callable<Void> {

    String nombre;
    Despensa despensa;
    int estrellasMichelin;
    List<Cocinable> recetas;

    private Despensable estante;


    public Chef() {}

    public Chef(String nombre, Despensa despensa, int estrellasMichelin, List<Cocinable> recetas) {
        this.nombre = nombre;
        this.despensa = despensa;
        this.estrellasMichelin = estrellasMichelin;
        this.recetas = recetas;
        this.estante = Estante.getInstance();

    }

    @Override
    public String toString() {
        return "Chef{" +
                "nombre='" + nombre + '\'' +
                ", despensa=" + despensa +
                ", estrellasMichelin=" + estrellasMichelin +
                '}';
    }

    public List<Cocinable> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Cocinable> recetas) {
        this.recetas = recetas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Despensa getDespensa() {
        return despensa;
    }

    public void setDespensa(Despensa despensa) {
        this.despensa = despensa;
    }

    public int getEstrellasMichelin() {
        return estrellasMichelin;
    }

    public void setEstrellasMichelin(int estrellasMichelin) {
        this.estrellasMichelin = estrellasMichelin;
    }

    public void cocinar (Cocinable cocinable) throws VidaUtilInsuficienteException, StockInsuficienteException, InterruptedException {
            if (cocinable.sePuedeCocinar(despensa)){
                System.out.println("Cocinando ".concat(cocinable.getClass().getName()));
                wait(cocinable.getTiempoCoccion());
            }else{
                throw new VidaUtilInsuficienteException("No se puede cocinar ".concat(cocinable.getClass().getName()));
            }
    }


    @Override
    public Void call() throws VidaUtilInsuficienteException, StockInsuficienteException {
        for (Cocinable receta : getRecetas()){
            try {
                cocinar(receta);
            } catch (VidaUtilInsuficienteException ve){
                throw new VidaUtilInsuficienteException("Vida insuficiente del utensillo ".concat(getNombre()));
            }
            catch (StockInsuficienteException se){
                throw  new StockInsuficienteException("Stock insuficiente de ".concat(getNombre()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
