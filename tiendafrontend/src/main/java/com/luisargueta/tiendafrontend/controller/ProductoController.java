package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.Producto;
import com.luisargueta.tiendafrontend.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendafront/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/get")
    public List<Producto> listar(){
        return productoService.listar();
    }

    @GetMapping("/get/{id}")
    public Producto obtenerPorId(@PathVariable Integer id){
        return productoService.obtenerPorId(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto){
        return productoService.crear(producto);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Integer id){
        productoService.eliminar(id);
    }

    @PutMapping("/put/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody Producto producto){
        return productoService.actualizar(id, producto);
    }

}
