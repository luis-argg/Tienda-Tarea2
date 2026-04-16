package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.Pedido;
import com.luisargueta.tiendafrontend.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/get")
    public List<Pedido> listar(){
        return pedidoService.listar();
    }

    @GetMapping("/get/{id}")
    public Pedido obtenerPorId(@PathVariable Integer id){
        return pedidoService.obtenerPorId(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido crear(@RequestBody Pedido pedido){
        return pedidoService.crear(pedido);
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("modeEdicion", false);
        return "pedido-formulario";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("pedido") Pedido pedido, Model model, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("modeEdicion", false);
            return "pedido-formulario";
        }

        pedidoService.crear(pedido);

        return "redirect:/pedido";
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Integer id){
        pedidoService.eliminar(id);
    }

    @PutMapping("/put/{id}")
    public Pedido actualizar(@PathVariable Integer id, @RequestBody Pedido pedido){
        return pedidoService.actualizar(id, pedido);
    }

}
