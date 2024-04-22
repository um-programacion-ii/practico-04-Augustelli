package dto;

import exceptions.VidaUtilInsuficienteException;

public class Utensillo  implements Reutilizable, Despensable {
    private int vidaUtil;
    private String nombre;

    public Utensillo() {}

    public Utensillo(String nombre, int vidaUtil) {
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
    }

    @Override
    public Despensable sacar(int cantidad) throws VidaUtilInsuficienteException {
        if ( this.vidaUtil - cantidad < 0){
            throw new VidaUtilInsuficienteException("Vida útil insuficiente de ".concat(getNombre()));
        }
        this.vidaUtil -= cantidad;
        return this;

    }

    @Override
    public int obtenerCanitdad() {
        return getVidaUtil();
    }

    @Override
    public String obtenerNombre() {
        return getNombre();
    }

    @Override
    public int getVidaUtil() {
        return vidaUtil;
    }

    @Override
    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Vida util: " + vidaUtil;
    }

    public String getNombre() {
        return nombre;
    }

}
