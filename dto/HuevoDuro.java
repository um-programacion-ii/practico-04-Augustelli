package dto;

import java.util.List;

public class HuevoDuro extends Receta{
    public HuevoDuro(int tiempoCoccion, List<Ingrediente> ingredientes, String preparacion, List<Utensillo> utensillos) {
        super(tiempoCoccion, ingredientes, preparacion, utensillos);
    }

}
