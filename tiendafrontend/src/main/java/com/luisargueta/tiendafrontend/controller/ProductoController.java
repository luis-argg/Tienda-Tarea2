package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.Producto;
import com.luisargueta.tiendafrontend.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/producto")
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

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("producto") Producto producto, Model model, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("modeEdicion", false);
            return "usuario-formulario";
        }

        productoService.crear(producto);

        return "redirect:/producto";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("modeEdicion", false);
        return "producto-formulario";
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
