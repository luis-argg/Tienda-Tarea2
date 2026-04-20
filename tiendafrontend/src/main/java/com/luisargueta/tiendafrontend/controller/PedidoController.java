package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.Pedido;
import com.luisargueta.tiendafrontend.service.PedidoService;
import com.luisargueta.tiendafrontend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final UsuarioService usuarioService;

    public PedidoController(PedidoService pedidoService, UsuarioService usuarioService) {
        this.pedidoService = pedidoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoService.listar());
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("pedido", new Pedido());
        return "pedidos";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/pedidos";
        }
        pedidoService.crear(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        pedidoService.eliminar(id);
        return "redirect:/pedidos";
    }
}