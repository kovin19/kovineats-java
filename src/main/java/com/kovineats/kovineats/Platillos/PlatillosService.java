package com.kovineats.kovineats.Platillos;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.kovineats.kovineats.Ingredientes.Ingredientes;

public interface PlatillosService {

    List <Platillos> getAllPlatillos();

    Optional <Platillos> getPlatilloById(Long id);

    Set<Ingredientes> getIngredientesByPlatillo(Platillos platillo);

}
