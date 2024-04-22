package dto;

import exceptions.StockInsuficienteException;
import exceptions.VidaUtilInsuficienteException;

import java.util.HashMap;
import java.util.Map;

public class Despensa {
    Map<String, Despensable> despensaMap;

    public Map<String, Despensable> getDespensaMap() {
        return despensaMap;
    }

    public void setDespensaMap(Map<String, Despensable> despensaMap) {
        this.despensaMap = despensaMap;
    }

    public Despensa() {
        despensaMap = new HashMap<>();
    }

    public void addDespensable(String nombre, Despensable despensable) {
        despensaMap.put(nombre, despensable);
    }

    public Despensable getDespensable(String nombre, int cantidad) throws StockInsuficienteException, VidaUtilInsuficienteException {
        return getDespensaMap().get(nombre).sacar(cantidad);
    }

    @Override
    public String toString() {
        String despensaStr = "Despensa:\n";
        for (Map.Entry<String, Despensable> entry : despensaMap.entrySet()) {
            despensaStr += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return despensaStr;
    }




}
