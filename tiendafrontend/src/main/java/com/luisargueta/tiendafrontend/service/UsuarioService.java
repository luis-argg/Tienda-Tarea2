package com.luisargueta.tiendafrontend.service;

import com.luisargueta.tiendafrontend.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario obtenerPorId(Integer id);
    Usuario crear(Usuario usuario);
    Usuario actualizar(Integer id, Usuario usuario);
    void eliminar(Integer id);
}
