package com.kovineats.kovineats.Ingredientes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class IngredientesServiceImp implements IngredientesService {

    private IngredientesRepository ingredientesRepository;

    public IngredientesServiceImp(IngredientesRepository ingredientesRepository) {
        this.ingredientesRepository = ingredientesRepository;
    }

    @Override
    public List <Ingredientes> getAllIngredientes() {
        return ingredientesRepository.findAll();
    }

    @Override
    public Optional <Ingredientes> getIngredienteById(Long id) {
        return ingredientesRepository.findById(id);
    }
    
}
