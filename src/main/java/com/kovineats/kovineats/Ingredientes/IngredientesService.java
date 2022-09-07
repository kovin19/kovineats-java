package com.kovineats.kovineats.Ingredientes;

import java.util.List;
import java.util.Optional;

public interface IngredientesService {

    List <Ingredientes> getAllIngredientes();

    Optional <Ingredientes> getIngredienteById(Long id);

}
