package com.luisargueta.tiendafrontend.service;

import com.luisargueta.tiendafrontend.entity.DetallePedido;
import com.luisargueta.tiendafrontend.exception.ResourceNotFoundException;
import com.luisargueta.tiendafrontend.repository.DetallePedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements  DetallePedidoService{

    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }


    @Override
    public List<DetallePedido> listar() {
        return detallePedidoRepository.findAll();

    }

    @Override
    public DetallePedido obtenerPorId(Integer id) {
        return detallePedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("DetallePedido no encontrado: " + id));

    }

    @Override
    public DetallePedido crear(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);

    }

    @Override
    public DetallePedido actualizar(Integer id, DetallePedido detallePedido) {

        DetallePedido existente = obtenerPorId(id);

        existente.setCantidad(detallePedido.getCantidad());
        existente.setPrecioUnitario(detallePedido.getPrecioUnitario());

        return detallePedidoRepository.save(detallePedido);    }

    @Override
    public void eliminar(Integer id) {
        if (!detallePedidoRepository.existsById(id)) {
            throw new ResourceNotFoundException("El detalle del pedido con el id: " + id + " no se ha encontrado");
        }

        detallePedidoRepository.deleteById(id);
    }

    }

