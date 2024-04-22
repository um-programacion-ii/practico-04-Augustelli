package dto;

import exceptions.StockInsuficienteException;

public class Ingrediente implements Despensable {

    private String nombre;
    private int cantidad;

    public Ingrediente() {}

    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Cantidad: " + cantidad;
    }

    @Override
    public Despensable sacar(int cantidad) throws StockInsuficienteException {
        if ( this.cantidad - cantidad < 0){
            throw new StockInsuficienteException("Cantidad insuficiente de ".concat(getNombre()));
        }
        this.cantidad -= cantidad;
        return this;

    }

    @Override
    public int obtenerCanitdad() {
        return getCantidad();
    }

    @Override
    public String obtenerNombre() {
        return getNombre();
    }

}
