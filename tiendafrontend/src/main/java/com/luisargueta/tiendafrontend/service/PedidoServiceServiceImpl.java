package com.luisargueta.tiendafrontend.service;

import com.luisargueta.tiendafrontend.entity.Pedido;
import com.luisargueta.tiendafrontend.exception.ResourceNotFoundException;
import com.luisargueta.tiendafrontend.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceServiceImpl implements PedidoService{

    private final PedidoRepository pedidoRepository;

    public PedidoServiceServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPorId(Integer id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado: " + id));
    }

    @Override
    public Pedido crear(Pedido pedido) {
        return pedidoRepository.save(pedido);

    }

    @Override
    public Pedido actualizar(Integer id, Pedido pedido) {

        Pedido existente = obtenerPorId(id);

        existente.setFechaPedido(pedido.getFechaPedido());
        existente.setTotalPedido(pedido.getTotalPedido());

        return pedidoRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {

        if (!pedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido con ID no encontrado: " + id);
        }

        pedidoRepository.deleteById(id);
    }


    }

