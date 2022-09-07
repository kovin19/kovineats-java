package com.kovineats.kovineats.Pedidos;

import java.util.List;
import java.util.Optional;

public interface PedidosService {
    
    List<Pedidos> getAllPedidos();

    Optional<Pedidos> getPedidoById(Long id);

    void savePedido(Pedidos pedido);
}
