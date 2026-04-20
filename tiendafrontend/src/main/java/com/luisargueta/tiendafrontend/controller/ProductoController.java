package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.Producto;
import com.luisargueta.tiendafrontend.service.ProductoService;
import com.luisargueta.tiendafrontend.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.listar());
        return "productos";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("producto") Producto producto,
                          BindingResult result,
                          Model model) {

        if (result.hasErrors()) {
            model.addAttribute("productos", productoService.listar());
            model.addAttribute("categorias", categoriaService.listar());
            return "productos";
        }

        productoService.crear(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }
}