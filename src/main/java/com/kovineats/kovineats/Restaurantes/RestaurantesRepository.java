package com.kovineats.kovineats.Restaurantes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantesRepository extends JpaRepository<Restaurantes, Long> {
    
}
