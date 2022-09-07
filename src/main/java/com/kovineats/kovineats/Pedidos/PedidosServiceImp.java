package com.kovineats.kovineats.Pedidos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PedidosServiceImp implements PedidosService {
    
    private PedidosRepository pedidosRepository;

    public PedidosServiceImp(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    @Override
    public List <Pedidos> getAllPedidos() {
        return pedidosRepository.findAll();
    }

    @Override
    public Optional <Pedidos> getPedidoById(Long id) {
        return pedidosRepository.findById(id);
    }

    @Override
    public void savePedido(Pedidos pedido) {
        pedidosRepository.save(pedido);
    }
}
