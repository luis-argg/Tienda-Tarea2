package com.luisargueta.tiendafrontend.service;

import com.luisargueta.tiendafrontend.entity.Producto;
import com.luisargueta.tiendafrontend.exception.ResourceNotFoundException;
import com.luisargueta.tiendafrontend.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();

    }

    @Override
    public Producto obtenerPorId(Integer id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id));

    }

    @Override
    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {

        Producto existente = obtenerPorId(id);

        existente.setCategoria(producto.getCategoria());
        existente.setNombreProducto(producto.getNombreProducto());
        existente.setStock(producto.getStock());
        existente.setCategoria(producto.getCategoria());

        return productoRepository.save(producto);
    }

    @Override
    public void eliminar(Integer id) {

        if (!productoRepository.existsById(id)) {
            throw new ResourceNotFoundException("El producto con el id:  " + id + " no se ha encontrado");
        }

        productoRepository.deleteById(id);
    }


    }
