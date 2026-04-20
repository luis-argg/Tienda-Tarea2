package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.Categoria;
import com.luisargueta.tiendafrontend.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("categoria", new Categoria());
        return "categorias";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/categorias";
        }
        categoriaService.crear(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        categoriaService.eliminar(id);
        return "redirect:/categorias";
    }
}