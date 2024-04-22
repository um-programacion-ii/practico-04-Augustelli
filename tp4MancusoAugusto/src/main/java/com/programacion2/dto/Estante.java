package tp4MancusoAugusto.src.main.java.com.programacion2.dto;

import tp4MancusoAugusto.src.main.java.com.programacion2.exceptions.StockInsuficienteException;
import tp4MancusoAugusto.src.main.java.com.programacion2.exceptions.VidaUtilInsuficienteException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Estante implements Despensable {
    private static Estante instance = null;
    private static final ReentrantLock lock = new ReentrantLock();
    private List<Utensillo> utensilios;

    private Estante() {
        utensilios = new ArrayList<>();
    }

    public static Estante getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Estante();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

public synchronized Utensillo getUtensillo() throws InterruptedException {
    while (utensilios.isEmpty()) {
        wait();
    }
    Utensillo utensillo = utensilios.remove(0);
    return utensillo;
}
public synchronized void returnUtensillo(Utensillo utensillo) {
    utensilios.add(utensillo);
    notifyAll();
}

@Override
public Despensable sacar(int cantidad) throws VidaUtilInsuficienteException, StockInsuficienteException {
    if (cantidad > utensilios.size()) {
        throw new StockInsuficienteException("Not enough utensilios in the estante");
    }

    List<Utensillo> utensillosToReturn = new ArrayList<>();
    for (int i = 0; i < cantidad; i++) {
        utensillosToReturn.add(utensilios.remove(0));
    }

    return new Estante();
}

@Override
public int obtenerCanitdad() {
    return utensilios.size();
}

@Override
public String obtenerNombre() {
    return "Estante";
}
}