package com.luisargueta.tiendafrontend.controller;

import com.luisargueta.tiendafrontend.entity.Usuario;
import com.luisargueta.tiendafrontend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        // Importante: El nombre "usuario" debe coincidir con th:object en el HTML
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                   BindingResult result,
                                   Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        // Llamamos al servicio para guardar
        usuarioService.crear(usuario);
        return "redirect:/login?success";
    }
}
