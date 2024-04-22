package tp4MancusoAugusto.src.main.java.com.programacion2.service;

import tp4MancusoAugusto.src.main.java.com.programacion2.dto.Chef;
import tp4MancusoAugusto.src.main.java.com.programacion2.dto.Cocinable;
import tp4MancusoAugusto.src.main.java.com.programacion2.dto.Utensillo;
import tp4MancusoAugusto.src.main.java.com.programacion2.exceptions.VidaUtilInsuficienteException;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CocinaSvc {

    private static CocinaSvc instance = null;
    List<Chef> chefsLuneasAJueves; // 3 Chefs
    List<Chef> chefsViernesADomingoYFeriados; // 5 Chefs

    List<Cocinable> recetasAPreparar;

    private CocinaSvc(List<Chef> chefsLuneasAJueves, List<Chef> chefsViernesADomingoYFeriados) {
        this.chefsLuneasAJueves = chefsLuneasAJueves;
        this.chefsViernesADomingoYFeriados = chefsViernesADomingoYFeriados;
    }

    private CocinaSvc(){

    }

    public static CocinaSvc getInstance() {
        if (instance == null) {
            instance = new CocinaSvc();
        }
        return  instance;
    }
    public void agregarRecetasParaPreparar(List<Cocinable> recetas){
        recetasAPreparar.addAll(recetas);
    }
    public void prepararPlatilloChefsLuneasAJueves(List<Cocinable> recetasPorCocinar){
        ExecutorService executorServiceLunesAJueves  = Executors.newFixedThreadPool(3);
        for (int i = 0; i < chefsLuneasAJueves.size(); i++){
            Chef chef = chefsLuneasAJueves.get(i);
            chef.setRecetas(recetasPorCocinar);
            executorServiceLunesAJueves.submit(chef);
        }
        executorServiceLunesAJueves.shutdown();
    }

    public void prepararPlatilloChefsViernesADomingoYFeriados(List<Cocinable> recetasPorCocinar){
        ExecutorService executorServiceViernesADomingoYFeriados  = Executors.newFixedThreadPool(5);
        for (int i = 0; i < chefsViernesADomingoYFeriados.size(); i++){
            Chef chef = chefsViernesADomingoYFeriados.get(i);
            chef.setRecetas(recetasPorCocinar);
            executorServiceViernesADomingoYFeriados.submit(chef);
        }
        executorServiceViernesADomingoYFeriados.shutdown();
    }

    private void disminuirVidaUtil(Cocinable cocinable) throws VidaUtilInsuficienteException {
        for (Utensillo utensillo : cocinable.getUtensillos()){
                utensillo.sacar(1);
        }

    }

}
