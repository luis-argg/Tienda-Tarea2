package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.DetallePedido;
import com.luisargueta.tiendafrontend.service.DetallePedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-pedido")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping
    public List<DetallePedido> listar(){
        return detallePedidoService.listar();
    }

    @GetMapping("/{id}")
    public DetallePedido obtenerPorId(@PathVariable Integer id){
        return detallePedidoService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetallePedido crear(@RequestBody DetallePedido detallePedido){
        return detallePedidoService.crear(detallePedido);
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("detallepedido", new DetallePedido());
        model.addAttribute("modeEdicion", false);
        return "detallepedido-formulario";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("detallepedido") DetallePedido detallePedido, Model model, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("modeEdicion", false);
            return "detallepedido-formulario";
        }

        detallePedidoService.crear(detallePedido);

        return "redirect:/detalle-pedido";
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        detallePedidoService.eliminar(id);
    }

    @PutMapping("/{id}")
    public DetallePedido actualizar(@PathVariable Integer id, @RequestBody DetallePedido detallePedido){
        return detallePedidoService.actualizar(id, detallePedido);
    }


}
