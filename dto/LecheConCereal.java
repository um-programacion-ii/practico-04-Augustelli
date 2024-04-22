package dto;

import java.util.List;

public class LecheConCereal extends Receta{

    public LecheConCereal(int tiempoCoccion, List<Ingrediente> ingredientes, String preparacion, List<Utensillo> utensillos) {
        super(tiempoCoccion, ingredientes, preparacion, utensillos);
        System.out.println("Creando Leche con Cereal...");
    }

}
