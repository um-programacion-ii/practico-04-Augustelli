package dto;

import java.util.List;

public class PanConQueso extends Receta{

    public PanConQueso(int tiempoCoccion, List<Ingrediente> ingredientes, String preparacion, List<Utensillo> utensillos) {
        super(tiempoCoccion, ingredientes, preparacion, utensillos);
    }
}
