package com.kovineats.kovineats.Restaurantes;

import java.util.List;
import java.util.Optional;

public interface RestaurantesService {

    List <Restaurantes> getAllRestaurantes();

    Optional <Restaurantes> getRestauranteById(Long id);

}
