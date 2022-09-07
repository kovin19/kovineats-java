package com.kovineats.kovineats.Platillos;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.kovineats.kovineats.Ingredientes.Ingredientes;

@Service
public class PlatillosServiceImp implements PlatillosService {

    private PlatillosRepository platillosRepository;

    public PlatillosServiceImp(PlatillosRepository platillosRepository) {
        this.platillosRepository = platillosRepository;
    }

    @Override
    public Optional<Platillos> getPlatilloById(Long id) {
        return platillosRepository.findById(id);
    }

    @Override
    public List<Platillos> getAllPlatillos() {
        return platillosRepository.findAll();
    }

    @Override
    public Set<Ingredientes> getIngredientesByPlatillo(Platillos platillo) {
        return platillo.getIngredientes();
    }
}
