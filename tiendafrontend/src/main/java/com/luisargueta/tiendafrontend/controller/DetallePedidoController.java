package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.DetallePedido;
import com.luisargueta.tiendafrontend.service.DetallePedidoService;
import com.luisargueta.tiendafrontend.service.PedidoService;
import com.luisargueta.tiendafrontend.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detallepedidos")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;
    private final PedidoService pedidoService;
    private final ProductoService productoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService,
                                   PedidoService pedidoService,
                                   ProductoService productoService) {
        this.detallePedidoService = detallePedidoService;
        this.pedidoService = pedidoService;
        this.productoService = productoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("detallepedidos", detallePedidoService.listar());
        model.addAttribute("pedidos", pedidoService.listar());
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("detallePedido", new DetallePedido());
        return "detallepedidos";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("detallePedido") DetallePedido detallePedido, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/detallepedidos";
        }
        detallePedidoService.crear(detallePedido);
        return "redirect:/detallepedidos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        detallePedidoService.eliminar(id);
        return "redirect:/detallepedidos";
    }
}