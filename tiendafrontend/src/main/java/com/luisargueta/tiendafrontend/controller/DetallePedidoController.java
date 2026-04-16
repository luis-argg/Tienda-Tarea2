package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.DetallePedido;
import com.luisargueta.tiendafrontend.service.DetallePedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendafront/detalle/pedido")
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

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        detallePedidoService.eliminar(id);
    }

    @PutMapping("/{id}")
    public DetallePedido actualizar(@PathVariable Integer id, @RequestBody DetallePedido detallePedido){
        return detallePedidoService.actualizar(id, detallePedido);
    }


}
