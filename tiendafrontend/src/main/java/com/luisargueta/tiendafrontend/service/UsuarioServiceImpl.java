package com.luisargueta.tiendafrontend.service;

import com.luisargueta.tiendafrontend.entity.Usuario;
import com.luisargueta.tiendafrontend.exception.ResourceNotFoundException;
import com.luisargueta.tiendafrontend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl  implements  UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private  UsuarioRepository userLogueado;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioRepository userLogueado) {
        this.usuarioRepository = usuarioRepository;
        this.userLogueado = userLogueado;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails usuarioLog = usuarioRepository.findByUsername(username);

        if (usuarioLog== null){
                throw UsernameNotFoundException.fromUsername("El usuario no se ha encontrado " + username);

        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(usuarioLog.getUsername())
                .password(usuarioLog.getPassword())
                .roles("USER")
                .build();
    }

}

