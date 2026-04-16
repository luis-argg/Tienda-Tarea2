package com.luisargueta.tiendafrontend.service;

import com.luisargueta.tiendafrontend.entity.Usuario;
import com.luisargueta.tiendafrontend.exception.ResourceNotFoundException;
import com.luisargueta.tiendafrontend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl  implements  UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();

    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + id));

    }

    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {

        Usuario existente = obtenerPorId(id);

        existente.setNombreUsuario(usuario.getNombreUsuario());
        existente.setApellidoUsuario(usuario.getApellidoUsuario());
        existente.setEdadUsuario(usuario.getEdadUsuario());

        return usuarioRepository.save(existente);

    }

    @Override
    public void eliminar(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario con ID no encontrado: " + id);
        }

        usuarioRepository.deleteById(id);
    }

    }

