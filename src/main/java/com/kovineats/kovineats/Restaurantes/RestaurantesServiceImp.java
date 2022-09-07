package com.kovineats.kovineats.Restaurantes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RestaurantesServiceImp implements RestaurantesService {

    private RestaurantesRepository restaurantesRepository;

    public RestaurantesServiceImp(RestaurantesRepository restaurantesRepository) {
        this.restaurantesRepository = restaurantesRepository;
    }

    @Override
    public Optional<Restaurantes> getRestauranteById(Long id) {
        return restaurantesRepository.findById(id);
    }

    @Override
    public List <Restaurantes> getAllRestaurantes() {
        return restaurantesRepository.findAll();
    }
}
