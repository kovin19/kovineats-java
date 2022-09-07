package com.kovineats.kovineats.Platillos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatillosRepository extends JpaRepository<Platillos, Long> {
    
}
