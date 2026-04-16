package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.Categoria;
import com.luisargueta.tiendafrontend.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendafront/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listar(){
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public Categoria obtenerPorId(@PathVariable Integer id){
        return categoriaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria crear(@RequestBody Categoria categoria){
        return categoriaService.crear(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        categoriaService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Integer id, @RequestBody Categoria categoria){
        return categoriaService.actualizar(id, categoria);
    }
}
