package com.luisargueta.tiendafrontend.controller;


import com.luisargueta.tiendafrontend.entity.Usuario;
import com.luisargueta.tiendafrontend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@Validated
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //listar registros
    @GetMapping
    public String lista(Model model){
        model.addAttribute("usuarios", usuarioService.listar());
        return "usuarios";
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable Integer id){
        return usuarioService.obtenerPorId(id);
    }

    //abrir form
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("modeEdicion", false);
        return "usuario-formulario";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@RequestBody Usuario usuario){
        return usuarioService.crear(usuario);
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("usuario") Usuario usuario, Model model, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("modeEdicion", false);
            return "usuario-formulario";
        }

        usuarioService.crear(usuario);
        return "redirect:/usuarios";
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        usuarioService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
        return usuarioService.actualizar(id, usuario);
    }


}
